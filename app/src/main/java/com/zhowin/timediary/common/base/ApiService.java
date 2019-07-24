package com.zhowin.timediary.common.base;


import com.zhowin.timediary.BuildConfig;
import com.zhowin.timediary.home.model.AdvertisementList;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * 网络请求
 */
public interface ApiService {


    //baseUrl
//    String API_SERVER_URL = "https://miyue.nacy.cc/";  //-->线下
    String API_SERVER_URL = BuildConfig.API_HOST; //-->线上
    String TOKEN = "token";
    String PARAM = "param";
    String HEADER_URL = "api/v1";


    /**
     * 获取广告
     */
    String ADVERTISMENT_LIST_URL = "/api.php/advert/lists";

    /**
     * 获取广告列表
     */
    @FormUrlEncoded
    @POST(ADVERTISMENT_LIST_URL)
    Observable<ResultResponse<List<AdvertisementList>>> getAdvertisementList(@Field("advert_type") String param);

    /**
     * 下载文件
     */
    @Streaming //大文件时要加不然会OOM
    @GET
    Observable<ResponseBody> downloadFile(@Url String url);


}
