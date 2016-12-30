package com.cxz.mvpdemo.activity.presenter;


import com.cxz.mvpdemo.activity.MainActivity;
import com.cxz.mvpdemo.data.api.ApiService;
import com.cxz.mvpdemo.http.HttpResult;
import com.cxz.mvpdemo.model.User;
import com.cxz.mvpdemo.model.Version;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * author: Shoxz.Cheng
 * Date: 2016-12-28
 * Time: 10:35
 */
public class MainPresenter{

    private MainActivity mainActivity;
    private ApiService apiService;
    private User user;

    public MainPresenter(ApiService apiService,MainActivity activity,User user){
        this.mainActivity = activity;
        this.apiService = apiService;
        this.user = user;
    }

    public void showToast(String msg){
//        /**retrofit使用**/
//        apiService.showToast("5").enqueue(new Callback<HttpResult<Version>>() {
//            @Override
//            public void onResponse(Call<HttpResult<Version>> call, Response<HttpResult<Version>> response) {
//                mainActivity.showToast(response.body().getData().getPath());
//            }
//
//            @Override
//            public void onFailure(Call<HttpResult<Version>> call, Throwable t) {
//                mainActivity.showToast("onFailure-->"+t.getMessage());
//            }
//        });

//        /***rxjava使用**/
//        Observable<String> observable = Observable.just(msg);
//        observable.subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                mainActivity.showToast(s);
//            }
//        });

        /**retrofit+rxjava使用***/
        apiService.showRxToast("5").subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<HttpResult<Version>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mainActivity.showToast("onError-->"+e.getMessage());
                    }

                    @Override
                    public void onNext(HttpResult<Version> versionHttpResult) {
                        mainActivity.showToast(versionHttpResult.getData().getPath());
                    }
                });

    }

}
