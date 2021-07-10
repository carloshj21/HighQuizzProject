package com.example.highquizzproject.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.highquizzproject.LoginAuth;
import com.example.highquizzproject.PreguntasActivity;
import com.example.highquizzproject.R;
import com.example.highquizzproject.SplashActivity;
import com.google.firebase.auth.FirebaseAuth;

public class PerfilFragment extends Fragment {

    private Button btnLogout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil,container,false);
        btnLogout = v.findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(onClickButton);

        return v;
    }

    View.OnClickListener onClickButton = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FirebaseAuth.getInstance().signOut();
            //Intent intAuth = new Intent(getContext(), SplashActivity.class);
        }
    };
}
