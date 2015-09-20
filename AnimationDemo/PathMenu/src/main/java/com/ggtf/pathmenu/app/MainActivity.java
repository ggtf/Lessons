package com.ggtf.pathmenu.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.LinkedList;
import java.util.List;


public class MainActivity extends Activity implements Animator.AnimatorListener {

    private ImageView imageViewIcon1;
    private ImageView imageViewIcon2;
    private ImageView imageViewIcon3;
    private ImageView imageViewIcon4;
    private ImageView imageViewIcon5;
    private ImageView imageViewIcon6;
    private ImageView imageViewIcon;
    private boolean isAgain=false;
    private List<ImageView> imageViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageViewIcon = (ImageView) findViewById(R.id.imageView_icon);
        imageViewIcon1 = (ImageView) findViewById(R.id.imageView_icon1);
        imageViewIcon2 = (ImageView) findViewById(R.id.imageView_icon2);
        imageViewIcon3 = (ImageView) findViewById(R.id.imageView_icon3);
        imageViewIcon4 = (ImageView) findViewById(R.id.imageView_icon4);
        imageViewIcon5 = (ImageView) findViewById(R.id.imageView_icon5);
        imageViewIcon6 = (ImageView) findViewById(R.id.imageView_icon6);
        imageViews = setImageViews();
//        imageViewIcon.setRotation();
    }
    private List<ImageView> setImageViews(){
        List<ImageView> imageViews = new LinkedList<ImageView>();
        imageViews.add(imageViewIcon1);
        imageViews.add(imageViewIcon2);
        imageViews.add(imageViewIcon3);
        imageViews.add(imageViewIcon4);
        imageViews.add(imageViewIcon5);
        imageViews.add(imageViewIcon6);
        return  imageViews;
    }


    /**
     * 按钮点击实现动画
     * @param view
     */
    public void btnClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.imageView_icon:
                if (isAgain){
                    retractionAnimation();
                    isAgain = false;
                }else {
                    unfoldAnimation();
                    isAgain = true;
                }
                break;
            case R.id.imageView_icon1:
                actionAnimation(1);
                break;
            case R.id.imageView_icon2:
                actionAnimation(2);
                break;
            case R.id.imageView_icon3:
                actionAnimation(3);
                break;
            case R.id.imageView_icon4:
                actionAnimation(4);
                break;
            case R.id.imageView_icon5:
                actionAnimation(5);
                break;
            case R.id.imageView_icon6:
                actionAnimation(6);
                break;

        }
    }

    /**
     * 点击回缩其他按钮
     */
    private void retractionAnimation(){
        for (ImageView imageView : imageViews) {
            imageView.setVisibility(View.VISIBLE);
        }
        //        Icon的动画
        Animator animator6 = AnimatorInflater.loadAnimator(this, R.animator.animator_rotation_again);
        animator6.setTarget(imageViewIcon);
        animator6.start();

        //IconA的动画
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.animator_translatey_back);
        animator.setTarget(imageViewIcon1);
        animator.start();
//                IconB的动画
        Animator animator1 = AnimatorInflater.loadAnimator(this, R.animator.animator_translate_cos18_back);
        animator1.setTarget(imageViewIcon2);
        animator1.start();
//                IconC的动画
        Animator animator2 = AnimatorInflater.loadAnimator(this, R.animator.animator_translate_cos36_back);
        animator2.setTarget(imageViewIcon3);
        animator2.start();
//                IconD的动画
        Animator animator3 = AnimatorInflater.loadAnimator(this, R.animator.animator_translate_sin36_back);
        animator3.setTarget(imageViewIcon4);
        animator3.start();
//                IconE的动画
        Animator animator4 = AnimatorInflater.loadAnimator(this, R.animator.animator_translate_sin18_back);
        animator4.setTarget(imageViewIcon5);
        animator4.start();
//                IconF的动画
        Animator animator5 = AnimatorInflater.loadAnimator(this, R.animator.animator_translatex_back);
        animator5.setTarget(imageViewIcon6);
        animator5.start();

    }
    /**
     * 点击展开其他按钮
     */
    private void unfoldAnimation() {
        for (ImageView imageView : imageViews) {
            imageView.setVisibility(View.VISIBLE);
        }
//        Icon的动画
        Animator animator6 = AnimatorInflater.loadAnimator(this, R.animator.animator_rotation_first);
        animator6.setTarget(imageViewIcon);
        animator6.start();

        //IconA的动画
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.animator_translate_y);
        animator.setTarget(imageViewIcon1);
        animator.start();
//                IconB的动画
        Animator animator1 = AnimatorInflater.loadAnimator(this, R.animator.animator_translate_cos18);
        animator1.setTarget(imageViewIcon2);
        animator1.start();
//                IconC的动画
        Animator animator2 = AnimatorInflater.loadAnimator(this, R.animator.animator_translate_cos36);
        animator2.setTarget(imageViewIcon3);
        animator2.start();
//                IconD的动画
        Animator animator3 = AnimatorInflater.loadAnimator(this, R.animator.animator_translate_sin36);
        animator3.setTarget(imageViewIcon4);
        animator3.start();
//                IconE的动画
        Animator animator4 = AnimatorInflater.loadAnimator(this, R.animator.animator_translate_sin18);
        animator4.setTarget(imageViewIcon5);
        animator4.start();
//                IconF的动画
        Animator animator5 = AnimatorInflater.loadAnimator(this, R.animator.animator_translate_x);
        animator5.setTarget(imageViewIcon6);
        animator5.start();
    }

    private void actionAnimation(int pos) {
        Animator animator6 = AnimatorInflater.loadAnimator(this, R.animator.animator_show);
        animator6.setTarget(imageViews.get(pos - 1));
        animator6.addListener(this);
        animator6.start();
        for (int i = 1; i < 7; i++) {
            if (i != pos){
                Animator animator7 = AnimatorInflater.loadAnimator(this, R.animator.animator_hint);
                animator7.setTarget(imageViews.get(i - 1));
                animator7.addListener(this);
                animator7.start();

            }
        }
    }
    
    private void setPackHome(){
        for (int i = 0; i <imageViews.size() ; i++) {
            ImageView imageView = imageViews.get(i);
            imageView.setVisibility(View.GONE);
            imageView.setAlpha(1.0f);
            imageView.setScaleX(1);
            imageView.setScaleY(1);

        }
    }

//    动画效果监听
    @Override
    public void onAnimationStart(Animator animation) {

    }

    @Override
    public void onAnimationEnd(Animator animation) {
        retractionAnimation();
        isAgain = false;
        setPackHome();

    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }
}
