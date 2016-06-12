package com.xiaopang.oschina.fragment.home;

import com.itheima.oschina.adapter.home.NewsAdapter;
import com.itheima.oschina.fragment.base.BaseLazyFragment;
import com.itheima.oschina.adapter.base.BaseMoreAdapter;
import com.itheima.oschina.bean.NewsList;
import com.itheima.oschina.net.OsChinaHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsFragment extends BaseLazyFragment {

    @Override
    public BaseMoreAdapter createAdapter() {
        return new NewsAdapter(mList, this);
    }

    @Override
    public void onLazyLoad() {
        Call<NewsList> call = OsChinaHelper.newsApi().news_list(TYPE_NEWS, PAGE_SIZE, pageIndex);
        call.enqueue(new Callback<NewsList>() {
            @Override
            public void onResponse(Call<NewsList> call, Response<NewsList> response) {
                try {
                    NewsList newsList = response.body();
                    mSflRoot.show(STATE_SUCCESS);
                    if (newsList.pageIndex == newsList.pageCount) {
                        mAdapter.currentMode = MORE_FINISH;
                    } else {
                        mAdapter.currentMode = MORE_LOAD;
                    }
                    mAdapter.updateMode();
                    if (pageIndex == 0) {
                        mList = newsList.list;
                    } else {
                        mList.addAll(newsList.list);
                    }
                    mAdapter.setList(mList);
                    mSrlRefresh.setEnabled(true);
                    mSrlRefresh.setRefreshing(false);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (pageIndex == 0) {
                        mSflRoot.show(STATE_FAIL);
                    } else {
                        mAdapter.currentMode = MORE_FAIL;
                        mAdapter.updateMode();
                    }
                }
            }

            @Override
            public void onFailure(Call<NewsList> call, Throwable t) {
                System.out.println(t.getMessage());
                if (pageIndex == 0) {
                    mSflRoot.show(STATE_FAIL);
                } else {
                    mAdapter.currentMode = MORE_FAIL;
                    mAdapter.updateMode();
                }
            }
        });
    }

}
