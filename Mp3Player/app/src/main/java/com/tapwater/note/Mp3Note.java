package com.tapwater.note;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.tapwater.mp3player.R;

/**
 * Created by Tapwater on 16-2-5.
 */
public class Mp3Note {

    private NotificationManager notificationManager;
    private static final int NOTIFICATION_FLAG = 1;
    private String showInfo;
    private Context context;
    public Mp3Note(NotificationManager manager,Context context,String showInfo)
    {
        notificationManager = manager;
        this.context = context;
        this.showInfo = showInfo;
    }
    public void setNote()
    {
        // Notification myNotify = new Notification(R.drawable.message,
        // "自定义通知：您有新短信息了，请注意查收！", System.currentTimeMillis());
        Notification myNotify = new Notification();
//        myNotify.icon = R.drawable.message;
        myNotify.tickerText = "TickerText:您有新短消息，请注意查收！";
        myNotify.when = System.currentTimeMillis();
        myNotify.flags = Notification.FLAG_NO_CLEAR;// 不能够自动清除
        RemoteViews rv = new RemoteViews(context.getPackageName(),
                R.layout.mp3_note_layout);
        rv.setTextViewText(R.id.text_content, showInfo);
        myNotify.contentView = rv;
        Intent intent = new Intent(Intent.ACTION_MAIN);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 1, intent, 0);
        myNotify.contentIntent = contentIntent;
        notificationManager.notify(NOTIFICATION_FLAG, myNotify);
    }
}
