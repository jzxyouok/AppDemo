package com.xiaopang.oschina.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.itheima.oschina.R;
import com.itheima.oschina.adapter.base.BaseRecyclerAdapter;
import com.itheima.oschina.utils.DebugUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class SelectPhotoAdapter extends BaseRecyclerAdapter {

    private List<String> mSelectPhoto = new ArrayList<>();

    public SelectPhotoAdapter(Context context, List<String> list) {
        mList = list;
        mContext = context;
        DebugUtils.log("mList="+mList.size());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        DebugUtils.log("onCreateViewHolder=");
        return new ViewHolder();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        DebugUtils.log("onBindViewHolder=");
        final ViewHolder viewHolder = (ViewHolder) holder;
        final String url = (String) mList.get(position);
        Glide.with(mContext).load(url).placeholder(R.mipmap.hm_widget_selectphoto_default).centerCrop().into(viewHolder.mIvPhoto);
        if (mSelectPhoto.contains(url)){
            viewHolder.mIvSelect.setBackgroundResource(R.mipmap.hm_widget_selectphoto_select);
        }else{
            viewHolder.mIvSelect.setBackgroundResource(R.mipmap.hm_widget_selectphoto_unselect);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DebugUtils.toast("哈哈哈哈");
                if (mSelectPhoto.contains(url)){
                    mSelectPhoto.remove(url);
                    viewHolder.mIvSelect.setBackgroundResource(R.mipmap.hm_widget_selectphoto_unselect);
                }else{
                    mSelectPhoto.add(url);
                    viewHolder.mIvSelect.setBackgroundResource(R.mipmap.hm_widget_selectphoto_select);
                }
//                notifyDataSetChanged();
            }
        });
    }

    class ViewHolder extends MyViewHolder {
        @Bind(R.id.iv_photo)
        ImageView mIvPhoto;
        @Bind(R.id.iv_select)
        ImageView mIvSelect;

        public ViewHolder() {
            super(R.layout.hm_item_selectphoto);
        }
    }

}
