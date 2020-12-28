package com.example.piggybank;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CompareFragment extends Fragment {

    View view;

    TextView comparetotal; // 아낀 금액 텍스트뷰
    TextView presentview; // 선물내역
    ImageView choiceview; //선물 이미지뷰

    int checkmoney=0;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        DBHelper helper= new DBHelper(getContext(), "adddb.db", null, 1);
        final SQLiteDatabase db = helper.getWritableDatabase();

        //세림 2020-12-27 비교비용을 계산하기위함 - bundle로 수정하면 더 좋을 듯
        Cursor cthistotal = db.query("mytable11",null,"month=(strftime('%m', 'now')-1)",null,null,null,null,null);
        int thistotal = 0;
        while(cthistotal.moveToNext()) {
            thistotal+=cthistotal.getInt(cthistotal.getColumnIndex("price"));
        }

        Cursor cpretotal = db.query("mytable11",null,"month=(strftime('%m', 'now')-2)",null,null,null,null,null);
        int pretotal = 0;   // 저번달 사용한 값
        while(cpretotal.moveToNext()) {
            pretotal+=cpretotal.getInt(cpretotal.getColumnIndex("price"));
        }

        checkmoney = pretotal - thistotal;

        //세림 2020-12-27 지난달-이번달 검사용
        Log.d("pre-this", String.valueOf(checkmoney));


        //정애
        view = inflater.inflate(R.layout.fragment_compare, container, false);

        comparetotal = (TextView)view.findViewById(R.id.comparemoney);
        presentview = (TextView)view.findViewById(R.id.presentview);
        choiceview = (ImageView)view.findViewById(R.id.movie);

       int[] imageArray = {R.drawable.beggar, R.drawable.movie, R.drawable.chicken, R.drawable.cake, R.drawable.cloth, R.drawable.shoes};


        comparetotal.setText( Integer.toString(checkmoney) + "원");

        if(checkmoney <10000){
            choiceview.setImageResource(imageArray[0]);

        }

        if(checkmoney < 20000 && checkmoney >= 10000){
            choiceview.setImageResource(imageArray[1]);
            presentview.setText("영화티켓");

        }

        else if (checkmoney >= 20000 && checkmoney < 30000){
            choiceview.setImageResource(imageArray[2]);
            presentview.setText("치킨 한마리");

        }//20000 치킨 한마리

        else if (checkmoney >= 30000 && checkmoney < 50000){
            choiceview.setImageResource(imageArray[3]);
            presentview.setText("케이크");

        }// 30000 케이크

        else if (checkmoney >= 50000 && checkmoney < 100000){
            choiceview.setImageResource(imageArray[4]);
            presentview.setText("후드티");

        }// 50000 후드티

        else if (checkmoney >= 10000){
            choiceview.setImageResource(imageArray[5]);
            presentview.setText("신발");

        }//100000 신발


        return view;
    }



}

