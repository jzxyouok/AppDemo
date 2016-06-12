package com.xiaopang.oschina.utils;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;
import com.itheima.oschina.app.App;
import com.itheima.oschina.app.AppConstants;

final public class DebugUtils {

    private DebugUtils() {
    }

    private static final String TAG = DebugUtils.class.getName();

    /**
     * 打印日志
     */
    public static void log(Object object) {
        if (AppConstants.IS_DEBUG) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                Log.d(TAG, "log:" + object);
            } else {
                Log.d(TAG, "log thread:" + object);
            }
        }
    }

    /**
     * 显示吐司
     */
    public static void toast(final Object object) {
        if (AppConstants.IS_DEBUG) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                Toast.makeText(App.sContext, "toast:" + object, Toast.LENGTH_SHORT).show();
            } else {
                Looper.prepare();
                new Handler().post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(App.sContext, "toast thread:" + object, Toast.LENGTH_SHORT).show();
                    }
                });
                Looper.loop();
            }
        }
    }

    /**
     * 打印日志并显示吐司
     */
    public static void logAndToast(Object object) {
        log(object);
        toast(object);
    }

}