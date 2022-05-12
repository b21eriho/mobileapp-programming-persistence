package com.example.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;



public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "dvsug_rules.db";
    private static final int DATABASE_VERSION = 1;
    public static final String COLLUMN_NAME = "name";
    public static final String TABLE_BIKE = "bike";
    public static final String COLLUMN_ID = "_id";
    public static final String COLLUMN_BRAND = "brand";
    public static final String COLLUMN_NR_WHEELS = "nrWheels";

    public DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_BIKE + " (" + COLLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLLUMN_NAME + " TEXT, " + COLLUMN_BRAND + " TEXT, " + COLLUMN_NR_WHEELS + " TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}