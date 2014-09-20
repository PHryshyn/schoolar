package com.schoolar.modules.service;

import com.schoolar.modules.model.Rating;

import java.util.List;


public interface RatingService{

    public void updateRating(Rating rating);
    public void saveRating(Rating rating);
    public List<Rating> getRatingListByDate();
    Rating findById(Integer ratingId);
    void delete(Integer ratingId);


}
