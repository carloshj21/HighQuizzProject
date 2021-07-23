package com.example.highquizzproject;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button btnRegistro;
    private Button btnSendToLogin;

    private String nombre = "";
    private String correo = "";
    private String password = "";

    FirebaseAuth firebaseAuth;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_registro);

        firebaseAuth = FirebaseAuth.getInstance();

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        btnRegistro = (Button) findViewById(R.id.btnRegistro);
        btnSendToLogin = (Button) findViewById(R.id.btnSendToLogin);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre = editTextName.getText().toString();
                correo = editTextEmail.getText().toString();
                password = editTextPassword.getText().toString();

                // ---------------------------------------- Validación de formulario para registro ----------------------------------------
                if(!nombre.isEmpty() && !correo.isEmpty() && !password.isEmpty()){
                    if(password.length() >= 6){
                        registrarUsuario();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"La contraseña debe tener al menos 6 caracteres",Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),"Es necesario completar TODOS los campos",Toast.LENGTH_LONG).show();
                }
            }
        });


        // --------------------------------------------- Botón para ir a la vista de Log in --------------------------------------------
        btnSendToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        });
    }


    // ------------------------------------------------  Registrar usuario ----------------------------------------------------------
    private void registrarUsuario(){
        firebaseAuth.createUserWithEmailAndPassword(correo,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Map<String,Object> usuario = new HashMap<>();
                    usuario.put("nombre",nombre);
                    usuario.put("correo",correo);
                    usuario.put("contrasena",password);

                    db.collection("Usuarios")
                            .add(usuario)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Log.d("RegisterActivity","DocumentSnapshot added with ID: "+ documentReference.getId());
                                    startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                                    finish();
                                }
                            })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w("RegisterActivity","Error adding document",e);
                        }
                    });
                }
                else{
                    Toast.makeText(getApplicationContext(),"Error al registrar al usuario",Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    // ------------------------------------------------  Verificar sesión activa ----------------------------------------------------------
    @Override
    protected void onStart() {
        super.onStart();

        if(firebaseAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));   // Verifica si el usuario ya tiene una sesión activa
            finish();
        }
    }
}
