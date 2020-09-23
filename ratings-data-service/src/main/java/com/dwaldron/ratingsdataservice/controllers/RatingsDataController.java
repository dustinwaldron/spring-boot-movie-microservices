package com.dwaldron.ratingsdataservice.controllers;

import com.dwaldron.ratingsdataservice.messages.Rating;
import com.dwaldron.ratingsdataservice.messages.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings-data")
public class RatingsDataController {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") Integer movieId) {
        return new Rating(movieId, (int)(Math.random() * 5));
    }

    @RequestMapping("/user/{userId}")
    public UserRating getUserRatings(@PathVariable("userId") Integer userId) {
        UserRating userRating = new UserRating();
        userRating.initData(userId);
        return userRating;
    }
}
