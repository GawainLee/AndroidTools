package com.tapwater.learn_22_baseadapter;

/**
 * Created by Tapwater on 15-12-28.
 */
public class ItemBean {

    private int itemImageSrc;
    private String itemTitle;
    private String itemContent;

    public ItemBean(String itemTitle, int itemImageSrc, String itemContent) {
        this.itemContent = itemContent;
        this.itemImageSrc = itemImageSrc;
        this.itemTitle = itemTitle;
    }

    public String getItemContent() {
        return itemContent;
    }

    public void setItemContent(String itemContent) {
        this.itemContent = itemContent;
    }

    public int getItemImageSrc() {
        return itemImageSrc;
    }

    public void setItemImageSrc(int itemImageSrc) {
        this.itemImageSrc = itemImageSrc;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }
}
