package com.example.appapiconviewmodel;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppMain extends AppCompatActivity {

    UsuarioViewModel vm;
    AppAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.RecyclerMain);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adaptador = new AppAdaptador(this);
        recyclerView.setAdapter(adaptador);

        vm = new ViewModelProvider(this).get(UsuarioViewModel.class);


        vm.obtenerDatos().observe(this, new Observer<List<Usuario>>() {
            @Override
            public void onChanged(List<Usuario> pruebas) {
                // Actualizar el UI
                adaptador.addData(new ArrayList(pruebas));
            }
        });







    }
}