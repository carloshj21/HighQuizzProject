package com.example.highquizzproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
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

    /*private int[] id_answers ={
            R.id.rdbAnswerA, R.id.rdbAnswerB, R.id.rdbAnswerC, R.id.rdbAnswerD

    };

     */

    public static String[] arregloDepregntasdos =new String[120];
    //DatabaseReference mRootReference;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

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
        btnSigPregunta = findViewById(R.id.btnSigPregunta);
        Bundle bundle = getIntent().getExtras();
        ArrayList<String> materiasElegidas = bundle.getStringArrayList("strArrayMat");
        btnSigPregunta.setOnClickListener(clickSigPregunta);


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

    View.OnClickListener clickSigPregunta = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //j=j+1;
            obtenerDatos();
            //obtenerDatosdos();
            //ConsultarPreguntas();
        }
    };

    public void obtenerDatos() {//para obtener un campo de la base
        // for (int i = 0; i<5;i++) {
        db.collection("Preguntas").document("0FnpVj6PT7pkXZBxaOAv").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenGeo");
                    arregloDepregntasdos[0]=materia;
                    //txtvMateriaTest.setText(arregloDepregntasdos[0]);
                    //rdbA.setText(materia);
                }
            }

        });
    }

    public void obtenerDatosdos(){
        db.collection("Preguntas").document("8ZenugljXoL9a4cZ1Bic").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenGeo");
                    arregloDepregntasdos[1]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatostres(){
        db.collection("Preguntas").document("B889e1RSgvS7EkVfSs95").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenGeo");
                    arregloDepregntasdos[2]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatoscuatro(){
        db.collection("Preguntas").document("D1D9Oqf3Pj9HrggB21f0").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenGeo");
                    arregloDepregntasdos[3]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatoscinco(){
        db.collection("Preguntas").document("LLOLFJOt1Limza5jKdxA").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenGeo");
                    arregloDepregntasdos[4]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosSeis(){
        db.collection("Preguntas").document("PljHKAXOjJCoIMX2swg1").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenGeo");
                    arregloDepregntasdos[5]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosSiete(){
        db.collection("Preguntas").document("QPx8Hgkw8Zih0k1s4ALy").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenGeo");
                    arregloDepregntasdos[6]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosOcho(){
        db.collection("Preguntas").document("Z9pVUKxp3LOc1pGtk8n1").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenGeo");
                    arregloDepregntasdos[7]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosNueve(){
        db.collection("Preguntas").document("ZJyxxvlsgYapgFkb6fdS").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenGeo");
                    arregloDepregntasdos[8]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosDiez(){
        db.collection("Preguntas").document("hdAWdT6SRiuL4oKraLA3").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenGeo");
                    arregloDepregntasdos[9]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    //////////////////////PREGUNTAS MATEMATICAS//////////////////////

    public void obtenerDatosOnce(){
        db.collection("Preguntas").document("0rdxWOhNjKCLh4GPcqEN").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenMat");
                    arregloDepregntasdos[10]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosDoce(){
        db.collection("Preguntas").document("3eko8gQEGEcYrXdUn62Y").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenMat");
                    arregloDepregntasdos[11]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosTrece(){
        db.collection("Preguntas").document("7aOdNNpSF8LaPaCjisGr").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenMat");
                    arregloDepregntasdos[12]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosCatorce(){
        db.collection("Preguntas").document("D6tsAtUZka3oLQXu52fo").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenMat");
                    arregloDepregntasdos[13]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }


    public void obtenerDatosQuince(){
        db.collection("Preguntas").document("Huf0mC4sbmo4enW0ZghX").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenMat");
                    arregloDepregntasdos[14]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosDiezyseis(){
        db.collection("Preguntas").document("JSYcwXfTlm1wYwd9ZIZb").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenMat");
                    arregloDepregntasdos[15]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosDiezysiete(){
        db.collection("Preguntas").document("JrwnUcRelP5jz0lcGdmk").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenMat");
                    arregloDepregntasdos[16]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosDiezyocho(){
        db.collection("Preguntas").document("KONYjQujmjOO3Wu3YhyF").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenMat");
                    arregloDepregntasdos[17]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosDiezynueve(){
        db.collection("Preguntas").document("UCARAwm1z2B2FGU7ZOFf").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenMat");
                    arregloDepregntasdos[18]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosVeinte(){
        db.collection("Preguntas").document("UU0BWKoU8MvXeyeLr59n").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenMat");
                    arregloDepregntasdos[19]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    ///////////////////////////////////////FORMACION CIVICA Y ETICA//////////////////////////
    //}
    public void obtenerDatosVeinteyuno(){
        db.collection("Preguntas").document("0gDhiWWhI9ieR9y9SDMd").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenCiv");
                    arregloDepregntasdos[20]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosVeinteyDos(){
        db.collection("Preguntas").document("AKWyutDeWGOzjCOdSkZ9").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenCiv");
                    arregloDepregntasdos[21]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }


    public void obtenerDatosVeinteyTres(){
        db.collection("Preguntas").document("AaZdOSJPaJJNosoQzkaz").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenCiv");
                    arregloDepregntasdos[22]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosVeinteyCuatro(){
        db.collection("Preguntas").document("FqnU7Bt4269ZFwHdlhLb").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenCiv");
                    arregloDepregntasdos[23]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosVeinteyCinco(){
        db.collection("Preguntas").document("MEGU6M9LEwzPjjkApTPT\n").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenCiv");
                    arregloDepregntasdos[24]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosVeinteySeis(){
        db.collection("Preguntas").document("N6AQvDv1djXYFjeL8ARq").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenCiv");
                    arregloDepregntasdos[25]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosVeinteySiete(){
        db.collection("Preguntas").document("QjsYlYNxCMeDV5Ffdj1a").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenCiv");
                    arregloDepregntasdos[26]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosVeinteyOcho(){
        db.collection("Preguntas").document("T4vGJtNvu9obNxyYi1Yw").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenCiv");
                    arregloDepregntasdos[27]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosVeinteyNueve(){
        db.collection("Preguntas").document("WO9dT44jWXdaAGrqeCl6").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenCiv");
                    arregloDepregntasdos[28]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosTreinta(){
        db.collection("Preguntas").document("bcy89WtDta8BxmtIBqgp").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenCiv");
                    arregloDepregntasdos[29]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    /////////////////////////////////PREGUNTAS ESPAÑOL////////////////////////////////
    public void obtenerDatosTreintayUno(){
        db.collection("Preguntas").document("1FDkykgkMrEEy5vV8K2y").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamen");
                    arregloDepregntasdos[30]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }


    public void obtenerDatosTreintayDos(){
        db.collection("Preguntas").document("7sQwBXSHUkubuHiDemMc").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamen");
                    arregloDepregntasdos[31]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosTreintayTres(){
        db.collection("Preguntas").document("9S5yvhQJ3jNiSduC6bIE").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamen");
                    arregloDepregntasdos[32]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosTreintayCuatro(){
        db.collection("Preguntas").document("CRcDje2zk0hTvYFE0ajz").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamen");
                    arregloDepregntasdos[33]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosTreintayCinco(){
        db.collection("Preguntas").document("EIE3lQuKTwEMEsA49xo5").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamen");
                    arregloDepregntasdos[34]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosTreintaySeis(){
        db.collection("Preguntas").document("G3A3KUkIE8D1e4CSHJZh").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamen");
                    arregloDepregntasdos[35]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosTreintaySiete(){
        db.collection("Preguntas").document("PSzfZj94yvyhOJnvzWPB").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamen");
                    arregloDepregntasdos[36]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosTreintayOcho(){
        db.collection("Preguntas").document("PVOlNWz3Y76kAhjtlWBU").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamen");
                    arregloDepregntasdos[37]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosTreintayNueve(){
        db.collection("Preguntas").document("TOaWY0oEhPEf6NwJHjRV").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamen");
                    arregloDepregntasdos[38]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosCuarenta(){
        db.collection("Preguntas").document("VzgxevXoJek7OoIJhALd").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamen");
                    arregloDepregntasdos[39]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    /////////////////////PREGUNTAS QUIMICA//////////////////////////

    public void obtenerDatosCuarentayUno(){
        db.collection("Preguntas").document("0t3hnzmKKkLTu8DVoF8x").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenQuim");
                    arregloDepregntasdos[40]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosCuarentayDos(){
        db.collection("Preguntas").document("7kArfAbtrvlLm9jSL2rT").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenQuim");
                    arregloDepregntasdos[41]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosCuarentayTres(){
        db.collection("Preguntas").document("7zE6rHCpSdlkO1em3AVk").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenQuim");
                    arregloDepregntasdos[42]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosCuarentayCuatro(){
        db.collection("Preguntas").document("IvYj3SOA7mUNsIUdfugt").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenQuim");
                    arregloDepregntasdos[43]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosCuarentayCinco(){
        db.collection("Preguntas").document("KHwyx3aMrHdNU3wOSS6S").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenQuim");
                    arregloDepregntasdos[44]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosCuarentaySeis(){
        db.collection("Preguntas").document("L2JsrxT8N0DhR3Ymt35P").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenQuim");
                    arregloDepregntasdos[45]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosCuarentaySiete(){
        db.collection("Preguntas").document("Rm5tcnF5Ds9jAmrghPzX").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenQuim");
                    arregloDepregntasdos[46]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosCuarentayOcho(){
        db.collection("Preguntas").document("YAf7u0pNuiYJv0yUbrWm").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenQuim");
                    arregloDepregntasdos[47]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosCuarentayNueve(){
        db.collection("Preguntas").document("cnrQRGyVnmr6XMRd1Lao").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenQuim");
                    arregloDepregntasdos[48]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosCincuenta(){
        db.collection("Preguntas").document("eycI1UYy9jtt5izDZvvC").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenQuim");
                    arregloDepregntasdos[49]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }

    /////////////////////PREGUNTAS FISICA/////////////////////
    public void obtenerDatosCincuentayUno(){
        db.collection("Preguntas").document("2XTY6JGACHqFD4it9Hr0").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenFis");
                    arregloDepregntasdos[50]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosCincuentayDos(){
        db.collection("Preguntas").document("BQ5i3mBOW7iz0Tpw3XUf").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenFis");
                    arregloDepregntasdos[51]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }


    public void obtenerDatosCincuentayTres(){
        db.collection("Preguntas").document("HZczBwnJNPg8nDsLD9V4").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenFis");
                    arregloDepregntasdos[52]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosCincuentayCuatro(){
        db.collection("Preguntas").document("L8ELzYAkDuu1ONb4rjXn").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenFis");
                    arregloDepregntasdos[53]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosCincuentayCinco(){
        db.collection("Preguntas").document("RobhtdCWXoEeQWrlOmYk").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenFis");
                    arregloDepregntasdos[54]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosCincuentaySeis(){
        db.collection("Preguntas").document("RpCHQtM7656JMV8qw2BV").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenFis");
                    arregloDepregntasdos[55]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosCincuentaySiete(){
        db.collection("Preguntas").document("SkOQBOQGW1pQvbR58QMI").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenFis");
                    arregloDepregntasdos[56]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosCincuentayOcho(){
        db.collection("Preguntas").document("VDUM4a72pY63hEGqwUoL").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenFis");
                    arregloDepregntasdos[57]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosCincuentayNueve(){
        db.collection("Preguntas").document("bmKAdK3GfqN8Vo6LvwJd").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenFis");
                    arregloDepregntasdos[58]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosSesenta(){
        db.collection("Preguntas").document("dIygxEKiSUjHDPo7Fxnj").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenFis");
                    arregloDepregntasdos[59]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    /////////////////////////////PREGUNTAS BIOLOGIA////////////////////////
    public void obtenerDatosSesentayUno(){
        db.collection("Preguntas").document("40cfXLly0ntfCtIJPG2q").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenBio");
                    arregloDepregntasdos[60]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosSesentayDos(){
        db.collection("Preguntas").document("6lGYZ7hitJZZyqkc6Pgl").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenBio");
                    arregloDepregntasdos[61]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosSesentayTres(){
        db.collection("Preguntas").document("DixV3tWXipA4QbyuFcDW\n").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenBio");
                    arregloDepregntasdos[62]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosSesentayCuatro(){
        db.collection("Preguntas").document("HZwIrQMGrFtCZJ3TIe2l").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenBio");
                    arregloDepregntasdos[63]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosSesentayCinco(){
        db.collection("Preguntas").document("KIBk0PVxRcGEhafotfZm").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenBio");
                    arregloDepregntasdos[64]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosSesentaySeis(){
        db.collection("Preguntas").document("Od41N62E1uAbgYP1R6R1").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenBio");
                    arregloDepregntasdos[65]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosSesentaySiete(){
        db.collection("Preguntas").document("Yb4Jm3G2f71kuqNBiXdb").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenBio");
                    arregloDepregntasdos[66]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosSesentayOcho(){
        db.collection("Preguntas").document("coWCxCd010eJWbc4BWuz").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenBio");
                    arregloDepregntasdos[67]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosSesentayNueve(){
        db.collection("Preguntas").document("cr6H2fq0IPTPoyw9xbrZ").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenBio");
                    arregloDepregntasdos[68]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosOchenta(){
        db.collection("Preguntas").document("enn8jyVSUv9ahMoXcGJ8").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenBio");
                    arregloDepregntasdos[69]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }

    ///////////////////////////PREGUNTAS HISTORIA/////////////////////////////
    public void obtenerDatosOchentayUno(){
        db.collection("Preguntas").document("48vD0PHuLtdpd0gzMRkp").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenHis");
                    arregloDepregntasdos[70]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosOchentayDos(){
        db.collection("Preguntas").document("6AB2bBFMQ1vJJXKOrDEW").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenHis");
                    arregloDepregntasdos[71]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosOchentayTres(){
        db.collection("Preguntas").document("BMBEb5HMohumoIfLQaj8").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenHis");
                    arregloDepregntasdos[72]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosOchentayCuatro(){
        db.collection("Preguntas").document("ChRln3MWHKMdSmsPMZOe").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenHis");
                    arregloDepregntasdos[73]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosOchentayCinco(){
        db.collection("Preguntas").document("J8rAd5R5wr1ZFpvkKMqf").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenHis");
                    arregloDepregntasdos[74]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosOchentaySeis(){
        db.collection("Preguntas").document("TFJkZmu1XOq5Sce790Sa").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenHis");
                    arregloDepregntasdos[75]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosOchentaySiete(){
        db.collection("Preguntas").document("ZZ2u64CGSsyrzuZjLBWu").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenHis");
                    arregloDepregntasdos[76]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosOchentayOcho(){
        db.collection("Preguntas").document("bF79amzoORdFjq5MQ9p9").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenHis");
                    arregloDepregntasdos[77]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosOchentayNueve(){
        db.collection("Preguntas").document("hHBZYZ3bvsFjYFayvNc7").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenHis");
                    arregloDepregntasdos[78]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void obtenerDatosNoventa(){
        db.collection("Preguntas").document("hoDdEukipCv8wQRBzzLS").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {

                    String materia = documentSnapshot.getString("preguntaExamenHis");
                    arregloDepregntasdos[79]=materia;
                    //txtvMateriaTest.setText(materia);
                    //rdbA.setText(arregloDepregntasdos[0]);
                }
            }
        });
    }
    public void ConsultarPreguntas () {
        db.collection("Preguntas").whereEqualTo("materia", "Español")
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        txtvMateriaTest.setText(document.getId()+document.getData().toString());
                        // Log.d("resultado", document.getId() + "->" + document.getData());
                    }
                } else {
                    //  Log.d("no se pudo", "Error getting documents", task.getException());
                }
            }
        });
    }
}