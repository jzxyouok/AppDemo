package com.xiaopang.oschina.activity;

import android.database.Cursor;
import android.graphics.Rect;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.itheima.oschina.R;
import com.itheima.oschina.activity.base.BaseBackActivity;
import com.itheima.oschina.adapter.SelectPhotoAdapter;
import com.itheima.oschina.utils.DebugUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class SelectPhotoActivity extends BaseBackActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    @Bind(R.id.rv_photos)
    RecyclerView mRvPhotos;

    private List<String> mList;

    @Override
    public int layoutId() {
        return R.layout.hm_activity_selectphoto;
    }

    @Override
    public void initView() {
        mList = new ArrayList<>();
        getSupportLoaderManager().initLoader(0, null, this);
    }

    @Override
    public String getTitleName() {
        return "选择图片";
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(this, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{MediaStore.Images.Media.DATA}, null, null, MediaStore.Images.Media._ID + " DESC");
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mList.clear();
        if (data != null) {
            while (data.moveToNext()) {
                String path = data.getString(data.getColumnIndexOrThrow(MediaStore.Images.Media.DATA));
                File file = new File(path);
                if (file.canRead() && file.length() / 1024 > 5) {// 小于5Kb的图片过滤掉
                    DebugUtils.log("file="+path);
                    mList.add(path);
                }
            }
        }
        mRvPhotos.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        SelectPhotoAdapter adapter = new SelectPhotoAdapter(this, mList);
        SpacesItemDecoration decoration=new SpacesItemDecoration(16);
        mRvPhotos.addItemDecoration(decoration);
        mRvPhotos.setAdapter(adapter);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
    public class SpacesItemDecoration extends RecyclerView.ItemDecoration {

        private int space;

        public SpacesItemDecoration(int space) {
            this.space=space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.left=space;
            outRect.right=space;
            outRect.bottom=space;
            if(parent.getChildAdapterPosition(view)==0){
                outRect.top=space;
            }
        }
    }


}
