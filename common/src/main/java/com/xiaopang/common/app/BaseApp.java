package com.xiaopang.common.app;

import android.app.Application;
import android.content.Context;

import com.alipay.euler.andfix.patch.PatchManager;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

import okhttp3.OkHttpClient;

public class BaseApp extends Application {

    public static Context sContext;
    public static PatchManager patchManager;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();

//        OkHttpClient okHttpClient = new OkHttpClient();
//        ImagePipelineConfig config = OkHttpImagePipelineConfigFactory.newBuilder(this, okHttpClient).build();

        Fresco.initialize(this);

        //初始化热修复
        patchManager = new PatchManager(this);
        patchManager.init("1.0");
        patchManager.loadPatch();
    }

}
