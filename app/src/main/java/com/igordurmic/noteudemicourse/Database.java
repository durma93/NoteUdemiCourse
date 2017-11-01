package com.igordurmic.noteudemicourse;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Point;

import java.util.List;


public class Database extends SQLiteOpenHelper{

    private static final String POINT_TABLE= "POINTS";


    public Database(Context context) {
        super(context, "note.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = String.format("create table %s(ID INTEGER PRIMARY KEY, X INTEGER NOT NULL, Y INTEGER NOT NULL)",POINT_TABLE);

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void storePoints(List<Point> points){

        SQLiteDatabase db = getWritableDatabase();

        db.delete(POINT_TABLE,null,null);

        for (Point p:points
             ) {
            ContentValues values = new ContentValues();

           // values.put();
        }
        db.close();

    }
}
