package com.dwaldron.ratingsdataservice.messages;

import java.util.Arrays;
import java.util.List;

public class UserRating {

    private int userId;
    private List<Rating> ratings;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public void initData(int userId) {
        this.setUserId(userId);
        this.setRatings(Arrays.asList(
                new Rating(1, 3),
                new Rating(2, 4),
                new Rating(3, 5)
        ));
    }
}
