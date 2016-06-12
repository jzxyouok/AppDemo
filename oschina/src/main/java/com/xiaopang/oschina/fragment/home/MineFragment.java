package com.xiaopang.oschina.fragment.home;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.itheima.oschina.R;
import com.itheima.oschina.adapter.home.MineAdapter;
import com.itheima.oschina.adapter.home.MineGridAdapter;
import com.itheima.oschina.fragment.base.BaseAnimFragment;

import butterknife.Bind;

/**
 * 我页面
 */
public class MineFragment extends BaseAnimFragment {

    @Bind(R.id.rv_grid)
    RecyclerView mRvGrid;
    @Bind(R.id.rv_list)
    RecyclerView mRvList;

    @Override
    public int layoutId() {
        return R.layout.hm_fragment_home_mine;
    }

    @Override
    public void initView() {
        mRvGrid.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        mRvGrid.setAdapter(new MineGridAdapter());
        mRvList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvList.setAdapter(new MineAdapter());
    }

}