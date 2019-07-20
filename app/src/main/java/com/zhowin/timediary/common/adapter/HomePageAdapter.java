package com.zhowin.timediary.common.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by: Z_B on 2017/7/10.
 * Function:
 */
public class HomePageAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;
    private String[] mTitles;

    public HomePageAdapter(FragmentManager fm) {
        super(fm);
    }

    public HomePageAdapter(FragmentManager fm, List<Fragment> mFragment, String[] mTitles) {
        super(fm);
        this.mFragments = mFragment;
        this.mTitles = mTitles;
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
        return mTitles[position];
    }
}
