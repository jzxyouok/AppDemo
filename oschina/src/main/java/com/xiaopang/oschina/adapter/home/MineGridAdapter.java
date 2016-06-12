package com.xiaopang.oschina.adapter.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.itheima.oschina.R;
import com.itheima.oschina.adapter.base.BaseRecyclerAdapter;
import com.itheima.oschina.utils.DebugUtils;

import butterknife.Bind;

public class MineGridAdapter extends BaseRecyclerAdapter {

    public MineGridAdapter() {
        mData = new String[]{"积分", "收藏", "关注", "粉丝"};
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.mTvScore.setText("0");
        viewHolder.mTvName.setText(mData[position].toString());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DebugUtils.toast("点击条目");
            }
        });
    }

    class ViewHolder extends MyViewHolder {
        @Bind(R.id.tv_score)
        TextView mTvScore;
        @Bind(R.id.tv_name)
        TextView mTvName;

        public ViewHolder() {
            super(R.layout.hm_item_home_mine_grid);
        }
    }

}