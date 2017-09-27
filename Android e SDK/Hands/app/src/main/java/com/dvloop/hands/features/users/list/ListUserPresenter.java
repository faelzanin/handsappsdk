package com.dvloop.hands.features.users.list;

import android.content.Context;

import com.dvloop.hands.Presenter;
import com.dvloop.sdk.api.UserAPI;
import com.dvloop.sdk.services.interfaces.ListUsersCallback;

import java.util.List;


/**
 * Created by rafaelzanin on 25/09/17.
 */

public class ListUserPresenter implements Presenter<ListUserView> {

    private ListUserView view;

    public void getListUsers(int limit, Context context) {
        UserAPI userAPI = new UserAPI();
        userAPI.getListUsers(limit, context, new ListUsersCallback() {

            @Override
            public void onFailure(Throwable t) {
                view.showError(t.getMessage());
            }

            @Override
            public void onSuccess(List<String> userList) {
                view.showListUsers(userList);
            }
        });
    }

    @Override
    public void attachView(ListUserView view) {
        this.view = view;
    }

    @Override
    public void dettachView() {
        this.view = null;
    }
}
