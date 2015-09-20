package com.ggtf.propertyanimationdemo.app;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.LinearLayout;

/**
 * 实现滑动菜单，LinearLayout可以被拖拽
 */
public class SwipeActivity extends Activity implements View.OnTouchListener {

    private LinearLayout linearLayout;
    //    上一次触摸的位置
    private float lastX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);
        linearLayout = (LinearLayout) findViewById(R.id.linear_layout);
//        给LinearLayout设置触摸事件
        linearLayout.setOnTouchListener(this);
    }


    /**
     * 触摸事件
     *
     * @param v     被触摸的对象
     * @param event MotionEvent
     * @return boolean 返回false事件提交给父容器处理，返回true事件在当前自己处理
     */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();
//        获取手，触摸到屏幕的硬件位置，
        float rawX = event.getRawX();
//        需要上一次的位置，和当前rawX进行运算，算出移动的距离，然后处理移动LinearLayout
        boolean isDown = false;
        switch (action) {
//            按下事件，这个事件需要返回true,才可以接受到后续的 移动事件
            case MotionEvent.ACTION_DOWN:
                isDown = true;
//                DOWN表示事件开始
                lastX = rawX;
                break;
//            手指在屏幕的移动，会触发事件，移动LinearLayout就是在这里；
            case MotionEvent.ACTION_MOVE:
                float cc = rawX - lastX;
                float x = linearLayout.getX();
                x += cc;
//                在事件处理的方法中，能够获取控件的宽高；
                int myselfw = linearLayout.getWidth();
//                获取布局信息
                ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams();
//                从布局中加载的左右边距信息
                int leftMargin = layoutParams.leftMargin;
                int rightMargin = layoutParams.rightMargin;
                int containerW = myselfw+leftMargin+rightMargin;

                if (x <=0 && x>=(leftMargin+rightMargin)){
//                    int right = linearLayout.getRight();
//                    if (right + cc >=containerW){
//                        //                设置X
                        linearLayout.setX(x);
//                    }
                }
//                设置上一次的位置
                lastX = rawX;
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return isDown;
    }
}
