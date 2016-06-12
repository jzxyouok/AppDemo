package com.xiaopang.oschina.ui.base;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

import butterknife.ButterKnife;

public abstract class BasePopup extends PopupWindow {

    public Activity mActivity;
    public View mRootView;

    public BasePopup(Activity activity) {
        this.mActivity = activity;
        mRootView = View.inflate(mActivity, layoutId(), null);
        ButterKnife.bind(this, mRootView);
        setContentView(mRootView);
        setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
                // 隐藏阴影
                WindowManager.LayoutParams lp = mActivity.getWindow().getAttributes();
                lp.alpha = 1f;
                mActivity.getWindow().setAttributes(lp);
            }
        });
        // 设置窗口宽度
        setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        // 设置窗口高度
        setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        // 设置点窗口以外的区域关闭窗口
        setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setOutsideTouchable(true);
        setFocusable(true);
        initView();
    }

    public abstract int layoutId();

    public void initView() {
    }

}
