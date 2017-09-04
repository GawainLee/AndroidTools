package com.tapwater.learn_30_downloadfile;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tapwater.learn_30_downloadfile.com.tapwater.utils.HttpDownloader;

/**
 * Created by Tapwater on 16-1-20.
 */
public class MainDownloadFile extends Activity {

    Button buttonDownloadFile, buttonDownloadMP3;
    EditText editTextURLAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.download_file_layout);

        buttonDownloadFile = (Button) findViewById(R.id.buttonDownloadFile);
        buttonDownloadMP3 = (Button) findViewById(R.id.buttonDownloadMP3);
        editTextURLAddress = (EditText) findViewById(R.id.editTextDownloadURL);
        buttonDownloadFile.setOnClickListener(new DownloadFile());
        buttonDownloadMP3.setOnClickListener(new DownloadMP3());
    }

    class DownloadFile implements View.OnClickListener
    {

        @Override
        public void onClick(View view) {
            HttpDownloader httpDownloader = new HttpDownloader();
            String result = httpDownloader.download("");
            Log.d("lz",result);
        }
    }

    class DownloadMP3 implements View.OnClickListener
    {

        @Override
        public void onClick(View view) {
            HttpDownloader httpDownloader = new HttpDownloader();
            int result = httpDownloader.downloadFile("","","");
        }
    }
}
