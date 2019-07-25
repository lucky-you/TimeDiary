package com.zhowin.timediary.home.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.zhouwei.mzbanner.holder.MZViewHolder;
import com.zhowin.timediary.R;
import com.zhowin.timediary.common.utils.GlideUtils;
import com.zhowin.timediary.home.model.BannerList;

/**
 * Created by : Z_B on 2019/7/25.
 * describe：
 */
public class MZBannerViewHolder implements MZViewHolder<BannerList> {
    private RoundedImageView mImageView;
    private TextView tvBannerTitle;

    @Override
    public View createView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.include_banner_item_view, null);
        mImageView = view.findViewById(R.id.rivBannerImage);
        tvBannerTitle = view.findViewById(R.id.tvBannerTitle);
        return view;
    }

    @Override
    public void onBind(Context context, int position, BannerList bannerList) {
        GlideUtils.loadImage(context, bannerList.getVideoUrl(), mImageView);
        tvBannerTitle.setText(bannerList.getVideoTitle());
    }
}
