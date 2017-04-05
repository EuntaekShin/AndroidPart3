package com.example.seekbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;
/*
onSeekBarChaedListener 필요
void onStartTarckingTouch(Seeekbar)도 정의 해줘야한다
//   OnstopTrackingTouch(Seekbark) 역시 정의
//   OnProgressChanged 역시정의필요
 */

public class MainActivity extends AppCompatActivity {

    Button progressButton;
    Button ResetButton;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar)findViewById(R.id.sb01);
        progressButton =(Button)findViewById(R.id.btn_progress);
        ResetButton = (Button)findViewById(R.id.btn_Reset);

        progressButton.setOnClickListener(listener);
        ResetButton.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_progress:
                    Toast.makeText(MainActivity.this,"Progress",Toast.LENGTH_SHORT).show();
                    seekBar.incrementProgressBy(10);
                    break;

                case R.id.btn_Reset:
                    Toast.makeText(MainActivity.this,"Reset",Toast.LENGTH_LONG).show();
                    seekBar.setProgress(0);
                    break;
            }

        }
    };
}
