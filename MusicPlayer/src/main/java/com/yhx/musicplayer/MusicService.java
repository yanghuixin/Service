package com.yhx.musicplayer;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by yhx on 2017/10/28.
 */

public class MusicService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MusicCrontroller();
    }

    class MusicCrontroller extends Binder implements ControllerInterface{

        @Override
        public void play() {
            MusicService.this.play();
        }

        @Override
        public void pause() {
            MusicService.this.pause();
        }
    }

    public void play(){
        System.out.println("开始播放音乐");
    }

    public void pause(){
        System.out.println("暂停播放音乐");
    }
}
