package com.example.scott.ohemem;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Scott on 2/27/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = String.valueOf(R.string.database_name);
    public static final String TABLE_NAME = String.valueOf(R.string.table_name);
    public static final String UID = String.valueOf(R.string.UID);
    public static final String NAME = String.valueOf(R.string.clm_name);
    public static final String DESCRIPTION = String.valueOf(R.string.clm_description);
    public static final String CATEGORY = String.valueOf(R.string.clm_category);
    public static final String VIDURL = String.valueOf(R.string.clm_vid);
    public static final String PICURL = String.valueOf(R.string.clm_pic);

    private static final String CREATE_TABLE =
            "CREATE TABLE "+TABLE_NAME+" ("
            +UID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
            +NAME+" VARCHAR(100), "
            +DESCRIPTION+" VARCHAR(1000), "
            +CATEGORY+" VARCHAR(20), "
            +VIDURL+" VARCHAR(200), "
            +PICURL+" VARCHAR(200));";

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_TABLE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
