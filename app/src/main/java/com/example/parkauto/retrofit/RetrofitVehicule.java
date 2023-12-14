package com.example.parkauto.retrofit;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitVehicule {
    private Retrofit retrofit;

    public RetrofitVehicule() {
        initializeRetrofit();
    }
        private void initializeRetrofit () {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://192.168.1.92:8080")
                    .addConverterFactory(GsonConverterFactory.create(new Gson()))
                    .build();

    }
    public Retrofit getRetrofit(){
        return retrofit;

    }
}