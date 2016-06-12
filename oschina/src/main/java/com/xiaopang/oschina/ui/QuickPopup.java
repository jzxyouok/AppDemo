package com.xiaopang.oschina.ui;

import android.app.Activity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.WindowManager;

import com.itheima.oschina.R;
import com.itheima.oschina.adapter.home.QuickAdapter;
import com.itheima.oschina.window.base.BasePopup;

import butterknife.Bind;

public class QuickPopup extends BasePopup {

    @Bind(R.id.rv_options)
    RecyclerView mRvOptions;

    public QuickPopup(Activity activity) {
        super(activity);
    }

    @Override
    public int layoutId() {
        return R.layout.hm_ui_popup_quick;
    }

    @Override
    public void initView() {
        mRvOptions.setLayoutManager(new GridLayoutManager(mActivity, 3));
        mRvOptions.setAdapter(new QuickAdapter(mActivity));
        mRvOptions.startLayoutAnimation();
        setAnimationStyle(R.style.popup_quick_anim);
    }


    public void show() {
        WindowManager.LayoutParams lp = mActivity.getWindow().getAttributes();
        lp.alpha = 0.6f;
        mActivity.getWindow().setAttributes(lp);
        showAtLocation(mRootView, Gravity.LEFT + Gravity.BOTTOM, 0, 0);
    }

}
