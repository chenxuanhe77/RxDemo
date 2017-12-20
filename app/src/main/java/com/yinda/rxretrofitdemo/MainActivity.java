package com.yinda.rxretrofitdemo;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yinda.rxretrofitdemo.gson.LoginData;
import com.yinda.rxretrofitdemo.http.MyRxHttp;
import com.yinda.rxretrofitdemo.http.ProgressObserver;
import com.yinda.rxretrofitdemo.http.RetrofitFactory;
import com.yinda.rxretrofitdemo.http.StandardObserver;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    TextView txt_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
        Button btn_baidu = findViewById(R.id.btn_baidu);
        btn_baidu.setOnClickListener(this);
        txt_login = findViewById(R.id.txt_login);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                login();
                break;
            case R.id.btn_baidu:
                baidu();
                break;
        }
    }

    private void login() {
        HashMap<String, Object> param = new HashMap<>();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Msisdn", "13aaaaaaa");
            jsonObject.put("Imei", "862033030640468ec0ed0bf54717eb6");
            jsonObject.put("phoneType", Build.MODEL + "-" + Build.VERSION.RELEASE);
            jsonObject.put("phoneBrand", Build.BRAND);
            param.put("request", jsonObject);
        } catch (JSONException E) {
            E.printStackTrace();
        }
        ProgressObserver<LoginData> observer = new ProgressObserver<LoginData>(
                ContextHelper.getActivityContext(),
                new ProgressObserver.OperateListener<LoginData>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginData loginData) {
                        System.out.println(loginData.toString());
                        txt_login.setText(loginData.toString());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        MyRxHttp.toSubscribe(RetrofitFactory.getInstance().login(param), observer);
    }

    private void baidu() {
        StandardObserver<ResponseBody> observer = new StandardObserver<ResponseBody>(
                new StandardObserver.OperateListener<ResponseBody>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            System.out.println(responseBody.string());
                            txt_login.setText(responseBody.string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        MyRxHttp.toSubscribe(RetrofitFactory.getInstanceBaidu().baidu(), observer);
    }

}
