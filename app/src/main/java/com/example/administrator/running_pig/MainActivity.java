package com.example.administrator.running_pig;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity {

    private AnimationDrawable anim; //获取应用的帧动画

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView iv = (ImageView) findViewById(R.id.iamgeview1);
        anim = (AnimationDrawable) iv.getBackground();
        //获取向左向右的动画资源
        final Animation translateright = AnimationUtils.loadAnimation(this, R.anim.translateright);
        final Animation translateleft = AnimationUtils.loadAnimation(this, R.anim.translateleft);
        //获取线性布局管理器
        LinearLayout ll = (LinearLayout) findViewById(R.id.linearlayout1);
        Toast.makeText(this, "触摸屏幕开始奔跑。。。", Toast.LENGTH_SHORT).show();

        //开始播放帧动画，向右奔跑的动画
        ll.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                anim.start();   //开始播放帧动画
                iv.startAnimation(translateright);  //开始向右奔跑
                return false;
            }
        });

        translateright.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            /**
             * 动画结束后
             */
            @Override
            public void onAnimationEnd(Animation animation) {
                iv.setBackgroundResource(R.drawable.motionleft); //重新设置imagevie应用的帧动画
                iv.startAnimation(translateleft);
                anim = (AnimationDrawable) iv.getBackground();  //获取应用的帧动画
                anim.start();   //开始播放帧动画
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        translateleft.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                iv.setBackgroundResource(R.drawable.motionright);
                iv.startAnimation(translateright);
                anim = (AnimationDrawable) iv.getBackground();
                anim.start();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }
}
