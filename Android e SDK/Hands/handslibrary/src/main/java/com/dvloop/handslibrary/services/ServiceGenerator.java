package com.dvloop.handslibrary.services;

import android.content.Context;

import com.dvloop.handslibrary.R;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rafaelzanin on 15/09/17.
 */
public class ServiceGenerator<T> {

    public static <T> T create(Class<T> apiClass, Context context) {
        String BASE_URL = context.getString(R.string.ENDPOINT);

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