package com.tapwater.learn_23_asynctask;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ProgressBar;

/**
 * Created by Tapwater on 15-12-29.
 */
public class ProgressBarTest extends Activity {

    private ProgressBar progressBar;
    private MyAsynctask myAsynctask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progressbar);

        progressBar = (ProgressBar) findViewById(R.id.loadingProgressBar);
        myAsynctask = new MyAsynctask();
        myAsynctask.execute();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(myAsynctask != null && myAsynctask.getStatus() == AsyncTask.Status.RUNNING)
        {
            myAsynctask.cancel(true);
        }
    }

    class MyAsynctask extends AsyncTask<Void, Integer, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            for (int i = 0; i < 100; i++) {
                if(isCancelled())
                {
                    break;
                }
                publishProgress(i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            finish();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            if (isCancelled())
            {
                return;
            }
            progressBar.setProgress(values[0]);
        }
    }
}
