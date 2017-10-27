package com.yhx.recorder;

import android.app.Service;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

import java.io.IOException;

/**
 * Created by yhx on 2017/10/27.
 */

public class RecorderService extends Service {
    private MediaRecorder recorder;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //获取电话管理器
        TelephonyManager tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        //监听电话状态
        tm.listen(new MyLinstener(),PhoneStateListener.LISTEN_CALL_STATE);
    }

    class MyLinstener extends PhoneStateListener{
        //电话状态改变时调用
        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            super.onCallStateChanged(state, incomingNumber);
            //判断电话当前是什么状态
            switch (state){
                case TelephonyManager.CALL_STATE_IDLE:
                    System.out.println("空闲");
                    if (recorder != null){
                        //停止录音
                        recorder.stop();
                        //释放录音机占用的资源
                        recorder.release();
                        recorder = null;
                    }
                    break;
                case TelephonyManager.CALL_STATE_RINGING:
                    System.out.println("响铃");
                    if (recorder == null){
                        recorder = new MediaRecorder();
                        //设置音频来源
                        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                        //设置音频格式
                        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                        //设置保存音频路径
                        recorder.setOutputFile("sdcard/voice.3gp");
                        //设置音频编码
                        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                        try {
                            recorder.prepare();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case TelephonyManager.CALL_STATE_OFFHOOK:
                    System.out.println("摘机");
                    if (recorder != null){
                        //开始录音
                        recorder.start();
                    }
                    break;
            }
        }
    }
}
