package com.yhx.leaderservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    PublicBusiness pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this,LeaderService.class);
        bindService(intent, new ServiceConnection() {
            //service这个对象就是onBind方法返回的中间人
            //onBind方法有返回值此方法才会调用
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                pb = (PublicBusiness) service;
            }

            //连接因为异常终止此方法才会调用
            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        }, BIND_AUTO_CREATE);
    }

    public void click(View view) {
        pb.qianxian();
    }
}
