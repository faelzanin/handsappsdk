package com.dvloop.hands.features.users.detail;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.dvloop.hands.BaseActivity;
import com.dvloop.hands.R;
import com.dvloop.hands.features.users.list.ListUserFragment;

import butterknife.ButterKnife;

/**
 * Created by rafaelzanin on 25/09/17.
 */

public class DetailUserActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user);

        initComponents();
    }

    private void initComponents() {
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        new Handler().post(() -> {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            DetailUserFragment detailUserFragment = new DetailUserFragment();
            fragmentTransaction.add(R.id.main_container, detailUserFragment, DetailUserFragment.class.toString());
            fragmentTransaction.commit();
        });


    }
}
