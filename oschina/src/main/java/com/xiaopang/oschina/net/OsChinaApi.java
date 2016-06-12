package com.xiaopang.oschina.net;

import com.itheima.oschina.bean.NewsList;
import com.itheima.oschina.bean.TweetList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OsChinaApi {

    /**
     * 综合
     */
    @GET("news_list")
    Call<NewsList> news_list(@Query("catalog") int catalog, @Query("pageSize") int pageSize, @Query("pageIndex") int pageIndex);

    /**
     * 动弹
     */
    @GET("tweet_list")
    Call<TweetList> tweet_list(@Query("uid") int uid, @Query("pageSize") int pageSize, @Query("pageIndex") int pageIndex);

}
