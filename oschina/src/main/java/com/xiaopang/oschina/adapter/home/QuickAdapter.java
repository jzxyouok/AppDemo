package com.xiaopang.oschina.adapter.home;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.itheima.oschina.R;
import com.itheima.oschina.activity.SelectPhotoActivity;
import com.itheima.oschina.adapter.base.BaseRecyclerAdapter;
import com.itheima.oschina.utils.DebugUtils;

import butterknife.Bind;

public class QuickAdapter extends BaseRecyclerAdapter {

    final int[] itemIcons = {
            R.drawable.hm_home_quick_text,
            R.drawable.hm_home_quick_album,
            R.drawable.hm_home_quick_photo,
            R.drawable.hm_home_quick_voice,
            R.drawable.hm_home_quick_scan,
            R.drawable.hm_home_quick_note
    };

    public QuickAdapter(Context context) {
        mData = new String[]{"文字", "相册", "拍照", "语音", "扫一扫", "便签"};
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.mIvIcon.setBackgroundResource(itemIcons[position]);
        viewHolder.mTvName.setText(mData[position].toString());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position) {
                    case 0:
                        mContext.startActivity(new Intent(mContext,SelectPhotoActivity.class));
                        DebugUtils.toast("文字");
                        break;
                    case 1:
                        DebugUtils.toast("相册");
                        break;
                    case 2:
                        DebugUtils.toast("拍照");
                        break;
                    case 3:
                        DebugUtils.toast("语音");
                        break;
                    case 4:
                        DebugUtils.toast("扫一扫");
                        break;
                    case 5:
                        DebugUtils.toast("便签");
                        break;
                }
            }
        });
    }

    class ViewHolder extends MyViewHolder {
        @Bind(R.id.iv_icon)
        ImageView mIvIcon;
        @Bind(R.id.tv_name)
        TextView mTvName;

        public ViewHolder() {
            super(R.layout.hm_item_home_quick);
        }
    }

}
