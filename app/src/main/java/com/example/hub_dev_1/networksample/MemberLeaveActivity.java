package com.example.hub_dev_1.networksample;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.hub_dev_1.networksample.databinding.ActivityMemberLeaveBinding;

public class MemberLeaveActivity extends AppCompatActivity {

    ActivityMemberLeaveBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_member_leave);
    }

    public void onButtonClick(View view) {
        Log.e("회원탈퇴", "클릭");
        Intent intent = new Intent(this, MemberLeaveActivity.class);
        startActivity(intent);
    }
}
