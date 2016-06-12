package com.xiaopang.oschina.ui.base;

import android.content.Context;
import android.support.v7.app.AppCompatDialog;
import android.view.View;

import butterknife.ButterKnife;

public abstract class BaseDialog extends AppCompatDialog {

    public View mRootView;

    public BaseDialog(Context context) {
        super(context);
        mRootView = View.inflate(context, layoutId(), null);
        ButterKnife.bind(this, mRootView);
        setContentView(mRootView);
        setTitle("提示");
        setCancelable(false);
        initView();
    }

    public abstract int layoutId();

    public void initView() {
    }

}
