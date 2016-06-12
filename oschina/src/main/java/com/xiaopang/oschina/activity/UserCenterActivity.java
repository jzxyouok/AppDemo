package com.xiaopang.oschina.activity;

import com.itheima.oschina.R;
import com.itheima.oschina.activity.base.BaseActivity;
import com.itheima.oschina.activity.base.BaseBackActivity;

/**
 * Created by yaoshouyun on 2016/5/13.
 */
public class UserCenterActivity extends BaseBackActivity {

    @Override
    public int layoutId() {
        return R.layout.hm_activity_usercenter;
    }

    @Override
    public String getTitleName() {
        return "用户中心";
    }
}
