package com.xiaopang.oschina.utils;

import com.itheima.oschina.app.App;

final public class DensityUtils {

    private DensityUtils() {
    }

    /**
     * dp转px
     */
    public static int dp2px(double dpValue) {
        return (int) Math.ceil(dpValue * App.sContext.getResources().getDisplayMetrics().density);
    }

    /**
     * px转dp
     */
    public static int px2dp(float pxValue) {
        return (int) Math.ceil(pxValue / App.sContext.getResources().getDisplayMetrics().density);
    }

    /**
     * sp转px
     */
    public static int sp2px(float spValue) {
        return (int) (spValue * App.sContext.getResources().getDisplayMetrics().scaledDensity);
    }

    /**
     * px转sp
     */
    public static int px2sp(float pxValue) {
        return (int) Math.ceil(pxValue / App.sContext.getResources().getDisplayMetrics().scaledDensity);
    }

}
