package com.example.smartariumapp.data.model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *  Class that returns base Retrofit instance.
 *
 * @author Robert Chojdak
 * @version 2020.05
 * @since 1.0
 */

public class ZabbixApiClient {

    public static Retrofit retrofit;
    /**
     * This public static method will return Retrofit client anywhere in the application.
     *
     * @param url String representation of main URI
     * @return Retrofit instance with added GSON converter and provided URI
     *
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