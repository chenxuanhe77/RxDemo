package com.yinda.rxretrofitdemo.http;

import com.yinda.rxretrofitdemo.gson.LoginData;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ChenXuanHe on 2017/12/19.
 */

public class MyRxHttp {


    public static void postHttp(Map<String, Object> map, Observer<LoginData> observer) {
        RetrofitFactory.getInstance()
                .login(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }
}
