package com.example.hub_dev_1.networksample;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.hub_dev_1.networksample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    public void onButtonClick(View view) {

        Intent intent = null;

        switch (view.getId()) {
            case R.id.bt_sign_up:
                Log.e("회원가입", "클릭");
                intent = new Intent(this, SignUpActivity.class);
                break;

            case R.id.bt_login:
                Log.e("로그인", "클릭");
                intent = new Intent(this, LoginActivity.class);
                break;

            case R.id.bt_leave:
                Log.e("회원탈퇴", "클릭");
                intent = new Intent(this, MemberLeaveActivity.class);
                break;
        }

        startActivity(intent);
    }

}
