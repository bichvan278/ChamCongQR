package com.example.chamcong;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.chamcong.Connect.ConnectionHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import static com.example.chamcong.MyUtil.jsonArrayUser;

public class Thongtinuser extends AppCompatActivity {

    EditText nv_hoten, nv_sdt, nv_gioitinh, nv_email, nv_diachi, nv_tp, nv_quan, nv_phuong ;
    TextView nv_chucvu, nv_phongban;
    Button btnnewpw, btnSave;
    String u_hoten, u_sdt, u_gioitinh, u_email, u_diachi, u_phuong, u_quan, u_tp;
    Connection connect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtinuser);
        setTitle("Thông tin nhân viên");

        nv_hoten = findViewById(R.id.hoten);
        nv_sdt = findViewById(R.id.sdt);
        nv_gioitinh = findViewById(R.id.gioitinh);
        nv_email = findViewById(R.id.email);
        nv_diachi = findViewById(R.id.diachi);
        nv_phuong = findViewById(R.id.phuong);
        nv_tp = findViewById(R.id.tp);
        nv_quan = findViewById(R.id.quan);
        nv_chucvu = findViewById(R.id.chucvu);
        nv_phongban = findViewById(R.id.phongban);


        Intent intent = getIntent();
        int i = intent.getIntExtra("userdata",0);
        int id = intent.getIntExtra("userData",0);

        try {
            JSONObject userObj = jsonArrayUser.getJSONObject(i);

            nv_hoten.setText(userObj.getString("User_hoten"));
            nv_sdt.setText(userObj.getString("User_sdt"));
            nv_gioitinh.setText(userObj.getString("User_gioitinh"));
            nv_email.setText(userObj.getString("User_email"));
            nv_diachi.setText(userObj.getString("User_diachi"));
            nv_chucvu.setText(userObj.getString("Chucvu"));
            nv_phongban.setText(userObj.getString("Phongban"));

        } catch (JSONException e) {
            e.printStackTrace();
        }


//        btnSave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                u_hoten = nv_hoten.getText().toString().trim();
//                u_sdt = nv_sdt.getText().toString().trim();
//                u_gioitinh = nv_gioitinh.getText().toString().trim();
//                u_email = nv_email.getText().toString().trim();
//                u_diachi = nv_diachi.getText().toString().trim();
//                u_phuong = nv_phuong.getText().toString().trim();
//                u_quan = nv_quan.getText().toString().trim();
//                u_tp = nv_tp.getText().toString().trim();
//
//                if (TextUtils.isEmpty(u_hoten)) {
//                    nv_hoten.setError("Vui lòng nhập họ tên");
//                } else if (TextUtils.isEmpty(u_sdt)) {
//                    nv_sdt.setError("Vui lòng nhập số điện thoại");
//                } else if (TextUtils.isEmpty(u_gioitinh)) {
//                    nv_gioitinh.setError("Vui lòng nhập giới tính");
//                } else if (TextUtils.isEmpty(u_email)) {
//                    nv_email.setError("Vui lòng nhập email");
//                } else if (TextUtils.isEmpty(u_diachi)) {
//                    nv_diachi.setError("Vui lòng nhập địa chỉ");
//                } else if (TextUtils.isEmpty(u_phuong)) {
//                    nv_phuong.setError("Vui lòng nhập phường");
//                } else if (TextUtils.isEmpty(u_quan)) {
//                    nv_quan.setError("Vui lòng nhập quận");
//                } else if (TextUtils.isEmpty(u_tp)) {
//                    nv_tp.setError("Vui lòng nhập thành phô");
//                } else {
//                    insertdata(u_hoten, u_sdt, u_gioitinh, u_email, u_diachi, u_phuong, u_quan, u_tp);
//                }
//            }
//        });

//        btnnewpw.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(Thongtinuser.this, Doimatkhau.class);
//                startActivity(i);
//            }
//        });
//    }
//
//    private void insertdata(String u_hoten, String u_sdt, String u_gioitinh, String u_email, String u_diachi, String u_phuong, String u_quan, String u_tp) {
//
//        String url = "http://chamcong.somee.com/api/users";
//
//        // creating a new variable for our request queue
//        RequestQueue queue = Volley.newRequestQueue(Thongtinuser.this);
//
//        // on below line we are calling a string
//        // request method to post the data to our API
//        // in this we are calling a post method.
//        StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                Log.e("TAG", "RESPONSE IS " + response);
//                try {
//                    JSONObject jsonObject = new JSONObject(response);
//                    // on below line we are displaying a success toast message.
//                    Toast.makeText(Thongtinuser.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                // and setting data to edit text as empty
//                nv_hoten.setText("");
//                nv_sdt.setText("");
//                nv_gioitinh.setText("");
//                nv_email.setText("");
//                nv_diachi.setText("");
//                nv_phuong.setText("");
//                nv_quan.setText("");
//                nv_tp.setText("");
//            }
//        }, new com.android.volley.Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                // method to handle errors.
//                Toast.makeText(Thongtinuser.this, "Fail to get response = " + error, Toast.LENGTH_SHORT).show();
//            }
//        }) {
//            @Override
//            public String getBodyContentType() {
//                // as we are passing data in the form of url encoded
//                // so we are passing the content type below
//                return "application/x-www-form-urlencoded; charset=UTF-8";
//            }
//
//            @Override
//            protected Map<String, String> getParams() {
//
//                // below line we are creating a map for storing
//                // our values in key and value pair.
//                Map<String, String> params = new HashMap<String, String>();
//
//                // on below line we are passing our
//                // key and value pair to our parameters.
//                params.put("u_hoten", u_hoten);
//                params.put("u_sdt", u_sdt);
//                params.put("u_gioitinh", u_gioitinh);
//                params.put("u_email", u_email);
//                params.put("u_diachi", u_diachi);
//                params.put("u_phuong", u_phuong);
//                params.put("u_quan", u_quan);
//                params.put("u_tp", u_tp);
//                // at last we are returning our params.
//                return params;
//            }
//        };
//        // below line is to make
//        // a json object request.
//        queue.add(request);
//    }
//
//
//    public void showdata (View v){
//        try {
//            ConnectionHelper connHelper = new ConnectionHelper();
//            connect = connHelper.CONN();
//            if(connect != null){
//
//                String query1 = "SELECT cv_ten FROM Chucvus WHERE cv_id = u_id";
//                Statement st1 = connect.createStatement();
//                ResultSet result1 = st1.executeQuery(query1);
//
//                String query2 = "SELECT pb_ten FROM Phongbans WHERE pb_id = u_id";
//                Statement st2 = connect.createStatement();
//                ResultSet result2 = st1.executeQuery(query2);
//
//                while (result1.next() && result2.next()){
//                    nv_chucvu.setText(result1.getString(String.valueOf(nv_chucvu)));
//                    nv_phongban.setText(result2.getString(String.valueOf(nv_phongban)));
//                }
//            }
//        }catch (Exception ex){
//            Log.e("Error:", ex.getMessage());
//        }
    }
}
