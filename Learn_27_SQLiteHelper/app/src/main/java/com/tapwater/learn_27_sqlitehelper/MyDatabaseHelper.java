package com.tapwater.learn_27_sqlitehelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Tapwater on 16-1-19.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public MyDatabaseHelper(Context context, String name)
    {
        super(context, name, null, VERSION);
    }

    public MyDatabaseHelper(Context context, String name, int version)
    {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        System.out.println("create database");
        sqLiteDatabase.execSQL("create table if not exists userTable(id int primary key not null, name text not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        System.out.println("onUpgrade method");

    }
}
