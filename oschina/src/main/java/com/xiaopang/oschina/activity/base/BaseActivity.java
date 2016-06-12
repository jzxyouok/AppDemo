//package com.xiaopang.oschina.activity.base;
//
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//
//import com.itheima.oschina.R;
//import com.itheima.oschina.app.AppConstants;
//import com.itheima.oschina.utils.PreferencesUtils;
//
//import butterknife.ButterKnife;
//
//public abstract class BaseActivity extends AppCompatActivity implements AppConstants {
//
//    public View mRootView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
////        if (PreferencesUtils.readBoolean(KEY_NIGHT_MODE, false)) {
////            setTheme(R.style.AppBaseTheme_Night);// 夜间模式
////        } else {
////            setTheme(R.style.AppBaseTheme_Light);// 日间模式
////        }
//        mRootView = View.inflate(this, layoutId(), null);
//        ButterKnife.bind(this, mRootView);
//        setContentView(mRootView);
//        initToolBar();
//        initView();
//        loadData();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        ButterKnife.unbind(this);
//    }
//
//    /**
//     * 页面布局ID
//     */
//    public abstract int layoutId();
//
//    /**
//     * 初始化标题栏
//     */
//    public void initToolBar() {
//    }
//
//    /**
//     * 初始化页面
//     */
//    public void initView() {
//    }
//
//    /**
//     * 加载数据
//     */
//    public void loadData() {
//    }
//
//}
