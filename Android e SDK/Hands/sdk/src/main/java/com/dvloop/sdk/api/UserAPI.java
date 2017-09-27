package com.dvloop.sdk.api;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;

import com.dvloop.sdk.models.domain.User;
import com.dvloop.sdk.services.ServiceGenerator;
import com.dvloop.sdk.services.interfaces.ListUsersCallback;
import com.dvloop.sdk.services.interfaces.UserCallback;
import com.dvloop.sdk.services.interfaces.UserServiceInterface;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;

import java.util.ArrayList;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by rafaelzanin on 15/09/17.
 */

public class UserAPI {

    public void getUser(String userId, Context context, final UserCallback callback) {
        final UserServiceInterface userServiceInterface = ServiceGenerator.create(UserServiceInterface.class, context);
        userServiceInterface.getUser(userId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responseObject -> {
                            List<Object> list = (List<Object>) responseObject.getData();
                            LinkedTreeMap jsonObject = (LinkedTreeMap) list.get(0);
                            User user = new User();
                            user.setEuid(jsonObject.get("euid").toString());
                            user.setDeviceId(jsonObject.get("deviceId").toString());
                            user.setOs(jsonObject.get("os").toString());
                            user.setOsVersion(jsonObject.get("osVersion").toString());
                            user.setDeviceModel(jsonObject.get("deviceModel").toString());
                            user.setHome(jsonObject.get("home").toString());
                            user.setWork(jsonObject.get("work").toString());
                            user.setIstInstalledApps(jsonObject.get("istInstalledApps").toString());
                            user.setBatteryState(Float.parseFloat(jsonObject.get("batteryState").toString()));
                            user.setBatteryPercentage(Float.parseFloat(jsonObject.get("batteryPercentage").toString()));
                            user.setArrival(jsonObject.get("arrival").toString());
                            user.setDeparture(jsonObject.get("departure").toString());
                            user.setCategorie(jsonObject.get("categorie").toString());
                            user.setVenueName(jsonObject.get("venueName").toString());
                            user.setVenueTotalTime(Float.parseFloat(jsonObject.get("venueTotalTime").toString()));
                            user.setPrecision(Float.parseFloat(jsonObject.get("precision").toString()));
                            user.setVenueLngLat(jsonObject.get("venueLngLat").toString());
                            user.setAddress(jsonObject.get("address").toString());
                            user.setCity(jsonObject.get("city").toString());
                            user.setState(jsonObject.get("state").toString());
                            user.setCountry(jsonObject.get("country").toString());

                            callback.onSuccess(user);
                        },
                        callback::onFailure);

    }

    public void getListUsers(int limit, Context context, final ListUsersCallback callback) {
        final UserServiceInterface userServiceInterface = ServiceGenerator.create(UserServiceInterface.class, context);
        userServiceInterface.getListUsers(limit).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responseObject -> {
                            callback.onSuccess((ArrayList) responseObject.getData());
                        },
                        callback::onFailure);

    }




}
