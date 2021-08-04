package com.example.highquizzproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;

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
    ArrayList<String> materiasSelecc = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
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


    }

    private void SeleccionMaterias() {
        if (chkEsp.isChecked()==true){
            materiasSelecc.add("Español");
        }
        if (chkMat.isChecked()==true){
            materiasSelecc.add("Matemáticas");
        }
        if (chkBio.isChecked()==true){
            materiasSelecc.add("Biología");
        }
        if (chkHis.isChecked()==true){
            materiasSelecc.add("Historia");
        }
        if (chkGeo.isChecked()==true){
            materiasSelecc.add("Geografía");
        }
        if (chkFis.isChecked()==true){
            materiasSelecc.add("Física");
        }
        if (chkFCyE.isChecked()==true){
            materiasSelecc.add("Formación Cívica y Ética");
        }
        if (chkQuim.isChecked()==true){
            materiasSelecc.add("Química");
        }
    }

    View.OnClickListener clickStartPreguntas = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intentStartPreguntas = new Intent(PreguntasActivity.this,PlantillaTestActivity.class);
            SeleccionMaterias();
            intentStartPreguntas.putExtra("strArrayMat", materiasSelecc);
            startActivity(intentStartPreguntas);
            finish();//Destruye esta activity para evitar un error o bug al llenar el Array y pasar a la siguiente Activity

        }
    };
}