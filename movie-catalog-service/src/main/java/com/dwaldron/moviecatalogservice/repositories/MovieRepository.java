package com.dwaldron.moviecatalogservice.repositories;

import com.dwaldron.moviecatalogservice.repositories.messages.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.client.RestTemplate;

public class MovieRepository {
    private static final String MOVIES_BASE_URL = "http://localhost:8082";

    @Autowired
    private RestTemplate webClient;

    public Movie getMovie(Integer movieId) {
        return webClient.getForObject(
                MOVIES_BASE_URL + "/movies/" + movieId.toString(),
                Movie.class);
    }
}
