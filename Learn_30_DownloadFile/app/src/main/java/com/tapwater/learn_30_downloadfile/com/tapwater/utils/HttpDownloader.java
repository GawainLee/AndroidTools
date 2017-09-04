package com.tapwater.learn_30_downloadfile.com.tapwater.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Tapwater on 16-1-20.
 */
public class HttpDownloader {
    private URL url = null;

    /**
     * download file from the Internet by Http, download file only can be file-type
     * @param urlAddress
     * @return
     */
    public String download(String urlAddress)
    {
        StringBuffer stringBuffer = new StringBuffer();
        String line = null;
        BufferedReader bufferedReader = null;
        try {
            //create URL object
            url = new URL(urlAddress);
            //get http URL connection to internet
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            //get bufferReader from httpConnection
            bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            //check read and save bufferReader line by line
            while ((line = bufferedReader.readLine()) != null)
            {
                stringBuffer.append(line);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //finally clean bufferReader
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuffer.toString();
    }

    public int downloadFile(String urlAddress, String fileAddress, String fileName)
    {
        InputStream inputStream = null;
        FileUtils fileUtils = new FileUtils();
        try {
        if (fileUtils.checkFileExist(urlAddress + fileName))
        {
            return 1;
        }
        else
        {
                inputStream =getInputStreamFromURL(fileAddress);
            File fileResult = fileUtils.writeToSDFromInput(urlAddress,fileName,inputStream);
            if (fileResult == null)
            {
                return -1;
            }
        }
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
        finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public InputStream getInputStreamFromURL(String URLAddress) throws IOException
    {
        url = new URL(URLAddress);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        InputStream inputStream = httpURLConnection.getInputStream();
        return inputStream;
    }
}
