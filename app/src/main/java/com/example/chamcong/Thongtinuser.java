package com.example.chamcong;

import android.annotation.SuppressLint;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class Thongtinuser extends AppCompatActivity {

    Connection connect;
    EditText hoten, sdt, gioitinh, email, diachi, phuong, quan, tp;
    TextView cv, bp;
    Button btnnewpw, btnSave;
    String u_hoten, u_sdt, u_gioitinh, u_email, u_diachi, u_phuong, u_quan, u_tp;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtinuser);

        hoten = (EditText) findViewById(R.id.hoten);
        sdt = (EditText) findViewById(R.id.sdt);
        gioitinh = (EditText) findViewById(R.id.gioitinh);
        email = (EditText) findViewById(R.id.email);
        diachi = (EditText) findViewById(R.id.diachi);
        phuong = (EditText) findViewById(R.id.phuong);
        quan = (EditText) findViewById(R.id.quan);
        tp = (EditText) findViewById(R.id.tp);

        cv = (TextView) findViewById(R.id.chucvu);
        bp = (TextView) findViewById(R.id.bophan);

        btnnewpw = (Button) findViewById(R.id.btnnewpw);
        btnSave = (Button) findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                u_hoten = hoten.getText().toString().trim();
                u_sdt = sdt.getText().toString().trim();
                u_gioitinh = gioitinh.getText().toString().trim();
                u_email = email.getText().toString().trim();
                u_diachi = diachi.getText().toString().trim();
                u_phuong = phuong.getText().toString().trim();
                u_quan = quan.getText().toString().trim();
                u_tp = tp.getText().toString().trim();

                if (TextUtils.isEmpty(u_hoten)) {
                    hoten.setError("Vui lòng nhập họ tên");
                } else if (TextUtils.isEmpty(u_sdt)) {
                    sdt.setError("Vui lòng nhập số điện thoại");
                } else if (TextUtils.isEmpty(u_gioitinh)) {
                    gioitinh.setError("Vui lòng nhập giới tính");
                } else if (TextUtils.isEmpty(u_email)) {
                    email.setError("Vui lòng nhập email");
                } else if (TextUtils.isEmpty(u_diachi)) {
                    diachi.setError("Vui lòng nhập địa chỉ");
                } else if (TextUtils.isEmpty(u_phuong)) {
                    phuong.setError("Vui lòng nhập phường");
                } else if (TextUtils.isEmpty(u_quan)) {
                    quan.setError("Vui lòng nhập quận");
                } else if (TextUtils.isEmpty(u_tp)) {
                    tp.setError("Vui lòng nhập thành phô");
                } else {
                    insertdata(u_hoten, u_sdt, u_gioitinh, u_email, u_diachi, u_phuong, u_quan, u_tp);
                }
            }
        });

        btnnewpw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Thongtinuser.this, Doimatkhau.class);
                startActivity(i);
            }
        });
    }

    public void insertdata ( String u_hoten, String u_sdt, String u_gioitinh, String u_email, String u_diachi, String u_phuong, String u_quan, String u_tp){
//        try {
//            ConnectionHelper conHelper = new ConnectionHelper();
//            connect = conHelper.CONN();
//            if(connect != null){
//                String query = "INSERT INTO users VALUES ('" + u_hoten + "','" + u_sdt + "','" + u_gioitinh + "','" + u_email + "','"+ u_diachi +"','" + u_phuong + "','"+ u_quan +"'" +
//                        ",'"+ u_tp +"');";
//                Statement st = connect.createStatement();
//                ResultSet result = st.executeQuery(query);
//                if(result.next())
//                {
//
//                    Toast.makeText(Thongtinuser.this, "Cập nhật thành công.",
//                            Toast.LENGTH_LONG).show();
//                }
//                else
//                {
//                    Toast.makeText(Thongtinuser.this, "Lỗi! Vui lòng thử lại.",
//                            Toast.LENGTH_LONG).show();
//                }
//            }
//        }
//        catch (Exception ex){
//            Log.e("Error:", ex.getMessage());
//        }

        // url to post our data
        String url = "http://chamcong.somee.com/api/users";

        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(Thongtinuser.this);

        // on below line we are calling a string
        // request method to post the data to our API
        // in this we are calling a post method.
        StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("TAG", "RESPONSE IS " + response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    // on below line we are displaying a success toast message.
                    Toast.makeText(Thongtinuser.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                // and setting data to edit text as empty
                hoten.setText("");
                sdt.setText("");
                gioitinh.setText("");
                email.setText("");
                diachi.setText("");
                phuong.setText("");
                quan.setText("");
                tp.setText("");
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // method to handle errors.
                Toast.makeText(Thongtinuser.this, "Fail to get response = " + error, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public String getBodyContentType() {
                // as we are passing data in the form of url encoded
                // so we are passing the content type below
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }

            @Override
            protected Map<String, String> getParams() {

                // below line we are creating a map for storing
                // our values in key and value pair.
                Map<String, String> params = new HashMap<String, String>();

                // on below line we are passing our
                // key and value pair to our parameters.
                params.put("u_hoten", u_hoten);
                params.put("u_sdt", u_sdt);
                params.put("u_gioitinh", u_gioitinh);
                params.put("u_email", u_email);
                params.put("u_diachi", u_diachi);
                params.put("u_phuong", u_phuong);
                params.put("u_quan", u_quan);
                params.put("u_tp", u_tp);
                // at last we are returning our params.
                return params;
            }
        };
        // below line is to make
        // a json object request.
        queue.add(request);
    }


    public void showdata (View v){
        try {
            ConnectionHelper connHelper = new ConnectionHelper();
            connect = connHelper.CONN();
            if(connect != null){

                    String query1 = "SELECT cv_ten FROM Chucvus WHERE cv_id = u_id";
                Statement st1 = connect.createStatement();
                ResultSet result1 = st1.executeQuery(query1);

                String query2 = "SELECT pb_ten FROM Phongbans WHERE pb_id = u_id";
                Statement st2 = connect.createStatement();
                ResultSet result2 = st1.executeQuery(query2);

                while (result1.next() && result2.next()){
                    cv.setText(result1.getString(String.valueOf(cv)));
                    bp.setText(result2.getString(String.valueOf(bp)));
                }
            }
        }catch (Exception ex){
            Log.e("Error:", ex.getMessage());
        }
    }
}