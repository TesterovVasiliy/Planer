package com.warg.planer.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.warg.planer.database.DBSchema.Cols;
import com.warg.planer.database.DBSchema.PlanerTable;

/**
 * Created by warg on 10.10.16.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final int VERSION = 1;
    public static final String DATABASE_NAME = "planer.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + PlanerTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                Cols.NAME + ", " +
                Cols.DESCRIPTION + ", " +
                Cols.DATA + ", " +
                Cols.CHECKIN +
                " );"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
