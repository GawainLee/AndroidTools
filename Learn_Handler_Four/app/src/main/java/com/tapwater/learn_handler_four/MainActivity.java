package com.tapwater.learn_handler_four;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("Handler ID -----> " + Thread.currentThread().getId());
        System.out.println("Handler Name -----> " + Thread.currentThread().getName());

        HandlerThread handlerThread = new HandlerThread("handlerThread");
        handlerThread.start();

        MyHandler myHandler = new MyHandler(handlerThread.getLooper());
        Message message = myHandler.obtainMessage();

        Bundle bundle = new Bundle();
        bundle.putString("whether","Sun");
        bundle.putInt("temperature",16);
        message.setData(bundle);
        message.sendToTarget();

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

    class MyHandler extends Handler
    {
        public MyHandler(){}

        public MyHandler(Looper looper)
        {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            System.out.println("Handler ID -----> " + Thread.currentThread().getId());
            System.out.println("Handler Name -----> " + Thread.currentThread().getName());
            Bundle bundle = msg.getData();
            String whether = bundle.getString("whether");
            int temperature = bundle.getInt("temperature");
            System.out.println("Whether -----> " + whether + " Temperature -----> " + temperature);
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
