package com.example.highquizzproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    private static final long DURACION_SPLASH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);   // Se obliga a que la vista siempre esté vertical
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);  // Pantalla completa
        setContentView(R.layout.activity_splash);

        ImageView imageView2=findViewById(R.id.imageView2);

        Animation animacion1= AnimationUtils.loadAnimation(this,R.anim.desplazamiento_arriba);
        imageView2.setAnimation(animacion1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Intent intAuth = new Intent(getApplicationContext(),LoginAuth.class);
                Intent intRegister = new Intent(getApplicationContext(),RegisterActivity.class);
                //startActivity(intAuth);
                startActivity(intRegister);
                finish();
            }
        },DURACION_SPLASH);
    }
}