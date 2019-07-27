package com.zhowin.timediary.home.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;
import com.zhowin.timediary.R;
import com.zhowin.timediary.common.activity.HomeActivity;
import com.zhowin.timediary.common.base.BaseFragment;
import com.zhowin.timediary.common.utils.BarUtils;
import com.zhowin.timediary.home.model.BannerList;
import com.zhowin.timediary.home.model.HomeVideoList;
import com.zhowin.timediary.home.model.VideoList;
import com.zhowin.timediary.home.viewholder.MZBannerViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by: Z_B on 2019/7/20.
 * Function: 首页的fragment
 */
public class HomeFragment extends BaseFragment {

    private MZBannerView mzBannerView;

    private RecyclerView videoRecyclerView;

    private List<HomeVideoList> homeVideoLists = new ArrayList<>();


    public static HomeFragment newInstance(int index) {
        HomeFragment fragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("index", index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void initData(@Nullable Bundle bundle) {

    }

    @Override
    public int loadViewLayout() {
        return R.layout.include_home_fragment_layout;
    }

    @Override
    public void bindViews(View contentView) {
        BarUtils.addMarginTopEqualStatusBarHeight(get(R.id.actionBarTitle));

        mzBannerView = get(R.id.mzBannerView);
        videoRecyclerView = get(R.id.videoRecyclerView);

    }

    @Override
    public void processLogic(Bundle savedInstanceState) {

        mzBannerView.setIndicatorVisible(false);
        mzBannerView.setDelayedTime(5000);
        mzBannerView.setBannerPageClickListener(new MZBannerView.BannerPageClickListener() {
            @Override
            public void onPageClick(View view, int position) {
                showToast("click page:" + position);
            }
        });
        mzBannerView.setPages(getBannerList(), new MZHolderCreator() {
            @Override
            public MZViewHolder createViewHolder() {
                return new MZBannerViewHolder();
            }
        });
    }

    private List<BannerList> getBannerList() {
        List<BannerList> bannerLists = new ArrayList<>();
        bannerLists.add(new BannerList("http://img.mukewang.com/55237dcc0001128c06000338.jpg", "环境变量配置文件"));
        bannerLists.add(new BannerList("http://img.mukewang.com/552640c300018a9606000338.jpg", "Android断点续传下载"));
        bannerLists.add(new BannerList("http://img.mukewang.com/551b98ae0001e57906000338.jpg", "CSS动画实用技巧"));
        bannerLists.add(new BannerList("http://img.mukewang.com/5518ecf20001cb4e06000338.jpg", "高德云图在线使用"));
        return bannerLists;

    }


    private List<HomeVideoList> getVideoDataList() {
        List<HomeVideoList> homeVideoLists = new ArrayList<>();

        List<VideoList> videoListsOne = new ArrayList<>();



        return homeVideoLists;

    }


    @Override
    public void setClickListener(View view) {

    }

    @Override
    public void onResume() {
        super.onResume();
        mzBannerView.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        mzBannerView.pause();
    }

}
