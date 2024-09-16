package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.mappers.JsonParsePersona;
import com.example.myapplication.mappers.ListAdapter;
import com.example.myapplication.modelo.Persona;
import com.example.myapplication.modelo.Respuesta;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements Interfaces{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getdata();
    }

    public void getdata() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://randomuser.me/").
                addConverterFactory(GsonConverterFactory.create()).build();

        JsonParsePersona jsn = retrofit.create(JsonParsePersona.class);
        Call<Respuesta> call = jsn.getPersonas(5);
        call.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                Respuesta respuesta = response.body();
                assert respuesta != null;
                List<Persona> lista = respuesta.getResults();
                ListAdapter listAdapter = new ListAdapter(lista, getApplicationContext());
                RecyclerView recyclerView = findViewById(R.id.miRecycleView);
                //GridLayoutManager gridLayoutManager = new GridLayoutManager(getBaseContext(), 4);
                //recyclerView.setLayoutManager(gridLayoutManager);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setAdapter(listAdapter);
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }


    @Override
    public void abrirModal(Bundle data) {
        Vista vista = new Vista();
        vista.setArguments(data);
        vista.show(getSupportFragmentManager(), "vista");
    }
}