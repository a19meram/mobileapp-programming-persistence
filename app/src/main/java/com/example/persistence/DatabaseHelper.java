package com.example.persistence;

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

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
