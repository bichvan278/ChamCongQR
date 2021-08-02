package com.example.chamcong.API;

import com.example.chamcong.Object.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {
    @POST("login")
    abstract Call<User> userLogIn(@Body User user);

//    @POST("register")
//    Call<User> userSignUp(@Body User user);
//
//    @GET("/api/users")
//    Call<UserList> getData(@Query("page") int pageNumber);
}
