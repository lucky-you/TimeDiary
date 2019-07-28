package com.zhowin.timediary.home.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zhowin.timediary.R;
import com.zhowin.timediary.common.base.BaseActivity;
import com.zhowin.timediary.common.utils.BarUtils;
import com.zhowin.timediary.common.view.TitleBuilder;
import com.zhowin.timediary.home.adapter.ColumnListAdapter;
import com.zhowin.timediary.home.model.ColumnList;

import java.util.ArrayList;
import java.util.List;

/**
 * 全部频道
 */
public class AllChannelsActivity extends BaseActivity {


    private RecyclerView MyChannelRecyclerView, RecommendedRecyclerView;
    private ColumnListAdapter columnListAdapterOne;
    private ColumnListAdapter columnListAdapterTwo;
    private List<ColumnList> columnLists = new ArrayList<>();
    private TitleBuilder titleBuilder;
    private boolean isEditStatus;


    public static void start(Context context) {
        Intent intent = new Intent(context, AllChannelsActivity.class);
        context.startActivity(intent);
    }


    @Override
    public void initData(@Nullable Bundle bundle) {

    }

    @Override
    public int loadViewLayout() {
        return R.layout.activity_all_channels;
    }

    @Override
    public void bindViews(View contentView) {
        BarUtils.addMarginTopEqualStatusBarHeight(get(R.id.fakeStatusBar));
        BarUtils.setStatusBar(this, false, false);
        MyChannelRecyclerView = get(R.id.MyChannelRecyclerView);
        RecommendedRecyclerView = get(R.id.RecommendedRecyclerView);

        titleBuilder = initTitle(mContext.getString(R.string.All_Channels))
                .setRightText(mContext.getString(R.string.edit))
                .setRightOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (isEditStatus) {
                            titleBuilder.setRightText(mContext.getString(R.string.edit));
                            isEditStatus = !isEditStatus;
                        } else {
                            titleBuilder.setRightText(mContext.getString(R.string.complete));
                            isEditStatus = !isEditStatus;
                        }
                    }
                });


    }

    @Override
    public void processLogic(Bundle savedInstanceState) {

        columnListAdapterOne = new ColumnListAdapter(getColumnLists());
        MyChannelRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 4));
        MyChannelRecyclerView.setAdapter(columnListAdapterOne);

        columnListAdapterTwo = new ColumnListAdapter(getColumnLists());
        RecommendedRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 4));
        RecommendedRecyclerView.setAdapter(columnListAdapterTwo);

    }


    private List<ColumnList> getColumnLists() {
        List<ColumnList> columnLists = new ArrayList<>();
        columnLists.add(new ColumnList("电影", 1));
        columnLists.add(new ColumnList("电视剧", 1));
        columnLists.add(new ColumnList("动漫", 1));
        columnLists.add(new ColumnList("综艺", 1));
        columnLists.add(new ColumnList("纪录片", 2));
        columnLists.add(new ColumnList("伦理剧", 2));
        return columnLists;
    }


    @Override
    public void setClickListener(View view) {

    }
}
