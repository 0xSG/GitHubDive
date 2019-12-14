package com.atomtray.android.githubdive.api;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {

    public static final String BASE_URL= "https://api.github.com";
    public static Retrofit refrofit = null;

    public static Retrofit getClient(){
        if(refrofit == null){
            refrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return refrofit;
    }
}
