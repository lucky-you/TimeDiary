package com.zhowin.timediary.home.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;
import com.zhowin.timediary.R;
import com.zhowin.timediary.common.base.BaseFragment;
import com.zhowin.timediary.common.utils.ConstantValues;
import com.zhowin.timediary.home.adapter.HomeVideoListAdapter;
import com.zhowin.timediary.home.model.BannerList;
import com.zhowin.timediary.home.model.HomeVideoList;
import com.zhowin.timediary.home.model.VideoList;
import com.zhowin.timediary.home.viewholder.MZBannerViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by : Z_B on 2019/7/27.
 * describe：视频列表的fragment
 */
public class VideoListFragment extends BaseFragment {


    public static VideoListFragment newInstance(int index) {
        VideoListFragment fragment = new VideoListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ConstantValues.INDEX, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    private MZBannerView mzBannerView;
    private RecyclerView videoRecyclerView;
    private List<HomeVideoList> homeVideoLists = new ArrayList<>();
    private HomeVideoListAdapter homeVideoListAdapter;
    private View headerView, footView;


    @Override
    public void initData(@Nullable Bundle bundle) {

    }

    @Override
    public int loadViewLayout() {
        return R.layout.include_recycler_view_layout;
    }

    @Override
    public void bindViews(View contentView) {

        videoRecyclerView = get(R.id.recyclerView);

        headerView = View.inflate(mContext, R.layout.include_video_list_header_layout, null);
        footView = View.inflate(mContext, R.layout.include_video_list_footer_layout, null);
        mzBannerView = headerView.findViewById(R.id.mzBannerView);


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

        homeVideoListAdapter = new HomeVideoListAdapter(getVideoDataList());
        videoRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        videoRecyclerView.setAdapter(homeVideoListAdapter);
        homeVideoListAdapter.addHeaderView(headerView);
        homeVideoListAdapter.addFooterView(footView);

    }

    private List<BannerList> getBannerList() {
        List<BannerList> bannerLists = new ArrayList<>();
        bannerLists.add(new BannerList(imageList[0], "环境变量配置文件"));
        bannerLists.add(new BannerList(imageList[1], "Android断点续传下载"));
        bannerLists.add(new BannerList(imageList[2], "CSS动画实用技巧"));
        bannerLists.add(new BannerList(imageList[3], "高德云图在线使用"));
        return bannerLists;

    }

    public String[] imageList = {
            "http://img.mukewang.com/55237dcc0001128c06000338.jpg",
            "http://img.mukewang.com/552640c300018a9606000338.jpg",
            "http://img.mukewang.com/551b98ae0001e57906000338.jpg",
            "http://img.mukewang.com/5518ecf20001cb4e06000338.jpg"
    };


    private List<HomeVideoList> getVideoDataList() {
        List<HomeVideoList> homeVideoLists = new ArrayList<>();

        List<VideoList> videoListsOne = new ArrayList<>();
        List<VideoList> videoListsTwo = new ArrayList<>();
        List<VideoList> videoListsThree = new ArrayList<>();
        List<VideoList> videoListsFour = new ArrayList<>();

        videoListsOne.add(new VideoList("狂野巨兽", imageList[0], "02:15:36", "1635", "87%"));
        videoListsOne.add(new VideoList("机械师", imageList[1], "02:15:36", "1635", "87%"));
        videoListsOne.add(new VideoList("扫毒2", imageList[2], "02:15:36", "1635", "87%"));
        videoListsOne.add(new VideoList("战斗天使", imageList[3], "02:15:36", "1635", "87%"));
        homeVideoLists.add(new HomeVideoList("热播动作片", videoListsOne));

        videoListsTwo.add(new VideoList("狂野巨兽", imageList[0], "02:15:36", "1635", "87%"));
        videoListsTwo.add(new VideoList("机械师", imageList[1], "02:15:36", "1635", "87%"));
        videoListsTwo.add(new VideoList("扫毒2", imageList[2], "02:15:36", "1635", "87%"));
        videoListsTwo.add(new VideoList("战斗天使", imageList[3], "02:15:36", "1635", "87%"));
        homeVideoLists.add(new HomeVideoList("热播科幻片", videoListsTwo));

        videoListsThree.add(new VideoList("狂野巨兽", imageList[0], "02:15:36", "1635", "87%"));
        videoListsThree.add(new VideoList("机械师", imageList[1], "02:15:36", "1635", "87%"));
        videoListsThree.add(new VideoList("扫毒2", imageList[2], "02:15:36", "1635", "87%"));
        videoListsThree.add(new VideoList("战斗天使", imageList[3], "02:15:36", "1635", "87%"));
        homeVideoLists.add(new HomeVideoList("热播爱情片", videoListsThree));

        videoListsFour.add(new VideoList("狂野巨兽", imageList[0], "02:15:36", "1635", "87%"));
        videoListsFour.add(new VideoList("机械师", imageList[1], "02:15:36", "1635", "87%"));
        videoListsFour.add(new VideoList("扫毒2", imageList[2], "02:15:36", "1635", "87%"));
        videoListsFour.add(new VideoList("战斗天使", imageList[3], "02:15:36", "1635", "87%"));
        homeVideoLists.add(new HomeVideoList("热播动画片", videoListsFour));

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
