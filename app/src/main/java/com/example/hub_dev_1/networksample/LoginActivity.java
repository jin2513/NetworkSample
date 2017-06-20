package com.example.hub_dev_1.networksample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.hub_dev_1.networksample.databinding.ActivityLoginBinding;
import com.example.hub_dev_1.networksample.network.ListService;
import com.google.gson.Gson;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
    }

    public void onButtonClick(View view) {
        Log.e("로그인", "클릭");
        login();
    }

    private void login() {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("email", binding.etLoginId.getText().toString());
        params.put("passwd", binding.etLoginPw.getText().toString());

        ListService.api().login(params).enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Gson gson = new Gson();
                String json = gson.toJson(response);
                Log.e("json", json);
                Log.e("response header", response.headers().toString());
                Log.e("response body", response.body().toString());
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Log.e("fail", "fail");
            }
        });
    }
}
