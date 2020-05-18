package com.example.smartariumapp.data.model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ZabbixApiClient {

    public static Retrofit retrofit;
    /*
    This public static method will return Retrofit client
    anywhere in the appplication
    */
    public static Retrofit getRetrofitClient(String url) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}