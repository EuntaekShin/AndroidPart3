package com.example.toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button =(Button)findViewById(R.id.btn01);
    }

    public  void btn01Clicked (View v){

        //토스트에 shape를 설정한 뷰 정의
        LayoutInflater inflater = getLayoutInflater();
        View toastView = inflater.inflate(R.layout.toast_shape,(ViewGroup)findViewById(R.id.linear));

        //토스트에 보여질 메세지
        TextView textView = (TextView)toastView.findViewById(R.id.tv_shape);
        textView.setText("토스트 모양 바뀌었습니다!!");

        //토스트 생성하기
        Toast toast = new Toast(this);
        toast.setGravity(Gravity.CENTER,100,100);
        toast.setDuration(Toast.LENGTH_LONG);

        //토스트에 뷰를 설정한다
        toast.setView(toastView);
        toast.show();


    }


}
