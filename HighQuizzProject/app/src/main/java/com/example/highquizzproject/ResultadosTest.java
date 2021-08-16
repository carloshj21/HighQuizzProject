package com.example.highquizzproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.example.highquizzproject.fragments.InicioFragment;

import static com.example.highquizzproject.PlantillaTestActivity.correcta;
import static com.example.highquizzproject.PlantillaTestActivity.incorrecta;


public class ResultadosTest extends AppCompatActivity {

    TextView Correctas;
    TextView Total;
    int totalPreguntas;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados_test);
        Correctas = findViewById(R.id.txtvCorrectas);
        Total = findViewById(R.id.txtvTotal);

        Correctas.setText(String.valueOf(correcta));
        totalPreguntas=correcta+incorrecta;

        Total.setText(String.valueOf(totalPreguntas));

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                correcta=0;
                incorrecta=0;
                finish();
            }
        }, 5000);
    }
}