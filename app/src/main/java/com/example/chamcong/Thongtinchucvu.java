package com.example.chamcong;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class Thongtinchucvu extends AppCompatActivity {
    TextView cvID, cvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtinchucvu);
        setTitle("Thông Tin Chức Vụ");

        cvName = findViewById(R.id.cvTen);
        cvID = findViewById(R.id.cvId);


        Intent intent = getIntent();
        int i = intent.getIntExtra("chucvudata", 0);
        int id = intent.getIntExtra("chucvuData", 0);

        try {
            JSONObject userObj = MyUtil.jsonArrayChucvu.getJSONObject(i);

            cvID.setText("ID Chức Vụ: " + userObj.getString("cv_id"));
            cvName.setText("Tên Chức Vụ: " + userObj.getString("cv_ten"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
