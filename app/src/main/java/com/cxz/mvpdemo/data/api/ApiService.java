package com.cxz.mvpdemo.data.api;


import com.cxz.mvpdemo.model.User;

import java.util.List;

import retrofit2.Callback;
import retrofit2.http.GET;

/**
 * author: Shoxz.Cheng
 * Date: 2016-12-28
 * Time: 10:31
 */
public interface ApiService {

    @GET("/users")
    public void getUsers(Callback<List<User>> callback);
}
