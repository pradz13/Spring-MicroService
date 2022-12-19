package com.microservice.tutorial.moviecatalogservice.model;

public class MovieCatalogItem {
    private String movieName;
    private String description;
    private String rating;

    public MovieCatalogItem(String movieName, String description, String rating) {
        this.movieName = movieName;
        this.description = description;
        this.rating = rating;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getDescription() {
        return description;
    }

    public String getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "MovieCatalogItem{" +
                "movieName='" + movieName + '\'' +
                ", description='" + description + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}
