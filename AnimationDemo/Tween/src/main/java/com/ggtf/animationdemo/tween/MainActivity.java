package com.ggtf.animationdemo.tween;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;


public class MainActivity extends Activity implements Animation.AnimationListener {

    private TextView add;
    private TextView fan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = (TextView) findViewById(R.id.txt_zan_inc);
        fan = (TextView) findViewById(R.id.txt_fan);

    }
    /**
     * 点赞加一 实现加1动画启动
     * @param view
     */
    public void btnClick(View view) {
        add.setVisibility(View.VISIBLE);
//        1.加载动画资源， anim 文件夹下的动画，需要使用AnimationUtils 工具来加载
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_translation);
//        1.1动画加载之后，设置监听接口
        animation.setAnimationListener(this);
//        2.使用动画，对控件进行处理和变化，形成动画
//        相当于控件播放动画
        add.startAnimation(animation);
    }

//    动画监听接口

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
//        动画结束回调
        add.setVisibility(View.GONE);

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    public void btnFan(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
//        设置动画的平滑播放
        animation.setInterpolator(new LinearInterpolator());
        fan.startAnimation(animation);
    }

}
