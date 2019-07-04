package com.example.hideadsqb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;

public class getData extends AsyncTask<Void,Void,Void> {

	 String data ="";
	    String dataParsed = "";
	    String singleParsed ="";


	    String interstitialServer = "";

	
	@Override
	protected Void doInBackground(Void... params) {
		// TODO Auto-generated method stub
		 try {
	            URL url = new URL("https://drive.google.com/uc?id=1zjaTOk08K4knstX0axSrQLvzoyz7E9ZU");
	            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
	            InputStream inputStream = httpURLConnection.getInputStream();
	            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
	            String line = "";
	            while(line != null){
	                line = bufferedReader.readLine();
	                data = data + line;
	            }

	            JSONObject jsonRoot  = new JSONObject(data);

	            interstitialServer = jsonRoot.getString("interstitial");


	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (JSONException e) {
	            e.printStackTrace();
	        }
		return null;
	}

	
	@Override
	protected void onPostExecute(Void result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		ServiceShowI3lan.interstitialServer = this.interstitialServer ;
	}
}
