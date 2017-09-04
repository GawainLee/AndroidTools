package com.tapwater.reviseexpanablelistview;

/**
 * Created by Tapwater on 16-11-23.
 */

public class Item {
    private int heroHead;
    private String heroName;

    public Item() {
    }

    public Item(int heroHead, String heroName) {

        this.heroHead = heroHead;
        this.heroName = heroName;
    }

    public int getHeroHead() {

        return heroHead;
    }

    public void setHeroHead(int heroHead) {
        this.heroHead = heroHead;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }
}
