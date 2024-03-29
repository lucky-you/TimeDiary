package com.zhowin.timediary.common.download;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;

import com.zhowin.timediary.R;
import com.zhowin.timediary.common.base.ApiService;
import com.zhowin.timediary.common.base.BaseApplication;
import com.zhowin.timediary.common.retrofit.RetrofitFactory;
import com.zhowin.timediary.common.utils.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * 下载的工具类
 */
public class DownloadUtil {

    private static final String TAG = "xy";
    public static final String PATH_CHALLENGE_VIDEO = Environment.getExternalStorageDirectory() + "/" + BaseApplication.getInstance().getString(R.string.app_name);
    //视频下载相关
    protected ApiService mApiService;
    private String mVideoPath; //下载到本地的视频路径


    public DownloadUtil() {
        if (mApiService == null) {
            mApiService = RetrofitFactory.getInstance();
        }
    }

    /**
     * 下载文件
     *
     * @param url              链接
     * @param downloadListener 监听回调
     */
    public void downloadFile(String url, final DownloadStatusListener downloadListener) {
        //通过Url得到保存到本地的文件名
        String name = url;
        if (FileUtils.createOrExistsDir(PATH_CHALLENGE_VIDEO)) {
            int i = name.lastIndexOf('/');//一定是找最后一个'/'出现的位置
            if (i != -1) {
                name = name.substring(i);
                mVideoPath = PATH_CHALLENGE_VIDEO + name;
            }
        }
        if (TextUtils.isEmpty(mVideoPath)) {
            Log.e(TAG, "downloadVideo:存储路径为空了");
            return;
        }
        //建立一个文件
        File mFile = new File(mVideoPath);
        if (!FileUtils.isFileExists(mFile) && FileUtils.createOrExistsFile(mFile)) {
            if (mApiService == null) {
                Log.e(TAG, "downloadVideo:下载接口为空了");
                return;
            }
            mApiService.downloadFile(url)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<ResponseBody>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                            downloadListener.onStart();
                        }

                        @Override
                        public void onNext(ResponseBody responseBody) {
                            writeFileToDisk(responseBody, mFile, downloadListener);
                        }

                        @Override
                        public void onError(Throwable e) {
                            downloadListener.onError(e.getMessage());
                        }

                        @Override
                        public void onComplete() {

                        }
                    });


        } else {
            //已经存在了，不再重复下载
            downloadListener.onSuccess(mVideoPath);
        }
    }

    /**
     * 保存到本地
     */
    private void writeFileToDisk(ResponseBody response, File file, DownloadStatusListener downloadListener) {
//        downloadListener.onStart();
        long currentLength = 0;
        OutputStream os = null;
        if (response == null) {
            downloadListener.onError("资源错误!");
            return;
        }
        InputStream is = response.byteStream();
        long totalLength = response.contentLength();
        try {
            os = new FileOutputStream(file);
            int len;
            byte[] buff = new byte[1024];
            while ((len = is.read(buff)) != -1) {
                os.write(buff, 0, len);
                currentLength += len;
                Log.e(TAG, "当前进度:" + currentLength);
                downloadListener.onProgress((int) (100 * currentLength / totalLength));
                if ((int) (100 * currentLength / totalLength) == 100) {
                    downloadListener.onSuccess(mVideoPath);
                }
            }
        } catch (FileNotFoundException e) {
            downloadListener.onError("未找到文件!");
            e.printStackTrace();
        } catch (IOException e) {
            downloadListener.onError("IO错误!");
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
