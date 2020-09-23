package com.dwaldron.moviecatalogservice.controllers;

import com.dwaldron.moviecatalogservice.messages.CatalogItem;
import com.dwaldron.moviecatalogservice.repositories.MovieRepository;
import com.dwaldron.moviecatalogservice.repositories.RatingRepository;
import com.dwaldron.moviecatalogservice.repositories.messages.Movie;
import com.dwaldron.moviecatalogservice.repositories.messages.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movie-catalog")
public class MovieCatalogController {
    private MovieRepository movieRepository;
    private RatingRepository ratingRepository;

    @Autowired
    public MovieCatalogController(MovieRepository movieRepository, RatingRepository ratingRepository) {
        this.movieRepository = movieRepository;
        this.ratingRepository = ratingRepository;
    }

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") Integer userId) {
        UserRating userRating = ratingRepository.getUserRatings(userId);
        return userRating.getRatings().stream()
                .map(rating -> {
                    Movie movie = movieRepository.getMovie(rating.getMovieId());
                    return new CatalogItem(movie.getTitle(), movie.getDescription(), rating.getRating());
                })
                .collect(Collectors.toList());
    }
}
