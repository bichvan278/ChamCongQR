package com.example.chamcong;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class Thongtinphongban extends AppCompatActivity {
    TextView pbID, pbName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtinphongban);
        setTitle("Thông Tin Phòng Ban");

        pbName = findViewById(R.id.pbTen);
        pbID = findViewById(R.id.pbId);


        Intent intent = getIntent();
        int i = intent.getIntExtra("phongbandata", 0);
        int id = intent.getIntExtra("phongbandata", 0);

        try {
            JSONObject userObj = MyUtil.jsonArrayPhongban.getJSONObject(i);

            pbID.setText("ID phòng ban: " + userObj.getString("Pb_id"));
            pbName.setText("Tên phòng ban: " + userObj.getString("Pb_ten"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}