package com.xiaopang.oschina.fragment.home;

import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioGroup;

import com.itheima.oschina.R;
import com.itheima.oschina.fragment.base.BaseAnimFragment;
import com.itheima.oschina.fragment.base.BaseFragment;
import com.itheima.oschina.window.QuickPopup;

import butterknife.Bind;

public class HomeFragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    @Bind(R.id.rg_tabs)
    RadioGroup mRgTabs;
    @Bind(R.id.ib_quick)
    ImageButton mIbQuick;

    private BaseAnimFragment currentFragment;//当前页面
    private BaseAnimFragment newFragment;//打开的页面
    private NewsViewPagerFragment newsViewPagerFragment;
    private TweetViewPagerFragment tweetViewPagerFragment;
    private ExploreFragment exploreFragment;
    private MineFragment mineFragment;

    private QuickPopup quickPopup;

    @Override
    public int layoutId() {
        return R.layout.hm_fragment_home;
    }

    @Override
    public void initView() {
        mRgTabs.setOnCheckedChangeListener(this);
        mIbQuick.setOnClickListener(this);
        newsViewPagerFragment = new NewsViewPagerFragment();//综合页面
        tweetViewPagerFragment = new TweetViewPagerFragment();//动弹页面
        exploreFragment = new ExploreFragment();//发现页面
        mineFragment = new MineFragment();//我页面
        currentFragment = newsViewPagerFragment;
        getChildFragmentManager().beginTransaction().add(R.id.frame_content, currentFragment).commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_news:
                newFragment = newsViewPagerFragment;
                break;
            case R.id.rb_tweet:
                newFragment = tweetViewPagerFragment;
                break;
            case R.id.rb_explore:
                newFragment = exploreFragment;
                break;
            case R.id.rb_mine:
                newFragment = mineFragment;
                break;
        }
        switchFragment();
    }

    private void switchFragment() {
        if (newFragment != currentFragment) {
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            if (newFragment.isAdded()) {
                transaction.show(newFragment);
                newFragment.onResume();
            } else {
                transaction.add(R.id.frame_content, newFragment);
            }
            transaction.hide(currentFragment).commit();
            newFragment.startAnim();
            currentFragment.stopAnim();
            currentFragment.onPause();
            currentFragment = newFragment;
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ib_quick) {
            if (quickPopup == null) {
                quickPopup = new QuickPopup(getActivity());
            }
            quickPopup.show();
        }
    }

}
