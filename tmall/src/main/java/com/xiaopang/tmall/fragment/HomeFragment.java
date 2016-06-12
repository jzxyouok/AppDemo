package com.xiaopang.tmall.fragment;

import com.xiaopang.common.fragment.BaseFragment;
import com.xiaopang.tmall.R;
import com.xiaopang.tmall.weight.TmallRefresh;

import butterknife.Bind;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class HomeFragment extends BaseFragment {

    @Bind(R.id.pfl_refresh)
    PtrFrameLayout pflRefresh;

    @Override
    public int layoutId() {
        return R.layout.tm_fragment_home;
    }

    @Override
    public void initView() {
        TmallRefresh tmallRefresh = new TmallRefresh(getContext());
        pflRefresh.setHeaderView(tmallRefresh);
        pflRefresh.addPtrUIHandler(tmallRefresh);
        pflRefresh.setRatioOfHeaderHeightToRefresh(1);
        pflRefresh.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                pflRefresh.refreshComplete();
            }
        });
        pflRefresh.autoRefresh();
    }

}
