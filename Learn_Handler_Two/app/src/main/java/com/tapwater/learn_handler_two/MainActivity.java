package com.tapwater.learn_handler_two;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private Button buttonStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        buttonStart = (Button) findViewById(R.id.buttonStart);
        buttonStart.setOnClickListener(new HandlerStartListener());

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

    private class HandlerStartListener implements View.OnClickListener
    {

        @Override
        public void onClick(View view) {
            progressBar.setVisibility(View.VISIBLE);
            update_handler_progress_bar.post(update_thread);
        }
    }


    private Handler update_handler_progress_bar = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            progressBar.setProgress(msg.arg1);
            update_handler_progress_bar.post(update_thread);
        }
    };

    private Runnable update_thread = new Runnable() {
        int i = 0;
        @Override
        public void run() {
            i += 10;
            Message message = update_handler_progress_bar.obtainMessage();
            message.arg1 = i;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            update_handler_progress_bar.sendMessage(message);
            if (i == 100)
            {
                update_handler_progress_bar.removeCallbacks(update_thread);
                i = 0;
                progressBar.setVisibility(View.INVISIBLE);
            }

        }
    };


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
