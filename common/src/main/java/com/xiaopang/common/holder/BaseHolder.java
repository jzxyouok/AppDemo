package com.xiaopang.common.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.xiaopang.common.app.BaseApp;

import butterknife.ButterKnife;

public abstract class BaseHolder extends RecyclerView.ViewHolder {

    public BaseHolder(int layoutId) {
        super(View.inflate(BaseApp.sContext, layoutId, null));
        ButterKnife.bind(this, itemView);
    }

}
