package com.xiaopang.oschina.activity;

import android.support.v7.widget.Toolbar;

import com.baidu.mapapi.map.MapView;
import com.itheima.oschina.R;
import com.itheima.oschina.activity.base.BaseActivity;
import com.itheima.oschina.activity.base.BaseBackActivity;

import butterknife.Bind;

/**
 * Created by yaoshouyun on 2016/5/9.
 */
public class MapActivity extends BaseBackActivity {

    @Bind(R.id.bmapView)
    MapView mMapView;

    @Override
    public int layoutId() {
        return R.layout.hm_activity_map;
    }

    @Override
    protected void onDestroy() {
        mMapView.onDestroy();
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理

    }

    @Override
    protected void onResume() {
        mMapView.onResume();
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理

    }

    @Override
    protected void onPause() {
        mMapView.onPause();
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
    }

    @Override
    public String getTitleName() {
        return "百度地图";
    }

}
