package com.dvloop.handslibrary.services.interfaces;

import com.dvloop.handslibrary.models.services.ResponseObject;

/**
 * Created by rafaelzanin on 15/09/17.
 */

public interface HandsCallback {

    void onSuccess(ResponseObject responseObject);

    void onFailure(Throwable t);
}
