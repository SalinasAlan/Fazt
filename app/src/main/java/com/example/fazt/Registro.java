package com.example.fazt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;


public class Registro extends AppCompatActivity {

    private Button btnRegresar, btnRegistrar;
    private EditText editText_correo, editText_contraseña, editText_contraseñaVerificada;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnRegresar = findViewById(R.id.regresar);
        btnRegistrar = findViewById(R.id.registrar);

        editText_correo = findViewById(R.id.editText_correo);
        editText_contraseña = findViewById(R.id.editText_contrasenia);
        editText_contraseñaVerificada = findViewById(R.id.editText_contraseniaVerificada);

        mAuth = FirebaseAuth.getInstance();


        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarUsuario();
            }
        });


        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regresar();
            }
        });
    }

    public void regresar() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void limpiarCampos() {
        editText_correo.setText("");
        editText_contraseña.setText("");
        editText_contraseñaVerificada.setText("");
    }

    private void registrarUsuario() {
        String correo = editText_correo.getText().toString().trim();
        String contrasenia = editText_contraseña.getText().toString().trim();
        String contraseniaVerificada = editText_contraseñaVerificada.getText().toString().trim();

        if (correo.isEmpty()) {
            editText_correo.setError("Correo necesario");
            editText_correo.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            editText_correo.setError("Ingresa un correo valido");
            editText_correo.requestFocus();
            return;
        }

        if (contrasenia.isEmpty()) {
            editText_contraseña.setError("Contraseña necesaria");
            editText_contraseña.requestFocus();
            return;
        }


        if (contraseniaVerificada.isEmpty()) {
            editText_contraseñaVerificada.setError(("Contraseña necesaria"));
            editText_contraseñaVerificada.requestFocus();
            return;
        }

        if (contrasenia.equals(contraseniaVerificada)) {

            mAuth.createUserWithEmailAndPassword(correo, contrasenia)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(Registro.this, "Usuario registrado correctamente",
                                        Toast.LENGTH_LONG).show();
                                limpiarCampos();
                                regresar();
                                //Log.d(TAG, "createUserWithEmail:success");
                                //FirebaseUser user = mAuth.getCurrentUser();
                                //updateUI(user);
                            } else {
                                // If sign in fails, display a message to the user.
                                //Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                if (task.getException() instanceof FirebaseAuthUserCollisionException){
                                    Toast.makeText(Registro.this, "Ya estás registrado",
                                            Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(Registro.this, "Registro fallido",
                                            Toast.LENGTH_SHORT).show();
                                }
                                limpiarCampos();
                                //updateUI(null);
                            }

                            // ...
                        }
                    });


        } else {
            editText_contraseña.setError("Contraseñas no iguales");
            editText_contraseñaVerificada.setError(("Contraseñas no iguales"));
            editText_contraseña.requestFocus();
        }
    }
}
