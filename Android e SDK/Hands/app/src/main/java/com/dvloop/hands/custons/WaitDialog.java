package com.dvloop.hands.custons;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import com.dvloop.hands.R;
/**
 * Created by rafaelzanin on 27/09/17.
 */

public class WaitDialog extends ProgressDialog {

    public WaitDialog(Context context) {
        super(context, R.style.HandsProgressTheme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_wait);

    }


}
