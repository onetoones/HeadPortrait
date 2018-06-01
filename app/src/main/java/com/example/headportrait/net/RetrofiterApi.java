package com.example.headportrait.net;

import com.example.headportrait.MyBean;
import com.example.headportrait.base.UserBean;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * @Creation date
 * @name
 * @Class action
 */

public interface RetrofiterApi {

    @POST("file/upload")
    @Multipart
    Observable<MyBean> head(@Query("uid") String uid, @Part MultipartBody.Part file);

    @GET("user/getUserInfo")
    Observable<UserBean> users(@Query("uid") String uid);

}
