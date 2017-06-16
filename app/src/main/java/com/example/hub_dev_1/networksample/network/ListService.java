package com.example.hub_dev_1.networksample.network;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public class ListService extends BaseService {
    public static ListAPI api() {
        return (ListAPI) retrofit(ListAPI.class);
    }

    public interface ListAPI {
        @POST("signup")
        Call<Object> signUp(@Body HashMap<String, String> params);

        @POST("login")
        Call<Object> login(@Body HashMap<String, String> params);

        @DELETE("signout")
        Call<Object> leave(@QueryMap HashMap<String, String> params);

    }
}
