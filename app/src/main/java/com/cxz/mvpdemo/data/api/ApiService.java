package com.cxz.mvpdemo.data.api;


import com.cxz.mvpdemo.http.HttpResult;
import com.cxz.mvpdemo.model.Version;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * author: Shoxz.Cheng
 * Date: 2016-12-28
 * Time: 10:31
 */
public interface ApiService {

    @GET("/ksudi-star-api/android/systemSetting/getVersionInfo/1")
    Call<HttpResult<Version>> showToast(@Query("type") String type);


    @GET("/ksudi-star-api/android/systemSetting/getVersionInfo/1")
    Observable<HttpResult<Version>> showRxToast(@Query("type") String type);
}
