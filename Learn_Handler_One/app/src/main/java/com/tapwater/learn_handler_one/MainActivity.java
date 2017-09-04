package com.tapwater.learn_handler_one;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewOutPut;
    private Button buttonHandlerRun, buttonHandlerOff;

    private Handler handler = new Handler();
    private Runnable update_thread = new Runnable() {
        @Override
        public void run() {
            textViewOutPut.append("\nUpdate Thread");
            handler.postDelayed(update_thread,1000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewOutPut = (TextView) findViewById(R.id.outPutTextView);
        buttonHandlerRun = (Button) findViewById(R.id.HandlerOnButton);
        buttonHandlerRun.setOnClickListener(new HandlerRunListener());
        buttonHandlerOff = (Button) findViewById(R.id.HandlerOffButton);
        buttonHandlerOff.setOnClickListener(new HandlerOffListener());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private class HandlerRunListener implements View.OnClickListener
    {

        @Override
        public void onClick(View view) {
            handler.post(update_thread);
        }
    }

    private class HandlerOffListener implements View.OnClickListener
    {

        @Override
        public void onClick(View view) {
            handler.removeCallbacks(update_thread);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
