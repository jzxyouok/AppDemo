package com.xiaopang.oschina.fragment.base;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xiaopang.common.fragment.BaseFragment;
import com.xiaopang.oschina.R;
import com.xiaopang.oschina.adapter.base.BaseMoreAdapter;
import com.xiaopang.oschina.weight.StateFrameLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import retrofit2.Call;

public abstract class BaseLazyFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {


    @Bind(R.id.sfl_root)
    public StateFrameLayout mSflRoot;
    @Bind(R.id.srl_refresh)
    public SwipeRefreshLayout mSrlRefresh;
    @Bind(R.id.rv_list)
    public RecyclerView mRvList;

    public int pageIndex = 0;
    public List mList = new ArrayList();
    public BaseMoreAdapter mAdapter = createAdapter();

    @Override
    public int layoutId() {
        return R.layout.hm_fragment_home_pager;
    }

    @Override
    public void initView() {
        mRvList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvList.setAdapter(mAdapter);
        mSrlRefresh.setEnabled(false);//禁用刷新
        mSrlRefresh.setColorSchemeResources(R.color.default_green);
        mSrlRefresh.setOnRefreshListener(this);
    }

    /**
     * 创建页面适配器
     */
    public abstract BaseMoreAdapter createAdapter();

    /**
     * 下拉刷新
     */
    @Override
    public void onRefresh() {
        pageIndex = 0;
        mAdapter.currentMode = MORE_INIT;
        onLazyLoad();
    }

    /**
     * 加载更多
     */
    public void onLoadMore() {
        pageIndex++;
        mSrlRefresh.setEnabled(false);
        onLazyLoad();
    }

    /**
     * 懒加载
     */
    public abstract void onLazyLoad();

}
