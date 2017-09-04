package com.tapwater.revisesocketclient;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by Tapwater on 16-12-14.
 */

public class ClientSocket extends Thread {

    String socketIP = "";
    public ClientSocket(String ip) {
        socketIP = ip;
    }

    @Override
    public void run() {

        //1.创建客户端Socket，指定服务器地址和端口
        Socket socket = null;
        try {
            socket = new Socket(socketIP, 12345);
            System.out.println("1");
            //2.获取输出流，向服务器端发送信息
            OutputStream os = socket.getOutputStream();//字节输出流
            PrintWriter pw = new PrintWriter(os);//将输出流包装为打印流
            System.out.println("2");
            //获取客户端的IP地址
            InetAddress address = InetAddress.getLocalHost();
            String ip = address.getHostAddress();
            pw.write("客户端：~" + ip + "~ 接入服务器！！");
            System.out.println("3");
            pw.flush();
            socket.shutdownOutput();//关闭输出流
            socket.close();
            System.out.println("4");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
