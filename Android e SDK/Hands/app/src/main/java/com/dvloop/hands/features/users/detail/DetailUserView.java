package com.dvloop.hands.features.users.detail;

import com.dvloop.sdk.models.domain.User;

import java.util.List;

/**
 * Created by rafaelzanin on 25/09/17.
 */

public interface DetailUserView {

    void showUser(User user);
    void showError(String message);

}