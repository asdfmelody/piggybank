package com.example.piggybank;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


public class CategoryFragment extends Fragment {

    ArrayList<PiggybankData> list = new ArrayList<>();
    ArrayList<PiggybankData> listcates = new ArrayList<>();

    ArrayList<Integer> listsum = new ArrayList<>();
    ArrayList<String> listcate = new ArrayList<>();
    List<HashMap> listsums;
    HashMap<String,Integer> ny;
    int sum[]=new int[4];
    View view;

    int sum1,sum2,sum3,sum4=0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_category, container, false);

/*
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);

        for (int i=0; i < 5; i++){
            list.add(new PiggybankData("옷",i*1000));
        }

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new RecyclerAdapter(list));*/
        DBHelper helper = new DBHelper(getContext(), "adddb.db", null, 1);
        final SQLiteDatabase db = helper.getWritableDatabase();
        Cursor c = db.query("mytable11", null, null, null, null, null, null, null);

        String Result = "output"; //쿼리에 맞게 누적된 정보 저장

        //희선 2020-12-24 쿼리문 실행
        while (c.moveToNext()) {
            String cat = c.getString(c.getColumnIndex("category"));
            int y = c.getInt(c.getColumnIndex("year"));
            int m = c.getInt(c.getColumnIndex("month"));
            int d = c.getInt(c.getColumnIndex("day"));
            int p = c.getInt(c.getColumnIndex("price"));
            //String amount 가 필요!
            if (cat.equals("쇼핑")) {
                sum1 += p;
            } else if (cat.equals("운동")) {
                sum2 += p;
            } else if (cat.equals("생활품")) {
                sum3 += p;
            } else if (cat.equals("음식")) {
                sum4 += p;
            }

            list.add(new PiggybankData(cat, p, String.valueOf(d)));
            //Result = "";
            // Result += cat + "," + y + "," + m + "," + d+","+p;
        }
        listcates.add(new PiggybankData("쇼핑",sum1, ""));
        listcates.add(new PiggybankData("운동",sum2, ""));
        listcates.add(new PiggybankData("생활품",sum3, ""));
        listcates.add(new PiggybankData("음식",sum4, ""));


    /*    list.add(new PiggybankData("옷","1000"));
        list.add(new PiggybankData("옷","1000"));
        list.add(new PiggybankData("옷","1000"));*/

        RecyclerAdapter adapter = new RecyclerAdapter(listcates);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();

    }
}