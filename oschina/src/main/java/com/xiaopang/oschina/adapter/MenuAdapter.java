package com.xiaopang.oschina.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.itheima.oschina.R;
import com.itheima.oschina.activity.MapActivity;
import com.itheima.oschina.adapter.base.BaseRecyclerAdapter;
import com.itheima.oschina.utils.DebugUtils;

import butterknife.Bind;

public class MenuAdapter extends BaseRecyclerAdapter {

    final int[] itemIcons = {
            R.mipmap.hm_menu_icon_quest,
            R.mipmap.hm_menu_icon_blog,
            R.mipmap.hm_menu_icon_opensoft,
            R.mipmap.hm_menu_icon_gitapp,
    };
    private Context mContext;

    public MenuAdapter(Context context) {
        this.mContext = context;
        mData = new String[]{"技术问答", "开源软件", "博客区", "百度地图"};
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
                mContext.startActivity(new Intent(mContext, MapActivity.class));
            }
        });
    }

    class ViewHolder extends MyViewHolder {
        @Bind(R.id.iv_icon)
        ImageView mIvIcon;
        @Bind(R.id.tv_name)
        TextView mTvName;

        public ViewHolder() {
            super(R.layout.hm_item_menu);
        }
    }

}
