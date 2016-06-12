package com.xiaopang.oschina.activity;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;

import com.itheima.oschina.R;
import com.itheima.oschina.activity.base.BaseActivity;
import com.itheima.oschina.fragment.home.HomeFragment;
import com.itheima.oschina.fragment.MenuFragment;
import com.itheima.oschina.window.ExitDialog;
import com.itheima.oschina.utils.PreferencesUtils;

import butterknife.Bind;

/**
 * 主页面
 */
public class MainActivity extends BaseActivity {

    @Bind(R.id.tb_toolbar)
    Toolbar mTbToolbar;
    @Bind(R.id.dl_navigation)
    DrawerLayout mDlNavigation;

    private ExitDialog exitDialog;

    @Override
    public int layoutId() {
        return R.layout.hm_activity_main;
    }

    @Override
    public void initToolBar() {
        mTbToolbar.setTitle("开源中国");
        setSupportActionBar(mTbToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDlNavigation, 0, 0);
        mDrawerToggle.syncState();
        mDlNavigation.addDrawerListener(mDrawerToggle);
    }

    @Override
    public void initView() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new HomeFragment()).replace(R.id.frame_menu, new MenuFragment()).commit();
        // 如果是第一次运行
        if (PreferencesUtils.readBoolean(KEY_FIRST_START, true)) {
            mDlNavigation.openDrawer(Gravity.LEFT);
            PreferencesUtils.save(KEY_FIRST_START, false);
        }
    }

    public void toggleMenu() {
        if (mDlNavigation.isDrawerOpen(Gravity.LEFT)) {
            mDlNavigation.closeDrawer(Gravity.LEFT);
        } else {
            mDlNavigation.openDrawer(Gravity.LEFT);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                toggleMenu();
                break;
            case R.id.toolbar_search:
                startActivity(new Intent(this, SearchActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_home, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {
        if (mDlNavigation.isDrawerOpen(Gravity.LEFT)) {
            mDlNavigation.closeDrawer(Gravity.LEFT);
        } else {
            if (exitDialog == null) {
                exitDialog = new ExitDialog(this);
                exitDialog.addDialogCallBack(new ExitDialog.DialogCallBack() {
                    @Override
                    public void onConfirm() {
                        MainActivity.super.onBackPressed();
                    }
                });
            }
            exitDialog.show();
        }
    }

}
