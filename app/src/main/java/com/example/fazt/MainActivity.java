package com.example.fazt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private Button btnRegistrar, btnIniciarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegistrar =  findViewById(R.id.registrate);
        btnIniciarSesion = findViewById(R.id.btn_iniciarsessionMain);

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inicioSesion();
            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registro();
            }
        });
    }

    public void registro() {
        Intent intent = new Intent(this, Registro.class);
        startActivity(intent);
    }

    public void inicioSesion(){
        Intent intent = new Intent(this, InicioSesion.class);
        startActivity(intent);
    };
}
