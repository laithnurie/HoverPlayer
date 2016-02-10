package com.sky.hoverplayer.data;

/**
 * Created by davidshalom on 10/02/16.
 */
public class Movie {

    String title;
    String imageUrl;
    String description;

    public Movie(String title, String description, String imageUrl ) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }
}
