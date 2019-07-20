package com.zhowin.timediary.common.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.zhowin.timediary.R;
import com.zhowin.timediary.common.adapter.HomePageAdapter;
import com.zhowin.timediary.common.base.BaseActivity;
import com.zhowin.timediary.common.utils.BarUtils;
import com.zhowin.timediary.common.widget.HomeTabEntity;
import com.zhowin.timediary.home.fragment.HomeFragment;
import com.zhowin.viewlibrary.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * 主页
 */
public class MainActivity extends BaseActivity {


    private String[] mTitles = {"首页", "分类", "会员", "分享"};

    private int[] mIconUnselectIds = {
            R.drawable.tab_home_unselect, R.drawable.tab_home_unselect,
            R.drawable.tab_home_unselect, R.drawable.tab_home_unselect};

    private int[] mIconSelectIds = {
            R.drawable.tab_home_select, R.drawable.tab_home_select,
            R.drawable.tab_home_select, R.drawable.tab_home_select};

    private NoScrollViewPager noScrollViewPager;
    private CommonTabLayout commonTabLayout;
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private List<Fragment> mFragments = new ArrayList<>();

    @Override
    public void initData(@Nullable Bundle bundle) {

    }

    @Override
    public int loadViewLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void bindViews(View contentView) {
        BarUtils.setStatusBar(this, false, false);
        noScrollViewPager=get(R.id.noScrollViewPager);
        commonTabLayout=get(R.id.commonTabLayout);

        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new HomeTabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
            mFragments.add(HomeFragment.newInstance(i));
        }

        noScrollViewPager.setAdapter(new HomePageAdapter(getSupportFragmentManager(), mFragments, mTitles));
        commonTabLayout.setTabData(mTabEntities);
        noScrollViewPager.setOffscreenPageLimit(mTitles.length);
    }

    @Override
    public void processLogic(Bundle savedInstanceState) {
        commonTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                noScrollViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }


    @Override
    public void setClickListener(View view) {

    }


}





