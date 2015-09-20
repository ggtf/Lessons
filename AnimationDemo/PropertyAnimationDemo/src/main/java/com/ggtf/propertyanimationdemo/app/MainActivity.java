package com.ggtf.propertyanimationdemo.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends Activity {

    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView) findViewById(R.id.txt);
    }

    /**
     * 移位动画
     * @param view
     */
    public void btnTranslate(View view) {
//        1.加载属性动画
//        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.animator_translate);
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.animator_transform);
//        2.Animator 需要设置一个目标，这个目标代表了要修改哪一个对象的属性
        animator.setTarget(txt);
        animator.start();
    }

    /**
     * 旋转动画
     * @param view
     */
    public void btnRotation(View view) {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.animator_rotation);
        animator.setTarget(txt);
        animator.start();
    }
}
