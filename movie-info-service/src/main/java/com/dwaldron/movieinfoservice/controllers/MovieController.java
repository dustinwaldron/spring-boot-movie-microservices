package com.dwaldron.movieinfoservice.controllers;

import com.dwaldron.movieinfoservice.messages.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") Integer movieId) {
        List<Movie> movies = Arrays.asList(
                new Movie(1, "Lego Movie", "legos in a movie"),
                new Movie(2, "The Dark Knight", "another batman movie"),
                new Movie(3, "The Room", "best worst movie ever")
        );
        return movies.stream()
                .filter(movie -> movie.getId() == movieId)
                .findFirst()
                .orElse(movies.get(0));
    }
}
