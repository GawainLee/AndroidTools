package com.tapwater.reviseimage;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int[] images = new int[]
            {
                    R.drawable.one,
                    R.drawable.two,
                    R.drawable.three,
                    R.drawable.four
            };

    Button buttonNext;
    int currenImg = 2;
    int alpha = 255;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button up = (Button) findViewById(R.id.buttonUp);
        final Button down = (Button) findViewById(R.id.buttonDown);
        final ImageView imageViewOrg = (ImageView) findViewById(R.id.imageViewOrg);
        final ImageView imageViewZone = (ImageView) findViewById(R.id.imageViewZone);
        buttonNext = (Button) findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageViewOrg.setImageResource(images[++currenImg % images.length]);
            }
        });
        View.OnClickListener listener = new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                if(view == up)
                {
                    alpha += 20;
                }
                if (view == down)
                {
                    alpha -= 20;
                }
                if (alpha >= 255)
                {
                    alpha = 255;
                }
                if (alpha <= 0)
                {
                    alpha = 0;
                }
                imageViewOrg.setImageAlpha(alpha);
            }
        };
        up.setOnClickListener(listener);
        down.setOnClickListener(listener);
        imageViewOrg.setOnTouchListener(new View.OnTouchListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) imageViewOrg.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();
                double scale = 1.0 * bitmap.getHeight() / imageViewOrg.getHeight();
                int x = (int) (motionEvent.getX() * scale);
                int y = (int) (motionEvent.getY() * scale);
                if (x + 120 > bitmap.getWidth())
                {
                    x = bitmap.getWidth() - 120;
                }
                if(y + 120 > bitmap.getHeight())
                {
                    y = bitmap.getHeight() - 120;
                }
                imageViewZone.setImageBitmap(Bitmap.createBitmap(bitmap,x,y,120,120));
                imageViewZone.setImageAlpha(alpha);
                return false;
            }
        });
    }
}
