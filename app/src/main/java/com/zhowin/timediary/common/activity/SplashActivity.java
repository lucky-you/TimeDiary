package com.zhowin.timediary.common.activity;

import com.zhowin.timediary.R;
import com.zhowin.timediary.common.base.BaseSplashActivity;
import com.zhowin.timediary.common.utils.ActivityUtils;

/**
 * author      : Z_B
 * date       : 2019/6/6
 * function  : 启动页
 */
public class SplashActivity extends BaseSplashActivity {
    @Override
    protected void onCreateActivity() {
        initSplashView(R.drawable.ic_launcher_background);
        startSplash(false);

    }

    @Override
    protected void onSplashFinished() {
        ActivityUtils.startActivity(MainActivity.class);
        finish();
    }
}
