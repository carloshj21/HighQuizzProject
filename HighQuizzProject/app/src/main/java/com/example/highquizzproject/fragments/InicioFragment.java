package com.example.highquizzproject.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.highquizzproject.PreguntasActivity;
import com.example.highquizzproject.R;

public class InicioFragment extends Fragment {

    private TextView textView2;
    private Button btnPreguntas;
    private Button btnExamen;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_inicio,container,false);

        textView2 = v.findViewById(R.id.textView2);
        btnPreguntas = v.findViewById(R.id.btnPreguntas);
        btnExamen = v.findViewById(R.id.btnExamen);
        btnPreguntas.setOnClickListener(onClickButton);

        return v;
    }

    View.OnClickListener onClickButton = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intentPreguntas = new Intent(getContext(),PreguntasActivity.class);
            startActivity(intentPreguntas);
        }
    };
}
