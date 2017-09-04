package com.tapwater.learn_24_asynctask_baseadapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.LruCache;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by Tapwater on 16-1-5.
 */
public class ImageLoader {

    private ImageView imageView;
    private String imageURL;

    private LruCache<String,Bitmap> lruCache;

    private ListView listView;
    private Set<NewsAsyncTask> allTask;

    public ImageLoader(ListView listView)
    {
        this.listView = listView;
        allTask = new HashSet<>();
        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        int useMemory = maxMemory/4;
        lruCache = new LruCache<String,Bitmap>(useMemory)
        {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getByteCount();
            }
        };
    }

    public void addBitmapToCache(String url, Bitmap bitmap) {
        if (getBitmapFromCache(url) == null)
        {
            lruCache.put(url,bitmap);
        }

    }

    public Bitmap getBitmapFromCache(String url)
    {
        return lruCache.get(url);
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (imageView.getTag().equals(imageURL))
            {
                imageView.setImageBitmap((Bitmap)msg.obj);
            }
        }
    };

    public void showImageByThread(ImageView imageView, final String url)
    {
        this.imageView = imageView;
        this.imageURL = url;
        new Thread()
        {
            @Override
            public void run() {
                super.run();
                Bitmap bitmap = getBitmapFromURL(url);
                Message message = Message.obtain();
                message.obj = bitmap;
                handler.sendMessage(message);
            }
        }.start();
    }

    public Bitmap getBitmapFromURL(String imageURL)
    {
        Bitmap bitmap;
        InputStream inputStream = null;
        try {
            URL url = new URL(imageURL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            bitmap = BitmapFactory.decodeStream(inputStream);
            httpURLConnection.disconnect();
            return bitmap;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void showImageViewByAsyncTask(ImageView imageView, String imageURL)
    {
        Bitmap bitmap = getBitmapFromCache(imageURL);
        if (bitmap == null)
        {
//            new NewsAsyncTask(imageURL).execute(imageURL);
            imageView.setImageResource(R.mipmap.ic_launcher);
        }
        else
        {
            imageView.setImageBitmap(bitmap);
        }
    }

    private class NewsAsyncTask extends AsyncTask < String, Void, Bitmap >
    {
//        private ImageView imageView;
        private String url;

        public NewsAsyncTask(String url)
        {
//            this.imageView = imageView;
            this.url = url;
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap bitmap = getBitmapFromURL(strings[0]);
            if (bitmap != null)
            {
                addBitmapToCache(strings[0], bitmap);
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            ImageView imageView = (ImageView) listView.findViewWithTag(url);

            if(imageView != null && bitmap != null) {
                imageView.setImageBitmap(bitmap);
            }
        }
    }

    public void loadImage(int start, int end)
    {
        for (int i = start; i < end; i++)
        {
            String oneImageURL = MyAdapter.allIconURLList[i];
            Bitmap bitmap = getBitmapFromCache(oneImageURL);
            if (bitmap == null)
            {
//                new NewsAsyncTask(oneImageURL).execute(oneImageURL);

                NewsAsyncTask newsAsyncTask = new NewsAsyncTask(oneImageURL);
                newsAsyncTask.execute(oneImageURL);
                allTask.add(newsAsyncTask);
            }
            else
            {
                ImageView imageView = (ImageView) listView.findViewWithTag(oneImageURL);
                imageView.setImageBitmap(bitmap);
            }
        }
    }

    public void cancelAllTask() {
        if (allTask != null)
        {
            for (NewsAsyncTask task: allTask)
            {
                task.cancel(false);
            }
        }
    }
}
