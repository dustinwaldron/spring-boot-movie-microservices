package com.dwaldron.moviecatalogservice.repositories;

import com.dwaldron.moviecatalogservice.repositories.messages.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class RatingRepository {
    private static final String RATINGS_BASE_URL = "http://localhost:8083";

    @Autowired
    private RestTemplate webClient;

    public UserRating getUserRatings(Integer userId) {
        return webClient.getForObject(
                RATINGS_BASE_URL + "/ratings-data/user/" + userId.toString(),
                UserRating.class);
    }
}
