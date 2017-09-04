package com.tapwater.reviseviewflipper;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    private ViewFlipper viewFlipper;
    private Context mContext;
    private int[] imageIDs = {R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4};
    private final static int MOV_MIN = 200;
    private GestureDetector gestureDetector;
    private MyGestureListener myGestureListener;
    private Animation leftIn, leftOut, rightIn, rightOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipperPlace);
        for (int i = 0; i <imageIDs.length; i++)
        {
            viewFlipper.addView(getView(imageIDs[i]));
        }
        myGestureListener = new MyGestureListener();
        gestureDetector = new GestureDetector(mContext,myGestureListener);
        leftIn = AnimationUtils.loadAnimation(this,R.anim.left_in);
        leftOut = AnimationUtils.loadAnimation(this,R.anim.left_out);
        rightIn = AnimationUtils.loadAnimation(this,R.anim.right_in);
        rightOut = AnimationUtils.loadAnimation(this,R.anim.right_out);
    }
    private View getView(int imageID)
    {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(imageID);
        return imageView;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener
    {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if(e1.getX() - e2.getX() >= MOV_MIN)
            {
                viewFlipper.setInAnimation(rightIn);
                viewFlipper.setOutAnimation(rightOut);
                viewFlipper.showNext();

            }
            else if (e2.getX() - e1.getX() >= MOV_MIN)
            {
                viewFlipper.setInAnimation(leftIn);
                viewFlipper.setOutAnimation(leftOut);
                viewFlipper.showPrevious();
            }
            return true;
        }
    }
}
