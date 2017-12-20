package com.yinda.rxretrofitdemo.http;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by ChenXuanHe on 2017/12/20.
 */

public class StandardObserver<T> implements Observer<T>{

    private StandardObserver.OperateListener listener;
    private Disposable d;

    public StandardObserver(StandardObserver.OperateListener listener) {
        this.listener = listener;
    }

    @Override
    public void onSubscribe(Disposable d) {
        this.d = d;
        listener.onSubscribe(d);
    }

    @Override
    public void onNext(T t) {
        listener.onNext(t);
    }

    @Override
    public void onError(Throwable e) {
        d.dispose();
        listener.onError(e);
    }

    @Override
    public void onComplete() {
        d.dispose();
        listener.onComplete();
    }
    public interface OperateListener<T>{

        void onSubscribe(Disposable d);

        void onNext(T t);

        void onError(Throwable e);

        void onComplete();
    }
}
