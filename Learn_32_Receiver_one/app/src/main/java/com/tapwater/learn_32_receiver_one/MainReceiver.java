package com.tapwater.learn_32_receiver_one;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.URISyntaxException;

/**
 * Created by Tapwater on 16-1-21.
 */
public class MainReceiver extends Activity {

    Button buttonReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receiver);

        buttonReceiver = (Button) findViewById(R.id.buttonReceiver);
        buttonReceiver.setOnClickListener(new ReceiverListener());
    }

    class ReceiverListener implements View.OnClickListener
    {

        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            try {
                intent.setSelector(Intent.getIntent(Intent.ACTION_AIRPLANE_MODE_CHANGED));
                MainReceiver.this.sendBroadcast(intent);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }
}
