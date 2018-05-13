package guardado.com.personas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import guardado.com.personas.Datos.Persona;
import guardado.com.personas.Entidades.DBHelper;

public class RegistarActivity extends AppCompatActivity {

    private EditText txtId, txtNombre;
    private Button btnEnviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registar);

        //capturamos los datos
        btnEnviar = findViewById(R.id.btnRegistrar);
        txtId=findViewById(R.id.txtId);
        txtNombre=findViewById(R.id.txtNombre);


        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = DBHelper.myDB.add(new Persona(
                        txtId.getText().toString(),
                        txtNombre.getText().toString()
                ));
                if(flag)
                {
                    Log.d("Edit",txtNombre.getText().toString());
                }
            }
        });
    }
}
