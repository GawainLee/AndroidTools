package com.tapwater.revisehandler;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextMax;
    private Button buttonCal;
    MyThread myThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextMax = (EditText) findViewById(R.id.editTextPlace);
        buttonCal = (Button) findViewById(R.id.buttonPlace);
        buttonCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message message = new Message();
                message.what = 0x123;
                Bundle bundle = new Bundle();
                bundle.putInt("Key",Integer.parseInt(editTextMax.getText().toString()));
                message.setData(bundle);
                myThread.handler.sendMessage(message);
                System.out.println("Button Start");
            }
        });
        myThread = new MyThread(MainActivity.this);
        myThread.start();
        System.out.println("Thread Start");
    }
}
