package com.xiaopang.oschina.app;

import android.database.sqlite.SQLiteDatabase;

import com.xiaopang.common.app.BaseApp;

/**
 * Created by yaoshouyun on 2016/6/12.
 */
public class OsChinaApp extends BaseApp {


//    public static DaoSession sDaoSession;
    private static SQLiteDatabase sDb;


        @Override
        public void onCreate() {
            super.onCreate();
            sContext = getApplicationContext();
//            SDKInitializer.initialize(getApplicationContext());//初始化百度地图
//            PushManager.startWork(getApplicationContext(), PushConstants.LOGIN_TYPE_API_KEY, "GVoD9ouWIkuRsVTjDh8xtnv6");//初始化百度云推送
            initDB();
        }

    private void initDB() {
//        if (sDaoSession == null) {
//            if (sDb == null) {
//                DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "oschina-db", null);
//                sDb = helper.getWritableDatabase();
//            }
//            sDaoSession = new DaoMaster(sDb).newSession();
//        }
    }

}
