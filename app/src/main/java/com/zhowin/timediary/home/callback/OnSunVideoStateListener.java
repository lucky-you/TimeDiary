package com.zhowin.timediary.home.callback;

public interface OnSunVideoStateListener {

    /**
     * 准备状态
     */
    void onReadinessState();


    /**
     * 播放状态
     */
    void onPlayingState();

    /**
     * 暂停状态
     */
    void onPauseState();

    /**
     * 错误状态
     */
    void onErrorState();

    /**
     * 播放完成
     */
    void onPlayCompletedState();

}
