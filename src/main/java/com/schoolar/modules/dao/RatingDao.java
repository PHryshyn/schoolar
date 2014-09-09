package com.schoolar.modules.dao;

import com.schoolar.modules.model.Rating;

import java.util.List;

public interface RatingDao extends BasicCrudDao<Rating, Integer> {
    public void saveRating(Rating rating);
    public Rating findByIdRating(int ratingId);
    public void updateRating(Rating rating);
    public void deleteRating(int ratingId);
    public List<Rating> getRatingList();
}
