package com.example.adp_29_authnew;

import com.example.adp_29_authnew.Models.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface MyApi {
    @FormUrlEncoded
    @POST("signup.php")
    Call<ResponseBody> createNewAccount(@Field("name") String username,
                                       @Field("email") String email,
                                       @Field("password") String pass
    );

    @FormUrlEncoded
    @POST("login.php")
    Call<User>logIn(@Field("email") String email,
                    @Field("password") String pass
    );

}