package com.xiaopang.common.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {

    public View mBaseView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBaseView = View.inflate(getContext(), layoutId(), null);
        ButterKnife.bind(this, mBaseView);
        initView();
        loadData();
        return mBaseView;
    }

    public abstract int layoutId();

    public void initView() {
    }

    public void loadData() {
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

}
