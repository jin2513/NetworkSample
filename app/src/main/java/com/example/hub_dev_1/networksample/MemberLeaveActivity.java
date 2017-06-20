package com.example.hub_dev_1.networksample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.hub_dev_1.networksample.databinding.ActivityMemberLeaveBinding;
import com.example.hub_dev_1.networksample.network.ListService;
import com.google.gson.Gson;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MemberLeaveActivity extends AppCompatActivity {

    ActivityMemberLeaveBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_member_leave);
    }

    public void onButtonClick(View view) {
        Log.e("회원탈퇴", "클릭");
        leave();
    }

    private void leave() {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("email", binding.etLeaveId.getText().toString());
        params.put("passwd", binding.etLeavePw.getText().toString());

        ListService.api().leave(params).enqueue(new Callback<Object>() {
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
