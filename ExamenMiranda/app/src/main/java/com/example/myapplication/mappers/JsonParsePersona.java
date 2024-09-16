package com.example.myapplication.mappers;

import com.example.myapplication.modelo.Respuesta;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonParsePersona {

    @GET("api/")
    Call<Respuesta> getPersonas(@Query("result") int num);
}
