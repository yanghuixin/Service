package com.yhx.register;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by yhx on 2017/10/28.
 */

class ScreanOnOffReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (Intent.ACTION_SCREEN_ON.equals(action)){
            System.out.println("屏幕亮了");
        }else if (Intent.ACTION_SCREEN_ON.equals(action)){
            System.out.println("屏幕灭了");
        }
    }
}
