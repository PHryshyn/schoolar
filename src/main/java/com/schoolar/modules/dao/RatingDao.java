package com.schoolar.modules.dao;

import com.schoolar.modules.model.Rating;

import java.util.List;

public interface RatingDao {
    public void addRating(Rating rating);
    public Rating getOneRating(int ratingId);
    public void deleteRating(int RatingId);
    public List<Rating> getRatingList();
}
