package com.zhowin.timediary.common.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zhowin.timediary.R;
import com.zhowin.timediary.common.base.BaseActivity;
import com.zhowin.timediary.common.view.LoadingViewUtils;
import com.zhowin.timediary.common.view.RefreshLayout;
import com.zhowin.viewlibrary.empty.LoadingController;

/**
 * 登录界面，这里只是方便展示网络请求，正式项目根据不同的需求来展示不同的界面
 */
public class LoginActivity extends BaseActivity {

    private RefreshLayout refreshLayout;
    private RecyclerView recyclerView;
    private LoadingController loadingController;


    @Override
    public void initData(@Nullable Bundle bundle) {

    }

    @Override
    public int loadViewLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void bindViews(View contentView) {
        refreshLayout = get(R.id.refreshLayout);
        recyclerView = get(R.id.recyclerView);

        loadingController = LoadingViewUtils.showLoadingView(mContext, recyclerView, () -> {
            showToast("点击了重新加载");
            loadingController.dismissLoading();
        });

    }

    @Override
    public void processLogic(Bundle savedInstanceState) {
        refreshLayout.setOnRefreshListener(() -> {
            refreshLayout.setRefreshing(false);
            loadingController.showError();
        });

        recyclerView.postDelayed(() -> {
//                loadingController.showEmpty();
            loadingController.showNetworkError();
        }, 2000);

    }


    @Override
    public void setClickListener(View view) {

    }
}

