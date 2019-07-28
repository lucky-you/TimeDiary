package com.zhowin.timediary.home.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.zhowin.timediary.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhowin.timediary.home.callback.OnVideoListClickListener;
import com.zhowin.timediary.home.model.HomeVideoList;

import java.util.List;

/**
 * Created by : Z_B on 2019/7/27.
 * describe：首页视频列表的adapter
 */
public class HomeVideoListAdapter extends BaseQuickAdapter<HomeVideoList, BaseViewHolder> {

    private OnVideoListClickListener onVideoListClickListener;

    public HomeVideoListAdapter(@Nullable List<HomeVideoList> data) {
        super(R.layout.include_home_video_list_item_view, data);
    }

    public void setOnVideoListClickListener(OnVideoListClickListener onVideoListClickListener) {
        this.onVideoListClickListener = onVideoListClickListener;
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeVideoList item) {

        helper.setText(R.id.tvVideoTypeTitle, item.getTitle())
                .addOnClickListener(R.id.llChangeBatchesLayout)
                .addOnClickListener(R.id.tvRightMore);

        RecyclerView VideoListRecycler = helper.getView(R.id.VideoListRecycler);

        VideoListAdapter videoListAdapter = new VideoListAdapter(item.getList());
        VideoListRecycler.setLayoutManager(new GridLayoutManager(mContext, 2));
        VideoListRecycler.setAdapter(videoListAdapter);
        videoListAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (onVideoListClickListener != null) {
                    onVideoListClickListener.onVideoClick(position, "");
                }
            }
        });
    }
}
