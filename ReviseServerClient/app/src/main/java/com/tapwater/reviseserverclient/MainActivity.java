package com.tapwater.reviseserverclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonSent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonSent = (Button) findViewById(R.id.buttonSent);
        buttonSent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendMessage sendMessage = new SendMessage();
                sendMessage.start();
            }
        });
    }
}
