package com.tapwater.revisefollowfingerball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Tapwater on 16-9-10.
 */
public class DrawView extends View {

    float currentX = 40.0f;
    float currentY = 30.0f;

    Paint p = new Paint();


    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        p.setColor(Color.RED);
        canvas.drawCircle(currentX,currentY,15,p);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        return super.onTouchEvent(event);
        currentX = event.getX();
        currentY = event.getY();
        invalidate();
        return true;
    }
}
