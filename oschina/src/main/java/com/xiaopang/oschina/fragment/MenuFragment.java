package com.xiaopang.oschina.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.itheima.oschina.app.AppConstants;
import com.itheima.oschina.R;
import com.itheima.oschina.activity.MainActivity;
import com.itheima.oschina.activity.SettingActivity;
import com.itheima.oschina.adapter.MenuAdapter;
import com.itheima.oschina.fragment.base.BaseFragment;
import com.itheima.oschina.utils.PreferencesUtils;

import butterknife.Bind;
import butterknife.OnClick;

public class MenuFragment extends BaseFragment {

    @Bind(R.id.rv_navigation)
    RecyclerView mRvNavigation;
    @Bind(R.id.tv_night)
    TextView mTvNight;

    @Override
    public int layoutId() {
        return R.layout.hm_fragment_menu;
    }

    @Override
    public void initView() {
        mRvNavigation.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvNavigation.setAdapter(new MenuAdapter(getActivity()));
        if (PreferencesUtils.readBoolean(AppConstants.KEY_NIGHT_MODE, false)) {
            mTvNight.setText("日间");
        } else {
            mTvNight.setText("夜间");
        }
    }

    @OnClick({R.id.ll_setting, R.id.ll_night})
    public void onClick(View v) {
        if (v.getId() == R.id.ll_setting) {
            startActivity(new Intent(getActivity(), SettingActivity.class));
            ((MainActivity) getActivity()).toggleMenu();
        } else if (v.getId() == R.id.ll_night) {
            PreferencesUtils.save(KEY_NIGHT_MODE, !PreferencesUtils.readBoolean(KEY_NIGHT_MODE, false));
            startActivity(new Intent(getActivity(), MainActivity.class));
            getActivity().overridePendingTransition(0, 0);
            getActivity().finish();
        }
    }

}
