package com.example.taren.moviereviews;

/**
 * Created by taren on 12/29/2017.
 */

public class Movie {



    String title;

    String description;

    Integer rating;

    public Movie(){}

    public Movie(String title, String description, Integer rating) {
        this.title = title;
        this.description = description;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getRating() {
        return rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }




}
