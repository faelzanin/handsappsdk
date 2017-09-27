package com.dvloop.sdk.services.interfaces;


import com.dvloop.sdk.models.domain.User;

/**
 * Created by rafaelzanin on 15/09/17.
 */

public interface UserCallback {

    void onFailure(Throwable t);

    void onSuccess(User user);
}
