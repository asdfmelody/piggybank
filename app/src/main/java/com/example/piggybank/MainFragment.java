package com.example.piggybank;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;

public class MainFragment extends Fragment {


     View view;

    ImageView pigimage;
    TextView output;
    TextView percentoutput;
  
   ImageView thirty;
    ImageView fifty;
    ImageView seventy;
    ImageView hundred;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_main, container, false);

        //희선 2020-12-26 db 변수 선언: SQLite 데이터 InputForm -> MainFragment로 전달하기 위해
        DBHelper helper= new DBHelper(getContext(), "adddb.db", null, 1);
        final SQLiteDatabase db = helper.getWritableDatabase();


        // 세림 2020-12-22 res/drawble 폴더에 있는 이미지로 세팅하기
        pigimage = (ImageView) view.findViewById(R.id.pig);

        int percentage;


        //희선 2020-12-26
        //Select 쿼리 이용
        //변수를 통해 데이터 조작시 참고 :  https://m.blog.naver.com/PostView.nhn?blogId=qbxlvnf11&logNo=221406135285&proxyReferer=https:%2F%2Fwww.google.com%2F
/*<<<<<<< HEAD
        Cursor c = db.query("mytable11",null,null,null,null,null,null,null);
=======*/
        //세림 2020-12-26 출력시 현재 달 총 금액 출력 - strftime
        Cursor cthistotal = db.query("mytable11",null,"month=(strftime('%m', 'now')-1)",null,null,null,null,null);


        String Result = "output"; //쿼리에 맞게 누적된 정보 저장
        double thistotal = 0;

        //희선 2020-12-24 쿼리문 실행
        while(cthistotal.moveToNext()) {
            thistotal+=cthistotal.getInt(cthistotal.getColumnIndex("price"));
        }


        output = (TextView) view. findViewById(R.id.output);
        output.setText("이번 달은 " + (int)thistotal + "원을 썼어요!");

        //세림 2020-12-27 지난 달과 이번 달 비교
        Cursor cpretotal = db.query("mytable11",null,"month=(strftime('%m', 'now')-2)",null,null,null,null,null);

        double pretotal = 0;   // 저번달 사용한 값

        while(cpretotal.moveToNext()) {
            pretotal+=cpretotal.getInt(cpretotal.getColumnIndex("price"));
        }

        Log.d("dsf-this", String.valueOf(thistotal));
        Log.d("dsf-last", String.valueOf(pretotal));

        //세림 2020-12-27 정수/정수 -> 0 으로 결과값이 나와 thistotal과 pretotal, division의 변수형을 double로 변경하였음.
        double division = thistotal/pretotal -1;
        percentage = (int) (division * 100);
        Log.d("dsf-percentage", String.valueOf(percentage));



        //정애 2020-12-24 percent 이미지 세팅
        thirty = view.findViewById(R.id.thirtyview);
        fifty = view.findViewById(R.id.fiftyview);
        seventy = view.findViewById(R.id.seventyview);
        hundred = view.findViewById(R.id.hundredview);


        pigimage.setImageResource(R.drawable.pig);
        pigimage.setOnClickListener(new MyListener());


        if(30 <= percentage && percentage < 50) {
            thirty.setVisibility(view.VISIBLE);
            fifty.setVisibility(view.INVISIBLE);
            seventy.setVisibility(view.INVISIBLE);
            hundred.setVisibility(view.INVISIBLE);

        }

        else if(50 <= percentage && percentage < 70){
            thirty.setVisibility(view.INVISIBLE);
            fifty.setVisibility(view.VISIBLE);
            seventy.setVisibility(view.INVISIBLE);
            hundred.setVisibility(view.INVISIBLE);
        }

        else if(70<= percentage && percentage <100){
            thirty.setVisibility(view.INVISIBLE);
            fifty.setVisibility(view.INVISIBLE);
            seventy.setVisibility(view.VISIBLE);
            hundred.setVisibility(view.INVISIBLE);
        }

        else if (percentage >= 100){
            thirty.setVisibility(view.INVISIBLE);
            fifty.setVisibility(view.INVISIBLE);
            seventy.setVisibility(view.INVISIBLE);
            hundred.setVisibility(view.VISIBLE);
        }

        percentoutput = (TextView) view. findViewById(R.id.percentview);
        percentoutput.setText("지난달보다 "+percentage + "% 많이 썼어요 😥");


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
