package com.example.progressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar_horizontal;
    ProgressBar progressBar_spinner;

    Button btnProgress;
    Button btnReset;
    Button btnShow;
    Button btnhide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar_horizontal = (ProgressBar)findViewById(R.id.pb01);
        progressBar_spinner = (ProgressBar)findViewById(R.id.pb02);

        btnProgress =(Button)findViewById(R.id.btn_progress);
        btnReset =(Button)findViewById(R.id.btn_reset);
        btnShow =(Button)findViewById(R.id.btn_show);
        btnhide =(Button)findViewById(R.id.btn_hide);

        btnProgress.setOnClickListener(listener);
        btnReset.setOnClickListener(listener);
        btnShow.setOnClickListener(listener);
        btnhide.setOnClickListener(listener);

    }
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){

                case R.id.btn_progress:

                    Toast.makeText(getBaseContext(),"Progress",Toast.LENGTH_SHORT).show();
                    progressBar_horizontal.incrementProgressBy(5);
                    progressBar_horizontal.incrementSecondaryProgressBy(10);

                    break;

                case R.id.btn_reset:

                    Toast.makeText(getBaseContext(),"Reset",Toast.LENGTH_SHORT).show();
                    progressBar_horizontal.setProgress(0);
                    progressBar_horizontal.setProgress(0);

                    break;

                case R.id.btn_show :

                    Toast.makeText(getApplicationContext(),"Show",Toast.LENGTH_SHORT).show();
                    progressBar_spinner.setVisibility(ProgressBar.VISIBLE);
                    break;

                case R.id.btn_hide:
                    Toast.makeText(getApplicationContext(),"Hide",Toast.LENGTH_SHORT).show();
                    progressBar_spinner.setVisibility(ProgressBar.INVISIBLE);
                    break;

            }

        }
    };
}
