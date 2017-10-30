
package com.yhx.startremoteservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.yhx.remoteservice.PublicBusiness;

public class MainActivity extends AppCompatActivity {

    MyConn myConn;
    PublicBusiness pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myConn = new MyConn();
    }

    public void start(View view) {
        Intent intent = new Intent();
        intent.setAction("com.yhx.remote");
        startService(intent);
    }

    public void stop(View view) {
        Intent intent = new Intent();
        intent.setAction("com.yhx.remote");
        stopService(intent);
    }

    public void bind(View view) {
        Intent intent = new Intent();
        intent.setAction("com.yhx.remote");
        bindService(intent,myConn,BIND_AUTO_CREATE);
    }

    public void unbind(View view) {
        Intent intent = new Intent();
        intent.setAction("com.yhx.remote");
        unbindService(myConn);
    }

    public void banzheng(View view) {
        try {
            pb.qianxian();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    class MyConn implements ServiceConnection{

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            pb = PublicBusiness.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }
}
