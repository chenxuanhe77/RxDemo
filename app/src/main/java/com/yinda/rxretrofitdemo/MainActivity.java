package com.yinda.rxretrofitdemo;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yinda.rxretrofitdemo.gson.LoginData;
import com.yinda.rxretrofitdemo.http.MyRxHttp;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    TextView txt_login;
    TextView txt_login1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
        txt_login = findViewById(R.id.txt_login);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
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
                MyRxHttp.postHttp(param, observer);
                break;
        }
    }

    /**
     * 定义一个登陆的观察者
     */
    private Observer<LoginData> observer = new Observer<LoginData>() {
        Disposable d;

        @Override
        public void onSubscribe(Disposable d) {
            this.d = d;
        }

        @Override
        public void onNext(LoginData loginData) {
            Log.d(TAG, "成功----------: " + loginData.toString());
            txt_login.setText(loginData.toString());
        }

        @Override
        public void onError(Throwable e) {
            d.dispose();
        }

        @Override
        public void onComplete() {
            d.dispose();
        }
    };
}
