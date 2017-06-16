package com.example.hub_dev_1.networksample.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseService {

    protected static Object retrofit(Class<?> className) {
        String host = "http://127.0.0.1:5000/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(host)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(className);
    }
}