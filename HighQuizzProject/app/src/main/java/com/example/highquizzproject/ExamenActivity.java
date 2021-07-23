package com.example.highquizzproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ExamenActivity extends AppCompatActivity {
    private int[] id_answers ={
            R.id.rdbAnswerA, R.id.rdbAnswerB, R.id.rdbAnswerC, R.id.rdbAnswerD

    };

    private String[] arregloDepregntas ={

            "1.Funciones de una ficha bibliográfica;a)Localizar y conservar información de un libro;b)Leer y memorizar el contenido de un libro;c)Escribir y resumir el contenido de un libro;d)Resumir y memorizar el contenido de un libro;0", //con uno marca b como correcta, por ello PARA RESPUESTAS el indice vuelve a iniciar en 0
            "2. Identifica el enunciado que inicia con una expresión que indica relación de jerarquía;a)En primer lugar, expuso los problemas de salud pública;b)Asimismo, los gobernantes deben cumplir con las leyes;c)Posteriormente, realizó estudios de informática;d)A pesar de su enfermedad, aprobó el examen;0",
            "3.Identifica cuál es el tiempo y el modo del verbo: Observaron;a)Presente de indicativo;b)Copretérito de indicativo;c)Pretérito de indicativo;d)Presente de subjuntivo;2",
            "4.Identifica el enunciado en con verbo en copretérito ;a)La formación que hemos recibido es bastante escasa;b)Este muchacho no se conformaba con poco;c) El libro pretende ayudar a las personas sensibles;d)El cocinero ha estado preparando el festín;1",
            "5.El propósito de la noticia es;a)Dar a conocer un acontecimiento actual importante;b)Comentar sobre un suceso diario;c)Dar a conocer la postura del periódico sobre un hecho;d)Mostar diferentes posturas de un acontecimiento actual;0",


    };


    TextView text_question;
    int pregunta = 0;
    String [] partesDeLaCadena;
    RadioGroup group;
    boolean[] arregloDeRespuestasCorrectas;
    Button btnComprobarRespuesta;
    //Button btnSiguientePregunta;
    int correcta =0;
    int incorrecta=0;
    Button botonAnterior;
    int[] answer;
    int respuestaCorrectaInt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examen);

        text_question = findViewById(R.id.txtv_question);
        btnComprobarRespuesta =findViewById(R.id.btnCheck);
        btnComprobarRespuesta.setOnClickListener(onClickListenerchek);

        arregloDeRespuestasCorrectas = new boolean[arregloDepregntas.length];
        botonAnterior= findViewById(R.id.btn_previo);
        botonAnterior.setOnClickListener(onClickListenerAnterior);
        answer = new int[arregloDepregntas.length];
        for (int i=0;i<arregloDepregntas.length;i++){
            answer[i] =-1;
        }

        muestraPreguntasYRespuestas();

    }
    public void muestraPreguntasYRespuestas(){


        String r0 = arregloDepregntas[pregunta]; //inicuamos en 0 porque asi inicia pregunta
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
        if (pregunta ==arregloDepregntas.length-1){
            btnComprobarRespuesta.setText("ultima pregunta");
        }else {
            btnComprobarRespuesta.setText("Next"); //porque ahora podemos regresar, sino pondria ultima pregunta al regresar y pues no querremos eso
        }
    }

    View.OnClickListener onClickListenerchek = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //para saber que opcion esta clickada
            String respuestaCorrectaString = partesDeLaCadena[5];
            int respuestaCorrectaInt = Integer.parseInt(respuestaCorrectaString);

            //Toast.makeText(getApplicationContext(), respuestaCorrectaInt,Toast.LENGTH_SHORT).show();

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

            if (pregunta < arregloDepregntas.length - 1) { //no olvidar que la ultima pregunta es la menos 1, por eso se puso

                pregunta++;
                muestraPreguntasYRespuestas();
            }else{
                for (boolean b: arregloDeRespuestasCorrectas) {
                    if (b) correcta++;
                    else incorrecta++;
                }
                Toast.makeText(getApplicationContext(), "Correctas"+correcta+" "+"Incorrecta"+incorrecta,Toast.LENGTH_LONG).show();
                finish();
            }
        }


    };

    View.OnClickListener onClickListenerAnterior = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
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



}