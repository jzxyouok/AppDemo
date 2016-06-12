package com.xiaopang.oschina.fragment.base;

import android.view.animation.AnimationUtils;

import com.itheima.oschina.R;

public abstract class BaseAnimFragment extends BaseFragment {

    /**
     * 执行动画
     */
    public void startAnim() {
        if (mRootView != null) {
            mRootView.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.hm_scale));
        }
    }

    /**
     * 停止动画
     */
    public void stopAnim() {
        if (mRootView != null) {
            mRootView.clearAnimation();
        }
    }

}
