package com.example.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
/*
1. 옵션메뉴(핸드폰 자체에 깔려있는것)  ->3.0이전 에만 있다, 3.0이후에는 엑션바에 포함되어있다
사용하는 메서드
OnCreateOptionsMenu(Menu menu)
SubMEnu addsubMenu(int titles Res)

2. 컨텍스트메뉴(붙여 넣기, 복사하기 등)
OnCreateContextMenu(contextMenu menu , View v, contextMenuInfo info)
MenuItem add(int groupId, int itemId, int order,charsequence title)

3.Res ->menu->xml

4.액션바 모양을 변화시키는 메서드
setDisplayOption(미리정해진 파라미터)
1.미리정해진 상수, 2.DIsPLaY_USE_LOGO , 3.DisPLAY_SHOW_HOME , 4.DisPLAY_HOME.AS.up
 */

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.tv01);

    }

    //1.우리가 추가해줘야할 메뉴를 추가할때 쓰는 메서드
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    //인플레이터 과정
    getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
        }

    //작동시키는 메서드

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //각각의 아이템들을 어어오는 과정

        switch (item.getItemId()){
        case R.id.item01:
        Toast.makeText(this,"메뉴 1",Toast.LENGTH_SHORT).show();
            break;

        case R.id.item02:
            Toast.makeText(this,"메뉴 2",Toast.LENGTH_SHORT).show();

            break;
        case R.id.item03:
            Toast.makeText(this,"메뉴 3",Toast.LENGTH_SHORT).show();

            break;
        }
        textView.setText(item.getTitle().toString());

        return false;
    }
}
