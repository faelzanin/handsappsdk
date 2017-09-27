package com.dvloop.handslibrary.api;

import android.content.Context;

import com.dvloop.handslibrary.services.ServiceGenerator;
import com.dvloop.handslibrary.services.interfaces.HandsCallback;
import com.dvloop.handslibrary.services.interfaces.UserServiceInterface;


import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by rafaelzanin on 15/09/17.
 */

public class UserAPI {

    public void getUser(String userId, Context context, final HandsCallback callback){
      /*  final UserServiceInterface userServiceInterface = ServiceGenerator.create(UserServiceInterface.class, context);
         userServiceInterface.getUser(userId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback::onSuccess,
                        callback::onFailure);*/

    }

    public void getListUsers(int limit, Context context, final HandsCallback callback){
     /*   final UserServiceInterface userServiceInterface = ServiceGenerator.create(UserServiceInterface.class, context);
        userServiceInterface.getListUsers(limit).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback::onSuccess,
                        callback::onFailure);*/

    }


}
