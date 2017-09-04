package com.tapwater.utils;

import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Tapwater on 16-2-4.
 */
public class FileUtils {

    private String SDCardRoot;

    /**
     * create FileUtils and get the location of SD Card
     */
    public FileUtils()
    {
        //get the SD card root location
        SDCardRoot = Environment.getExternalStorageDirectory().getAbsolutePath()+ File.separator;
    }

    /**
     * create file in SD Card, input file name and location of saving file
     * @param fileName
     * @param dir
     * @return
     * @throws IOException
     */
    public File createFileInSDCard(String fileName, String dir) throws IOException {
        File file = new File(SDCardRoot + dir + File.separator + fileName);
        file.createNewFile();
        return file;
    }

    /**
     * create file dir from String dir
     * @param dir
     * @return
     */
    public File createSDDir(String dir)
    {
        File file = new File(SDCardRoot + dir + File.separator);
        System.out.println(file.mkdirs());
        return file;
    }

    /**
     * check file exist or not
     * @param fileName
     * @param path
     * @return
     */
    public boolean isFileExist(String fileName, String path)
    {
        File file = new File(SDCardRoot + path + File.separator + fileName);
        return file.exists();
    }

    /**
     * write InputString into SD card file
     * @param path
     * @param fileName
     * @param inputStream
     * @return
     */
    public File writeIntoSDFromInputString(String path, String fileName, InputStream inputStream)
    {
        File file = null;
        OutputStream outputStream = null;
        try {
            createSDDir(path);
            file = createFileInSDCard(fileName,path);
            outputStream = new FileOutputStream(file);
            //input buffer
            byte[] buffer = new byte[ 4 * 1024 ];
            int temp;
            while ((temp = inputStream.read(buffer)) != -1)
            {
                outputStream.write(buffer,0,temp);
            }
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }
}
