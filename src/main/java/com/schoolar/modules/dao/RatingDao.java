package com.schoolar.modules.dao;

import com.schoolar.modules.model.Rating;

import java.util.List;

public interface RatingDao extends BasicCrudDao<Rating, Integer> {

    public void updateRating(Rating rating);
    public void saveRating(Rating rating);
    public List<Rating> getRatingListByDate();
    public List<Rating> getRatingListByUser();

}
