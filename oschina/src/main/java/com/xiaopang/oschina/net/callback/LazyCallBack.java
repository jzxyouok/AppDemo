package com.xiaopang.oschina.net.callback;

import android.support.v4.widget.SwipeRefreshLayout;

import com.itheima.oschina.adapter.base.BaseMoreAdapter;
import com.itheima.oschina.bean.NewsList;
import com.itheima.oschina.weight.StateFrameLayout;

import retrofit2.Call;
import retrofit2.Response;

public abstract class LazyCallBack<T> extends BaseCallback {

    private int pageIndex;
    private StateFrameLayout mSflRoot;
    private BaseMoreAdapter mAdapter;
    private SwipeRefreshLayout mSrlRefresh;

    public LazyCallBack(int pageIndex, StateFrameLayout mSflRoot, BaseMoreAdapter mAdapter, SwipeRefreshLayout mSrlRefresh) {
        this.pageIndex = pageIndex;
        this.mSflRoot = mSflRoot;
        this.mAdapter = mAdapter;
        this.mSrlRefresh = mSrlRefresh;
    }

    @Override
    public void onResponse(Call call, Response response) {
        try {
            T newsList = (T) response.body();
            // mElRoot.show(LOAD_SUCCESS);
//            if (newsList.pageIndex == newsList.pageCount) {
//                mAdapter.currentMode = MORE_FINISH;
//            } else {
//                mAdapter.currentMode = MORE_LOAD;
//            }
//            mAdapter.updateMode();
//            if (pageIndex == 0) {
//                mList = newsList.list;
//            } else {
//                mList.addAll(newsList.list);
//            }
//            mAdapter.setList(mList);
            onSuccess(newsList);
            mSrlRefresh.setEnabled(true);
            mSrlRefresh.setRefreshing(false);
        } catch (Exception e) {
            e.printStackTrace();
            if (pageIndex == 0) {
                //   mElRoot.show(LOAD_FAIL);
            } else {
             //   mAdapter.currentMode = MORE_FAIL;
                mAdapter.updateMode();
            }
        }
    }

    @Override
    public void onFailure(Call call, Throwable t) {
        System.out.println(t.getMessage());
        if (pageIndex == 0) {
            //  mElRoot.show(LOAD_FAIL);
        } else {
//            mAdapter.currentMode = MORE_FAIL;
            mAdapter.updateMode();
        }
    }

    public abstract void onSuccess(T newsList);

}
