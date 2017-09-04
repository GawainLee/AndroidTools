package com.tapwater.learn_32_receiver_one;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Tapwater on 16-1-21.
 */
public class AirPlaneModeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("info","Air Plane Mode Receiver");
    }
}
