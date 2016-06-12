package com.xiaopang.common.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.xiaopang.common.app.BaseApp;

import java.io.File;

/**
 * Created by yaoshouyun on 2016/6/12.
 */
public class PatchBroadCast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        File file = new File("/mnt/sdcard/patchs");
        for (File f : file.listFiles()) {
            try {
                BaseApp.patchManager.addPatch(f.getAbsolutePath());
                System.out.println("补丁成功：" + f.getAbsolutePath());
            } catch (Exception e) {
                System.out.println("补丁失败：" + f.getAbsolutePath());
                e.printStackTrace();
            }
        }
    }

}
