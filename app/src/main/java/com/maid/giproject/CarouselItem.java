package com.maid.giproject;

public class CarouselItem {
    private String text;
    private int imageResId;

    public CarouselItem(String text, int imageResId) {
        this.text = text;
        this.imageResId = imageResId;
    }

    public String getText() {
        return text;
    }

    public int getImageResId() {
        return imageResId;
    }
}
