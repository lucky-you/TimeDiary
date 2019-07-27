package com.zhowin.timediary.home.model;

import java.util.List;

/**
 * Created by : Z_B on 2019/7/27.
 * describe： 首页的视频数据
 */
public class HomeVideoList {


    private String title;
    private List<VideoList>   list;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<VideoList> getList() {
        return list;
    }

    public void setList(List<VideoList> list) {
        this.list = list;
    }
}
