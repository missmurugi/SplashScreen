package com.example.splashscreen.services;



import com.example.splashscreen.response_object.AdminResponseObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Repository {




    @FormUrlEncoded
    @POST("register_admin")
    Call<AdminResponseObject> createAdmin(

            @Field("adminname") String name,
            @Field("adminemail") String email,
            @Field("adminpassword") String password

    );

//
//    @GET("BuildConfig")
//    Call<AdminResponseObject> distanceMatrix(
//            @Field("origins") String origins
//
//    );




}