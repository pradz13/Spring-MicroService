package com.microservice.tutorial.moviecatalogservice.model;

public class Movie {
    private String id;
    private String name;

    public Movie() {

    }

    public Movie(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
