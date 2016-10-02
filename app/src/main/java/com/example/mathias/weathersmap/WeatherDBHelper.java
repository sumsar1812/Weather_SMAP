package com.example.mathias.weathersmap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rasmus on 27-09-2016.
 */
public class WeatherDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Weather.db";
    private static final String TABLE = "WeatherInfo";

    private static final String PRIM_KEY = "id";
    private static final String KEY_INFO_KEY = "weather_info";
    private static final String KEY_TEMP = "temp";
    private static final String KEY_TIMESTAMP = "timestamp";
    public WeatherDBHelper(Context context)
    {
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String executeStatement = "CREATE TABLE " + TABLE + "(" + PRIM_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_INFO_KEY + " TEXT," + KEY_TEMP + " REAL," + KEY_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP" + ")";
        db.execSQL(executeStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);
    }

    public void addWeather(WeatherInfo i)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PRIM_KEY,i.getID());
        values.put(KEY_INFO_KEY,i.getDescription());
        values.put(KEY_TEMP,i.getTemperature());
        db.insert(TABLE,null,values);
    }
    public WeatherInfo getCurrentWeather()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE + " WHERE id = (SELECT MAX(id)  FROM " + TABLE + ")";
        //String[] queryOn = {PRIM_KEY,KEY_INFO_KEY,KEY_TEMP,KEY_TIMESTAMP};
        //Cursor cursor = db.query(TABLE,queryOn,PRIM_KEY + "=",new String[]{"MAX(id)"},null,null,null);
        Cursor cursor = db.rawQuery(selectQuery,null);
        WeatherInfo weather = new WeatherInfo();
        if(cursor.getCount() >0 &&cursor.moveToFirst()) {
            weather.setID(cursor.getInt(0));
            weather.setDescription(cursor.getString(1));
            weather.setTemperature(cursor.getDouble(2));
            weather.setDate(Timestamp.valueOf(cursor.getString(3)));
            return weather;
        }
        return null;
    }
    public List<WeatherInfo> getAllWeatherData()
    {
        List<WeatherInfo> weahterInfoList = new ArrayList<WeatherInfo>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE;
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.getCount() >0 && cursor.moveToFirst()) {
            do {
                WeatherInfo weather = new WeatherInfo();
                weather.setID(cursor.getInt(0));
                weather.setDescription(cursor.getString(1));
                weather.setTemperature(cursor.getDouble(2));
                weather.setDate(Timestamp.valueOf(cursor.getString(3)));
                weahterInfoList.add(weather);
            } while (cursor.moveToNext());
        }
        return weahterInfoList;
    }
}
