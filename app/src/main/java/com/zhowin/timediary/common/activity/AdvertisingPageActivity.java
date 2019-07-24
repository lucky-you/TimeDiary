package com.zhowin.timediary.common.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.zhowin.timediary.R;
import com.zhowin.timediary.common.base.BaseActivity;
import com.zhowin.timediary.common.base.ResultResponse;
import com.zhowin.timediary.common.retrofit.RetrofitFactory;
import com.zhowin.timediary.common.utils.ActivityUtils;
import com.zhowin.timediary.common.utils.BarUtils;
import com.zhowin.timediary.common.utils.GlideUtils;
import com.zhowin.timediary.home.model.AdvertisementList;

import java.util.List;
import java.util.Random;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 广告页面
 */
public class AdvertisingPageActivity extends BaseActivity {

    private ImageView ivAdvertisement;
    private String advertisementUrl;

    @Override
    public void initData(@Nullable Bundle bundle) {

    }

    @Override
    public int loadViewLayout() {
        return R.layout.activity_advertising_page;
    }

    @Override
    public void bindViews(View contentView) {
        BarUtils.setStatusBar(this, false, false);
        ivAdvertisement = get(R.id.ivAdvertisement);
        ivAdvertisement.setOnClickListener(this);
        get(R.id.tvSkipJump).setOnClickListener(this);
    }

    @Override
    public void processLogic(Bundle savedInstanceState) {

    }

    private void getData() {
        RetrofitFactory.getInstance().getAdvertisementList("1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResultResponse<List<AdvertisementList>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResultResponse<List<AdvertisementList>> listResultResponse) {
                        if (listResultResponse != null) {
                            List<AdvertisementList> advertisementList = listResultResponse.data;
                            if (advertisementList != null && !advertisementList.isEmpty()) {
                                String imageUrl = randomImageUrl(advertisementList);
                                if (!TextUtils.isEmpty(imageUrl)) {
                                    GlideUtils.loadAdvertisementImage(mContext, imageUrl, ivAdvertisement);
                                }
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("xy", "错误：" + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                    }
                });

    }

    private String randomImageUrl(List<AdvertisementList> imageList) {
        Random random = new Random();
        int randomInt = random.nextInt(imageList.size());
        String imageUrl = imageList.get(randomInt).getAdvert_img();
        advertisementUrl = imageList.get(randomInt).getAdvert_link();
        Log.e("xy", "跳转链接=" + advertisementUrl);
        return imageUrl;
    }

    @Override
    public void setClickListener(View view) {
        switch (view.getId()) {
            case R.id.tvSkipJump:
                ActivityUtils.startActivity(MainActivity.class);
                finish();
                break;
            case R.id.ivAdvertisement:
                //跳转外连接
                if (!TextUtils.isEmpty(advertisementUrl)) {
                    if (advertisementUrl.endsWith(".apk")) {
                        //下载apk
                    } else {
                        //跳转Url
                    }
                }
                break;
        }
    }
}
