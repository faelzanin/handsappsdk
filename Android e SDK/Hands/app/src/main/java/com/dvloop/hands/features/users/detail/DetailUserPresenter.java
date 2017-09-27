package com.dvloop.hands.features.users.detail;

import android.content.Context;

import com.dvloop.hands.Presenter;
import com.dvloop.hands.features.users.list.ListUserView;
import com.dvloop.sdk.api.UserAPI;
import com.dvloop.sdk.models.domain.User;
import com.dvloop.sdk.services.interfaces.ListUsersCallback;
import com.dvloop.sdk.services.interfaces.UserCallback;

import java.util.List;


/**
 * Created by rafaelzanin on 25/09/17.
 */

public class DetailUserPresenter implements Presenter<DetailUserView> {

    private DetailUserView view;

    public void getUser(String userId, Context context) {
        UserAPI userAPI = new UserAPI();
        userAPI.getUser(userId, context, new UserCallback() {

            @Override
            public void onFailure(Throwable t) {
                view.showError(t.getMessage());
            }

            @Override
            public void onSuccess(User user) {
                view.showUser(user);
            }

        });
    }

    @Override
    public void attachView(DetailUserView view) {
        this.view = view;
    }

    @Override
    public void dettachView() {
        this.view = null;
    }
}
