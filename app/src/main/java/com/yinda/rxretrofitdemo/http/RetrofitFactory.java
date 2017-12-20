package com.yinda.rxretrofitdemo.http;

import com.yinda.rxretrofitdemo.impl.HttpImpl;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ChenXuanHe on 2017/12/18.
 */

public class RetrofitFactory {


    /**
     * 初始化okHttpClient
     */
    private static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10,TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .build();

    /**
     * 初始化接口类
     */
    private static HttpImpl retrofit = new Retrofit.Builder()
//                .baseUrl("https://www.baidu.com/?tn=99055797_hao_pg")
            .baseUrl("http://13.13.13.186:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
            .create(HttpImpl.class);


    /**
     * 获取实例
     *
     * @return
     */
    public static HttpImpl getInstance() {

        return retrofit;
    }

}



