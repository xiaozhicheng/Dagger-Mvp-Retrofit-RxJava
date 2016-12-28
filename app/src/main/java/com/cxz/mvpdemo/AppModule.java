package com.cxz.mvpdemo;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * author: Shoxz.Cheng
 * Date: 2016-12-28
 * Time: 11:10
 */
@Module
public class AppModule {

    private Application application;

    public AppModule(Application application){
        this.application = application;
    }

    @Singleton
    @Provides
    public Application provideApplication(){
        return application;
    }

}
