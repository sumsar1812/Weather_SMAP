package com.example.mathias.weathersmap;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.database.sqlite.SQLiteDatabase;
import android.os.IBinder;
import android.os.ResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class WeatherView extends AppCompatActivity {
    private ListView custom_listView;
    private CustomAdapter adapter;
    private List<WeatherInfo> weatherModelList;
    private Intent serviceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter filter = new IntentFilter("com.example.broadcast");
        ServiceBroadCastReceiver receiver = new ServiceBroadCastReceiver();
        registerReceiver(receiver, filter);
        Log.d("Start", "StartSercice");
        serviceIntent = new Intent(WeatherView.this, WeatherService.class);
        startService(serviceIntent);
        updateView();

    }

    public void onRefresh(View view){
        Log.d("Action", "onRefreshbuttonclicked");
        //refresh button has been clicked
        updateView();
    };

    public class ServiceBroadCastReceiver extends BroadcastReceiver {
        public ServiceBroadCastReceiver(){

        }
        @Override
        public void onReceive(Context ctxt, Intent i) {
            Log.d("Action", "broadcastreceived");
            //New data has been save in the database
            updateView();

        }
    }

    ServiceConnection connAllWeatherInfo = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            //update or create listview here
            WeatherService.ServiceBinder service = (WeatherService.ServiceBinder) iBinder;
            weatherModelList = service.getService().getPastWeather();
            custom_listView = (ListView)findViewById(R.id.custom_listView);
            adapter = new CustomAdapter(getApplicationContext(), weatherModelList);
            custom_listView.setAdapter(adapter);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    ServiceConnection connCurrentWeatherInfo = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            //update current weather here
            WeatherService.ServiceBinder service = (WeatherService.ServiceBinder) iBinder;
            WeatherInfo weather = service.getService().getCurrentWeather();
            Log.d("dsf",weather.getDescription());
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };


    private void updateView(){
        Log.d("Action", "Update view");
        //Setting current weather
        bindService(serviceIntent, connCurrentWeatherInfo, BIND_AUTO_CREATE);
        // Past weather
        bindService(serviceIntent, connAllWeatherInfo, BIND_AUTO_CREATE);
    }
}
