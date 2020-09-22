package com.dwaldron.ratingsdataservice.controllers;

import com.dwaldron.ratingsdataservice.messages.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings-data")
public class RatingsDataController {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") int movieId) {
        return new Rating(2, 3);
    }
}
