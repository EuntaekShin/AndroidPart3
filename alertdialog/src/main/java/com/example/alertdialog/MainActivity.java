package com.example.alertdialog;

/*
    AlterDiaglog를 이용해서 대화상자 만들 수 있다(가장 간단한 방법)
    setNeutralButton()
    setNegativeButton()
    setPositiveButton()

    빌더객체를 이용해서야한다

     */
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView textView;
    String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.tv01);
        Button button = (Button)findViewById(R.id.btn01);
        //알림 대화상자를 생성하는 메소드를 호출(두번째 할일)

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = makeDialog();
                alertDialog.show();

            }
        });

    }



    //대화상자 설정(처음으로 할일)
    private AlertDialog makeDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        builder.setTitle("알림");
        builder.setMessage("아무거나 선택하세요");
        builder.setIcon(android.R.drawable.ic_dialog_alert);

        //ok 버튼 설정
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

                msg = "OK 버튼을 선택" + Integer.toString(whichButton);
                textView.setText(msg);
            }
        });
        //no 버튼 설정
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

                msg = "NO 버튼을 선택" + Integer.toString(whichButton);
                textView.setText(msg);


            }
        });

        //cancle 버튼 설정
        builder.setNeutralButton("CANCLE", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

                msg = "CANCLE 버튼을 선택" + Integer.toString(whichButton);
                textView.setText(msg);
            }
        });

        //Bulider 클래스의 crate()메소드 호출하여 대화상자 생성
        AlertDialog dialog = builder.create();

        return  dialog;
    }
    }
