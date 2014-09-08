package com.schoolar.modules.service;

import com.schoolar.modules.model.Rating;

import java.util.List;


public interface RatingService {
    public void saveRating(Rating rating);
    public Rating findByIdRating(int ratingId);
    public void deleteRating(int ratingId);
    public List<Rating> getRatingList();
}
