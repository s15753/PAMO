package com.example.smartariumapp.data.model;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ZabbixApiClient {
    public static final String BASE_URL = "https://zolw.tk";
    public static Retrofit retrofit;
    /*
    This public static method will return Retrofit client
    anywhere in the appplication
    */
    public static Retrofit getRetrofitClient() {
        //If condition to ensure we don't create multiple retrofit instances in a single application
        if (retrofit == null) {
            //Defining the Retrofit using Builder
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL) //This is the only mandatory call on Builder object.
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}