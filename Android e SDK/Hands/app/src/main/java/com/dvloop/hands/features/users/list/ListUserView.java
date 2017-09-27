package com.dvloop.hands.features.users.list;

import com.dvloop.sdk.models.domain.User;

import java.util.List;

/**
 * Created by rafaelzanin on 25/09/17.
 */

public interface ListUserView {

    void showListUsers(List<String> list);
    void showError(String message);

}