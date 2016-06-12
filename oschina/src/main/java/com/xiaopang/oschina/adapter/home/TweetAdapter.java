package com.xiaopang.oschina.adapter.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.itheima.oschina.app.App;
import com.itheima.oschina.R;
import com.itheima.oschina.fragment.base.BaseLazyFragment;
import com.itheima.oschina.adapter.base.BaseMoreAdapter;
import com.itheima.oschina.bean.Tweet;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TweetAdapter extends BaseMoreAdapter {

    public TweetAdapter(List mList, BaseLazyFragment mFragment) {
        super(mList, mFragment);
    }

//    public TweetAdapter(List<Tweet> list, BaseLazyFragment fragment) {
//        mList = list;
//        mFragment = fragment;
//    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder() {
        return new ViewHolder(View.inflate(App.sContext, R.layout.hm_item_home_tweet, null));
    }


    @Override
    public void onBindViewHolder2(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        final Tweet bean = (Tweet) mList.get(position);
        Glide.with(mFragment).load(BASE_URL + bean.userImage).into(viewHolder.mIvIcon);
        viewHolder.mTvName.setText(bean.userName);
        viewHolder.mTvBody.setText(bean.body);
        viewHolder.mTvPubDate.setText(bean.pubDate);
        viewHolder.mTvCommentCount.setText("" + bean.commentCount);
        viewHolder.mRvGrid.setVisibility(View.GONE);
//        if (bean.images.size() > 0){
//            viewHolder.mRvGrid.setLayoutManager(new GridLayoutManager(mFragment.getActivity(), 3));
//            viewHolder.mRvGrid.setAdapter(new TweetImageAdapter(bean.images, mFragment));
//        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.iv_icon)
        ImageView mIvIcon;
        @Bind(R.id.tv_name)
        TextView mTvName;
        @Bind(R.id.tv_body)
        TextView mTvBody;
        @Bind(R.id.tv_pubDate)
        TextView mTvPubDate;
        @Bind(R.id.tv_commentCount)
        TextView mTvCommentCount;
        @Bind(R.id.rv_grid)
        RecyclerView mRvGrid;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
