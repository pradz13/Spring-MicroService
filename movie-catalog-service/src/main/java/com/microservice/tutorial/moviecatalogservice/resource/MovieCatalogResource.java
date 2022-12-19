package com.microservice.tutorial.moviecatalogservice.resource;

import com.microservice.tutorial.moviecatalogservice.model.Movie;
import com.microservice.tutorial.moviecatalogservice.model.MovieCatalogItem;
import com.microservice.tutorial.moviecatalogservice.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/movies")
    public List<MovieCatalogItem> getMovieCatalog() {
        List<String> movieIds = List.of("1234", "2456", "6789");
        return movieIds.stream().map(movieId -> {
            Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + movieId, Movie.class);

            Rating rating = webClientBuilder
                    .build()
                    .get()
                    .uri("http://localhost:8083/rating-data/" +  movieId)
                    .retrieve()
                    .bodyToMono(Rating.class)
                    .block();

            return new MovieCatalogItem(Objects.requireNonNull(movie).getName(), "Desc", Objects.requireNonNull(rating).getRating());
        }).collect(Collectors.toList());

    }
}
