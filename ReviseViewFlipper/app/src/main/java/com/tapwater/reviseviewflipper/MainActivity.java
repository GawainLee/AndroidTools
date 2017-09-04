package com.tapwater.reviseviewflipper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    private ViewFlipper viewFlipper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
    }

    public void prev(View view)
    {
        viewFlipper.setInAnimation(MainActivity.this,R.anim.slide_in_right);
        viewFlipper.setOutAnimation(MainActivity.this,R.anim.slide_out_left);
        viewFlipper.showPrevious();
        viewFlipper.stopFlipping();
    }

    public void next(View view)
    {
        viewFlipper.setInAnimation(MainActivity.this,R.anim.slide_in_left);
        viewFlipper.setOutAnimation(MainActivity.this,R.anim.slide_out_right);
        viewFlipper.showNext();
        viewFlipper.stopFlipping();
    }

    public void auto(View view)
    {
        viewFlipper.startFlipping();
    }
}
