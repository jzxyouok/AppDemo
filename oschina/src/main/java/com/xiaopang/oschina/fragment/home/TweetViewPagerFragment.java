package com.xiaopang.oschina.fragment.home;

import com.itheima.oschina.fragment.base.BaseLazyFragment;
import com.itheima.oschina.fragment.base.BaseViewPagerFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 动弹页面
 */
public class TweetViewPagerFragment extends BaseViewPagerFragment {

    @Override
    public String[] getTabNames() {
        return new String[]{"最新动弹", "热门动弹", "我的动弹"};
    }

    @Override
    public List<BaseLazyFragment> getFragments() {
        List<BaseLazyFragment> list = new ArrayList<>();
        list.add(new TweetFragment());
        list.add(new TweetFragment());
        list.add(new TweetFragment());
        return list;
    }

}