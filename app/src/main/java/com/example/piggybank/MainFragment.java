package com.example.piggybank;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {

    private View view;

    ImageView pigimage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_main, container, false);

        pigimage = (ImageView) view.findViewById(R.id.pig);

        // res/drawble 폴더에 있는 이미지로 세팅하기
        pigimage.setImageResource(R.drawable.pig);

        pigimage.setOnClickListener(new MyListener());


        return view;
    }

    class MyListener implements View.OnClickListener{


        @Override
        public void onClick(View v) {

            InputForm inputform = new InputForm(getActivity());

            inputform.callFunction();

        }
    }
}
