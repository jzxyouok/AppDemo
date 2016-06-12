package com.xiaopang.oschina.fragment.base;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.itheima.oschina.R;

import java.util.List;

import butterknife.Bind;

public abstract class BaseViewPagerFragment extends BaseAnimFragment {

    @Bind(R.id.tl_tablayout)
    TabLayout mTlTablayout;
    @Bind(R.id.vp_pager)
    ViewPager mVpPager;

    private String[] tabNames = getTabNames();
    private List<BaseLazyFragment> fragments = getFragments();

    @Override
    public int layoutId() {
        return R.layout.hm_fragment_home_viewpager;
    }

    @Override
    public void initView() {
        mVpPager.setOffscreenPageLimit(fragments.size() - 1);
        mVpPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return tabNames.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return tabNames[position];
            }
        });
        mVpPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                fragments.get(position).onLazyLoad();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mTlTablayout.setupWithViewPager(mVpPager);
        fragments.get(0).onLazyLoad();
    }

    public abstract String[] getTabNames();

    public abstract List<BaseLazyFragment> getFragments();

}
