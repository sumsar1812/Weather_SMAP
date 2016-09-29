package com.example.mathias.weathersmap;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.TextView;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by solveigdoan on 27/09/16.
 */
public class CustomAdapter extends BaseAdapter {



    private Context mContext;
    private List<WeatherInfo> mWeatherModelList;

    public CustomAdapter(Context mContext, List<WeatherInfo> mWeatherModelList) {
        this.mContext = mContext;
        this.mWeatherModelList = mWeatherModelList;
    }

    @Override
    public int getCount() {
        return mWeatherModelList.size(); //number of elements in list
    }

    @Override
    public Object getItem(int position) {
        return mWeatherModelList;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View view = convertView ;  //convertView = null;
//if (view == null){
        if (convertView == null) {

            LayoutInflater mInflater = (LayoutInflater) mContext
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.list_layout, null);




            TextView Description = (TextView) convertView.findViewById(R.id.listDescrTxt);
            TextView Temperature = (TextView) convertView.findViewById(R.id.listTempTxt);
            TextView CurrentDate = (TextView) convertView.findViewById(R.id.listDateTxt);
            //TextView timestamp_ = (TextView) convertView.findViewById(R.id.listDateTxt);
            //TextView Time = (TextView) convertView.findViewById(R.id.listTimeTxt);

            // set text for textviews

            Description.setText(mWeatherModelList.get(position).getDescription());
            Temperature.setText(String.valueOf(mWeatherModelList.get(position).getTemperature()) + "°C");
            CurrentDate.setText(String.valueOf(mWeatherModelList.get(position).getCurrentDate()));
            //timestamp_.setText(String.valueOf(mWeatherModelList.get(position).getTimestamp_()));
            //Date.setText(String.valueOf(mWeatherModelList.get(position).getDate()));
            //Time.setText(String.valueOf(mWeatherModelList.get(position).getTime()));

            //save weatherId to tag

            convertView.setTag(mWeatherModelList.get(position).getID());

        }
        return convertView;
    }
}







