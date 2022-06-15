package com.example.reviewfragmentrecycler.brodcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class BrodCast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.ACTION_POWER_CONNECTED")){
            Toast.makeText(context.getApplicationContext(), "Contented Power",Toast.LENGTH_LONG).show();

        }else if(intent.getAction().equals("android.intent.action.ACTION_POWER_DISCONNECTED")){
            Log.d("ttt","dd");
            Toast.makeText(context.getApplicationContext(), "DisContented Power",Toast.LENGTH_LONG).show();


        }



    }
}
