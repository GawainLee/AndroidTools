package com.tapwater.revisebaseadapterbugtext;

/**
 * Created by Tapwater on 16-11-16.
 */

public class ListItem {
    private int head;
    private String editText;
    private boolean checkBox;

    private boolean isFocus =false;

    public ListItem() {
    }

    public ListItem(boolean checkBox, String editText, int head) {
        this.checkBox = checkBox;
        this.editText = editText;
        this.head = head;
    }

    public boolean isCheckBox() {
        return checkBox;
    }

    public void setCheckBox(boolean checkBox) {
        this.checkBox = checkBox;
    }

    public String getEditText() {
        return editText;
    }

    public void setEditText(String editText) {
        this.editText = editText;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public boolean isFocus() {
        return isFocus;
    }

    public void setFocus(boolean focus) {
        isFocus = focus;
    }
}
