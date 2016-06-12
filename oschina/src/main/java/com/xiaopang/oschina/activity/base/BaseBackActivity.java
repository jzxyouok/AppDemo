package com.xiaopang.oschina.activity.base;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.itheima.oschina.R;

import butterknife.Bind;

public abstract class BaseBackActivity extends BaseActivity {

    @Bind(R.id.tb_toolbar)
    Toolbar mTbToolbar;

    @Override
    public void initToolBar() {
        mTbToolbar.setTitle(getTitleName());
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

    public abstract String getTitleName();

}
