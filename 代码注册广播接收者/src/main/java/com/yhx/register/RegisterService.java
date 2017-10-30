package com.yhx.register;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by yhx on 2017/10/28.
 */

public class RegisterService extends Service {
    private ScreanOnOffReceiver receiver;;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //创建广播接收者对象
        receiver = new ScreanOnOffReceiver();
        //创建意图过滤器对象
        IntentFilter filter = new IntentFilter();
        //指定接收什么广播
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        //注册广播接收者
        registerReceiver(receiver,filter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //反注册广播接收者
        unregisterReceiver(receiver);
    }
}
