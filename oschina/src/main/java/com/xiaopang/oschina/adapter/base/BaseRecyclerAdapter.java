package com.xiaopang.oschina.adapter.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.itheima.oschina.app.App;

import java.util.List;

import butterknife.ButterKnife;

public abstract class BaseRecyclerAdapter extends RecyclerView.Adapter {

    public Object[] mData;
    public List mList;
    public Context mContext;

    @Override
    public int getItemCount() {
        return mData != null ? mData.length : (mList != null ? mList.size() : 0);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(int layoutId) {
            super(View.inflate(App.sContext, layoutId, null));
            ButterKnife.bind(this, itemView);
        }
    }

}
