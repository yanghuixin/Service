package com.yhx.leaderservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by yhx on 2017/10/27.
 */

public class LeaderService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new FengMiShu();
    }

    class FengMiShu extends Binder implements PublicBusiness{
        //中间人的牵线
        @Override
        public void qianxian(){
            //调用领导的办证
            banzheng();
        }

        public void takeScap(){

        }
    }

    public void banzheng(){
        System.out.println("成功办证");
    }
}
