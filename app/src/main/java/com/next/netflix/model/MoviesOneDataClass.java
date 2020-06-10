package com.next.netflix.model;

import android.graphics.drawable.Drawable;

public class MoviesOneDataClass {

    public Drawable getMovieImageDrawable() {
        return movieImageDrawable;
    }

    public void setMovieImageDrawable(Drawable movieImageDrawable) {
        this.movieImageDrawable = movieImageDrawable;
    }

    public String getMovieOneTitle() {
        return movieOneTitle;
    }

    public void setMovieOneTitle(String movieOneTitle) {
        this.movieOneTitle = movieOneTitle;
    }

    Drawable movieImageDrawable;
    String movieOneTitle;

}
