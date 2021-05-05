package com.example.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

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

    static final String SQL_DELETE_TABLE_STUDENT =
            // "DROP TABLE IF EXISTS mountain"
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    //Constructor added
    DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_STUDENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_TABLE_STUDENT);
        onCreate(db);
    }

    //adding student data
    void addStudent(Student Student) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NAME_AGE, Student.getAge());
        values.put(DatabaseHelper.COLUMN_NAME_NAME, Student.getName());
        values.put(DatabaseHelper.COLUMN_NAME_PROGRAM, Student.getProgram());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(DatabaseHelper.TABLE_NAME, null, values);
    }

    public List<Student> getStudentsList(){
        String sql = "SELECT * FROM" + TABLE_NAME;
        sqLiteDatabase = this.getReadableDatabase();
        List<Student> laddaStudent = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        if (cursor.moveToFirst()){
            do {
                String age = cursor.getString(0);
                String name = cursor.getString(1);
                String program = cursor.getString(2);
                laddaStudent.add(new Student(age,name,program));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return laddaStudent;
    }

}
