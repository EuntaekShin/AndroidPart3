package com.example.eventlistner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textview;
    ImageView imageView;
    Button button;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview = (TextView)findViewById(R.id.tv01);
        imageView = (ImageView)findViewById(R.id.iv01);
        button = (Button)findViewById(R.id.btn01);
        editText = (EditText)findViewById(R.id.et01);

        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"텍스트뷰 클릭되었습니다!!",Toast.LENGTH_LONG).show();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String name = editText.getText().toString();
                Toast.makeText(getApplicationContext(),"버튼이 눌려 이름이 뜹니다",Toast.LENGTH_LONG).show();
            }
        });
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Toast.makeText(getApplicationContext(),"이미지뷰 클릭되었습니다!!",Toast.LENGTH_LONG).show();

                return true;
            }
        });
        editText.addTextChangedListener(new TextWatcher() {
            //텍스트의 길이가 변경되었을 경우 발생할 이벤트를 작성
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Toast.makeText(getApplicationContext(),"텍스트의 길이가 변경 되었다 이놈아"+s.toString(),Toast.LENGTH_LONG).show();

            }

            //텍스트가 변경될때 마다 발생할 이벤트를 작성
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Toast.makeText(getApplicationContext(),"온텍스트 체인지 이벤트 발생!!"+s.toString(),Toast.LENGTH_LONG).show();

            }

            //텍스트 변경 후 발생할 이벤트를 작성
            @Override
            public void afterTextChanged(Editable s) {
                Toast.makeText(getApplicationContext(),"텍스트 변경되었다 이놈아"+s.toString(),Toast.LENGTH_LONG).show();

            }
        });

    }
}
