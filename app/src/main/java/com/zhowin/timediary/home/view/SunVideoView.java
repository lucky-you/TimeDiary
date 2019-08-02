package com.zhowin.timediary.home.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.SeekBar;

import com.zhowin.timediary.R;
import com.zhowin.timediary.home.callback.OnSunVideoStateListener;

import cn.jzvd.JZUtils;
import cn.jzvd.JzvdStd;

/**
 * 这里可以监听到视频播放的生命周期和播放状态
 */
public class SunVideoView extends JzvdStd {

    private static final String TAG = "xy";
    private OnSunVideoStateListener onSunVideoStateListener;

    public SunVideoView(Context context) {
        super(context);
    }

    public SunVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setOnSunVideoStateListener(OnSunVideoStateListener onSunVideoStateListener) {
        this.onSunVideoStateListener = onSunVideoStateListener;
    }

    @Override
    public void init(Context context) {
        super.init(context);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        int i = v.getId();
        if (i == cn.jzvd.R.id.fullscreen) {
            Log.i(TAG, "onClick: fullscreen button");
        } else if (i == R.id.start) {
            Log.i(TAG, "onClick: start button");
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        super.onTouch(v, event);
        int id = v.getId();
        if (id == cn.jzvd.R.id.surface_container) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_UP:
                    if (mChangePosition) {
                        Log.i(TAG, "Touch screen seek position");
                    }
                    if (mChangeVolume) {
                        Log.i(TAG, "Touch screen change volume");
                    }
                    break;
            }
        }

        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.jz_layout_std;
    }

    @Override
    public void onAutoCompletion() {
        if (screen == SCREEN_FULLSCREEN) {
            onStateAutoComplete();
        } else {
            super.onAutoCompletion();
        }

    }


    /**
     * 开启小窗播放
     */
    public void gotoScreenTiny() {
        Log.e(TAG, "startWindowTiny " + " [" + this.hashCode() + "] ");
        if (state == STATE_NORMAL || state == STATE_ERROR || state == STATE_AUTO_COMPLETE)
            return;
        ViewGroup vg = (ViewGroup) getParent();
        vg.removeView(this);
        cloneAJzvd(vg);
        CONTAINER_LIST.add(vg);
        ViewGroup vgg = (ViewGroup) (JZUtils.scanForActivity(getContext())).getWindow().getDecorView();//和他也没有关系
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(400, 300);
        lp.gravity = Gravity.RIGHT | Gravity.BOTTOM;
        //添加滑动事件等
        vgg.addView(this, lp);
        setScreenTiny();
    }


    @Override
    public void startVideo() {
        super.startVideo();
        Log.i(TAG, "startVideo");
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        super.onStopTrackingTouch(seekBar);
        Log.i(TAG, "Seek position ");
    }

    @Override
    public void gotoScreenFullscreen() {
        super.gotoScreenFullscreen();
        Log.i(TAG, "goto Fullscreen");
    }

    @Override
    public void gotoScreenNormal() {
        super.gotoScreenNormal();
        Log.i(TAG, "quit Fullscreen");
    }

    @Override
    public void autoFullscreen(float x) {
        super.autoFullscreen(x);
        Log.i(TAG, "auto Fullscreen");
    }

    @Override
    public void onClickUiToggle() {
        super.onClickUiToggle();
        Log.i(TAG, "click blank");
    }

    //onState 代表了播放器引擎的回调，播放视频各个过程的状态的回调
    @Override
    public void onStateNormal() {
        super.onStateNormal();
        Log.i(TAG, "进入普通状态，通常指setUp之后");
    }

    @Override
    public void onStatePreparing() {
        if (onSunVideoStateListener != null) {
            onSunVideoStateListener.onReadinessState();
        }
        super.onStatePreparing();
        Log.i(TAG, " 进入准备中状态，就是loading状态");
    }

    @Override
    public void onStatePlaying() {
        if (onSunVideoStateListener != null) {
            Log.i(TAG, "进入播放状态");
            onSunVideoStateListener.onPlayingState();
        }
        super.onStatePlaying();
    }

    @Override
    public void onStatePause() {
        if (onSunVideoStateListener != null) {
            Log.i(TAG, "进入暂停状态");
            onSunVideoStateListener.onPauseState();
        }
        super.onStatePause();
    }

    @Override
    public void onStateError() {
        if (onSunVideoStateListener != null) {
            Log.i(TAG, "进入错误状态");
            onSunVideoStateListener.onErrorState();
        }
        super.onStateError();

    }

    @Override
    public void onStateAutoComplete() {
        if (onSunVideoStateListener != null) {
            Log.i(TAG, "进入自动播放完成状态");
            onSunVideoStateListener.onPlayCompletedState();
        }
        super.onStateAutoComplete();
    }

    //changeUiTo 真能能修改ui的方法
    @Override
    public void changeUiToNormal() {
        super.changeUiToNormal();
    }

    @Override
    public void changeUiToPreparing() {
        super.changeUiToPreparing();
    }

    @Override
    public void changeUiToPlayingShow() {
        super.changeUiToPlayingShow();
    }

    @Override
    public void changeUiToPlayingClear() {
        super.changeUiToPlayingClear();
    }

    @Override
    public void changeUiToPauseShow() {
        super.changeUiToPauseShow();
    }

    @Override
    public void changeUiToPauseClear() {
        super.changeUiToPauseClear();
    }

    @Override
    public void changeUiToComplete() {
        super.changeUiToComplete();
    }

    @Override
    public void changeUiToError() {
        super.changeUiToError();
    }

    @Override
    public void onInfo(int what, int extra) {
        super.onInfo(what, extra);
    }

    @Override
    public void onError(int what, int extra) {
        super.onError(what, extra);
    }
}
