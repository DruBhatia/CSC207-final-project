package com.example.final_game;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "GAME.db";
    public static final String TABLE1_NAME = "GAME1STATS";
    public static final String TABLE2_NAME = "GAME2STATS";
    public static final String TABLE3_NAME = "GAME3STATS";

    public static final String ID1 = "ID";
    public static final String NAME = "NAME";

    public static final String TABLE1_STAT1 = "TABLE1_STAT1";
    public static final String TABLE1_STAT2 = "TABLE1_STAT2";
    public static final String TABLE1_STAT3 = "TABLE1_STAT3";

    public static final String TABLE2_STAT1 = "TABLE2_STAT1";
    public static final String TABLE2_STAT2 = "TABLE2_STAT2";
    public static final String TABLE2_STAT3 = "TABLE2_STAT3";

    public static final String TABLE3_STAT1 = "TABLE3_STAT1";
    public static final String TABLE3_STAT2 = "TABLE3_STAT2";
    public static final String TABLE3_STAT3 = "TABLE3_STAT3";


    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //even spacing matters in SqlLite queries
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE1_NAME + " (ID1 INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME TEXT, TABLE1_STAT1 TEXT, TABLE1_STAT2 TEXT, TABLE1_STAT3 TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE2_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME TEXT, TABLE2_STAT1 TEXT, TABLE2_STAT2 TEXT, TABLE2_STAT3 TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE3_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME TEXT, TABLE3_STAT1 TEXT, TABLE3_STAT2 TEXT, TABLE3_STAT3 TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE  IF EXISTS "+ TABLE1_NAME);
        sqLiteDatabase.execSQL("DROP TABLE  IF EXISTS "+ TABLE2_NAME);
        sqLiteDatabase.execSQL("DROP TABLE  IF EXISTS "+ TABLE3_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String table, String stat1, String stat2,String stat3){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        if (table.equals(TABLE1_NAME)) {
            contentValues.put(TABLE1_STAT1, stat1);
            contentValues.put(TABLE1_STAT2, stat2);
            contentValues.put(TABLE1_STAT3, stat3);
            long value = db.insert(TABLE1_NAME, null, contentValues);
            return value != - 1;
        } else if (table.equals(TABLE2_NAME)) {
            contentValues.put(TABLE2_STAT1, stat1);
            contentValues.put(TABLE2_STAT2, stat2);
            contentValues.put(TABLE2_STAT3, stat3);
            long value = db.insert(TABLE2_NAME, null, contentValues);
            return value != - 1;
        } else if (table.equals(TABLE3_NAME)) {
            contentValues.put(TABLE3_STAT1, stat1);
            contentValues.put(TABLE3_STAT2, stat2);
            contentValues.put(TABLE3_STAT3, stat3);
            long value = db.insert(TABLE3_NAME, null, contentValues);
            return value != - 1;
        } else return false;
    }
}
