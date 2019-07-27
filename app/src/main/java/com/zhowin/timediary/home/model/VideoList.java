package com.zhowin.timediary.home.model;

/**
 * Created by : Z_B on 2019/7/27.
 * describe：视频的数据
 */
public class VideoList {

    private String videoName;//名称
    private String videoPhoto;//图片
    private String videoDuration; //时长
    private String playNumber;//播放数量
    private String complimentsNumber;//点赞数量

    public VideoList(String videoName, String videoPhoto, String videoDuration, String playNumber, String complimentsNumber) {
        this.videoName = videoName;
        this.videoPhoto = videoPhoto;
        this.videoDuration = videoDuration;
        this.playNumber = playNumber;
        this.complimentsNumber = complimentsNumber;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getVideoPhoto() {
        return videoPhoto;
    }

    public void setVideoPhoto(String videoPhoto) {
        this.videoPhoto = videoPhoto;
    }

    public String getVideoDuration() {
        return videoDuration;
    }

    public void setVideoDuration(String videoDuration) {
        this.videoDuration = videoDuration;
    }

    public String getPlayNumber() {
        return playNumber;
    }

    public void setPlayNumber(String playNumber) {
        this.playNumber = playNumber;
    }

    public String getComplimentsNumber() {
        return complimentsNumber;
    }

    public void setComplimentsNumber(String complimentsNumber) {
        this.complimentsNumber = complimentsNumber;
    }
}
