package com.ggtf.pathmenu.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.LinkedList;
import java.util.List;


public class MainActivity extends Activity {

    private ImageButton imageBtnIcon1;
    private ImageButton imageBtnIcon2;
    private ImageButton imageBtnIcon3;
    private ImageButton imageBtnIcon4;
    private ImageButton imageBtnIcon5;
    private ImageButton imageBtnIcon6;
    private ImageButton imageBtnIcon;
    private boolean isAgain=false;
    private List<ImageButton> imageButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageBtnIcon = (ImageButton) findViewById(R.id.image_button_icon);
        imageBtnIcon1 = (ImageButton) findViewById(R.id.image_button_icon1);
        imageBtnIcon2 = (ImageButton) findViewById(R.id.image_button_icon2);
        imageBtnIcon3 = (ImageButton) findViewById(R.id.image_button_icon3);
        imageBtnIcon4 = (ImageButton) findViewById(R.id.image_button_icon4);
        imageBtnIcon5 = (ImageButton) findViewById(R.id.image_button_icon5);
        imageBtnIcon6 = (ImageButton) findViewById(R.id.image_button_icon6);
        imageButtons = setImageButtons();
//        imageBtnIcon.setRotation();
    }
    private List<ImageButton> setImageButtons(){
        List<ImageButton> imageButtons = new LinkedList<ImageButton>();
        imageButtons.add(imageBtnIcon1);
        imageButtons.add(imageBtnIcon2);
        imageButtons.add(imageBtnIcon3);
        imageButtons.add(imageBtnIcon4);
        imageButtons.add(imageBtnIcon5);
        imageButtons.add(imageBtnIcon6);
        return  imageButtons;
    }


    /**
     * 按钮点击实现动画
     * @param view
     */
    public void btnClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.image_button_icon:
//                IconA的动画
                Animator animator = AnimatorInflater.loadAnimator(this, R.animator.animator_translatey);
                animator.setTarget(imageBtnIcon1);
                animator.start();
//                IconB的动画
                Animator animator1 = AnimatorInflater.loadAnimator(this, R.animator.animator_translate_cos18);
                animator1.setTarget(imageBtnIcon2);
                animator1.start();
//                IconC的动画
                Animator animator2 = AnimatorInflater.loadAnimator(this, R.animator.animator_translate_cos36);
                animator2.setTarget(imageBtnIcon3);
                animator2.start();
//                IconD的动画
                Animator animator3 = AnimatorInflater.loadAnimator(this, R.animator.animator_translate_sin36);
                animator3.setTarget(imageBtnIcon4);
                animator3.start();
//                IconE的动画
                Animator animator4 = AnimatorInflater.loadAnimator(this, R.animator.animator_translate_sin18);
                animator4.setTarget(imageBtnIcon5);
                animator4.start();
//                IconF的动画
                Animator animator5 = AnimatorInflater.loadAnimator(this, R.animator.animator_translatex);
                animator5.setTarget(imageBtnIcon6);
                animator5.start();
                break;
            case R.id.image_button_icon1:
                Animator animator6 = AnimatorInflater.loadAnimator(this, R.animator.animator_show);
                animator6.setTarget(imageBtnIcon1);
                animator6.start();
                for (int i = 1; i < 7; i++) {
                    if (i != 1){
                        Animator animator7 = AnimatorInflater.loadAnimator(this, R.animator.animator_hint);
                        animator7.setTarget(imageButtons.get(i-1));
                        animator7.start();
                    }
                }
                break;
            case R.id.image_button_icon2:
                break;
            case R.id.image_button_icon3:
                break;
            case R.id.image_button_icon4:
                break;
            case R.id.image_button_icon5:
                break;
            case R.id.image_button_icon6:
                break;

        }
    }
}
