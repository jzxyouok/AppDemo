package com.xiaopang.oschina.adapter.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.itheima.oschina.app.App;
import com.itheima.oschina.R;
import com.itheima.oschina.adapter.base.BaseRecyclerAdapter;
import com.itheima.oschina.fragment.base.BaseFragment;
import com.itheima.oschina.bean.TweetImage;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TweetImageAdapter extends BaseRecyclerAdapter {

    private List<TweetImage> mList;
    private BaseFragment mFragment;

//    public TweetImageAdapter(List mList, BaseLazyFragment mFragment) {
//        super(mList, mFragment);
//    }

//    public TweetImageAdapter(List<TweetImage> list, BaseFragment fragment) {
//        this.mList = list;
//        this.mFragment = fragment;
//    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(App.sContext, R.layout.hm_item_home_tweet_image, null));
    }

    public RecyclerView.ViewHolder onCreateViewHolder() {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TweetImage bean = mList.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        Glide.with(mFragment).load(bean.url).into(viewHolder.mIvImage);
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.iv_image)
        ImageView mIvImage;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
