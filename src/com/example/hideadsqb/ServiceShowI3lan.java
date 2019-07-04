package com.example.hideadsqb;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.startapp.android.publish.adsCommon.StartAppAd;
import com.startapp.android.publish.adsCommon.StartAppSDK;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class ServiceShowI3lan extends Service{


	public static String interstitialServer = "";
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		getData process = new getData();
        process.execute();
	 	
        Toast.makeText(getApplicationContext(), "ad : "+interstitialServer, Toast.LENGTH_LONG).show();
        
        try{
       
        	displayInter();
        	displayStart();
            
        }
        catch(NullPointerException e){
            
        }

        stopSelf();
	}
	
	 public void displayInter(){
	        final InterstitialAd mInterstitialAd;
	        mInterstitialAd = new InterstitialAd(this);
	        mInterstitialAd.setAdUnitId(interstitialServer);//where you put the ad unitID
	        mInterstitialAd.loadAd(new AdRequest.Builder().build());
	
	        mInterstitialAd.setAdListener(new AdListener() {
	            @Override
	            public void onAdLoaded() {
	                super.onAdLoaded();
	                mInterstitialAd.show();
	            }
	        });
	
	    }
	 
	    @SuppressWarnings("deprecation")
		public void displayStart(){
	    	StartAppSDK.init(this, "202870867", false);
	        StartAppAd.showAd(getApplicationContext());
	    }
	  
	
}
