package com.tapwater.revisenotification;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    static final int NOtIFICATION_ID = 0x123;
    NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void show(View view)
    {
        Intent intent = new Intent(MainActivity.this,OtherActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,intent,0);
        Notification notification = new Notification.Builder(this)
                .setAutoCancel(true)
                .setTicker("New Message")
                .setSmallIcon(R.drawable.image11)
                .setContentTitle("One message")
                .setContentText("OMG")
                .setDefaults(Notification.DEFAULT_SOUND)
                .setWhen(System.currentTimeMillis())
                .setContentIntent(pendingIntent)
                .build();
        notificationManager.notify(NOtIFICATION_ID,notification);
    }

    public void cancel(View view)
    {
        notificationManager.cancel(NOtIFICATION_ID);
    }
}
