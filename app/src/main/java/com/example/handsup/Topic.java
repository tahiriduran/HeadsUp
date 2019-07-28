package com.example.handsup;

public class Topic {
    private String name;
    private int image;

    Topic(String name) {
        this.name = name;
    }

    Topic() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
