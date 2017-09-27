package com.dvloop.hands.features.users.list;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.dvloop.hands.BaseActivity;
import com.dvloop.hands.R;

import butterknife.ButterKnife;

/**
 * Created by rafaelzanin on 25/09/17.
 */

public class ListUserActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);

        initComponents();
    }

    private void initComponents() {
        ButterKnife.bind(this);

        new Handler().post(() -> {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            ListUserFragment listUserFragment = new ListUserFragment();
            fragmentTransaction.add(R.id.main_container, listUserFragment, ListUserFragment.class.toString());
            fragmentTransaction.commit();
        });


    }
}
