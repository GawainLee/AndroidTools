package com.tapwater.download;

import com.tapwater.utils.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Tapwater on 16-1-25.
 */
public class HttpDownloader {

    private String urlStr;
    public HttpDownloader () {}

    /**
     * download function (only type in text, XML and so on)
     * download from url address in String
     * use http url connection to download
     * @param urlStr
     * @return
     */
    public String download(String urlStr) {
        StringBuffer stringBuffer = new StringBuffer();
        String line = null;
        BufferedReader bufferedReader = null;

        try {
//            URL url = new URL(urlStr);
//            URLConnection httpURLConnection = (URLConnection) url.openConnection();
//            bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            bufferedReader = new BufferedReader(new InputStreamReader(getInputStreamFromURL(urlStr)));
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuffer.toString();
    }

    /**
     * download file function and save file into SD card
     * input URL address, file save dir location and file name
     * return 1: file already exists
     * return -1: download file error
     * return 0: file download success
     *
     * @param urlStr
     * @param path
     * @param fileName
     * @return
     */
    public int downFile(String urlStr, String path, String fileName) {
        InputStream inputStream = null;
        FileUtils fileUtils = new FileUtils();
        if (fileUtils.isFileExist(fileName, path)) {
            return 1;
        } else {
            try {
                inputStream = getInputStreamFromURL(urlStr);
                File resultFile = fileUtils.writeIntoSDFromInputString(path, fileName, inputStream);
                if (resultFile == null) {
                    return -1;
                }
            } catch (IOException e) {
                e.printStackTrace();
                return -1;
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }

    /**
     * get inputStream for URL address
     * @param urlStr
     * @return
     * @throws IOException
     */
    public InputStream getInputStreamFromURL(String urlStr) throws IOException {
        URL url = null;
        url = new URL(urlStr);
        URLConnection httpURLConnection = (URLConnection) url.openConnection();
        InputStream inputStream =  httpURLConnection.getInputStream();
        return inputStream;
    }
}
