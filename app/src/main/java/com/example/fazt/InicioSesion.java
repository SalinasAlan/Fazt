package com.example.fazt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InicioSesion extends AppCompatActivity {

    private Button btnRegresar, btnIniciarSesion;
    private EditText editText_correo, editText_contrasenia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        btnRegresar = findViewById(R.id.btn_regresarInicioSesion);
        btnIniciarSesion = findViewById(R.id.btn_iniciarsession);
        editText_correo = findViewById(R.id.editText_correoInicioSesion);
        editText_contrasenia = findViewById(R.id.editText_contraseniaInicioSeson);



        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regresar();
            }
        });
    }

    public void regresar() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
