package com.tapwater.learn_35_socketclient_tcp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MainActivity extends Activity {

    Button buttonSend;
    EditText editTextSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.socket_client_tcp);
        editTextSend = (EditText) findViewById(R.id.editTextInput);
        buttonSend = (Button) findViewById(R.id.buttonSend);
        buttonSend.setOnClickListener(new SentListener());
    }

    class SentListener implements View.OnClickListener
    {

        @Override
        public void onClick(View view) {
            new SendClientThread().start();
        }
    }

    class SendClientThread extends Thread
    {
        @Override
        public void run() {
            try {
                Socket socket = new Socket("192.168.1.103",3456);
                String str = editTextSend.getText().toString();
                InputStream inputStream = new ByteArrayInputStream(str.getBytes());
                OutputStream outputStream = socket.getOutputStream();
                byte[] buffer = new byte[4 * 1024];
                int temp = 0;
                while ((temp = inputStream.read(buffer)) != -1)
                {
                    outputStream.write(buffer,0,temp);
                }
                outputStream.flush();
                System.out.println("Send completed");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
