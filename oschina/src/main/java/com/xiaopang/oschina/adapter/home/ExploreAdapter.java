package com.xiaopang.oschina.adapter.home;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.itheima.oschina.R;
import com.itheima.oschina.activity.FriendsActivity;
import com.itheima.oschina.adapter.base.BaseRecyclerAdapter;

import butterknife.Bind;

public class ExploreAdapter extends BaseRecyclerAdapter {

    final int[] itemIcons = {
            R.mipmap.hm_home_explore_icon_friends,
            R.mipmap.hm_home_explore_icon_finduser,
            R.mipmap.hm_home_explore_icon_event,
            R.mipmap.hm_home_explore_icon_scan,
            R.mipmap.hm_home_explore_icon_shake
    };

    public ExploreAdapter(Context context) {
        mData = new String[]{"好友圈", "找人", "活动", "扫一扫", "摇一摇"};
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.mIvIcon.setBackgroundResource(itemIcons[position]);
        viewHolder.mTvName.setText(mData[position].toString());
        if (position == 2 || position == 4) {
            viewHolder.mLine.setVisibility(View.GONE);
        } else {
            viewHolder.mLine.setVisibility(View.VISIBLE);
        }
        viewHolder.mLlItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, FriendsActivity.class));
            }
        });
    }

    class ViewHolder extends MyViewHolder {
        @Bind(R.id.line)
        View mLine;
        @Bind(R.id.ll_item)
        View mLlItem;
        @Bind(R.id.iv_icon)
        ImageView mIvIcon;
        @Bind(R.id.tv_name)
        TextView mTvName;

        public ViewHolder() {
            super(R.layout.hm_item_home_explore);
        }
    }

}
