package com.zhowin.timediary.common.activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.runtime.Permission;
import com.zhowin.timediary.R;
import com.zhowin.timediary.common.base.BaseApplication;
import com.zhowin.timediary.common.base.BaseSplashActivity;
import com.zhowin.timediary.common.permission.AndPermissionListener;
import com.zhowin.timediary.common.permission.AndPermissionUtils;
import com.zhowin.timediary.common.utils.ActivityUtils;
import com.zhowin.timediary.common.utils.BarUtils;
import com.zhowin.timediary.common.utils.SystemUtil;
import com.zhowin.timediary.common.utils.ToastUtils;

import java.util.List;

/**
 * author      : Z_B
 * date       : 2019/6/6
 * function  : 启动页
 */
public class SplashActivity extends BaseSplashActivity {

    private static final int REQUEST_CODE_SETTING = 1;

    @Override
    protected void onCreateActivity() {
        BarUtils.setStatusBar(this, false, false);
        initSplashView(R.drawable.ic_welcome_page);
        requestPermission(
                Permission.READ_EXTERNAL_STORAGE,
                Permission.WRITE_EXTERNAL_STORAGE

        );

    }

    private void requestPermission(String... permissions) {
        AndPermissionUtils.requestPermission(SplashActivity.this, new AndPermissionListener() {
            @Override
            public void PermissionSuccess(List<String> permissions) {
                startSplash(false);
                String androidID = SystemUtil.getAndroidId();
                Log.e("xy", "androidID=" + androidID);
                if (!TextUtils.isEmpty(androidID)) {
                    BaseApplication.getInstance().setAndroidIdCode(androidID);
                }
            }

            @Override
            public void PermissionFailure(List<String> permissions) {

            }

            @Override
            public void OpenSystemSettings() {
                AndPermission.with(SplashActivity.this).runtime().setting().start(REQUEST_CODE_SETTING);
            }
        }, permissions);

    }

    @Override
    protected void onSplashFinished() {
        ActivityUtils.startActivity(AdvertisingPageActivity.class);
        finish();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case REQUEST_CODE_SETTING: {
                ToastUtils.showLong(BaseApplication.getInstance().getString(R.string.message_setting_comeback));
                break;
            }
        }
    }
}
