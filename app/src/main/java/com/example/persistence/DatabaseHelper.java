package com.example.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1; // If this is incremented onUpgrade() will be executed
    private static final String DATABASE_NAME = "Student_database"; // The file name of our database
    //Table name
    private static final String TABLE_NAME = "STUDENT";
    //Table columns
    static final String COLUMN_NAME_AGE = "age";
    static final String COLUMN_NAME_NAME = "name";
    static final String COLUMN_NAME_PROGRAM = "program";
    private SQLiteDatabase sqLiteDatabase;

    static final String SQL_CREATE_TABLE_STUDENT=
            // "CREATE TABLE mountain (id INTEGER PRIMARY KEY, name TEXT, height INT)"
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_NAME_AGE + " INTEGER PRIMARY KEY," +
                    COLUMN_NAME_NAME + " TEXT," +
                    COLUMN_NAME_PROGRAM + " INT)";

    static final String SQL_DELETE_TABLE_MOUNTAIN =
            // "DROP TABLE IF EXISTS mountain"
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    //Constructor added
    DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
