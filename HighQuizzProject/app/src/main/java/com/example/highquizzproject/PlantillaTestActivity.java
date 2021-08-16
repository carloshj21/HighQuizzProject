package com.example.highquizzproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

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

    private int[] id_answers ={
            R.id.rbOpcion1, R.id.rbOpcion2, R.id.rbOpcion3, R.id.rbOpcion4

    };

    private FirebaseFirestore db=FirebaseFirestore.getInstance();
    public String[] mat;
    public String [] preguntaTest;

    private TextView txtvMateriaTest;
    private TextView txtvPreguntaTest;
    private RadioGroup rdbGroup;
    private Button btnSigPregunta;
    RadioGroup respuestas;

    String [] partesDeLaCadena;
    boolean[] arregloDeRespuestasCorrectas;
    int [] answer;

    int pregunta = 0;
    public static int correcta =0;
    public static int incorrecta=0;
    int num =5;//Indica el número de preguntas de cada asignatura elegida
    int n=0;
    private Handler mHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_plantilla_test);

        Bundle bundle = getIntent().getExtras();
        ArrayList<String> materiasElegidas = bundle.getStringArrayList("strArrayMat");
        mat = new String[materiasElegidas.size()*num];
        preguntaTest=new String[materiasElegidas.size()*num];

        PreguntasSeleccionadas(materiasElegidas); //Este método nos permite consultar solamente las preguntas de las asignaturas previamente seleccionadas

        txtvMateriaTest = findViewById(R.id.txtvMateriaTest);
        txtvPreguntaTest = findViewById(R.id.txtvPreguntaTest);
        btnSigPregunta=findViewById(R.id.btnSigPregunta);
        btnSigPregunta.setOnClickListener(onClickListenerSig);

        arregloDeRespuestasCorrectas = new boolean[preguntaTest.length];
        answer = new int[preguntaTest.length];
        for (int i=0;i<preguntaTest.length;i++){
            answer[i] =-1;
        }

        Animation animacion2= AnimationUtils.loadAnimation(this,R.anim.desplazamiento_izquierda);
        respuestas=findViewById(R.id.rdbGroupOpciones);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() { muestraPreguntasYRespuestas(); }
        }, 1000);

    }

    private void PreguntasSeleccionadas(ArrayList MateriasElegidas)
    {

        if (MateriasElegidas.contains("Español"))
        {
            ConsultarPreguntasEsp();
        }
        if (MateriasElegidas.contains("Matemáticas"))
        {
            ConsultarPreguntasMat();
        }
        if (MateriasElegidas.contains("Biología"))
        {
            ConsultarPreguntasBio();
        }
        if (MateriasElegidas.contains("Historia"))
        {
            ConsultarPreguntasHis();
        }
        if (MateriasElegidas.contains("Geografía"))
        {
            ConsultarPreguntasGeo();
        }
        if (MateriasElegidas.contains("Física"))
        {
            ConsultarPreguntasFis();
        }
        if (MateriasElegidas.contains("Formación Cívica y Ética"))
        {
            ConsultarPreguntasFCE();
        }
        if (MateriasElegidas.contains("Química"))
        {
            ConsultarPreguntasQui();
        }
    }

    private void ConsultarPreguntasHis(){
        db.collection("Preguntas")
                .limit(num)
                .whereEqualTo("materia","Historia")
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshot) {
                        for (QueryDocumentSnapshot documentSnapshot:queryDocumentSnapshot)
                        {
                            preguntaTest[n]=documentSnapshot.getString("preguntaExamenHis");
                            mat[n]=documentSnapshot.getString("materia");
                            n++;
                        }
                    }
                });
    }

    public void ConsultarPreguntasQui(){
        db.collection("Preguntas")
                .limit(num)
                .whereEqualTo("materia","Química")
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshot) {
                        for (QueryDocumentSnapshot documentSnapshot:queryDocumentSnapshot)
                        {
                            preguntaTest[n]=documentSnapshot.getString("preguntaExamenQuim");
                            mat[n]=documentSnapshot.getString("materia");
                            n++;
                        }
                    }
                });
    }

    private void ConsultarPreguntasEsp(){

        db.collection("Preguntas")
                .limit(num)
                .whereEqualTo("materia","Español")
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshot) {
                        for (QueryDocumentSnapshot documentSnapshot:queryDocumentSnapshot)
                        {
                            preguntaTest[n]=documentSnapshot.getString("preguntaExamen");
                            mat[n]=documentSnapshot.getString("materia");
                            n++;
                        }
                    }
                });
    }

    private void ConsultarPreguntasBio(){
        db.collection("Preguntas")
                .limit(num)
                .whereEqualTo("materia","Biología")
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshot) {
                        for (QueryDocumentSnapshot documentSnapshot:queryDocumentSnapshot)
                        {
                            preguntaTest[n]=documentSnapshot.getString("preguntaExamenBio");
                            mat[n]=documentSnapshot.getString("materia");
                            n++;
                        }
                    }
                });
    }

    private void ConsultarPreguntasMat(){
        db.collection("Preguntas")
                .limit(num)
                .whereEqualTo("materia","Matemáticas")
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshot) {
                        for (QueryDocumentSnapshot documentSnapshot:queryDocumentSnapshot)
                        {
                            preguntaTest[n]=documentSnapshot.getString("preguntaExamenMat");
                            mat[n]=documentSnapshot.getString("materia");
                            n++;
                        }
                    }
                });
    }

    private void ConsultarPreguntasGeo(){
        db.collection("Preguntas")
                .limit(num)
                .whereEqualTo("materia","Geografía")
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshot) {
                        for (QueryDocumentSnapshot documentSnapshot:queryDocumentSnapshot)
                        {
                            preguntaTest[n]=documentSnapshot.getString("preguntaExamenGeo");
                            mat[n]=documentSnapshot.getString("materia");
                            n++;
                        }
                    }
                });
    }

    private void ConsultarPreguntasFis(){
        db.collection("Preguntas")
                .limit(num)
                .whereEqualTo("materia","Física")
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshot) {
                        for (QueryDocumentSnapshot documentSnapshot:queryDocumentSnapshot)
                        {
                            preguntaTest[n]=documentSnapshot.getString("preguntaExamenFis");
                            mat[n]=documentSnapshot.getString("materia");
                            n++;
                        }
                    }
                });
    }

    private void ConsultarPreguntasFCE(){
        db.collection("Preguntas")
                .limit(num)
                .whereEqualTo("materia","Formación Cívica y Ética")
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshot) {
                        for (QueryDocumentSnapshot documentSnapshot:queryDocumentSnapshot)
                        {
                            preguntaTest[n]=documentSnapshot.getString("preguntaExamenCiv");
                            mat[n]=documentSnapshot.getString("materia");
                            n++;
                        }
                    }
                });
    }


    public void muestraPreguntasYRespuestas()
    {

        String r0 = preguntaTest[pregunta]; //inicuamos en 0 porque asi inicia pregunta
        partesDeLaCadena= r0.split(";"); //con split lee la cadena del indice querido y separa cuando ve un punto y coma
        String partpreguntas= partesDeLaCadena[0];
        txtvPreguntaTest.setText(partpreguntas);
        txtvMateriaTest.setText(mat[pregunta]);

        for(int i=0; i<id_answers.length;i++) {
            RadioButton rb = findViewById(id_answers[i]);
            //rb.setText(answers[i]);
            String partRespuestas = partesDeLaCadena[i + 1];
            rb.setText(partRespuestas);
            if (answer[pregunta] ==i){
                rb.setChecked(true);      //esto junto con las declaraciones, es para que al regresar, tu respuesta siga marcada
            }
        }

        if (pregunta ==preguntaTest.length-1){
            btnSigPregunta.setText("Finalizar");
        }else {
            btnSigPregunta.setText("Siguiente"); //porque ahora podemos regresar, sino pondria ultima pregunta al regresar y pues no querremos eso
        }
    }

    View.OnClickListener onClickListenerSig =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            animacion();
            //para saber que opcion esta clickada
            String respuestaCorrectaString = partesDeLaCadena[5];
            int respuestaCorrectaInt = Integer.parseInt(respuestaCorrectaString);

            RadioGroup rdbGroup = findViewById(R.id.rdbGroupOpciones); //damos de alta al radio group para utilizar sus indices de opcion tambien
            int idRespuestaElegidaUsuario = rdbGroup.getCheckedRadioButtonId(); //esta linea identifica el id del radio buton que presiono el usuario
            int respuestaUsuario = -1;
            for (int i = 0; i < id_answers.length; i++) { //aqui esta la razon de porque el indice de las preguntas es desde 0 y no 1, porque en este ciclo se ignora la pregunta
                if (id_answers[i] == idRespuestaElegidaUsuario) {
                    respuestaUsuario = i;
                }

            }
            rdbGroup.clearCheck();  //este metodo sirve para ocultar tu radio boton elegido en la pregunta anteriorgroup.clearCheck();  //este metodo sirve para ocultar tu radio boton elegido en la pregunta anterior

            arregloDeRespuestasCorrectas[pregunta] = (respuestaUsuario == respuestaCorrectaInt);
            answer[pregunta]=respuestaUsuario;

            if (pregunta < preguntaTest.length-1) { //no olvidar que la ultima pregunta es la menos 1, por eso se puso

                pregunta++;
                muestraPreguntasYRespuestas();
            }else{
                for (boolean b: arregloDeRespuestasCorrectas) {
                    if (b) correcta++;
                    else incorrecta++;
                }
                Intent intentResultados = new Intent(PlantillaTestActivity.this, ResultadosTest.class);
                startActivity(intentResultados);
                finish();
            }
        }
    };
    public void animacion()//método para animar las opciones y respuestas
    {
        Animation animacion2= AnimationUtils.loadAnimation(this,R.anim.desplazamiento_izquierda);
        respuestas.startAnimation(animacion2);
        txtvPreguntaTest.startAnimation(animacion2);
        txtvMateriaTest.startAnimation(animacion2);

    }

}