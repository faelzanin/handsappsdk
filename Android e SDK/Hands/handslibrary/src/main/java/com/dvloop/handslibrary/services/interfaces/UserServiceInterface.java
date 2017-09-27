package com.dvloop.handslibrary.services.interfaces;

import com.dvloop.handslibrary.models.services.ResponseObject;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by rafaelzanin on 15/09/17.
 */

public interface UserServiceInterface {


    @GET("users/list")
    Observable<ResponseObject> getListUsers(@Query("limit") int limit);

    @GET("users/detail")
    Observable<ResponseObject> getUser(@Query("userId") String userId);

}
