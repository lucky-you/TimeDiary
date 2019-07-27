package com.zhowin.timediary.home.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.flyco.tablayout.SlidingTabLayout;
import com.zhowin.timediary.R;
import com.zhowin.timediary.common.adapter.HomePageAdapter;
import com.zhowin.timediary.common.base.BaseFragment;
import com.zhowin.timediary.common.utils.BarUtils;
import com.zhowin.viewlibrary.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by: Z_B on 2019/7/20.
 * Function: 首页的fragment
 */
public class HomeFragment extends BaseFragment {


    private SlidingTabLayout slidingTabLayout;
    private NoScrollViewPager noScrollViewPager;
    private List<Fragment> mFragments = new ArrayList<>();
    private HomePageAdapter homePageAdapter;


    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle bundle = new Bundle();
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
        slidingTabLayout = get(R.id.slidingTabLayout);
        noScrollViewPager = get(R.id.noScrollViewPager);
        get(R.id.rlAddColumn).setOnClickListener(this);
    }

    @Override
    public void processLogic(Bundle savedInstanceState) {
        String[] titleList = mContext.getResources().getStringArray(R.array.videoTitleList);
        for (int i = 0; i < titleList.length; i++) {
            mFragments.add(VideoListFragment.newInstance(i));
        }
        homePageAdapter = new HomePageAdapter(getChildFragmentManager(), mFragments, titleList);
        noScrollViewPager.setAdapter(homePageAdapter);
        slidingTabLayout.setViewPager(noScrollViewPager);
        noScrollViewPager.setOffscreenPageLimit(mFragments.size());

    }


    @Override
    public void setClickListener(View view) {

    }


}
