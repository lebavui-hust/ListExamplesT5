package com.example.listexamples;

public class ItemModel {
    private int imageResource;
    private String title;
    private boolean isSelected;

    public ItemModel(int imageResource, String title) {
        this.imageResource = imageResource;
        this.title = title;
        this.isSelected = false;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
