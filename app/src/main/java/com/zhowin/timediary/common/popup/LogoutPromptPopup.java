package com.zhowin.timediary.common.popup;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;

import com.zhowin.timediary.R;
import com.zhowin.timediary.common.callback.OnLogoutPromptListener;

import razerdp.basepopup.BasePopupWindow;

/**
 * Created by : Z_B on 2019/7/2.
 * describe： 退出登录的popup
 */
public class LogoutPromptPopup extends BasePopupWindow implements View.OnClickListener {

    private Context mContext;
    private OnLogoutPromptListener onLogoutPromptListener;

    public LogoutPromptPopup(Context context, OnLogoutPromptListener onLogoutPromptListener) {
        super(context);
        this.mContext = context;
        this.onLogoutPromptListener = onLogoutPromptListener;
    }

    @Override
    public View onCreateContentView() {
        View rootView = createPopupById(R.layout.include_logout_prompt_popup_layout);
        rootView.findViewById(R.id.tvCancel).setOnClickListener(this);
        rootView.findViewById(R.id.tvDetermine).setOnClickListener(this);
        return rootView;
    }

    @Override
    protected Animation onCreateShowAnimation() {
        return getDefaultScaleAnimation(true);
    }

    @Override
    protected Animation onCreateDismissAnimation() {
        return getDefaultScaleAnimation(false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvCancel:
                if (onLogoutPromptListener != null) {
                    onLogoutPromptListener.onCancel();
                }
                dismiss();
                break;
            case R.id.tvDetermine:
                if (onLogoutPromptListener != null) {
                    onLogoutPromptListener.onDetermine();
                }
                dismiss();
                break;
        }
    }
}
