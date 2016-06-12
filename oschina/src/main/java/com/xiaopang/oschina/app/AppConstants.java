package com.xiaopang.oschina.app;

/**
 * 常量
 */
public interface AppConstants {

    /**
     * 配置参数键
     */
    String KEY_NIGHT_MODE = "night_mode";//夜间模式
    String KEY_FIRST_START = "first_start";//第一次运行
//    String KEY_SCREEN_WDITH = "screen_wdith";//屏幕宽度
//    String KEY_SCREEN_HEIGHT = "screen_height";//屏幕高度

    /**
     * 其它常量
     */
    boolean IS_DEBUG = true;//是否是Debug模式
    String BASE_URL = "http://192.168.1.108:8080/OsChina/";
    int PAGE_SIZE = 20;
    String EXTRA_URL = "url";

    /**
     * 页面的4种状态
     */
    int STATE_LOADING = 1;//加载中
    int STATE_FAIL = 2;//加载失败
    int STATE_SUCCESS = 3;//加载成功


    int MORE_INIT = 1;//初始状态
    int MORE_LOAD = 2;//加载更多
    int MORE_FAIL = 3;//加载失败
    int MORE_FINISH = 4;//加载完成


    //综合模块类别
    int TYPE_NEWS = 1;
    int TYPE_HOTSPOT = 2;
    int TYPE_BLOG = 3;
    int TYPE_RECOMMEND = 4;


}
