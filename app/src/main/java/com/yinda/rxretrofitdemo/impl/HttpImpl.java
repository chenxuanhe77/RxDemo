package com.yinda.rxretrofitdemo.impl;

import com.yinda.rxretrofitdemo.gson.LoginData;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by ChenXuanHe on 2017/12/18.
 */

public interface HttpImpl {

    @FormUrlEncoded
    @POST("zt/appManage!AppUserLogin.action")
    Observable<LoginData> login(@FieldMap Map<String, Object> map);

    @GET("/")
    Call<ResponseBody> baidu();

}
