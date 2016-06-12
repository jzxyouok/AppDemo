package com.xiaopang.oschina.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.xiaopang.common.app.BaseConstants;
import com.xiaopang.oschina.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class StateFrameLayout extends FrameLayout implements BaseConstants {


    @Bind(R.id.pb_loading)
    ProgressBar mPbLoading;
    @Bind(R.id.tv_fail)
    TextView mTvFail;

    public StateFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        View.inflate(context, R.layout.hm_weight_stateframelayout, this);
        ButterKnife.bind(this);
        show(STATE_LOADING);

    }

    public void show(int status) {
        switch (status) {
            case STATE_LOADING:
                mPbLoading.setVisibility(View.VISIBLE);
                mTvFail.setVisibility(View.GONE);
                break;
            case STATE_FAIL:
                mPbLoading.setVisibility(View.GONE);
                mTvFail.setVisibility(View.VISIBLE);
                break;
            case STATE_SUCCESS:
                mPbLoading.setVisibility(View.GONE);
                mTvFail.setVisibility(View.GONE);
                break;
        }
    }

}
