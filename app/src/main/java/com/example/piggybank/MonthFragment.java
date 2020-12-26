package com.example.piggybank;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MonthFragment extends Fragment {

    ArrayList<PiggybankData> list2 = new ArrayList<>();
    ArrayList<PiggybankData> list2months = new ArrayList<>();

    int sum[]=new int[12];
    int sums=0;
    public MonthFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_month, container, false);



        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DBHelper helper= new DBHelper(getContext(), "adddb.db", null, 1);
        final SQLiteDatabase db = helper.getWritableDatabase();
        Cursor c = db.query("mytable11",null,null,null,null,null,null,null);

        String Result = "output"; //쿼리에 맞게 누적된 정보 저장
        for(int i=0;i<12;i++){
            sum[i]=0;
        }
        //희선 2020-12-24 쿼리문 실행
        while(c.moveToNext()) {
            String cat = c.getString(c.getColumnIndex("category"));
            int y = c.getInt(c.getColumnIndex("year"));
            int m = c.getInt(c.getColumnIndex("month"));
            int d = c.getInt(c.getColumnIndex("day"));
            int p = c.getInt(c.getColumnIndex("price"));
            //String amount 가 필요!

            if(m==1){
                sum[0]+=p;

            }
            else if(m==2){
                sum[1]+=p;

            }
            else if(m==3){
                sum[2]+=p;

            }
            else if(m==4){
                sum[3]+=p;

            }
            else if(m==5){
                sum[4]+=p;

            }
            else if(m==6){
                sum[5]+=p;

            }
            else if(m==7){
                sum[6]+=p;

            }
            else if(m==8){
                sum[7]+=p;

            }
            else if(m==9){
                sum[8]+=p;

            }
            else if(m==10){
                sum[9]+=p;

            }
            else if(m==11){
                sum[10]+=p;

            }
            else if(m==12){

            }
       

           // list2.add(new PiggybankData(cat,p,String.valueOf(d)));
            //Result = "";
            // Result += cat + "," + y + "," + m + "," + d+","+p;
        }


        for(int i=0;i<12;i++){

                    list2months.add(new PiggybankData("", sum[i], String.valueOf(i + 1)));

        }

/*

        list2.add(new PiggybankData("1월","2000"));
        list2.add(new PiggybankData("2월","2000"));
        list2.add(new PiggybankData("3월","2000"));
*/

        RecyclerAdapter2 adapter = new RecyclerAdapter2(list2months);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview2);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.setAdapter(adapter);
    }
}