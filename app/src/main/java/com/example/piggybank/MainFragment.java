package com.example.piggybank;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {

    private View view;

    ImageView pigimage;
    ImageView thirty;
    ImageView fifty;
    ImageView seventy;
    ImageView hundred;

    int pretotal=0; //저번달 데이터값
    int thistotal=0; //이번달 데이터값

    //데이터 값 DB



    int percentage = ((thistotal-pretotal)/pretotal)*100;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_main, container, false);


        // 세림 2020-12-22 res/drawble 폴더에 있는 이미지로 세팅하기
        pigimage = (ImageView) view.findViewById(R.id.pig);
        
        //정애 2020-12-24 percent 이미지 세팅
        thirty = view.findViewById(R.id.thirtyview);
        fifty = view.findViewById(R.id.fiftyview);
        seventy = view.findViewById(R.id.seventyview);
        hundred = view.findViewById(R.id.hundredview);

        
        pigimage.setImageResource(R.drawable.pig);
        pigimage.setOnClickListener(new MyListener());
        
        
        
        if(30 <= percentage || percentage < 50) {
            thirty.setVisibility(view.VISIBLE);
            fifty.setVisibility(view.INVISIBLE);
            seventy.setVisibility(view.INVISIBLE);
            hundred.setVisibility(view.INVISIBLE);

        }

        else if(50 <= percentage || percentage < 70){
            thirty.setVisibility(view.INVISIBLE);
            fifty.setVisibility(view.VISIBLE);
            seventy.setVisibility(view.INVISIBLE);
            hundred.setVisibility(view.INVISIBLE);
        }

        else if(70<= percentage || percentage <100){
            thirty.setVisibility(view.INVISIBLE);
            fifty.setVisibility(view.INVISIBLE);
            seventy.setVisibility(view.VISIBLE);
            hundred.setVisibility(view.INVISIBLE);
        }

        else if (percentage == 100){
            thirty.setVisibility(view.INVISIBLE);
            fifty.setVisibility(view.INVISIBLE);
            seventy.setVisibility(view.INVISIBLE);
            hundred.setVisibility(view.VISIBLE);
        }

        
        
        

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
