package com.yhx.remoteservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

/**
 * Created by yhx on 2017/10/28.
 */

public class RemoteService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("绑定");
        return new FengMiShu();
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

    public void remoteBanZheng(){
        System.out.println("苗领导在国外远程办证");
    }

    class FengMiShu extends PublicBusiness.Stub{

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public void qianxian() {
            remoteBanZheng();
        }
    }
}
