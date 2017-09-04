package com.tapwater.learn_30_downloadfile.com.tapwater.utils;

import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Tapwater on 16-1-20.
 */
public class FileUtils {
    private String SDPATH;

    public String getSDPATH()
    {
        return SDPATH;
    }

    public FileUtils()
    {
        SDPATH = Environment.getExternalStorageDirectory() + "/";
    }

    public File createFileOnSD(String fileName)
    {
        File file = new File(SDPATH + fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public File createDirOnSD(String fileAddress)
    {
        File file = new File(fileAddress);
        file.mkdir();
        return file;
    }

    public boolean checkFileExist(String fileName)
    {
        File file = new File(SDPATH + fileName);
        return file.exists();

    }

    public File writeToSDFromInput(String fileAddress, String fileName, InputStream inputStream)
    {
        File file = null;
        OutputStream outputStream =null;
        try {
            //create
            createDirOnSD(fileAddress);
            file = new File(fileAddress + fileName);
            outputStream = new FileOutputStream(file);
            byte[] buffer = new byte[4 * 1024];
            while ((inputStream.read(buffer)) != -1)
            {
                outputStream.write(buffer);
            }
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }
}
