package com.example.changedirection;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /*
    1. mainifest 파일 설정해야한다 (configChanged
    android:configChanges="orientation|screenSize|layoutDirection"
    2.바뀌면서 onconfigurationchangeed 메서드가 호출된다

     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //전체 화면보기
        final Window window = getWindow();

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    //화면전환할떄 저절로 불러와 지는 메서드

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        //가로방향으로 바뀌었을때
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(this,"가로방향 전환됨",Toast.LENGTH_SHORT).show();
            //세로방향으로 바뀌었을떄
        }else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this,"세로방향 전환됨",Toast.LENGTH_SHORT).show();
        }
    }
}
