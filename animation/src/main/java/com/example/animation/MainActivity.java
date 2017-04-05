package com.example.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
/*
Animation구현단계(Tweened animaiton)
1.xml을 이용한 애니메이션 액션 정의
(바람직한 방법)

res -> anim에다 적용하는것
1)<set>태그사용
<translate> -> from X Delta적용 :0%
                to X Delta : 100%
                Duration :3000  (속도 3초)
                repeatcount -> 반복횟수를 지정한다
 <alpha> ->투명도
 from alpha , to alpha

2.애니메이션을 로딩하는 과정 즉 객체화하는 과정(inflation)

loadAnimaiton

3.애니메이션 적용 -> 뷰객체에 적용
startAnimation  --- setAnimation + start()
setAnitmation

4. 연속적으로 에니메이션 적용 하는 방법
A + B = 7초
A가 끝나는 시점에 B가 바로시작 되야 하기때문에
onAnimation End()
Animaiton Listner가 필요하다

*/

public class MainActivity extends AppCompatActivity {
    Animation testAni;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testAni = AnimationUtils.loadAnimation(this,R.anim.ani_test);

        textView = (TextView)findViewById(R.id.tv01);
    }

    public void btnClikced (View view){
        //에니메이션에 리스너 정의
        testAni.setAnimationListener(new testAnimationListener());

        //텍스트뷰에 에니메이션 적용
        textView.startAnimation(testAni);

    }

    private  final class testAnimationListener implements Animation.AnimationListener{
        @Override
        //에니메이션이 시작될때
        public void onAnimationStart(Animation animation) {

        }

        @Override
        //에니메이션이 끝날때
        public void onAnimationEnd(Animation animation) {
            Toast.makeText(getApplicationContext(),"에니메이션 끝",Toast.LENGTH_LONG).show();

        }

        @Override
        //에니메이션이 반복될때
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
