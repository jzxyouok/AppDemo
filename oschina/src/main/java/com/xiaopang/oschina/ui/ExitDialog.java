package com.xiaopang.oschina.ui;

import android.content.Context;
import android.view.View;

import com.itheima.oschina.R;
import com.itheima.oschina.window.base.BaseDialog;

import butterknife.OnClick;

public class ExitDialog extends BaseDialog {

    private DialogCallBack callBack;

    public ExitDialog(Context context) {
        super(context);
    }

    @Override
    public int layoutId() {
        return R.layout.hm_ui_dialog_exit;
    }

    @OnClick({R.id.tv_cancel, R.id.tv_confirm})
    public void click(View v) {
        if (v.getId() == R.id.tv_cancel) {
            dismiss();
        } else if (v.getId() == R.id.tv_confirm) {
            if (callBack != null) {
                dismiss();
                callBack.onConfirm();
            }
        }
    }

    public interface DialogCallBack {
        public void onConfirm();
    }

    public void addDialogCallBack(DialogCallBack callback) {
        this.callBack = callback;
    }

}
