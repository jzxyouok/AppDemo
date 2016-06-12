package com.xiaopang.tmall.weight;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaopang.tmall.R;

import butterknife.Bind;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.indicator.PtrIndicator;

public class TmallRefresh extends FrameLayout implements PtrUIHandler {

    @Bind(R.id.sdv_gif)
    SimpleDraweeView sdvGif;

    public TmallRefresh(Context context) {
        super(context);
        View.inflate(context, R.layout.tm_weight_tmallrefresh, this);
        sdvGif = (SimpleDraweeView) findViewById(R.id.sdv_gif);
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse("http://img2.tuicool.com/6Rzamy7.gif"))
                .setAutoPlayAnimations(true)
                .build();
        sdvGif.setBackgroundColor(Color.RED);
        sdvGif.setController(controller);
    }

    @Override
    public void onUIReset(PtrFrameLayout frame) {
    }

    @Override
    public void onUIRefreshPrepare(PtrFrameLayout frame) {
    }

    @Override
    public void onUIRefreshBegin(PtrFrameLayout frame) {
    }

    @Override
    public void onUIRefreshComplete(PtrFrameLayout frame) {
    }

    @Override
    public void onUIPositionChange(PtrFrameLayout frame, boolean isUnderTouch, byte status, PtrIndicator ptrIndicator) {
        if (isUnderTouch) {
            if (ptrIndicator.getCurrentPercent() >= 1) {

            } else {

            }
        }
    }

}
