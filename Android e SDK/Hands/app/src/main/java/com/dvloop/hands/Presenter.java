package com.dvloop.hands;

/**
 * Created by rafaelzanin on 25/09/17.
 */

public interface Presenter<V> {
    void attachView(V view);

    void dettachView();

}
