package com.zhowin.timediary.home.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.request.RequestOptions;

import java.security.MessageDigest;

import static com.bumptech.glide.load.resource.bitmap.VideoBitmapDecoder.FRAME_OPTION;

/**
 * Created by : Z_B on 2019/7/28.
 * describe：
 */
public class VideoUtils {

    /**
     * 截取视频的第一帧作为封面
     *
     * @param context   上下文
     * @param uri       视频地址
     * @param imageView 显示图片
     */
    public static void loadVideoScreenshot(final Context context, String uri, ImageView imageView) {
        RequestOptions requestOptions = RequestOptions.frameOf(0); //默认第一帧
        requestOptions.set(FRAME_OPTION, MediaMetadataRetriever.OPTION_CLOSEST);
        requestOptions.transform(new BitmapTransformation() {
            @Override
            protected Bitmap transform(@NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
                return toTransform;
            }

            @Override
            public void updateDiskCacheKey(MessageDigest messageDigest) {
                try {
                    messageDigest.update((context.getPackageName() + "RotateTransform").getBytes("utf-8"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Glide.with(context).load(uri).apply(requestOptions).into(imageView);
    }
}
