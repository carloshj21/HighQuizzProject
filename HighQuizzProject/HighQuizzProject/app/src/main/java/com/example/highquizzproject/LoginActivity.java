package com.example.highquizzproject;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button btnLogin;

    private String correo = "";
    private String password = "";

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_inicio_sesion);

        firebaseAuth = FirebaseAuth.getInstance();

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correo = editTextEmail.getText().toString();
                password = editTextPassword.getText().toString();

                // ---------------------------------------- Validación de formulario para iniciar sesión ----------------------------------------
                if(!correo.isEmpty() && !password.isEmpty()){
                    loginUser();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Es necesario completar TODOS los campos",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    // ------------------------------------------------  Iniciar sesión ----------------------------------------------------------
    private void loginUser(){
        firebaseAuth.signInWithEmailAndPassword(correo,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    finish();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Error al iniciar sesión. Compruebe los datos.",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
