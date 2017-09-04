package com.tapwater.revisenotification;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Context mContext;
    private NotificationManager notificationManager;
    private Notification notification;
    private static final int NOTEID_1 = 1;

    private Button buttonShow, buttonCancel;

    private Bitmap largeBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        bindView();
    }

    private void bindView()
    {
        buttonShow = (Button) findViewById(R.id.buttonShow);
        buttonCancel = (Button) findViewById(R.id.buttonCancel);
        buttonShow.setOnClickListener(this);
        buttonCancel.setOnClickListener(this);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.buttonShow:
                Intent intent = new Intent(mContext,OtherActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivities(mContext,0, new Intent[]{intent},0);
                Notification.Builder myBuilder = new Notification.Builder(this);
                myBuilder.setContentText("ONE")
                        .setContentTitle("NOTE")
//                        .setSubText("HAHA")
                        .setTicker("Baby please one more time")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                        .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE)
                        .setAutoCancel(true)
                        .setContentIntent(pendingIntent);
                notification = myBuilder.build();
                notificationManager.notify(NOTEID_1,notification);
                break;
            case R.id.buttonCancel:
                notificationManager.cancel(NOTEID_1);
                break;
        }
    }
}
