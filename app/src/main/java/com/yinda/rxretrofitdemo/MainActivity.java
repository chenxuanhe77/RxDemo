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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import io.reactivex.disposables.Disposable;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    TextView txt_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
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

}
