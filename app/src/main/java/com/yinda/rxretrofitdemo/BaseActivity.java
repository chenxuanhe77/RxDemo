package com.yinda.rxretrofitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ChenXuanHe on 2017/12/20.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ContextHelper.setActivityContext(this);
        setContentView(this.getLayoutId());
        this.initView();
    }

    protected abstract int getLayoutId();

    protected abstract void initView();
}
