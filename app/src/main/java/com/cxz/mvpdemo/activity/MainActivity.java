package com.cxz.mvpdemo.activity;

import android.os.Bundle;
import android.os.PersistableBundle;

import com.cxz.mvpdemo.AppComponent;
import com.cxz.mvpdemo.activity.component.DaggerMainActivityComponent;
import com.cxz.mvpdemo.activity.module.MainActivityModule;
import com.cxz.mvpdemo.activity.presenter.MainPresenter;

import javax.inject.Inject;

/**
 * author: Shoxz.Cheng
 * Date: 2016-12-28
 * Time: 10:55
 */
public class MainActivity extends BaseActivity {

    @Inject
    MainPresenter mainPresenter;


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerMainActivityComponent.builder()
                .appComponent(appComponent).mainActivityModule(new MainActivityModule(this))
                .build().inject(this);
    }
}
