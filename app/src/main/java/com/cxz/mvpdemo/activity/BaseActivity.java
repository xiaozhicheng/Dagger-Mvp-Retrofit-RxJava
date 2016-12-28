package com.cxz.mvpdemo.activity;

import android.app.Activity;
import android.os.Bundle;

import com.cxz.mvpdemo.AppAplication;
import com.cxz.mvpdemo.AppComponent;


/**
 * author: Shoxz.Cheng
 * Date: 2016-12-28
 * Time: 10:55
 */
public abstract class BaseActivity  extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent(AppAplication.get(this).getAppComponent());
    }

    protected abstract void setupActivityComponent(AppComponent appComponent);
}
