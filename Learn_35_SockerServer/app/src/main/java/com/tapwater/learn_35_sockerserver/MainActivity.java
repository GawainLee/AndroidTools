package com.tapwater.learn_35_sockerserver;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MainActivity extends Activity {

    private Button buttonSocketServer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.socker_server);
        buttonSocketServer = (Button) findViewById(R.id.buttonSocketServer);
        buttonSocketServer.setOnClickListener(new SocketServerListener());

    }

    class SocketServerListener implements View.OnClickListener
    {

        @Override
        public void onClick(View view) {
            new SocketServerThread().start();
        }
    }

    class SocketServerThread extends Thread
    {
        //TCP server socket
        @Override
        public void run() {
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(3456);
//                Toast.makeText(MainActivity.this,"Wait Message",Toast.LENGTH_SHORT).show();
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                byte[] buffer = new byte[1024 * 4];
                int temp = 0;
                while ((temp = inputStream.read(buffer)) != -1)
                {
                    String str = new String(buffer,0,temp);
                    System.out.println(str);
//                    Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

//        //DCP server socket
//        @Override
//        public void run() {
//        }
    }
}
