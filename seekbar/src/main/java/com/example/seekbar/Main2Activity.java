package com.example.seekbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import static android.R.attr.value;

public class Main2Activity extends AppCompatActivity {

    View seekView;
    SeekBar seekBar;
    TextView textView;
    int brightness = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        seekView=findViewById(R.id.seekview);
        textView =(TextView)findViewById(R.id.tvt01);
        seekBar = (SeekBar)findViewById(R.id.seekBar01);

        Button showBtn = (Button)findViewById(R.id.btnshow);

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSeekBar();

            }
        });

        //시크바에 리스너를 설정하기
        seekBar.setOnSeekBarChangeListener(new MyListener());
    }


    //시크바 뷰그룹을 보이도록 한다
    public void showSeekBar(){
        seekBar.setProgress(brightness);
        seekView.setVisibility(View.VISIBLE);

    }


    //시크바를 감추는 메서드
    private void hideSeekBar1(){
        seekView.setVisibility(View.GONE);
    }

    //밝기를 조절하는 메서드
    private void setBrightness(int value){
        if(value <10){
            value = 10;
        }else if(value >100){
            value = 100;
        }
        brightness = value;

        //밝기를 조절하기 위해선 윈도우 매니저가 필요하다(getWindow메서드를 이용해서 알아온다
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.screenBrightness = (float)value/100;
        getWindow().setAttributes(params);
    }



    class MyListener implements SeekBar.OnSeekBarChangeListener {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            setBrightness(progress);
            textView.setText("현재 밝기 상태 :" + progress);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            hideSeekBar1();

        }
    }
}
