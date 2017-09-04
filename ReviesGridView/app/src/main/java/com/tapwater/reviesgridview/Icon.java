package com.tapwater.reviesgridview;

/**
 * Created by Tapwater on 16-11-22.
 */

public class Icon {
    private int iconHead;
    private String iconName;

    public Icon() {
    }

    public Icon(int iconHead, String iconName) {

        this.iconHead = iconHead;
        this.iconName = iconName;
    }

    public int getIconHead() {

        return iconHead;
    }

    public void setIconHead(int iconHead) {
        this.iconHead = iconHead;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }
}
