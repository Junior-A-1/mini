package com.maid.giproject;

public class Sport {
    private String name;
    private int imageRes;
    private boolean isFavorite;

    Sport(String name, int imageRes) {
        this.name = name;
        this.imageRes = imageRes;
        this.isFavorite = false;
    }

    public String getName() {
        return name;
    }

    public int getImageRes() {
        return imageRes;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
