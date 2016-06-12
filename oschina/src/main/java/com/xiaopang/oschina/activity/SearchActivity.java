package com.xiaopang.oschina.activity;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.itheima.oschina.R;
import com.itheima.oschina.activity.base.BaseActivity;

import butterknife.Bind;

/**
 * 搜索页面
 */
public class SearchActivity extends BaseActivity {

    @Bind(R.id.tb_toolbar)
    Toolbar mTbToolbar;

    @Override
    public int layoutId() {
        return R.layout.hm_activity_search;
    }

    @Override
    public void initView() {
        mTbToolbar.setTitle("搜索");
        setSupportActionBar(mTbToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_search, menu);
        return super.onCreateOptionsMenu(menu);
    }

}
