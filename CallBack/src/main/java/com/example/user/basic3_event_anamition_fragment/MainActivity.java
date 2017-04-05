package com.example.user.basic3_event_anamition_fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CustomView customView = new CustomView(this);

        setContentView(customView);


    }
}
