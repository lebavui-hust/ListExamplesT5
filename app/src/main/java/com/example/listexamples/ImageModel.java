package com.example.listexamples;

public class ImageModel {
    private String caption;
    private int thumbResource;
    private int wallResource;

    public ImageModel(String caption, int thumbResource, int wallResource) {
        this.caption = caption;
        this.thumbResource = thumbResource;
        this.wallResource = wallResource;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getThumbResource() {
        return thumbResource;
    }

    public void setThumbResource(int thumbResource) {
        this.thumbResource = thumbResource;
    }

    public int getWallResource() {
        return wallResource;
    }

    public void setWallResource(int wallResource) {
        this.wallResource = wallResource;
    }
}
