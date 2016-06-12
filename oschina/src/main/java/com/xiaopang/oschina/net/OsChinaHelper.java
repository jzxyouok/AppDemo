package com.xiaopang.oschina.net;

import com.itheima.oschina.app.AppConstants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OsChinaHelper {

    public static OsChinaApi newsApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(OsChinaApi.class);
    }

}