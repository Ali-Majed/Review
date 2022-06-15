package com.example.reviewfragmentrecycler.servies;

import android.app.IntentService;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;

public class MyIntentService  extends IntentService {
    MediaPlayer mp;


    public MyIntentService() {
        super("MyIntentService");
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("ttt", "c");

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("ttt","OnStart");
        try {
            Thread.sleep(5000);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }



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