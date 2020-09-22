package com.dwaldron.moviecatalogservice.controllers;

import com.dwaldron.moviecatalogservice.messages.CatalogItem;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/movie-catalog")
public class MovieCatalogController {

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        return Arrays.asList(
                new CatalogItem("Lego Movie", "legos in a movie", 5),
                new CatalogItem("The Dark Knight", "another batman movie", 4),
                new CatalogItem("The Room", "best worst movie ever", 1)
        );
    }
}
