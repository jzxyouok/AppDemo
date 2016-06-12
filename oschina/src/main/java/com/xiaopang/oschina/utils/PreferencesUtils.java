package com.xiaopang.oschina.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.itheima.oschina.app.App;

final public class PreferencesUtils {

    private PreferencesUtils() {
    }

    private static SharedPreferences sp;

    private static SharedPreferences getInstance() {
        if (sp == null) {
            sp = App.sContext.getSharedPreferences("config", Context.MODE_PRIVATE);
        }
        return sp;
    }

    /**
     * 移除配置参数
     */
    public static void removeKey(String key) {
        getInstance().edit().remove(key).commit();
    }

    /**
     * 清空配置参数
     */
    public static void clear() {
        getInstance().edit().clear().commit();
    }

    /**
     * 保存配置参数
     */
    public static void save(String key, Object value) {
        if (value instanceof Integer) {
            getInstance().edit().putInt(key, (Integer) value).commit();
        } else if (value instanceof Boolean) {
            getInstance().edit().putBoolean(key, (Boolean) value).commit();
        } else if (value instanceof String) {
            getInstance().edit().putString(key, (String) value).commit();
        }
    }

    /**
     * 读取int配置参数
     */
    public static int readInt(String key, int defaultValue) {
        return getInstance().getInt(key, defaultValue);
    }

    /**
     * 读取boolean配置参数
     */
    public static boolean readBoolean(String key, boolean defaultValue) {
        return getInstance().getBoolean(key, defaultValue);
    }

    /**
     * 读取String配置参数
     */
    public static String readString(String key, String defaultValue) {
        return getInstance().getString(key, defaultValue);
    }

}
