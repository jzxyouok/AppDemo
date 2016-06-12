package com.xiaopang.tmall.activity;

import com.xiaopang.common.activity.BaseActivity;
import com.xiaopang.tmall.R;
import com.xiaopang.tmall.fragment.HomeFragment;

public class TmallActivity extends BaseActivity {

    @Override
    public int layoutId() {
        return R.layout.tm_activity_tmall;
    }

    @Override
    public void initView() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new HomeFragment()).commitAllowingStateLoss();
    }

}
