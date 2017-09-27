package com.dvloop.sdk.services.interfaces;


import com.dvloop.sdk.models.domain.User;
import com.dvloop.sdk.models.services.ResponseObject;

import java.util.List;

/**
 * Created by rafaelzanin on 15/09/17.
 */

public interface ListUsersCallback {

    void onFailure(Throwable t);

    void onSuccess(List<String> userList);
}
