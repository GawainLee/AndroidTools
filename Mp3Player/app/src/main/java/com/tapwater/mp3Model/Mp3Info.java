package com.tapwater.mp3Model;

import java.io.Serializable;

/**
 * Created by Tapwater on 16-1-26.
 */
public class Mp3Info implements Serializable{

    private String id, mp3Name, mp3Size, lrcName, lrcSize;

    public Mp3Info(String id, String lrcName, String lrcSize, String mp3Name, String mp3Size) {
        this.id = id;
        this.lrcName = lrcName;
        this.lrcSize = lrcSize;
        this.mp3Name = mp3Name;
        this.mp3Size = mp3Size;
    }

    public Mp3Info() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLrcName() {
        return lrcName;
    }

    public void setLrcName(String lrcName) {
        this.lrcName = lrcName;
    }

    public String getLrcSize() {
        return lrcSize;
    }

    public void setLrcSize(String lrcSize) {
        this.lrcSize = lrcSize;
    }

    public String getMp3Name() {
        return mp3Name;
    }

    public void setMp3Name(String mp3Name) {
        this.mp3Name = mp3Name;
    }

    public String getMp3Size() {
        return mp3Size;
    }

    public void setMp3Size(String mp3Size) {
        this.mp3Size = mp3Size;
    }

    @Override
    public String toString() {
        return " id = " + id + " mp3Name = " + mp3Name + " mp3Size = " + mp3Size + " lrcName = " + lrcName + " lrcSize = " + lrcSize;
    }
}

