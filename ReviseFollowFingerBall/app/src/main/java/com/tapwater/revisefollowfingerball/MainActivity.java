package com.tapwater.revisefollowfingerball;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainone);
        LinearLayout root = (LinearLayout) findViewById(R.id.root);
        final DrawView drawView = new DrawView(this);
        drawView.setMinimumWidth(300);
        drawView.setMinimumHeight(500);
        root.addView(drawView);
    }

}
