package com.example.alertdialog_progress;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_alert;
    Button btn_custom;
    Button btn_progress;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_alert =(Button)findViewById(R.id.btn01);
        btn_custom =(Button)findViewById(R.id.btn02);
        btn_progress =(Button)findViewById(R.id.btn03);
        txt =(TextView)findViewById(R.id.tv01);

        //버튼을 한번에 등록
        btn_alert.setOnClickListener(listener);
        btn_custom.setOnClickListener(listener);
        btn_progress.setOnClickListener(listener);

    }

    View.OnClickListener listener = new View.OnClickListener(){
        public void onClick(View v){
            switch(v.getId()){
                case R.id.btn01:
                   alert();

                    break;

                case R.id.btn02:

                    custom();

                    break;
                case R.id.btn03:

                    progress();

                    break;
            }
        }
    };

    public void alert(){
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("2017 프로야구 우승후보")
                .setMessage("기아 타이거즈 입니다!!")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton("YES", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog , int which){
                        Toast.makeText(getApplicationContext(),"YES",Toast.LENGTH_LONG).show();
                        txt.setText("기아타이거즈");
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which){
                        Toast.makeText(getApplicationContext(),"OK",Toast.LENGTH_LONG).show();
                        txt.setText("다시 선택");
                    }
                }).show();
    }



    public void custom(){

        LinearLayout linearLayout = (LinearLayout)View.inflate(MainActivity.this,R.layout.custom, null);
        final EditText editText = (EditText)linearLayout.findViewById(R.id.et01);

        new AlertDialog.Builder(MainActivity.this)
                .setTitle("2016 프로야구 우승후보")
                .setView(linearLayout)
                .setPositiveButton("OK", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog , int which){
                        Toast.makeText(getApplicationContext(),"OK",Toast.LENGTH_SHORT).show();
                        String name =editText.getText().toString();
                        txt.setText(name);
                    }
                })
                .setNegativeButton("CANCLE", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which){
                        Toast.makeText(getApplicationContext(),"CANCLE",Toast.LENGTH_SHORT).show();

                    }
                }).show();
    }



    public void progress(){
        ProgressDialog  progressDialog=  new ProgressDialog(MainActivity.this);
        progressDialog.setProgressStyle(progressDialog.STYLE_HORIZONTAL);
        progressDialog.setIcon(android.R.drawable.ic_dialog_info);
        progressDialog.setTitle("DownLoad");
        progressDialog.setMessage("다운로드중.....");
        progressDialog.show();//hide();
    }

}
