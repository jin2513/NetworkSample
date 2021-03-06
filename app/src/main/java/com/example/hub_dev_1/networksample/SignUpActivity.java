package com.example.hub_dev_1.networksample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.hub_dev_1.networksample.databinding.ActivitySignUpBinding;
import com.example.hub_dev_1.networksample.network.ListService;
import com.google.gson.Gson;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SignUpActivity extends AppCompatActivity {

    ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up);
    }

    public void onButtonClick(View view) {
        Log.e("회원가입", "클릭");
        postSignUp();
    }

    private void postSignUp() {
        // network connect
        // 먼가를 작업함 111
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("username", binding.etSignUpId.getText().toString());
        params.put("passwd", binding.etSignUpPw.getText().toString());
        params.put("email", binding.etSignUpEmail.getText().toString());
        ListService.api().signUp(params).enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Gson gson = new Gson();
                String json = gson.toJson(response);
                Log.e("json", json);
                Log.e("response", response.body().toString());
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Log.e("fail", "fail");
            }
        });
    }

}
