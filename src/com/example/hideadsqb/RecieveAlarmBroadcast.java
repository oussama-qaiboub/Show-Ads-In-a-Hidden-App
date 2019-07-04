package com.example.hideadsqb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.widget.Toast;

public class RecieveAlarmBroadcast extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		  if (Intent.ACTION_MEDIA_BUTTON.equals(intent.getAction())) {
	            KeyEvent event = (KeyEvent)intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT);
	            if (KeyEvent.KEYCODE_VOLUME_UP == event.getKeyCode()) {
	                Toast.makeText(context, " volume",  Toast.LENGTH_LONG).show();
	            }
	        }

	        Intent newIntent = new Intent(context, ServiceShowI3lan.class);
	        newIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
	        context.startService(newIntent);
	}

}
