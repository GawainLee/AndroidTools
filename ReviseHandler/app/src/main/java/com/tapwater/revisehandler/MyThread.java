package com.tapwater.revisehandler;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tapwater on 16-12-9.
 */

public class MyThread extends Thread {

    public Handler handler;
    private Context mContext;

    public MyThread(Context context)
    {
        mContext = context;
    }

    @Override
    public void run() {
        System.out.println("Run Start");
        Looper.prepare();
        handler = new Handler()
        {
            @Override
            public void handleMessage(Message msg) {
                System.out.println("get Message");
                if (msg.what == 0x123)
                {
                    System.out.println("Cal");
                    Toast.makeText(mContext, "OK".toString()
                            , Toast.LENGTH_LONG).show();
                    int upper = msg.getData().getInt("Key");
                    List<Integer> nums = new ArrayList<Integer>();
                    outer:
                    for (int i = 2 ; i <= upper ; i++)
                    {
                        // 用i处于从2开始、到i的平方根的所有数
                        for (int j = 2 ; j <= Math.sqrt(i) ; j++)
                        {
                            // 如果可以整除，表明这个数不是质数
                            if(i != 2 && i % j == 0)
                            {
                                continue outer;
                            }
                        }
                        nums.add(i);
                    }
                    // 使用Toast显示统计出来的所有质数
                    Toast.makeText(mContext, nums.toString()
                            , Toast.LENGTH_LONG).show();

                }
            }
        };
        Looper.loop();
    }
}
