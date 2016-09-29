package com.example.mathias.weathersmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView custom_listView;
    private CustomAdapter adapter;
    private List<WeatherInfo> weatherModelList;

    //private TextView CurrentWeather;
    //private TextView TempTxt;
    //private TextView DescrTxt;
    //private TextView UpdateTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      // CurrentWeather = (TextView)findViewById(R.id.currentWeather);
        //TempTxt = (TextView)findViewById(R.id.tempTxt);
        //DescrTxt = (TextView)findViewById(R.id.descrTxt);
       // UpdateTxt = (TextView)findViewById(R.id.updateTxt);


        custom_listView = (ListView)findViewById(R.id.custom_listView);

        //Get
        weatherModelList = new ArrayList<>();

        //adding sample data to test list

        weatherModelList.add(new WeatherInfo(1,"Cloudy", 17,"25-09-2016"));
        weatherModelList.add(new WeatherInfo(2,"Cloudy", 17,"25-09-2016"));
        weatherModelList.add(new WeatherInfo(3,"Cloudy", 17,"25-09-2016"));
        weatherModelList.add(new WeatherInfo(4,"Cloudy", 17,"25-09-2016"));
        weatherModelList.add(new WeatherInfo(5,"Cloudy", 17,"25-09-2016"));

        adapter = new CustomAdapter(getApplicationContext(), weatherModelList);
        custom_listView.setAdapter(adapter);


    }


}

