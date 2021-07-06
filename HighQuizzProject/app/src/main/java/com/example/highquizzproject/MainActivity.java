package com.example.highquizzproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnPreguntas;
    private Button btnExamen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPreguntas=findViewById(R.id.btnPreguntas);
        btnPreguntas.setOnClickListener(clickProgramador);

    }

    View.OnClickListener clickProgramador = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intentPreguntas = new Intent(MainActivity.this, PreguntasActivity.class);
            startActivity(intentPreguntas);
        }
    };

}