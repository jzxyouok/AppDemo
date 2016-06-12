package com.xiaopang.oschina.fragment.home;

import com.itheima.oschina.fragment.base.BaseLazyFragment;
import com.itheima.oschina.fragment.base.BaseViewPagerFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 综合页面
 */
public class NewsViewPagerFragment extends BaseViewPagerFragment {

    @Override
    public String[] getTabNames() {
        return new String[]{"资讯", "热点", "博客", "推荐"};
    }

    @Override
    public List<BaseLazyFragment> getFragments() {
        List<BaseLazyFragment> list = new ArrayList<>();
        list.add(new NewsFragment());
        list.add(new NewsFragment());
        list.add(new NewsFragment());
        list.add(new NewsFragment());
        return list;
    }

}