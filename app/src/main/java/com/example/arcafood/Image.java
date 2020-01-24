package com.example.arcafood;

public class Image {

    private int mText;

    private int mImage;

    public Image(int text,int image) {
        mText = text;
        mImage = image;
    }

    public int getImage() {
       return mImage;
    }

    public int getText() {
        return mText;
    }
}
