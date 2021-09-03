package com.example.parte3;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.EditText;
public class Validaciones {
    //metodo para validar si editext esta vacio
    public  boolean Vacio(EditText campo){
        String dato = campo.getText().toString().trim();
        if(TextUtils.isEmpty(dato)){
            campo.setError("Campo Requerido");
            campo.requestFocus();
            return true;
        }
        else{
            return false;
        }
    }
}
