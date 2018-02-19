package com.example.jason.tutorapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by jason on 2/19/18.
 */

public class BroadCastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"FEED M3 M0AR P0WER PL0X", Toast.LENGTH_SHORT ).show();
    }
}
