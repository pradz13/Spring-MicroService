package com.microservice.tutorial.ratingdataservice.model;

public class Rating {
    private String movieId;
    private String rating;

    public Rating(String movieId, String rating) {
        this.movieId = movieId;
        this.rating = rating;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "movieId='" + movieId + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}
