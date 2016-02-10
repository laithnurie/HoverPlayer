package com.sky.hoverplayer.data;

/**
 * Created by davidshalom on 10/02/16.
 */
public class Movie {

    String title;
    String description;
    String imageUrl;
    String videoUrl;

    public Movie(String title, String description, String imageUrl , String videoUrl) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.videoUrl = videoUrl;

    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public String getTitle() {
        return title;
    }
}
