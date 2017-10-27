package com.yhx.startservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by yhx on 2017/10/27.
 */

public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("绑定");
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        System.out.println("解绑");
        return super.onUnbind(intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("创建");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("开始");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("摧毁");
    }
}
