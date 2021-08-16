package com.example.highquizzproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class ExamenActivity extends AppCompatActivity {

    private int[] id_answers ={
            R.id.rdbAnswerA, R.id.rdbAnswerB, R.id.rdbAnswerC, R.id.rdbAnswerD

    };

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    public String [] arregloDepregntasdos;

    private TextView text_question;
    private Button botonAnterior;
    private Button btnComprobarRespuesta;
    private RadioGroup group;
    RadioGroup respuestas;

    String [] partesDeLaCadena;
    boolean[] arregloDeRespuestasCorrectas;
    int[] answer;

    int num=5; //Indica el número de preguntas por materia
    int n=0;
    public static int correcta =0;
    public static int incorrecta=0;
    int pregunta = 0;
    int respuestaCorrectaInt;

    private Handler mHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_examen);

        arregloDepregntasdos=new String[8*num];

        RealizarConsulta();


        text_question = findViewById(R.id.txtv_question);
        btnComprobarRespuesta =findViewById(R.id.btnCheck);
        btnComprobarRespuesta.setOnClickListener(onClickListenerchek);

        arregloDeRespuestasCorrectas = new boolean[arregloDepregntasdos.length];
        botonAnterior= findViewById(R.id.btn_previo);
        botonAnterior.setOnClickListener(onClickListenerAnterior);
        answer = new int[arregloDepregntasdos.length];
        for (int i=0;i<arregloDepregntasdos.length;i++){
            answer[i] =-1;
        }

        Animation animacion2= AnimationUtils.loadAnimation(this,R.anim.desplazamiento_izquierda);
        respuestas=findViewById(R.id.rdbGroup);


        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                muestraPreguntasYRespuestas();
            }
        }, 1000);

    }

    private void RealizarConsulta() {
        ConsultarPreguntasExEsp();
        ConsultarPreguntasExBio();
        ConsultarPreguntasExFCE();
        ConsultarPreguntasExHis();
        ConsultarPreguntasExGeo();
        ConsultarPreguntasExMat();
        ConsultarPreguntasExQui();
        ConsultarPreguntasExFis();
    }

    private void ConsultarPreguntasExHis(){
        db.collection("Preguntas")
                .whereEqualTo("materia","Historia")
                .limit(num)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshot) {
                        for (QueryDocumentSnapshot documentSnapshot:queryDocumentSnapshot)
                        {
                            arregloDepregntasdos[n]=documentSnapshot.getString("preguntaExamenHis");
                            n++;
                        }
                    }
                });
    }

    public void ConsultarPreguntasExQui(){
        db.collection("Preguntas")
                .whereEqualTo("materia","Química")
                .limit(num)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshot) {
                        for (QueryDocumentSnapshot documentSnapshot:queryDocumentSnapshot)
                        {
                            arregloDepregntasdos[n]=documentSnapshot.getString("preguntaExamenQuim");
                            n++;
                        }
                    }
                });
    }

    private void ConsultarPreguntasExEsp(){

        db.collection("Preguntas")
                .whereEqualTo("materia","Español")
                .limit(num)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshot) {
                        for (QueryDocumentSnapshot documentSnapshot:queryDocumentSnapshot)
                        {
                            arregloDepregntasdos[n]=documentSnapshot.getString("preguntaExamen");
                            n++;
                        }
                    }
                });
    }

    private void ConsultarPreguntasExBio(){
        db.collection("Preguntas")
                .whereEqualTo("materia","Biología")
                .limit(num)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshot) {
                        for (QueryDocumentSnapshot documentSnapshot:queryDocumentSnapshot)
                        {
                            arregloDepregntasdos[n]=documentSnapshot.getString("preguntaExamenBio");
                            n++;
                        }
                    }
                });
    }

    private void ConsultarPreguntasExMat(){
        db.collection("Preguntas")
                .whereEqualTo("materia","Matemáticas")
                .limit(num)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshot) {
                        for (QueryDocumentSnapshot documentSnapshot:queryDocumentSnapshot)
                        {
                            arregloDepregntasdos[n]=documentSnapshot.getString("preguntaExamenMat");
                            n++;
                        }
                    }
                });
    }

    private void ConsultarPreguntasExGeo(){
        db.collection("Preguntas")
                .whereEqualTo("materia","Geografía")
                .limit(num)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshot) {
                        for (QueryDocumentSnapshot documentSnapshot:queryDocumentSnapshot)
                        {
                            arregloDepregntasdos[n]=documentSnapshot.getString("preguntaExamenGeo");
                            n++;
                        }
                    }
                });
    }

    private void ConsultarPreguntasExFis(){
        db.collection("Preguntas")
                .whereEqualTo("materia","Física")
                .limit(num)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshot) {
                        for (QueryDocumentSnapshot documentSnapshot:queryDocumentSnapshot)
                        {
                            arregloDepregntasdos[n]=documentSnapshot.getString("preguntaExamenFis");
                            n++;
                        }
                    }
                });
    }

    private void ConsultarPreguntasExFCE(){
        db.collection("Preguntas")
                .whereEqualTo("materia","Formación Cívica y Ética")
                .limit(num)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshot) {
                        for (QueryDocumentSnapshot documentSnapshot:queryDocumentSnapshot)
                        {
                            arregloDepregntasdos[n]=documentSnapshot.getString("preguntaExamenCiv");
                            n++;
                        }
                    }
                });
    }


    public void muestraPreguntasYRespuestas(){


        String r0 = arregloDepregntasdos[pregunta]; //inicuamos en 0 porque asi inicia pregunta
        partesDeLaCadena= r0.split(";"); //con split lee la cadena del indice querido y separa cuando ve un punto y coma
        String partpreguntas= partesDeLaCadena[0];
        text_question.setText(partpreguntas);

        for(int i=0; i<id_answers.length;i++){
            RadioButton rb = findViewById(id_answers[i]);
            //rb.setText(answers[i]);
            String partRespuestas = partesDeLaCadena[i+1];
            rb.setText(partRespuestas);

            if (answer[pregunta] ==i){
                rb.setChecked(true);      //esto junto con las declaraciones, es para que al regresar, tu respuesta siga marcada
            }
        }
        if(pregunta==0){
            botonAnterior.setVisibility(View.GONE); //hace invisible el boton regresar en caso de estar en la primer pregunta
        } else {
            botonAnterior.setVisibility(View.VISIBLE); // esto se pone porque tu lo volviste invisible, pero que, a si se va a quedar, pues no, para la siguiente pregunta necesita verse ya
        }
        if (pregunta ==arregloDepregntasdos.length-1){
            btnComprobarRespuesta.setText("Finalizar");
        }else {
            btnComprobarRespuesta.setText("Siguiente"); //porque ahora podemos regresar, sino pondria ultima pregunta al regresar y pues no querremos eso
        }
    }

    View.OnClickListener onClickListenerchek = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //para saber que opcion esta clickada
            String respuestaCorrectaString = partesDeLaCadena[5];
            int respuestaCorrectaInt = Integer.parseInt(respuestaCorrectaString);


            RadioGroup group = findViewById(R.id.rdbGroup); //damos de alta al radio group para utilizar sus indices de opcion tambien
            int idRespuestaElegidaUsuario = group.getCheckedRadioButtonId(); //esta linea identifica el id del radio buton que pucho el usuario
            int respuestaUsuario = -1;
            for (int i = 0; i < id_answers.length; i++) { //aqui esta la razon de porque el indice de las preguntas es desde 0 y no 1, porque en este ciclo se ignora la pregunta
                if (id_answers[i] == idRespuestaElegidaUsuario) {
                    respuestaUsuario = i;
                }

            }
            group.clearCheck();  //este metodo sirve para ocultar tu radio boton elegido en la pregunta anteriorgroup.clearCheck();  //este metodo sirve para ocultar tu radio boton elegido en la pregunta anterior

            arregloDeRespuestasCorrectas[pregunta] = (respuestaUsuario == respuestaCorrectaInt);
            answer[pregunta]=respuestaUsuario;

            if (pregunta < arregloDepregntasdos.length - 1) { //no olvidar que la ultima pregunta es la menos 1, por eso se puso
                animacion();
                pregunta++;
                muestraPreguntasYRespuestas();
            }else{
                for (boolean b: arregloDeRespuestasCorrectas) {
                    if (b) correcta++;
                    else incorrecta++;
                }
                Intent intentResultados = new Intent(ExamenActivity.this, Resultados.class);
                startActivity(intentResultados);
                finish();
            }
        }

    };

    View.OnClickListener onClickListenerAnterior = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            animacion();
            RadioGroup group = findViewById(R.id.rdbGroup); //damos de alta al radio group para utilizar sus indices de opcion tambien
            int idRespuestaElegidaUsuario = group.getCheckedRadioButtonId(); //esta linea identifica el id del radio buton que pucho el usuario
            int respuestaUsuario = -1;
            for (int i = 0; i < id_answers.length; i++) { //aqui esta la razon de porque el indice de las preguntas es desde 0 y no 1, porque en este ciclo se ignora la pregunta
                if (id_answers[i] == idRespuestaElegidaUsuario) {
                    respuestaUsuario = i;
                }
            }
            group.clearCheck();  //este metodo sirve para ocultar tu radio boton elegido en la pregunta anteriorgroup.clearCheck();  //este metodo sirve para ocultar tu radio boton elegido en la pregunta anterior

            arregloDeRespuestasCorrectas[pregunta] = (respuestaUsuario == respuestaCorrectaInt);
            answer[pregunta]=respuestaUsuario;
            if(pregunta>0){
                pregunta--;
                muestraPreguntasYRespuestas();
            }
        }
    };

    public void animacion()//método para animar las opciones y respuestas
    {
        Animation animacion2= AnimationUtils.loadAnimation(this,R.anim.desplazamiento_izquierda);
        respuestas.startAnimation(animacion2);
        text_question.startAnimation(animacion2);

    }



}