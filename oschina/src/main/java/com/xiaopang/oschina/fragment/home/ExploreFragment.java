package com.xiaopang.oschina.fragment.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.itheima.oschina.R;
import com.itheima.oschina.adapter.home.ExploreAdapter;
import com.itheima.oschina.fragment.base.BaseAnimFragment;

/**
 * 发现页面
 */
public class ExploreFragment extends BaseAnimFragment {

    @Override
    public int layoutId() {
        return R.layout.hm_fragment_home_explore;
    }

    @Override
    public void initView() {
        ((RecyclerView) mRootView).setLayoutManager(new LinearLayoutManager(getActivity()));
        ((RecyclerView) mRootView).setAdapter(new ExploreAdapter(getActivity()));
    }

}