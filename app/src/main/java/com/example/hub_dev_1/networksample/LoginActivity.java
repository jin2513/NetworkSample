package com.example.hub_dev_1.networksample;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.hub_dev_1.networksample.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
    }

    public void onButtonClick(View view) {
        Log.e("로그인", "클릭");
        Intent intent = new Intent(this, ResultActivity.class);
        startActivity(intent);
    }
}
