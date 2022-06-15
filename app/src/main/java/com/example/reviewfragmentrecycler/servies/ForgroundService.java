package com.example.reviewfragmentrecycler.servies;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;

import com.example.reviewfragmentrecycler.R;

public class ForgroundService  extends Service {
    public static final String CHANNEL_ID="channel_id";
    MediaPlayer mp;

    public ForgroundService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startForeground(15,CreateNotification());
        mp= MediaPlayer.create(this,R.raw.music);
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


    public Notification CreateNotification() {
        NotificationCompat.Builder noBuilder = new NotificationCompat.Builder(ForgroundService.this, CHANNEL_ID);
        noBuilder.setSmallIcon(R.drawable.ic_baseline_notifications)
                .setContentTitle("name")
                .setContentText("num");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel =
                    new NotificationChannel(CHANNEL_ID, "Name", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = (NotificationManager) getSystemService(getApplicationContext().NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }

        return noBuilder.build();

    }
}