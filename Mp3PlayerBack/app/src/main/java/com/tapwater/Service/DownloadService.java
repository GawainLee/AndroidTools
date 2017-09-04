package com.tapwater.Service;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.tapwater.download.HttpDownloader;
import com.tapwater.mp3Model.Mp3Info;

/**
 * Created by Tapwater on 16-2-4.
 */
public class DownloadService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    /**
     * start on run service
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //Mp3Info is Serializable
        Mp3Info mp3Info = (Mp3Info) intent.getSerializableExtra("mp3Info");
        DownloadThread downloadThread = new DownloadThread(mp3Info);
        Thread thread = new Thread(downloadThread);
        thread.start();
        System.out.println("Service " +mp3Info);
        return super.onStartCommand(intent, flags, startId);
    }

    /**
     *
     */
    class DownloadThread implements Runnable
    {
        Mp3Info mp3Info = null;

        public DownloadThread(Mp3Info mp3Info)
        {
            this.mp3Info = mp3Info;
        }

        @Override
        public void run() {
            String downloadURL = "http://192.168.1.101:8080/mp3/" + mp3Info.getMp3Name();
            HttpDownloader httpDownloader = new HttpDownloader();
            int i = httpDownloader.downFile(downloadURL,"mp3/",mp3Info.getMp3Name());
            String tempResult = null;
            if(i == 1)
            {
                tempResult = "File already exists";
            }
            else if(i == -1)
            {
                tempResult = "File download error";
            }
            else if (i == 0)
            {
                tempResult = "Finish download file";
            }
            System.out.println(tempResult);

        }
    }
}
