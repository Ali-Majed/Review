package com.example.reviewfragmentrecycler.servies;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import com.example.reviewfragmentrecycler.R;

public class TestService extends Service {
    MediaPlayer mp;

    public TestService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("ttt", "c");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mp=MediaPlayer.create(this, R.raw.music);
        if (!
                mp.isPlaying())
            mp.start();
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                stopSelf();
            }
        });

        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        if (mp.isPlaying()){
            mp.stop();
            mp.release();
        }

        super.onDestroy();
        Log.d("ttt", "dv");

    }
}