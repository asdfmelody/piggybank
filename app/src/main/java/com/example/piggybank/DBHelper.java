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
        //희선 2020-12-24 테이블 생성
        String sql = "CREATE TABLE if not exists mytable11 (" //테이블 중복 생성문 방지
                + "category text,"
                + "year integer,"
                + "month integer,"
                + "day integer,"
                + "price integer);"; //희선 2020-12-26 amount 추가 (입력 안했을 시 다음 단계로 넘어가지 않음
                //primary key autoincrement,
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE if exists mytable";

        db.execSQL(sql);
        onCreate(db);
    }
}