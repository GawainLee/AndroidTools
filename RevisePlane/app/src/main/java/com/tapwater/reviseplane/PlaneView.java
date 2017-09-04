package com.tapwater.reviseplane;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by Tapwater on 16-11-9.
 */



public class PlaneView extends View {

    public float currentX = 0
            , currentY = 0;

    public Bitmap plane;

    public PlaneView(Context context) {
        super(context);
        plane = BitmapFactory.decodeResource(context.getResources(),R.drawable.plane);
        setFocusable(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        canvas.drawBitmap(plane,currentX,currentY,paint);
    }
}
