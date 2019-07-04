package com.example.hideadsqb;

import java.util.Random;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

public class WhenDeviceBoots extends BroadcastReceiver{
	 
	 private AlarmManager alarm;
	 private PendingIntent pendingIntent;
     long x = 1;
     
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		    alarm = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
	        Intent myIntent = new Intent(context, RecieveAlarmBroadcast.class);
	        myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
	        pendingIntent = PendingIntent.getBroadcast(context, 0, myIntent, 0);
	        alarm.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
	                SystemClock.elapsedRealtime() + 1000*60*x, nextShowsI3lanRandm(), pendingIntent);
	}

	    public long nextShowsI3lanRandm(){
	        int x = 3;
	        Random myRandom = new Random();
	        return 60*1000*x + myRandom.nextInt(3)*60*1000;
	    }

}
