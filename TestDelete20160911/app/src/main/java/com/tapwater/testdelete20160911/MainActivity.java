package com.tapwater.testdelete20160911;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.root);
        final DrawView drawView = new DrawView(this);
        drawView.setMinimumWidth(300);
        drawView.setMinimumHeight(500);
        linearLayout.addView(drawView);
    }
}
