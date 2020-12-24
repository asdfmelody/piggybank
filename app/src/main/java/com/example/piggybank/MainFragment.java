package com.example.piggybank;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainFragment extends Fragment {


     View view;

    ImageView pigimage;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_main, container, false);


        // 세림 2020-12-22 res/drawble 폴더에 있는 이미지로 세팅하기
        pigimage = (ImageView) view.findViewById(R.id.pig);
        pigimage.setImageResource(R.drawable.pig);
        pigimage.setOnClickListener(new MyListener());

        return view;
    }



        // 세림 2020-12-22 돼지 아이콘 클릭시 커스텀다이얼로그 표시
    class MyListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            InputForm inputform = new InputForm(getActivity());
            inputform.callFunction();

        }
    }

}
