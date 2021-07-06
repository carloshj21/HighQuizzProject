package com.example.highquizzproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class PreguntasActivity extends AppCompatActivity {

    CheckBox chkEsp;
    CheckBox chkMat;
    CheckBox chkBio;
    CheckBox chkHis;
    CheckBox chkGeo;
    CheckBox chkFis;
    CheckBox chkFCyE;
    CheckBox chkQuim;
    Button btnStartPreguntas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);
        chkEsp = findViewById(R.id.chkEsp);
        chkMat = findViewById(R.id.chkMat);
        chkBio = findViewById(R.id.chkBio);
        chkHis = findViewById(R.id.chkHis);
        chkGeo = findViewById(R.id.chkGeo);
        chkFis = findViewById(R.id.chkFis);
        chkFCyE = findViewById(R.id.chkFCyE);
        chkQuim = findViewById(R.id.chkQuim);
        btnStartPreguntas = findViewById(R.id.btnStartPreguntas);
        btnStartPreguntas.setOnClickListener(clickStartPreguntas);
        SeleccionMaterias();

    }

    private void SeleccionMaterias() {
        if (chkEsp.isEnabled()){

        }
        if (chkMat.isEnabled()){

        }
        if (chkBio.isEnabled()){

        }
        if (chkHis.isEnabled()){

        }
        if (chkGeo.isEnabled()){

        }
        if (chkFis.isEnabled()){

        }
        if (chkFCyE.isEnabled()){

        }
        if (chkQuim.isEnabled()){

        }
    }

    View.OnClickListener clickStartPreguntas = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intentStartPreguntas = new Intent(PreguntasActivity.this,PlantillaTestActivity.class);
            startActivity(intentStartPreguntas);

        }
    };
}