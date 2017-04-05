package com.example.animationslide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    boolean isPageShow = false;

    Animation slidingLeft;
    Animation slidingRight;

    LinearLayout slidigPage;

    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         btn = (Button)findViewById(R.id.btn01);

        //슬라이딩 처리를 위한 뷰(linearLayout)참조

        slidigPage =(LinearLayout)findViewById(R.id.page01);

        //xml에 정의되어 있는 에니메이션 액션을 객체화하는 과정

        slidingLeft = AnimationUtils.loadAnimation(this,R.anim.sliding_left);
        slidingRight = AnimationUtils.loadAnimation(this,R.anim.sliding_right);

        //에니메이션 리스너 설정(등록)
        SlidingAnimationListnener animationListnener = new SlidingAnimationListnener();
        slidingLeft.setAnimationListener(animationListnener);
        slidingRight.setAnimationListener(animationListnener);

    }

    //버튼 이벤트 처리
    public void btnClicked (View v){
        if(isPageShow){
            slidigPage.startAnimation(slidingRight);

        }else {
            slidigPage.setVisibility(View.VISIBLE);
            slidigPage.startAnimation(slidingLeft);
        }
    }

    private  class SlidingAnimationListnener implements Animation.AnimationListener{

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
                if (isPageShow){
                    slidigPage.setVisibility(View.INVISIBLE);

                    btn.setText("SHOW");
                    isPageShow = false;

                }else{
                    btn.setText("HIDE");
                    isPageShow = true;

                }
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
