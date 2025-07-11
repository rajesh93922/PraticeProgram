package com.javaassignment.collectionsassignment.model;

public class Content {
    private String text;
    private boolean isImage;

    public Content(){}

    public Content(String text, boolean isImage) {
        this.text = text;
        this.isImage = isImage;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isImage() {
        return isImage;
    }

    public void setImage(boolean image) {
        isImage = image;
    }
}
