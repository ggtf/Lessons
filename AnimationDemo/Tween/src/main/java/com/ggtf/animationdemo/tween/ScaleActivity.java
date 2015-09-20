package com.ggtf.animationdemo.tween;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by Ggtf on 2015/9/19.
 * Author:GGTF
 * Email:15170069952@163.com
 * Time:2015/9/19
 * ProjectName:AnimationDemo
 */
public class ScaleActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale);
        ImageView heart = (ImageView) findViewById(R.id.heart);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        heart.startAnimation(animation);
    }
}
