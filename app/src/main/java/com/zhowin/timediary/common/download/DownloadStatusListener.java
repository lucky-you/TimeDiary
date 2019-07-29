package com.zhowin.timediary.common.download;

/**
 * 下载状态的监听
 */
public interface DownloadStatusListener {
    /**
     * 开始
     */
    void onStart();

    /**
     * 当前进度
     *
     * @param currentLength 进度
     */
    void onProgress(int currentLength);

    /**
     * 暂停
     *
     * @param currentLength 进度
     */
    void onPause(int currentLength);

    /**
     * 下载成功
     *
     * @param localPath 存储到本地的路径
     */
    void onSuccess(String localPath);

    /**
     * 下载失败
     *
     * @param errorInfo 信息
     */
    void onError(String errorInfo);
}
