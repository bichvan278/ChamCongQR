package com.example.chamcong;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import static com.example.chamcong.MyUtil.jsonArrayUser;

public class TrangchuAdmin extends AppCompatActivity {

    Button scanBtn, logoutBtn, historyBtn, infoBtn, manageuserBtn,
                        manageposBtn, managedepBtn, statisticalBtn;
    TextView nv_hoten, nv_chucvu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu_admin);
        setTitle("Trang chủ Admin");

        nv_hoten = findViewById(R.id.userName);
        nv_chucvu = findViewById(R.id.userChucvu);

        scanBtn = findViewById(R.id.scanBtn);
        historyBtn = findViewById(R.id.historyBtn);
        infoBtn = findViewById(R.id.infoBtn);
        logoutBtn = findViewById(R.id.logoutBtn);
        managedepBtn = findViewById(R.id.managedepBtn);
        manageposBtn = findViewById(R.id.manageposBtn);
        manageuserBtn = findViewById(R.id.manageuserBtn);
        statisticalBtn = findViewById(R.id.statisticalBtn);


        //scan QR
        scanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TrangchuAdmin.this, ScanQR.class);
                startActivity(i);
            }
        });

        //lịch sử chấm công
        historyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TrangchuAdmin.this, Lichsuchamcong.class);
                startActivity(i);
            }
        });

        //thông tin admin
        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TrangchuAdmin.this, Thongtinuser.class);
                startActivity(i);
            }
        });

        //logout
        Intent in = getIntent();
        String string = in.getStringExtra("message");
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(TrangchuAdmin.this);
                builder.setTitle("Xác nhận đăng xuất").
                        setMessage("Bạn muốn đăng xuất?");
                builder.setPositiveButton("Có",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent i = new Intent(getApplicationContext(),
                                        MainActivity.class);
                                startActivity(i);
                            }
                        });
                builder.setNegativeButton("Không",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert11 = builder.create();
                alert11.show();
            }
        });

        //quản lý phòng ban
        managedepBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TrangchuAdmin.this, QuanLyPhongBan.class);
                startActivity(i);
            }
        });

        //quản lý chức vụ
        manageposBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TrangchuAdmin.this, Quanlychucvu.class);
                startActivity(i);
            }
        });

        //quản lý nhân viên
        manageuserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TrangchuAdmin.this, Quanlynhanvien.class);
                startActivity(i);
            }
        });

        //thống kê
        statisticalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TrangchuAdmin.this, Thongke.class);
                startActivity(i);
            }
        });
    }
}