package com.zhowin.timediary.home.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhowin.timediary.R;
import com.zhowin.timediary.common.utils.GlideUtils;
import com.zhowin.timediary.home.model.VideoList;

import java.util.List;

/**
 * Created by : Z_B on 2019/7/28.
 * describe：猜你喜欢
 */
public class GuessLikeVideoAdapter extends BaseQuickAdapter<VideoList, BaseViewHolder> {
    public GuessLikeVideoAdapter(@Nullable List<VideoList> data) {
        super(R.layout.include_guess_like_video_item_view, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, VideoList item) {
        GlideUtils.loadImage(mContext, item.getVideoPhoto(), helper.getView(R.id.rivVideoPhoto));

        helper.setText(R.id.tvVideoName, item.getVideoName())
                .setText(R.id.tvVideoDuration, mContext.getString(R.string.Duration,item.getVideoDuration()))
                .setText(R.id.tvPlayNumber, item.getPlayNumber())
                .setText(R.id.tvComplimentsNumber, item.getComplimentsNumber())
                .addOnClickListener(R.id.llComplimentsLayout);

    }
}
