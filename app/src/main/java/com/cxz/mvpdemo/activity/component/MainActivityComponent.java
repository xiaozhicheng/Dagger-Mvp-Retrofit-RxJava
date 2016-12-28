package com.cxz.mvpdemo.activity.component;


import com.cxz.mvpdemo.AppComponent;
import com.cxz.mvpdemo.activity.ActivityScope;
import com.cxz.mvpdemo.activity.MainActivity;
import com.cxz.mvpdemo.activity.module.MainActivityModule;
import com.cxz.mvpdemo.activity.presenter.MainPresenter;

import dagger.Component;

/**
 * author: Shoxz.Cheng
 * Date: 2016-12-28
 * Time: 10:34
 */
@ActivityScope
@Component(modules = MainActivityModule.class,dependencies = AppComponent.class)
public interface MainActivityComponent {

    MainActivity inject(MainActivity mainActivity);

    MainPresenter presenter();
}
