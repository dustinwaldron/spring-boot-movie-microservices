package com.dwaldron.moviecatalogservice.repositories;

import com.dwaldron.moviecatalogservice.repositories.messages.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class MovieRepository {
    private static final String MOVIES_BASE_URL = "http://localhost:8082";

    @Autowired
    private final RestTemplate webClient;

    public Movie getMovie(int movieId) {
        
    }
}
