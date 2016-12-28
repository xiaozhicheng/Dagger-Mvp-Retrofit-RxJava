package com.cxz.mvpdemo;

import android.app.Application;

import com.cxz.mvpdemo.data.AppServiceModule;
import com.cxz.mvpdemo.data.api.ApiService;
import com.cxz.mvpdemo.data.api.ApiServiceModule;
import com.cxz.mvpdemo.model.User;

import javax.inject.Singleton;

import dagger.Component;

/**
 * author: Shoxz.Cheng
 * Date: 2016-12-28
 * Time: 10:30
 */
@Singleton
@Component(modules = {AppModule.class, ApiServiceModule.class, AppServiceModule.class})
public interface AppComponent {

    Application getApplicaiton();

    ApiService getService();

    User getUser();
}
