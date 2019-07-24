package com.zhowin.timediary.home.model;

/**
 * Created by : Z_B on 2019/7/24.
 * describe： 广告列表
 */
public class AdvertisementList {

    private int id;
    private int advert_type;
    private String advert_img;
    private String advert_link;
    private int sort;
    private int createtime;
    private int updatetime;
    private int time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAdvert_type() {
        return advert_type;
    }

    public void setAdvert_type(int advert_type) {
        this.advert_type = advert_type;
    }

    public String getAdvert_img() {
        return advert_img;
    }

    public void setAdvert_img(String advert_img) {
        this.advert_img = advert_img;
    }

    public String getAdvert_link() {
        return advert_link;
    }

    public void setAdvert_link(String advert_link) {
        this.advert_link = advert_link;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getCreatetime() {
        return createtime;
    }

    public void setCreatetime(int createtime) {
        this.createtime = createtime;
    }

    public int getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(int updatetime) {
        this.updatetime = updatetime;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
