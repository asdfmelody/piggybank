package com.example.piggybank;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//희선 2020-12-24 SQLite 사용을 위한 DBHelper 클래스 생성

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE if not exists mytable10 (" //테이블 중복 생성문 방지
                + "category text,"
                + "year integer,"
                + "month integer,"
                + "day integer);";
                //amount 추가 해야함.
                //primary key autoincrement,
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE if exists mytable10";

        db.execSQL(sql);
        onCreate(db);
    }
}