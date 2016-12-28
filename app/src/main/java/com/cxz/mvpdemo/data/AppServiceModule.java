package com.cxz.mvpdemo.data;

import com.cxz.mvpdemo.model.User;

import dagger.Module;
import dagger.Provides;

/**
 * author: Shoxz.Cheng
 * Date: 2016-12-28
 * Time: 11:15
 */
@Module
public class AppServiceModule {

    @Provides
    User provideUser(){
        User user = new User();
        user.setName("ccc");
        user.setAge(24);
        return user;
    }
}
