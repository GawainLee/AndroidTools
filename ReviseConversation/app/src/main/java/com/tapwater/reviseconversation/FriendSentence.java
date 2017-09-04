package com.tapwater.reviseconversation;

/**
 * Created by Tapwater on 16-11-18.
 */

public class FriendSentence {
    private int imgHead;
    private String sentence;

    public int getImgHead() {
        return imgHead;
    }

    public void setImgHead(int imgHead) {
        this.imgHead = imgHead;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public FriendSentence(int imgHead, String sentence) {

        this.imgHead = imgHead;
        this.sentence = sentence;
    }

    public FriendSentence() {

    }
}
