package com.zhowin.timediary.home.model;

/**
 * Created by : Z_B on 2019/7/25.
 * describe：
 */
public class BannerList {


    private String videoUrl;
    private String videoTitle;


    public BannerList(String videoUrl, String videoTitle) {
        this.videoUrl = videoUrl;
        this.videoTitle = videoTitle;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }
}
