package com.dvloop.sdk.services;

import android.content.Context;

import com.dvloop.sdk.R;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rafaelzanin on 15/09/17.
 */
public class ServiceGenerator<T> {
    private static String BASE_URL = "https://gentle-caverns-76840.herokuapp.com/";

    public static <T> T create(Class<T> apiClass, Context context) {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(getLoggingInterceptor());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(builder.build())
                .build();

        return retrofit.create(apiClass);
    }

    private static HttpLoggingInterceptor getLoggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }

}