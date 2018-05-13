package guardado.com.personas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import guardado.com.personas.Datos.Persona;
import guardado.com.personas.Entidades.DBHelper;

public class ModificarActivity extends AppCompatActivity {

    private EditText id,nombre;
    private Button btnBuscar,btnEliminar, btnActualizar,btnLimpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);

        //setemaos los elementos
        id=findViewById(R.id.txtIdM);
        nombre=findViewById(R.id.txtNombreM);
        btnBuscar=findViewById(R.id.btnBuscarM);
        btnEliminar=findViewById(R.id.btnEliminarM);
        btnActualizar=findViewById(R.id.btnActualizarM);
        btnLimpiar=findViewById(R.id.btnLimpiarM);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Persona p = DBHelper.myDB.findUser(id.getText().toString());
                if(p==null)
                {
                    Toast.makeText(getApplicationContext(),"El usuario no fu encontrado", Toast.LENGTH_LONG).show();
                    limpiar();
                }
                else {
                    nombre.setText(p.getNombre());
                }
            }
        });

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper.myDB.editUser(new Persona(id.getText().toString(),
                        nombre.getText().toString()));
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper.myDB.deleteUser(id.getText().toString());
                limpiar();
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiar();
            }
        });
    }

    public void limpiar()
    {
        nombre.setText("");
        id.setText("");
    }
}
