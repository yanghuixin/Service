package com.yhx.alipay;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

/**
 * Created by yhx on 2017/10/29.
 */

public class PayService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return new PayController();
    }

    class PayController extends PayInterface.Stub{

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public void pay() throws RemoteException {
            PayService.this.pay();
        }


    }

    public void pay(){
        System.out.println("检查支付环境");
        System.out.println("加密账号密码");
        System.out.println("上传账号密码");
        System.out.println("支付完成");
    }
}
