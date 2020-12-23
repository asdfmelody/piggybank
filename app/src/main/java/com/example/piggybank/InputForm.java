package com.example.piggybank;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Date;


public class InputForm{

    private Context context;

    // 세림 2020-12-22 스피너에 표시하기 위한 목록
    String[] categorylist = {"쇼핑", "운동", "생활품", "음식"};

    public InputForm(Context context) {
        this.context = context;
    }

    // 세림 2020-12-22 호출할 다이얼로그 함수를 정의

    public void callFunction(){

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

                // db 넣기


                // 세림 2020-12-22 커스텀 다이얼로그 종료
                dlg.dismiss();
            }
        });

    }

}
