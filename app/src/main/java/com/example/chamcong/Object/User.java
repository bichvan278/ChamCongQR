package com.example.chamcong.Object;

public class User {
    private String User_id;
    private String User_name;
    private String User_pw;
    private String User_hoten;
    private String User_email;
    private String User_sdt;
    private String User_diachi;
    private String User_gioitinh;
    private String avatar_url;
    private String token;


    public User() {
        this.User_hoten = User_hoten;
        this.User_name = User_name;
    }

    public String getUser_email() {
        return User_email;
    }

    public void setUser_email(String user_email) {
        this.User_email = user_email;
    }

    public String getUser_sdt() {
        return User_sdt;
    }

    public void setUser_sdt(String user_sdt) {
        User_sdt = user_sdt;
    }

    public String getUser_name() {
        return User_name;
    }

    public void setUser_name(String user_name) {
        User_name = user_name;
    }

    public String getUser_pw() {
        return User_pw;
    }

    public void setUser_pw(String user_pw) {
        User_pw = user_pw;
    }

    public String getUser_hoten() {
        return User_hoten;
    }

    public void setUser_hoten(String user_hoten) {
        this.User_hoten = user_hoten;
    }

    public String getUser_diachi() {
        return User_diachi;
    }

    public void setUser_diachi(String user_diachi) {
        User_diachi = user_diachi;
    }

    public String getUser_gioitinh() {
        return User_gioitinh;
    }

    public void setUser_gioitinh(String user_gioitinh) {
        User_gioitinh = user_gioitinh;
    }

    public String getUser_id() {
        return User_id;
    }

    public void setUser_id(String user_id) {
        this.User_id = user_id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
