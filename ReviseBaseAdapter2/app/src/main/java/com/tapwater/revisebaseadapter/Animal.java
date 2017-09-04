package com.tapwater.revisebaseadapter;

/**
 * Created by Tapwater on 16-11-16.
 */

public class Animal {

    private String name;
    private String said;
    private int head;

    public Animal() {
    }

    public Animal(int head, String name, String said) {
        this.head = head;
        this.name = name;
        this.said = said;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSaid() {
        return said;
    }

    public void setSaid(String said) {
        this.said = said;
    }
}
