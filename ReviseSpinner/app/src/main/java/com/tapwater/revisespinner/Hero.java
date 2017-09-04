package com.tapwater.revisespinner;

/**
 * Created by Tapwater on 16-11-23.
 */

public class Hero {
    private int heroIcon;
    private String heroName;

    public Hero() {
    }

    public Hero(int heroIcon, String heroName) {

        this.heroIcon = heroIcon;
        this.heroName = heroName;
    }

    public int getHeroIcon() {

        return heroIcon;
    }

    public void setHeroIcon(int heroIcon) {
        this.heroIcon = heroIcon;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }
}
