package com.example.mathias.weathersmap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
        String executeStatement = "CREATE TABLE " + TABLE + "(" + PRIM_KEY + "INTEGER PRIMARY KEY," + KEY_INFO_KEY + " TEXT," + KEY_TEMP + " REAL," + KEY_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP" + ")";
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
        values.put(PRIM_KEY,i.id);
        values.put(KEY_INFO_KEY,i.description);
        values.put(KEY_TEMP,i.temp);
    }
    public List<WeatherInfo> getAllWeatherData()
    {
        List<WeatherInfo> weahterInfoList = new ArrayList<WeatherInfo>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE;
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                WeatherInfo weather = new WeatherInfo();
                weather.id = Integer.parseInt(cursor.getString(0));
                weather.description = cursor.getString(1);
                weather.temp = Double.parseDouble(cursor.getString(2));
                weahterInfoList.add(weather);
            } while (cursor.moveToNext());
        }
        return weahterInfoList;
    }
}