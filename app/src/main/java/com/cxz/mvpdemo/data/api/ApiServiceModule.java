package com.cxz.mvpdemo.data.api;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * author: Shoxz.Cheng
 * Date: 2016-12-28
 * Time: 10:46
 */
@Module
public class ApiServiceModule {

    private static final String ENDPOINT = "";


    @Provides
    @Singleton
    Retrofit provideRetrofit(){
        Retrofit.Builder retrofit = new Retrofit.Builder();
        retrofit.baseUrl(ENDPOINT);
        return retrofit.build();
    }


    @Provides
    @Singleton
    ApiService provideApiService(Retrofit retrofit){
        return retrofit.create(ApiService.class);
    }

}
