package com.zhowin.timediary.common.popup;

import android.content.Context;
import android.view.View;


import com.zhowin.timediary.R;
import com.zhowin.timediary.common.callback.OnShareDialogItemClickListener;

import razerdp.basepopup.BasePopupWindow;

public class ShareResourcesDialog extends BasePopupWindow implements View.OnClickListener {

    private Context mContext;
    private OnShareDialogItemClickListener onShareDialogItemClickListener;

    public ShareResourcesDialog(Context context) {
        super(context);
        this.mContext = context;
    }

    public void setOnShareDialogItemClickListener(OnShareDialogItemClickListener onShareDialogItemClickListener) {
        this.onShareDialogItemClickListener = onShareDialogItemClickListener;
    }

    @Override
    public View onCreateContentView() {
        View popupView = createPopupById(R.layout.include_share_resources_dialog_layout);
        popupView.findViewById(R.id.llDailyUpdate).setOnClickListener(this);
        popupView.findViewById(R.id.llFilmSource).setOnClickListener(this);
        popupView.findViewById(R.id.llFreeAdmission).setOnClickListener(this);
        popupView.findViewById(R.id.llSaveAlbum).setOnClickListener(this);
        popupView.findViewById(R.id.llCopyLinks).setOnClickListener(this);
        popupView.findViewById(R.id.llTheMore).setOnClickListener(this);
        return popupView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.llDailyUpdate:
                if (onShareDialogItemClickListener != null) {
                    onShareDialogItemClickListener.onDialogItemClick(1);
                }
                break;
            case R.id.llFilmSource:
                if (onShareDialogItemClickListener != null) {
                    onShareDialogItemClickListener.onDialogItemClick(2);
                }
                break;
            case R.id.llFreeAdmission:
                if (onShareDialogItemClickListener != null) {
                    onShareDialogItemClickListener.onDialogItemClick(3);
                }
                break;
            case R.id.llSaveAlbum:
                if (onShareDialogItemClickListener != null) {
                    onShareDialogItemClickListener.onDialogItemClick(4);
                }
                break;
            case R.id.llCopyLinks:
                if (onShareDialogItemClickListener != null) {
                    onShareDialogItemClickListener.onDialogItemClick(5);
                }
                break;
            case R.id.llTheMore:
                if (onShareDialogItemClickListener != null) {
                    onShareDialogItemClickListener.onDialogItemClick(6);
                }
                break;
        }
        dismiss();
    }

}
