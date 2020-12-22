package com.example.piggybank;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class InputForm {

    private Context context;

    public InputForm(Context context) {
        this.context = context;
    }

    // 호출할 다이얼로그 함수를 정의한다
    public void callFunction(){

        // 커스텀 다이얼로그를 정의하기 위해 Dialog 클래스 생성
        final Dialog dlg = new Dialog(context);

        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // 커스텀 다이얼로그의 레이아웃 설정
        dlg.setContentView(R.layout.inputform);

        // 커스텀 다이얼로그 노출
        dlg.show();

        // 커스텀 다이얼로그의 각 위젯 정의
        final Spinner category = (Spinner) dlg.findViewById(R.id.category);
        final Button datepicker = (Button) dlg.findViewById(R.id.datepicker);
        final EditText totalprice = (EditText) dlg.findViewById(R.id.totalprice);
        final Button submit = (Button) dlg.findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener(){
            // 입력 버튼 클릭시
            @Override
            public void onClick(View v) {

                // db 넣기


                //커스텀 다이얼로그 종료
                dlg.dismiss();
            }
        });

    }

}
