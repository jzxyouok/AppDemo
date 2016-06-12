package com.xiaopang.oschina.activity;

import android.os.Bundle;
import android.webkit.WebView;

import com.itheima.oschina.R;
import com.itheima.oschina.activity.base.BaseBackActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 详情页面
 */
public class DetailActivity extends BaseBackActivity {

    @Bind(R.id.wv_webview)
    WebView mWvWebview;

    public int layoutId() {
        return R.layout.hm_activity_detail;
    }

    public String getTitleName() {
        return "详情";
    }

    @Override
    public void initView() {
        mWvWebview.loadUrl("http://city.oschina.net/guangzhou/event/2177482");
    }
}
