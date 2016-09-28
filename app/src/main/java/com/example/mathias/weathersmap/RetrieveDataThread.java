package com.example.mathias.weathersmap;

import android.content.Intent;
import android.util.Log;


class RetrieveDataThread implements Runnable {
    private NetworkHandler networkHandler;
    private Intent intent;
    RetrieveDataThread(){
        this.intent = new Intent("RetrieveDataThread");
        networkHandler = new NetworkHandler();
    }
    public void run() {
        while(true) {
            
            Log.d("hej", "Do database stuff");
            //
            try {
                Log.d("hej", "Wait for 30 min");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


}
