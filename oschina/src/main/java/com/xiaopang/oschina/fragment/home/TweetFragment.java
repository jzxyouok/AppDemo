package com.xiaopang.oschina.fragment.home;

import com.itheima.oschina.adapter.base.BaseMoreAdapter;
import com.itheima.oschina.adapter.home.NewsAdapter;
import com.itheima.oschina.adapter.home.TweetAdapter;
import com.itheima.oschina.bean.TweetList;
import com.itheima.oschina.fragment.base.BaseLazyFragment;
import com.itheima.oschina.net.OsChinaHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TweetFragment extends BaseLazyFragment {

    @Override
    public BaseMoreAdapter createAdapter() {
        return new TweetAdapter(mList, this);
    }

    @Override
    public void onLazyLoad() {
        Call<TweetList> call = OsChinaHelper.newsApi().tweet_list(0, PAGE_SIZE, pageIndex);
        call.enqueue(new Callback<TweetList>() {
            @Override
            public void onResponse(Call<TweetList> call, Response<TweetList> response) {
                try {
                    TweetList tweetList = response.body();
                    mSflRoot.show(STATE_SUCCESS);
                    if (tweetList.pageIndex == tweetList.pageCount) {
                        mAdapter.currentMode = MORE_FINISH;
                    } else {
                        mAdapter.currentMode = MORE_LOAD;
                    }
                    mAdapter.updateMode();
                    if (pageIndex == 0) {
                        mList = tweetList.list;
                    } else {
                        mList.addAll(tweetList.list);
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
            public void onFailure(Call<TweetList> call, Throwable t) {
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
