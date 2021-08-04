package com.example.highquizzproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.protobuf.StringValue;

import java.util.ArrayList;

public class PlantillaTestActivity extends AppCompatActivity {

    private TextView txtvMateriaTest;
    private TextView txtvPreguntaTest;
    private ImageView imgMat;
    private RadioGroup rdbGroup;
    private RadioButton rdbA;
    private RadioButton rdbB;
    private RadioButton rdbC;
    private RadioButton rdbD;
    private Button btnSigPregunta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_plantilla_test);
        txtvMateriaTest = findViewById(R.id.txtvMateriaTest);
        txtvPreguntaTest = findViewById(R.id.txtvPreguntaTest);
        imgMat = findViewById(R.id.imageView);
        rdbGroup = findViewById(R.id.rdbGroupOpciones);
        rdbA = findViewById(R.id.rbOpcion1);
        rdbB = findViewById(R.id.rbOpcion2);
        rdbC = findViewById(R.id.rbOpcion3);
        rdbD = findViewById(R.id.rbOpcion4);
        Bundle bundle = getIntent().getExtras();
        ArrayList<String> materiasElegidas = bundle.getStringArrayList("strArrayMat");
        // Sección donde se prueba el comando remove(índice)
        /*
        int noMaterias = materiasElegidas.size(); //Para saber el tamaño del arreglo por si se ocupa
        txtvMateriaTest.setText(materiasElegidas.remove(0));
        txtvPreguntaTest.setText(materiasElegidas.remove(0));
        rdbA.setText(materiasElegidas.remove(0));
        //rdbB.setText(materiasElegidas.remove(0));
        //rdbC.setText(materiasElegidas.remove(0));
        rdbD.setText(Integer.toString(noMaterias));

        /*
        Para quitar cada elemento del ArrayList se utiliza remove, esto hace que la 1ra materia seleccionada sea retirada del arreglo (indice 0)
        Por lo tanto el indice 1 pasa a ser el 0 y así se recorre, es por eso que siempre se quita el indice 0
         */




    }
}