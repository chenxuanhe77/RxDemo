package com.yinda.rxretrofitdemo;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by ChenXuanHe on 2017/12/20.
 */

public class HttpDialog extends Dialog {

    public HttpDialog(@NonNull Context context) {
        super(context);

        setContentView(R.layout.dialog_http);

        Window dialogWindow = this.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = 400;
        lp.height = 400;
        lp.alpha = 0.8f;
        dialogWindow.setAttributes(lp);
    }
}
