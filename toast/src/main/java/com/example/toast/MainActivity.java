package com.example.toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
/*
textview의 shape를 이용해서 토스트 모양을 바꿀수 있다

bacckgroud에 셀렉터에 적용했었다



 */

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 =(EditText)findViewById(R.id.et_x);
        editText2 =(EditText)findViewById(R.id.et_y);

    }

    public void btnClicked (View view){

        try {

            Toast toast = Toast.makeText(getApplicationContext(), "토스트위치설정", Toast.LENGTH_LONG);

            int xLoc = Integer.parseInt(editText1.getText().toString());
            int xLoy = Integer.parseInt(editText2.getText().toString());

            //위치 지정 하기 (setGravity이용)
            toast.setGravity(Gravity.CENTER, xLoc, xLoy);

            toast.show();
        }catch (NumberFormatException e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

}
