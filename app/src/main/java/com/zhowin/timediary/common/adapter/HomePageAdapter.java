package com.zhowin.timediary.common.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by: Z_B on 2017/7/10.
 * Function: viewPager的adapter
 */
public class HomePageAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;
    private String[] mTitles;
    private List<String> titleList;


    public HomePageAdapter(FragmentManager fm, List<Fragment> mFragment, String[] mTitles) {
        super(fm);
        this.mFragments = mFragment;
        this.mTitles = mTitles;
    }

    public HomePageAdapter(FragmentManager fm, List<Fragment> mFragments, List<String> titleList) {
        super(fm);
        this.mFragments = mFragments;
        this.titleList = titleList;
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (mTitles != null) {
            return mTitles[position];
        } else {
            return titleList.get(position);
        }
    }
}
