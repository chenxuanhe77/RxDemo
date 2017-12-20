package com.yinda.rxretrofitdemo.http;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ChenXuanHe on 2017/12/19.
 */

public class MyRxHttp {

    /**
     * 封装订阅方法
     *
     * @param observable
     * @param observer
     * @param <T>
     */
    public static <T> void toSubscribe(Observable<T> observable, Observer<T> observer) {
        observable
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


}
