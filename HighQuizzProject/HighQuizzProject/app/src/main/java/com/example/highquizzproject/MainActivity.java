package com.example.highquizzproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.highquizzproject.fragments.InicioFragment;
import com.example.highquizzproject.fragments.PerfilFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView btnNavigationPrincipal;
    private InicioFragment inicioFragment;
    private PerfilFragment perfilFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        btnNavigationPrincipal = findViewById(R.id.btnNavigationPrincipal);
        btnNavigationPrincipal.setItemIconTintList(null);
        inicioFragment = new InicioFragment();
        perfilFragment = new PerfilFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContenedor,inicioFragment).commit();   // EL primer fragment en mostrarse al iniciar la aplicación

        btnNavigationPrincipal.setOnNavigationItemSelectedListener(navListener);   // Asociación para que funcione el bottomNavigation
    }

    BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.nav_home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContenedor,inicioFragment).commit();

                    break;
                case R.id.nav_profile:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContenedor,perfilFragment).commit();
                    break;
            }
            return false;
        }
    };

}