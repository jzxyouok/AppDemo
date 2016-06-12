package com.xiaopang.oschina.adapter.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.xiaopang.common.app.BaseConstants;
import com.xiaopang.oschina.R;
import com.xiaopang.oschina.fragment.base.BaseLazyFragment;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public abstract class BaseMoreAdapter extends RecyclerView.Adapter implements BaseConstants {

    private static final int TYPE_ITEM = 1;
    private static final int TYPE_MORE = 2;


    public int currentMode = MORE_INIT;


    private MoreHolder moreHolder;

    public List mList;
    public BaseLazyFragment mFragment;

    public BaseMoreAdapter(List mList, BaseLazyFragment mFragment) {
        this.mList = mList;
        this.mFragment = mFragment;
    }

    public void setList(List mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mList.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position < mList.size()) {
            return TYPE_ITEM;
        } else {
            return TYPE_MORE;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            return onCreateViewHolder();
        } else {
            return new MoreHolder(View.inflate(parent.getContext(), R.layout.hm_item_more, null));
        }
    }

    public abstract RecyclerView.ViewHolder onCreateViewHolder();

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_ITEM) {
            onBindViewHolder2(holder, position);
            moreHolder = null;
        } else {
            moreHolder = (MoreHolder) holder;
            if (currentMode == MORE_LOAD) {
                mFragment.onLoadMore();
            }
            updateMode();
        }
    }

    public void updateMode() {
        if (moreHolder != null) {
            switch (currentMode) {
                case MORE_LOAD:
                    moreHolder.type1.setVisibility(View.VISIBLE);
                    moreHolder.type2.setVisibility(View.GONE);
                    moreHolder.type3.setVisibility(View.GONE);
                    break;
                case MORE_FAIL:
                    moreHolder.type1.setVisibility(View.GONE);
                    moreHolder.type2.setVisibility(View.VISIBLE);
                    moreHolder.type3.setVisibility(View.GONE);
                    break;
                case MORE_FINISH:
                    moreHolder.type1.setVisibility(View.GONE);
                    moreHolder.type2.setVisibility(View.GONE);
                    moreHolder.type3.setVisibility(View.VISIBLE);
                    break;
                default:
                    moreHolder.type1.setVisibility(View.GONE);
                    moreHolder.type2.setVisibility(View.GONE);
                    moreHolder.type3.setVisibility(View.GONE);
                    break;
            }
        }
    }

    public abstract void onBindViewHolder2(RecyclerView.ViewHolder holder, int position);


    public class MoreHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.type1)
        public View type1;
        @Bind(R.id.type2)
        public View type2;
        @Bind(R.id.type3)
        public View type3;

        public MoreHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
