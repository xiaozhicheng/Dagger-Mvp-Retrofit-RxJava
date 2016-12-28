package com.cxz.mvpdemo.activity.presenter;


import com.cxz.mvpdemo.activity.MainActivity;
import com.cxz.mvpdemo.model.User;

/**
 * author: Shoxz.Cheng
 * Date: 2016-12-28
 * Time: 10:35
 */
public class MainPresenter {

    private MainActivity mainActivity;

    private User user;

    public MainPresenter(MainActivity activity,User user){
        this.mainActivity = activity;
        this.user = user;
    }

}
