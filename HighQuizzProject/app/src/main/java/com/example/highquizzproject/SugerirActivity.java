package com.example.highquizzproject;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.highquizzproject.fragments.InicioFragment;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.protobuf.StringValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SugerirActivity extends AppCompatActivity {

    private EditText edtPreguntaSugerida;
    private EditText edtOpASugerida;
    private EditText edtOpBSugerida;
    private EditText edtOpCSugerida;
    private EditText edtOpDSugerida;
    private Button btnRegresarSugerencia;
    private Button btnGuardarSugerencia;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private Spinner spinMateriaSugerida;
    private Spinner spinResCorrectaSug;
    private ArrayList<String> opRespuesta = new ArrayList<String>();
    private ArrayList<String> opMaterias = new ArrayList<String>();
    private String materiaSug;
    private String indiceRespuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugerir);

        edtPreguntaSugerida = findViewById(R.id.edtPreguntaSugerida);
        spinMateriaSugerida = findViewById(R.id.spinMateriaSugerida);
        spinResCorrectaSug = findViewById(R.id.spinResCorrectaSug);
        edtOpASugerida = findViewById(R.id.edtOpASugerida);
        edtOpBSugerida = findViewById(R.id.edtOpBSugerida);
        edtOpCSugerida = findViewById(R.id.edtOpCSugerida);
        edtOpDSugerida = findViewById(R.id.edtOpDSugerida);
        btnRegresarSugerencia = findViewById(R.id.btnRegresarSugerencia);
        btnGuardarSugerencia = findViewById(R.id.btnGuardarSugerencia);
        btnRegresarSugerencia.setOnClickListener(onClickRegresarSugerencia);
        btnGuardarSugerencia.setOnClickListener(onClickGuardarSugerencia);

        InicializarSpinner();
        InicializarSpinnerRespuestas();
        ArrayAdapter adapterMaterias = new ArrayAdapter(SugerirActivity.this, android.R.layout.simple_spinner_dropdown_item,opMaterias);
        ArrayAdapter adapterRespuestas = new ArrayAdapter(SugerirActivity.this, android.R.layout.simple_spinner_item, opRespuesta);
        spinMateriaSugerida.setAdapter(adapterMaterias);
        spinResCorrectaSug.setAdapter(adapterRespuestas);

        spinResCorrectaSug.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                indiceRespuesta = String.valueOf(position);
                Toast.makeText(getApplicationContext(),"Seleccionaste: " + indiceRespuesta,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinMateriaSugerida.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                materiaSug = (String) spinMateriaSugerida.getAdapter().getItem(position);
                Toast.makeText(getApplicationContext(),"Seleccionaste: " + materiaSug,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    private void InicializarSpinnerRespuestas() {
        opRespuesta.add("a)");
        opRespuesta.add("b)");
        opRespuesta.add("c)");
        opRespuesta.add("d)");
    }

    private void InicializarSpinner() {
        opMaterias.add("Español");
        opMaterias.add("Matemáticas");
        opMaterias.add("Biología");
        opMaterias.add("Historia");
        opMaterias.add("Geografía");
        opMaterias.add("Física");
        opMaterias.add("Formación Cívica y Ética");
        opMaterias.add("Química");
    }

    View.OnClickListener onClickRegresarSugerencia = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intentRegresarSugerencia = new Intent(SugerirActivity.this, MainActivity.class);
            startActivity(intentRegresarSugerencia);
            finish();
        }
    };

    View.OnClickListener onClickGuardarSugerencia = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            SubirFirestore();
            /*
            String preguntaSugerida = String.valueOf(edtPreguntaSugerida.getText()) + ";a)" + String.valueOf(edtOpASugerida.getText()) + ";b)"
                    + String.valueOf(edtOpBSugerida.getText()) + ";c)" + String.valueOf(edtOpCSugerida.getText()) + ";d)" + String.valueOf(edtOpDSugerida.getText()) +
                    ";" + indiceRespuesta;
            String materiaSugerida = materiaSug;
            */
            edtPreguntaSugerida.setText("");
            edtOpASugerida.setText("");
            edtOpBSugerida.setText("");
            edtOpCSugerida.setText("");
            edtOpDSugerida.setText("");
            //Toast.makeText(getApplicationContext(), preguntaSugerida ,Toast.LENGTH_LONG).show();


        }


        private void SubirFirestore() {

            String preguntaSugerida = String.valueOf(edtPreguntaSugerida.getText()) + ";a)" + String.valueOf(edtOpASugerida.getText()) + ";b)"
                    + String.valueOf(edtOpBSugerida.getText()) + ";c)" + String.valueOf(edtOpCSugerida.getText()) + ";d)" + String.valueOf(edtOpDSugerida.getText()) +
                    ";" + indiceRespuesta;
            String materiaSugerida = materiaSug;

            Map<String,Object> preguntaSug = new HashMap<>();
            preguntaSug.put("pregutaSugerida", preguntaSugerida);
            preguntaSug.put("materia", materiaSugerida);

            db.collection("PreguntasSugeridasColl")
                    .add(preguntaSug)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(getApplicationContext(), "Se registró tu pregunta correctamente.\nGracias por tu sugerencia." ,Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(), "¡Ups! Hubo un error al registrar tu pregunta." ,Toast.LENGTH_LONG).show();
                        }
                    });


        }
    };
}


