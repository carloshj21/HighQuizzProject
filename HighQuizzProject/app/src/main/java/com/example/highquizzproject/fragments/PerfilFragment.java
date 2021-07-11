package com.example.highquizzproject.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.highquizzproject.LoginAuth;
import com.example.highquizzproject.PreguntasActivity;
import com.example.highquizzproject.R;
import com.example.highquizzproject.RegisterActivity;
import com.example.highquizzproject.SplashActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Array;
import java.util.List;

public class PerfilFragment extends Fragment {

    private Button btnLogout;
    private TextView txtvNombreUsu;
    private TextView txtvCorreoUsu;

    private String nombreUsu;
    private String correoUsu;
    private String idUsu;
    private List<String> usuarios;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseAuth mUser;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_perfil,container,false);

        btnLogout = v.findViewById(R.id.btnLogout);
        txtvNombreUsu = v.findViewById(R.id.txtvNombreUsu);
        txtvCorreoUsu = v.findViewById(R.id.txtvCorreoUsu);

        btnLogout.setOnClickListener(onClickButton);

        mUser = FirebaseAuth.getInstance();
        idUsu = mUser.getCurrentUser().getUid();

        obtenerInformacionUsuario();

        return v;
    }

    View.OnClickListener onClickButton = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getContext(), RegisterActivity.class));
            getActivity().onBackPressed();   // Finaliza el fragment
        }
    };

    private void obtenerInformacionUsuario() {
        txtvCorreoUsu.setText(mUser.getCurrentUser().getEmail());

        /*CollectionReference usuarios = db.collection("Usuarios");
        Query query = usuarios.whereEqualTo("correo",mUser.getCurrentUser().getEmail());*/


        /*Task<QuerySnapshot> querySnapshot = query.get();

        for(DocumentSnapshot document : querySnapshot.getResult().getDocuments()){
            System.out.println(document.getId());
        }*/


        /*db.collection("Usuarios")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("PerfilFragment", document.getId() + " => " + document.getData());
                            }

                        } else {
                            Log.w("PerfilFragment", "Error getting documents.", task.getException());
                        }
                    }
                });*/

        /*db.collection("Usuarios").document(idUsu).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    nombreUsu = documentSnapshot.getString("nombre");
                    txtvNombreUsu.setText(nombreUsu);
                }
            }
        });*/
    }
}
