package com.xiaopang.oschina.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.itheima.oschina.app.App;

final public class ScreenUtils {

    private ScreenUtils() {
    }

    /**
     * 获取屏幕宽度
     */
    public static int getScreenWidth() {
        DisplayMetrics metrics = new DisplayMetrics();
        ((WindowManager) App.sContext.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(metrics);
        return metrics.widthPixels;
    }

    /**
     * 获取屏幕高度
     */
    public static int getScreenHeight() {
        DisplayMetrics metrics = new DisplayMetrics();
        ((WindowManager) App.sContext.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(metrics);
        return metrics.heightPixels;
    }

}
