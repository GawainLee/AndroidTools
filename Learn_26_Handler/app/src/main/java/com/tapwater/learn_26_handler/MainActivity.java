package com.tapwater.learn_26_handler;

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

        //print the current thread id
        System.out.println("Main Activity Thread -> " + Thread.currentThread().getId());
        //create HandlerThread to control thread and give a name to it
        HandlerThread handlerThread =new HandlerThread("handler_thread");
        //start handlerThread !!must start
        handlerThread.start();
        //create myhandler and set the looper
        MyHandler myHandler = new MyHandler(handlerThread.getLooper());
        //find or create one message object
        Message message = myHandler.obtainMessage();

        Bundle bundle = new Bundle();
        bundle.putInt("age",12);
        bundle.putString("name", "Gawain");
        message.setData(bundle);

        //sent message to my handler, equal run the handlerMessage method
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


    class MyHandler extends Handler{

        public MyHandler(){}

        /**
         * set looper
         * @param looper
         */
        public MyHandler(Looper looper)
        {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            Bundle bundle = msg.getData();
            System.out.println("age " + bundle.getInt("age"));
            System.out.println("name " + bundle.getString("name"));
            System.out.println("handler message:" + Thread.currentThread().getId());
            System.out.println("handler message");
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
