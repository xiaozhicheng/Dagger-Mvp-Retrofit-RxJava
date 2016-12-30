package com.cxz.mvpdemo.data.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

/**
 * author: Shoxz.Cheng
 * Date: 2016-12-28
 * Time: 10:46
 */
@Module
public class ApiServiceModule {

    private static final String ENDPOINT = "http://192.168.1.38";


    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(12, TimeUnit.SECONDS);
        return httpClient.build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient client){
        // @formatter:off
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .serializeNulls()
                .create();
        Retrofit.Builder retrofit = new Retrofit.Builder();
        retrofit.addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create(gson));
        retrofit.client(client);
        retrofit.baseUrl(ENDPOINT);
        return retrofit.build();
    }


    @Provides
    @Singleton
    ApiService provideApiService(Retrofit retrofit){
        return retrofit.create(ApiService.class);
    }

}
