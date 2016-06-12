package com.xiaopang.oschina.activity;

import android.content.Intent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import com.itheima.oschina.R;
import com.itheima.oschina.activity.base.BaseActivity;

/**
 * 欢迎页面
 */
public class SplashActivity extends BaseActivity {

    @Override
    public int layoutId() {
        return R.layout.hm_activity_splash;
    }

    @Override
    public void initView() {
        Animation anim = new AlphaAnimation(0.5f, 1.0f);
        anim.setDuration(1000);
        mRootView.startAnimation(anim);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    /**
     * 在该页面时，不让返回
     */
    @Override
    public void onBackPressed() {
    }

}
