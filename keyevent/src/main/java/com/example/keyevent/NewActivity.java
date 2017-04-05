package com.example.keyevent;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class NewActivity extends AppCompatActivity {

    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        backButton = (Button)findViewById(R.id.btn02);



        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                close();

            }
        });
    }
    //Back 키를 눌렀을때 엑티비티를 닫고 메인화면으로 이동
    //keycode -> 방향키 keycode_DPAD_LEFT,RIGHT
    //전화 keycode_CALL, keycode_ENDCALL
    //                          _HOME, _BACK_VOLUME_UP(DOWN)
    //                          _0~9 ,A~Z
    public boolean onKeyDown(int keycode, KeyEvent ke){
        if(keycode == ke.KEYCODE_BACK){
            close();
            return  true;

        }
        return false;

    }

    private  void close(){
        //응답 결과 값을 전달하기 위한 인텐트 생성
        Intent resultIntent = new Intent();
        resultIntent.putExtra("name","신은택");

        //응답값을 전달
        setResult(Activity.RESULT_OK, resultIntent);

        //엑티비디 닫기
        finish();
    }


}
