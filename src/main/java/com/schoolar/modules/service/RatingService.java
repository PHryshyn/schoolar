package com.schoolar.modules.service;

import com.schoolar.modules.model.Rating;

import java.util.List;


public interface RatingService extends BasicService<Rating, Integer>{

    public void updateRating(Rating rating);

}
