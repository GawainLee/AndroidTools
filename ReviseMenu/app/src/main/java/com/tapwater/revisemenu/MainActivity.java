package com.tapwater.revisemenu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final private int RED = 110;
    final private int GREEN = 111;
    final private int BLUE = 112;
    final private int YELLOW = 113;
    final private int BLACK = 114;

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textViewPlace);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1,RED,4,"红");
        menu.add(1,BLACK,2,"黑");
        menu.add(1,YELLOW,1,"黄");
        menu.add(1,BLUE,3,"蓝");
        menu.add(1,GREEN,5,"绿");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id)
        {
            case RED:
                textView.setTextColor(Color.RED);
                break;
            case BLACK:
                textView.setTextColor(Color.BLACK);
                break;
            case BLUE:
                textView.setTextColor(Color.BLUE);
                break;
            case YELLOW:
                textView.setTextColor(Color.YELLOW);
                break;
            case GREEN:
                textView.setTextColor(Color.GREEN);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
