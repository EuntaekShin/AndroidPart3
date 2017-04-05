package com.example.keyevent;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    public static  final  int ReQuest_code =101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.btn01);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getApplicationContext(),NewActivity.class);
                startActivityForResult(intent,ReQuest_code);
            }
        });
        button.setBackgroundColor(0x8800ff);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ReQuest_code){
            Toast.makeText(getApplicationContext(),"요청코드:" +resultCode,Toast.LENGTH_LONG).show();
        }
        if(resultCode == Activity.RESULT_OK){
            String name  = data.getExtras().getString("name");
            Toast.makeText(getApplicationContext(),"응답이름:" +name,Toast.LENGTH_LONG).show();
        }
    }
}
