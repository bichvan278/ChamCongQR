package com.example.chamcong;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Dangnhap extends AppCompatActivity {

    private Button BtnDangnhap;
    private EditText EtUsername, EtPassword;
    private static final String TAG = "Dangnhap";
    private static final int REQUEST_SIGNUP = 0;
    private ProgressDialog pDialog;

    private static final String DATABASE_NAME = "Db_chamcong.db";

     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_dangnhap);

         BtnDangnhap = (Button) findViewById(R.id.btnlogin);
         EtUsername = (EditText) findViewById(R.id.username);
         EtPassword = (EditText) findViewById(R.id.password);

         BtnDangnhap.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 String username = EtUsername.getText().toString().trim();
                 String password = EtPassword.getText().toString().trim();

                 if(username == null || username.trim().length() == 0){
                     Toast.makeText(Dangnhap.this, "Username is required", Toast.LENGTH_SHORT).show();
                 }
                 if(password == null || password.trim().length() == 0){
                     Toast.makeText(Dangnhap.this, "Password is required", Toast.LENGTH_SHORT).show();
                 }else if(username == "user1" && password == "1111"){
                     Intent intent = new Intent(Dangnhap.this, Trangchu.class);
                     startActivity(intent);
                 }else {
                     Intent i = new Intent(Dangnhap.this, TrangchuAdmin.class);
                     startActivity(i);
                 }
             }
         });
     }

//    private void login(String username, String password) {
//        Log.d(TAG, "Login");
//
//        if (!validate(username,password)) {
//            onLoginFailed();
//            return;
//        }
//        BtnDangnhap.setEnabled(false);
//        loginByServer();
//    }
//
//    private void loginByServer() {
//        pDialog = new ProgressDialog(Dangnhap.this);
//        pDialog.setIndeterminate(true);
//        pDialog.setMessage("Creating Account...");
//        pDialog.setCancelable(false);
//
//        showpDialog();
//
//        String username = EtUsername.getText().toString();
//        String password = EtPassword.getText().toString();
//
//
//        APIService service = ApiClient.getClient().create(APIService.class);
//        User user = new User();
//        user.setUser_name(username);
//        user.setUser_pw(password);
//
//        service.userLogIn(user).enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                hidepDialog();
//
//                if (response.isSuccessful()) {
//                    onLoginSuccess();
//                } else {
//                    Toast.makeText(Dangnhap.this, "Wrong password : ErrorCode : 200" + response.toString(), Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                hidepDialog();
//            }
//        });
//    }
//    private void showpDialog() {
//
//        if (!pDialog.isShowing())
//            pDialog.show();
//    }
//
//    private void hidepDialog() {
//        if (pDialog.isShowing())
//            pDialog.dismiss();
//    }
//
//
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == REQUEST_SIGNUP) {
//            if (resultCode == RESULT_OK) {
//
//                // TODO: Implement successful signup logic here
//            }
//        }
//    }
//
//    public void onLoginSuccess() {
//        Intent i = new Intent(Dangnhap.this, Trangchu.class);
//        startActivity(i);
//    }
//
//    public void onLoginFailed() {
//
//        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
//
//        BtnDangnhap.setEnabled(true);
//    }
//
//    public boolean validate(String username, String password) {
//        boolean valid = true;
//
////        String username = EtUsername.getText().toString();
////        String password = EtPassword.getText().toString();
//
//        if (username.isEmpty()) {
//            EtUsername.setError("Enter a valid username");
//            requestFocus(EtUsername);
//            valid = false;
//        } else {
//            EtUsername.setError(null);
//        }
//
//        if (password.isEmpty()) {
//            EtPassword.setError("Password is empty");
//            requestFocus(EtPassword);
//            valid = false;
//        } else {
//            EtPassword.setError(null);
//        }
//
//        return valid;
//    }
//
//    private void requestFocus(View view) {
//        if (view.requestFocus()) {
//            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
//        }
//    }
//
}