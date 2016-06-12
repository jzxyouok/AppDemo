package com.xiaopang.oschina.adapter.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.itheima.oschina.app.App;
import com.itheima.oschina.R;
import com.itheima.oschina.activity.DetailActivity;
import com.itheima.oschina.adapter.base.BaseMoreAdapter;
import com.itheima.oschina.db.News;
import com.itheima.oschina.fragment.base.BaseLazyFragment;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewsAdapter extends BaseMoreAdapter {


    public NewsAdapter(List mList, BaseLazyFragment mFragment) {
        super(mList, mFragment);
    }


//    public NewsAdapter(List<News> list, BaseLazyFragment fragment) {
//        mList = list;
//        mFragment = fragment;
//    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder() {
        return new ViewHolder(View.inflate(App.sContext, R.layout.hm_item_home_news, null));
    }


    @Override
    public void onBindViewHolder2(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        final News bean = (News) mList.get(position);
        viewHolder.mTvTitle.setText(bean.getTitle());
        viewHolder.mTvBody.setText(bean.getBody());
        viewHolder.mTvAuthor.setText(bean.getAuthor());
        viewHolder.mTvPubDate.setText(bean.getPubDate());
        viewHolder.mTvCommentCount.setText(""+bean.getCommentCount());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               App.sDaoSession.getNewsDao().insert(bean);
//                App.sDaoSession.getNewsListDao().insert();

                Intent intent = new Intent(mFragment.getContext(), DetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable(EXTRA_URL, bean.getUrl());
                intent.putExtras(bundle);
                mFragment.getContext().startActivity(intent);
            }
        });
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.iv_newstype)
        ImageView mIvNewstype;
        @Bind(R.id.tv_title)
        TextView mTvTitle;
        @Bind(R.id.tv_body)
        TextView mTvBody;
        @Bind(R.id.tv_author)
        TextView mTvAuthor;
        @Bind(R.id.tv_pubDate)
        TextView mTvPubDate;
        @Bind(R.id.tv_commentCount)
        TextView mTvCommentCount;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
