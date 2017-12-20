package com.yinda.rxretrofitdemo.http;

import android.content.Context;

import com.yinda.rxretrofitdemo.HttpDialog;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by ChenXuanHe on 2017/12/20.
 */

public class ProgressObserver<T> implements Observer<T> {

    private HttpDialog dialog;
    private OperateListener listener;
    private Context context;
    private Disposable d;

    public ProgressObserver(Context context, OperateListener listener) {
        this.listener = listener;
        this.context = context;
        if (dialog == null) {
            dialog = new HttpDialog(context);
        }
    }

    @Override
    public void onSubscribe(Disposable d) {
        this.d = d;
        dialog.show();
        listener.onSubscribe(d);
    }

    @Override
    public void onNext(T t) {
        listener.onNext(t);
    }

    @Override
    public void onError(Throwable e) {
        d.dispose();
        dialog.dismiss();
        dialog = null;
        listener.onError(e);
    }

    @Override
    public void onComplete() {
        d.dispose();
        dialog.dismiss();
        dialog = null;
        listener.onComplete();
    }

    public interface OperateListener<T> {

        void onSubscribe(Disposable d);

        void onNext(T t);

        void onError(Throwable e);

        void onComplete();
    }
}
