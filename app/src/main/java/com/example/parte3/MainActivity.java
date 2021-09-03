package com.example.parte3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Validaciones  objValidar; //objeto de nuestro clase Validaciones
    EditText edtName;
    EditText edtGender;
    EditText edtOld;
    EditText edtEmail;
    private CheckBox seleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName = (EditText) findViewById(R.id.edtName);
        edtGender = (EditText) findViewById(R.id.edtGender);
        edtOld = (EditText) findViewById(R.id.edtOld);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        seleccion = (CheckBox) findViewById(R.id.cbCondiciones);
        objValidar = new Validaciones();
    }

    //Al dar clic en el botón “Cancelar”
    // debe borrar el texto o valor de todos los componentes del formulario.
    public void Cancel(View view) {
        edtName.setText("");
        edtGender.setText("");
        edtOld.setText("");
        edtEmail.setText("");
    }

    public void Registrar(View view){
        String s = "Estado: " + (seleccion.isChecked() ? "Marcado" : "No Marcado");
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();

        if(edtName.getText().toString().isEmpty()==true){
            edtName.setError("campo obligatorio");
            edtName.requestFocus();
            return;
        }else{
            if(edtGender.getText().toString().isEmpty()){
                edtGender.setError("campo obligatorio");
                edtGender.requestFocus();
                return;
            }else{
                if(edtOld.getText().toString().isEmpty()){
                    edtOld.setError("campo obligatorio");
                    edtOld.requestFocus();
                    return;
                }else{
                    if(edtEmail.getText().toString().isEmpty()){
                        edtEmail.setError("campo obligatorio");
                        edtEmail.requestFocus();
                        return;
                    }else{
                        Toast.makeText(this,"Formulario completo!",Toast.LENGTH_LONG).show();
                    }
                }
            }
        }

        Intent intent = new Intent(this, Validacion.class);
        String name = edtName.getText().toString();
        int edad = Integer.parseInt(String.valueOf(edtOld.getText()));
        Bundle extras = new Bundle();
        extras.putInt("EDAD", edad);
        extras.putString("NAME",name);
        //Agrega el objeto bundle a el Intent
        intent.putExtras(extras);
        //Inicia Activity
        startActivity(intent);
    }

}