package com.xiaopang.oschina.activity;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.itheima.oschina.R;
import com.itheima.oschina.activity.base.BaseActivity;
import com.itheima.oschina.activity.base.BaseBackActivity;

import butterknife.Bind;

/**
 * 设置页面
 */
public class SettingActivity extends BaseBackActivity {

    @Override
    public int layoutId() {
        return R.layout.hm_activity_setting;
    }

    @Override
    public String getTitleName() {
        return "设置";
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_search, menu);
        return super.onCreateOptionsMenu(menu);
    }

}
