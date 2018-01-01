package com.example.taren.moviereviews;

/**
 * Created by taren on 12/29/2017.
 */

public class Movie {



    String title;

    Long description;

    Integer rating;

    public Movie(String title, Long description, Integer rating) {
        this.title = title;
        this.description = description;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public Long getDescription() {
        return description;
    }

    public Integer getRating() {
        return rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(Long description) {
        this.description = description;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }




}
