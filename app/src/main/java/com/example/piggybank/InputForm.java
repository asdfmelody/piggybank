package com.example.piggybank;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Date;


public class InputForm {

    private Context context;

    //희선 2020-12-24 SQLite 기본 설정
    DBHelper helper;
    public static final String EEG_DB= "EEG_DB";
    public static final String EEG_TABLE="EEG";
    public static SQLiteDatabase eegDB = null;

    // 세림 2020-12-22 스피너에 표시하기 위한 목록
    String[] categorylist = {"쇼핑", "운동", "생활품", "음식"};


    public InputForm(Context context) {
        this.context = context;
        //희선 2020-12-24 생성자에 DBHelper 객체 생성
        helper= new DBHelper(context, "adddb.db", null, 1);
    }

    // 세림 2020-12-22 호출할 다이얼로그 함수를 정의

    public void callFunction(){

        //희선 2020-12-24 SQLite db설정
        final SQLiteDatabase db;
        db = helper.getWritableDatabase();
        helper.onCreate(db); //테이블 생성

        // 세림 2020-12-22 커스텀 다이얼로그를 정의하기 위해 Dialog 클래스 생성
        final Dialog dlg = new Dialog(context);
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 세림 2020-12-22 커스텀 다이얼로그의 레이아웃 설정
        dlg.setContentView(R.layout.inputform);
        // 세림 2020-12-22 커스텀 다이얼로그 노출
        dlg.show();

        // 세림 2020-12-22 커스텀 다이얼로그의 각 위젯 정의
        final Spinner category = (Spinner) dlg.findViewById(R.id.category);
        final DatePicker datepicker = (DatePicker) dlg.findViewById(R.id.datepicker); //희선 2020-12-24 DatePicker 완성
        final EditText totalprice = (EditText) dlg.findViewById(R.id.totalprice);
        final Button submit = (Button) dlg.findViewById(R.id.submit);


        // 세림 2020-12-22 스피너 구현
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
              context , android.R.layout.simple_spinner_item, categorylist);
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        category.setAdapter(adapter);


        submit.setOnClickListener(new View.OnClickListener(){
            // 입력 버튼 클릭시
            @Override
            public void onClick(View v) {

                //희선 2020-12-24 db 조작

                // 입력 받은 데이터 db에 전달할 변수로 저장
                final String dbcategory = category.getSelectedItem().toString();
                final int dbyear = datepicker.getYear();
                final int dbmonth = datepicker.getMonth();
                final int dbday = datepicker.getDayOfMonth();

                //insert 하기 전 values 에 저장할 데이터 넣기
                ContentValues values = new ContentValues();
                values.put("category",dbcategory);
                values.put("year",dbyear);
                values.put("month",dbmonth);
                values.put("day",dbday);

                //insert
                db.insert("mytable10",null,values);

                //쿼리 이용
                //변수를 통해 데이터 조작시 참고 :  https://m.blog.naver.com/PostView.nhn?blogId=qbxlvnf11&logNo=221406135285&proxyReferer=https:%2F%2Fwww.google.com%2F
                Cursor c = db.query("mytable10",null,"year=2016",null,null,null,null,null);

                String Result = ""; //쿼리에 맞게 누적된 정보 저장

                //희선 2020-12-24 쿼리문 실행
                while(c.moveToNext()) {
                    String cat = c.getString(c.getColumnIndex("category"));
                    int y = c.getInt(c.getColumnIndex("year"));
                    int m = c.getInt(c.getColumnIndex("month"));
                    int d = c.getInt(c.getColumnIndex("day"));
                    //String amount 가 필요!

                    Result += cat + "," + y + "," + m + "," + d;
                }

                totalprice.setText(Result);
                Log.d("asasdfasdf",Result);


                // 세림 2020-12-22 커스텀 다이얼로그 종료
                //dlg.dismiss();
            }
        });

    }

}
