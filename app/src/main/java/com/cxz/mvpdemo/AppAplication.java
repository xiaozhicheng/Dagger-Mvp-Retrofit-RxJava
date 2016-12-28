package com.cxz.mvpdemo;

import android.app.Application;
import android.content.Context;

import com.cxz.mvpdemo.data.AppServiceModule;
import com.cxz.mvpdemo.data.api.ApiServiceModule;


/**
 * author: Shoxz.Cheng
 * Date: 2016-12-28
 * Time: 10:29
 */
public class AppAplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .appServiceModule(new AppServiceModule())
                .apiServiceModule(new ApiServiceModule())
                .build();

    }

    public static AppAplication get(Context context){
        return (AppAplication) context.getApplicationContext();
    }


    public AppComponent getAppComponent(){
        return appComponent;
    }



}
