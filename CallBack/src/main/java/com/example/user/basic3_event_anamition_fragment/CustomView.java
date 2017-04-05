package com.example.user.basic3_event_anamition_fragment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by user on 2017-03-22.
 */

public class CustomView extends View {
    private Context mContext;

    public CustomView(Context mContext){

        super(mContext);
        this.mContext = mContext;
    }

    protected void onDraw(Canvas canvas){

        super.onDraw(canvas);
        Paint paint = new Paint();

        canvas.drawColor(Color.GREEN);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        //getAction 메소드는 이벤트에 대한 정보를 얻어온다.
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            Toast.makeText(mContext.getApplicationContext(),"모션 터치 이벤트 발생",Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }
}
