package com.tapwater.reviseneonlight;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private int currentColor = 1;
    final int[] colors = new  int[]{
            Color.argb(255,255,0,0),
            Color.argb(255,0,255,0),
            Color.argb(255,0,0,255),
            Color.argb(255,255,255,0),
            Color.argb(255,255,0,255),
            Color.argb(255,0,255,255)};

    final int[] names = new int[]{
            R.id.view01,
            R.id.view02,
            R.id.view03,
            R.id.view04,
            R.id.view05,
            R.id.view06
    };

    TextView[] views = new TextView[names.length];

    Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            if(msg.what == 0x123)
            {
                for(int i = 0; i < names.length; i++)
                {
                    views[i].setBackgroundColor(colors[(i +currentColor) % names.length]);
                    System.out.print("ok");
                }
                currentColor++;
            }
            super.handleMessage(msg);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i = 0; i < names.length; i++)
        {
            views[i] = (TextView) findViewById(names[i]);
        }
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0x123);
            }
        },0,500);
    }
}
