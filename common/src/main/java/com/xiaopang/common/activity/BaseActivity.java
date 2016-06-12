package com.xiaopang.common.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        ButterKnife.bind(this);
        initView();
        loadData();
    }

    public abstract int layoutId();

    public void initView() {
    }

    public void loadData() {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

}
