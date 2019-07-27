package com.zhowin.timediary.home.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhowin.timediary.R;
import com.zhowin.timediary.common.utils.GlideUtils;
import com.zhowin.timediary.home.model.VideoList;

import java.util.List;

/**
 * Created by : Z_B on 2019/7/27.
 * describe： 视频列表的adapter
 */
public class VideoListAdapter extends BaseQuickAdapter<VideoList, BaseViewHolder> {
    public VideoListAdapter(@Nullable List<VideoList> data) {
        super(R.layout.include_video_list_item_view, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, VideoList item) {

        GlideUtils.loadImage(mContext, item.getVideoPhoto(), helper.getView(R.id.rivVideoPhoto));
        helper.setText(R.id.tvPlayNumber, item.getPlayNumber())
                .setText(R.id.tvComplimentsNumber, item.getComplimentsNumber())
                .setText(R.id.tvVideoDuration, item.getVideoDuration())
                .addOnClickListener(R.id.llComplimentsNumberLayout);

    }
}
