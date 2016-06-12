package com.xiaopang.oschina.adapter.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.itheima.oschina.R;
import com.itheima.oschina.adapter.base.BaseRecyclerAdapter;
import com.itheima.oschina.utils.DebugUtils;

import butterknife.Bind;

public class MineAdapter extends BaseRecyclerAdapter {

    final int[] itemIcons = {
            R.mipmap.hm_home_mine_icon_message,
            R.mipmap.hm_home_mine_icon_blog,
            R.mipmap.hm_home_mine_icon_note,
            R.mipmap.hm_home_mine_icon_team,
    };

    public MineAdapter() {
        mData = new String[]{"消息", "博客", "便签", "团队"};
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
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DebugUtils.toast("点击条目");
            }
        });
    }

    class ViewHolder extends MyViewHolder {
        @Bind(R.id.iv_icon)
        ImageView mIvIcon;
        @Bind(R.id.tv_name)
        TextView mTvName;

        public ViewHolder() {
            super(R.layout.hm_item_home_mine);
        }
    }

}