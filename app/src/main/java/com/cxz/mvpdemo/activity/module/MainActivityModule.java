package com.cxz.mvpdemo.activity.module;


import com.cxz.mvpdemo.activity.ActivityScope;
import com.cxz.mvpdemo.activity.MainActivity;
import com.cxz.mvpdemo.activity.presenter.MainPresenter;
import com.cxz.mvpdemo.model.User;

import dagger.Module;
import dagger.Provides;

/**
 * author: Shoxz.Cheng
 * Date: 2016-12-28
 * Time: 10:34
 */
@Module
public class MainActivityModule {

    private MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }

    @Provides
    @ActivityScope
    MainActivity provideMainActivity(){
        return mainActivity;
    }

    @Provides
    @ActivityScope
    MainPresenter provideMainPresenter(MainActivity activity, User user){
        return new MainPresenter(activity,user);
    }
}
