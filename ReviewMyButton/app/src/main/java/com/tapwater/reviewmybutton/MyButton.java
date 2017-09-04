package com.tapwater.reviewmybutton;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Tapwater on 16-12-7.
 */

public class MyButton extends Button {
    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Toast.makeText(getContext(),"onKeyDown",Toast.LENGTH_LONG).show();
        return true;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Toast.makeText(getContext(),"onKeyUp",Toast.LENGTH_LONG).show();
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Toast.makeText(getContext(),"onTouchEvent",Toast.LENGTH_LONG).show();
        return true;
    }
}
