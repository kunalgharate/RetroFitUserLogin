package com.kunalgahrate.retrofituserlogin;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Skipper on 24-01-2018.
 */

public interface ILoginRetrofit {


    @FormUrlEncoded
    @POST("insert.php")
    Call<User> insertFood(@Field("name") String foodName, @Field("password") String foodQty,@Field("phone") int phone,@Field("emailid") String emailid);
}