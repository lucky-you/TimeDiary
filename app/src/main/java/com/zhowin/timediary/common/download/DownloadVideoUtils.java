package com.zhowin.timediary.common.download;

import android.util.Log;

import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadListener;
import com.liulishuo.filedownloader.FileDownloadQueueSet;
import com.liulishuo.filedownloader.FileDownloadSampleListener;
import com.liulishuo.filedownloader.FileDownloader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by : Z_B on 2019/7/29.
 * describe：下载文件
 */
public class DownloadVideoUtils {

    /**
     * 下载文件
     *
     * @param fileUrl    文件路劲
     * @param targetPath 保存路劲
     * @param listener   监听回调
     * @return
     */
    public static int startDownLoadFile(String fileUrl, String targetPath, DownloadStatusListener listener) {

        return FileDownloader.getImpl().create(fileUrl)
                .setPath(targetPath, false)
                .setCallbackProgressTimes(300)
                .setMinIntervalUpdateSpeed(400)
                .setTag(targetPath)
                .setListener(new FileDownloadSampleListener() {
                    @Override
                    protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                        Log.e("xy", "pending taskId:" + task.getId() + ",soFarBytes:" + soFarBytes + ",totalBytes:" + totalBytes + ",percent:" + soFarBytes * 1.0 / totalBytes);
                        listener.onStart();
                    }

                    @Override
                    protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                        Log.e("xy", "progress taskId:" + task.getId() + ",soFarBytes:" + soFarBytes + ",totalBytes:" + totalBytes + ",percent:" + soFarBytes * 1.0 / totalBytes + ",speed:" + task.getSpeed());
                        listener.onProgress((int) ((soFarBytes * 1.0 / totalBytes) * 100));

                    }

                    @Override
                    protected void blockComplete(BaseDownloadTask task) {
                        Log.e("xy", "blockComplete taskId:" + task.getId() + ",filePath:" + task.getPath() + ",fileName:" + task.getFilename() + ",speed:" +
                                task.getSpeed() + ",isReuse:" + task.reuse() + ",Url:" + task.getUrl());
                        listener.onSuccess(task.getPath());
                    }

                    @Override
                    protected void completed(BaseDownloadTask task) {
                        Log.e("xy", "completed taskId:" + task.getId() + ",isReuse:" + task.reuse());
                    }

                    @Override
                    protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                        Log.e("xy", "paused taskId:" + task.getId() + ",soFarBytes:" + soFarBytes + ",totalBytes:" + totalBytes + ",percent:" + soFarBytes * 1.0 / totalBytes);
                        listener.onPause((int) ((soFarBytes * 1.0 / totalBytes) * 100));
                    }

                    @Override
                    protected void error(BaseDownloadTask task, Throwable e) {
                        Log.e("xy", "error taskId:" + task.getId() + ",e:" + e.getLocalizedMessage());
                        listener.onError(e.getLocalizedMessage());
                    }

                    @Override
                    protected void warn(BaseDownloadTask task) {
                        Log.e("xy", "warn taskId:" + task.getId());
                    }
                }).start();

    }

    /**
     * 多线程下载
     *
     * @param videoUrlList 链接集合
     */
    private void MultiThreadedDownload(List<String> videoUrlList) {

        final FileDownloadQueueSet queueSet = new FileDownloadQueueSet(queueTarget);
        final List<BaseDownloadTask> tasks = new ArrayList<>();
        for (int i = 0; i < videoUrlList.size(); i++) {
            tasks.add(FileDownloader.getImpl().create(videoUrlList.get(i)).setTag(i + 1));
        }
        queueSet.disableCallbackProgressTimes(); // 由于是队列任务, 这里是我们假设了现在不需要每个任务都回调`FileDownloadListener#progress`, 我们只关系每个任务是否完成, 所以这里这样设置可以很有效的减少ipc.
        // 所有任务在下载失败的时候都自动重试一次
        queueSet.setAutoRetryTimes(1);
        // 并行执行该任务队列
        queueSet.downloadTogether(tasks);
        // 最后你需要主动调用start方法来启动该Queue
        queueSet.start();


    }


    final FileDownloadListener queueTarget = new FileDownloadListener() {
        @Override
        protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes) {
        }

        @Override
        protected void connected(BaseDownloadTask task, String etag, boolean isContinue, int soFarBytes, int totalBytes) {
        }

        @Override
        protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {
        }

        @Override
        protected void blockComplete(BaseDownloadTask task) {
        }

        @Override
        protected void retry(final BaseDownloadTask task, final Throwable ex, final int retryingTimes, final int soFarBytes) {
        }

        @Override
        protected void completed(BaseDownloadTask task) {
        }

        @Override
        protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes) {
        }

        @Override
        protected void error(BaseDownloadTask task, Throwable e) {
        }

        @Override
        protected void warn(BaseDownloadTask task) {
        }
    };


}
