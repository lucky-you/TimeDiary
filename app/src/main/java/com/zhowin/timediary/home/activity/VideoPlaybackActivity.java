package com.zhowin.timediary.home.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.request.RequestOptions;
import com.zhowin.timediary.R;
import com.zhowin.timediary.common.base.BaseActivity;
import com.zhowin.timediary.common.utils.BarUtils;
import com.zhowin.timediary.common.utils.ConstantValues;
import com.zhowin.timediary.home.adapter.GuessLikeVideoAdapter;
import com.zhowin.timediary.home.callback.OnSunVideoStateListener;
import com.zhowin.timediary.home.model.VideoList;
import com.zhowin.timediary.home.view.SunVideoView;
import com.zhowin.timediary.home.widget.VideoUtils;
import com.zhowin.viewlibrary.callback.NestedScrollViewListener;
import com.zhowin.viewlibrary.view.NoNestedScrollview;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

import static com.bumptech.glide.load.resource.bitmap.VideoBitmapDecoder.FRAME_OPTION;

/**
 * 视频播放
 */
public class VideoPlaybackActivity extends BaseActivity implements OnSunVideoStateListener {


    private String playVideoUrl;
    private NoNestedScrollview noNestedScrollview;
    private SunVideoView jzvdStd;
    private List<VideoList> videoLists = new ArrayList<>();
    private RecyclerView GuessLikeRecyclerView;
    private GuessLikeVideoAdapter guessLikeVideoAdapter;


    public static void start(Context context, String videoUrl) {
        Intent intent = new Intent(context, VideoPlaybackActivity.class);
        intent.putExtra(ConstantValues.VIDEO_URL, videoUrl);
        context.startActivity(intent);

    }

    @Override
    public void initData(@Nullable Bundle bundle) {
        playVideoUrl = bundle.getString(ConstantValues.VIDEO_URL);
    }

    @Override
    public int loadViewLayout() {
        return R.layout.activity_video_playback;
    }

    @Override
    public void bindViews(View contentView) {
        BarUtils.setStatusBar(this, false, false);
        BarUtils.setStatusBarLightMode(this, false);


        noNestedScrollview = get(R.id.noNestedScrollview);
        GuessLikeRecyclerView = get(R.id.GuessLikeRecyclerView);
        jzvdStd = get(R.id.videoPlayer);
        jzvdStd.setOnSunVideoStateListener(this);
        Jzvd.setVideoImageDisplayType(Jzvd.VIDEO_IMAGE_DISPLAY_TYPE_FILL_SCROP);


    }


    @Override
    public void processLogic(Bundle savedInstanceState) {
        if (!TextUtils.isEmpty(playVideoUrl)) {
            jzvdStd.setUp(playVideoUrl, "", JzvdStd.SCREEN_NORMAL);
            VideoUtils.loadVideoScreenshot(mContext, playVideoUrl, jzvdStd.thumbImageView);
//            jzvdStd.startVideo();
        }
        guessLikeVideoAdapter = new GuessLikeVideoAdapter(getVideoList());
        GuessLikeRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        GuessLikeRecyclerView.setAdapter(guessLikeVideoAdapter);
        noNestedScrollview.setScrollViewListener(new NestedScrollViewListener() {
            @Override
            public void onScrollChanged(NestedScrollView scrollView, int x, int y, int oldX, int oldY) {
            }

            @Override
            public void onScroll(int scrollY) {
                Log.e("xy", "scrollY=" + scrollY + "<-JZHeight->" + jzvdStd.getHeight());
                if (scrollY >= jzvdStd.getHeight()) {

                } else {

                }
            }
        });
    }


    @Override
    public void setClickListener(View view) {

    }

    private List<VideoList> getVideoList() {
        List<VideoList> videoListsThree = new ArrayList<>();
        videoListsThree.add(new VideoList("狂野巨兽", imageList[0], "02:15:36", "1635", "87%"));
        videoListsThree.add(new VideoList("机械师", imageList[1], "02:15:36", "1635", "87%"));
        videoListsThree.add(new VideoList("扫毒2", imageList[2], "02:15:36", "1635", "87%"));
        videoListsThree.add(new VideoList("战斗天使", imageList[3], "02:15:36", "1635", "87%"));
        return videoListsThree;
    }

    public String[] imageList = {
            "http://img.mukewang.com/55237dcc0001128c06000338.jpg",
            "http://img.mukewang.com/552640c300018a9606000338.jpg",
            "http://img.mukewang.com/551b98ae0001e57906000338.jpg",
            "http://img.mukewang.com/5518ecf20001cb4e06000338.jpg"
    };

    @Override
    public void onBackPressed() {
        if (Jzvd.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();
    }

    @Override
    public void onReadinessState() {

    }

    @Override
    public void onPlayingState() {

    }

    @Override
    public void onPauseState() {

    }

    @Override
    public void onErrorState() {

    }

    @Override
    public void onPlayCompletedState() {

    }
}
