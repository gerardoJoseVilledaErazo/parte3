package com.example.parte3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Validacion extends AppCompatActivity {
    TextView tvMessageV;
    TextView tvMessageV2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validacion);

        Intent intent = getIntent();
        String name = getIntent().getExtras().getString("NAME");
        int edad = getIntent().getExtras().getInt("EDAD");

        tvMessageV = findViewById(R.id.tvMessageV);
        tvMessageV2 = findViewById(R.id.tvMessageV2);

        if(edad>18){
            tvMessageV.setText("BIENVENIDO " + name.toUpperCase());
        }else{
            tvMessageV2.setText("Usted es menor de edad, no se puede registrar. " );
        }
    }
}