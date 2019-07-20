package com.zhowin.timediary.home.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.zhowin.timediary.R;
import com.zhowin.timediary.common.activity.HomeActivity;
import com.zhowin.timediary.common.base.BaseFragment;

/**
 * Created by: Z_B on 2019/7/20.
 * Function: 首页的fragment
 */
public class HomeFragment extends BaseFragment {

    private TextView tvIndexTitle;

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
        tvIndexTitle = get(R.id.tvIndexTitle);
        int index = getArguments().getInt("index");
        tvIndexTitle.setText("这是第" + index + "Fragment");
        tvIndexTitle.setOnClickListener(this::setClickListener);
    }

    @Override
    public void processLogic(Bundle savedInstanceState) {

    }

    @Override
    public void setClickListener(View view) {
        switch (view.getId()) {
            case R.id.tvIndexTitle:
                HomeActivity.start(mContext);
                break;

        }

    }
}
