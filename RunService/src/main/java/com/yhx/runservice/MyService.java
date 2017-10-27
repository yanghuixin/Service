package com.yhx.runservice;

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
        System.out.println("onBind");
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("创建服务");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("启动服务");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("销毁服务");
    }
}
