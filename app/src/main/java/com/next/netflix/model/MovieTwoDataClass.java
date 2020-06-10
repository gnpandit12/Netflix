package com.next.netflix.model;

import android.graphics.drawable.Drawable;

public class MovieTwoDataClass {

    public Drawable getmMovieTwoImage() {
        return mMovieTwoImage;
    }

    public void setmMovieTwoImage(Drawable mMovieTwoImage) {
        this.mMovieTwoImage = mMovieTwoImage;
    }

    public String getmMovieTitle() {
        return mMovieTitle;
    }

    public void setmMovieTitle(String mMovieTitle) {
        this.mMovieTitle = mMovieTitle;
    }

    private Drawable mMovieTwoImage;
    private String mMovieTitle;



}
