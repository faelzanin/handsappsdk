package com.dvloop.hands;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.dvloop.sdk.api.UserAPI;
import com.dvloop.sdk.models.services.ResponseObject;
import com.dvloop.sdk.services.interfaces.UserCallback;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
