package com.schoolar.modules.dao.Impl;

import com.schoolar.modules.dao.RatingDao;
import com.schoolar.modules.model.Rating;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ratingDao")
public class RatingDaoImpl extends BasicCrudDaoImpl<Rating, Integer> implements RatingDao {

    protected RatingDaoImpl() {
        super(Rating.class);
    }

    @Override
    public void updateRating(Rating rating) {
        Rating ratingToUpdate = findById(rating.getRatingId());
        ratingToUpdate.setRating(rating.getRating());
        ratingToUpdate.setRatingDate(rating.getRatingDate());
        ratingToUpdate.setUser(rating.getUser());
        ratingToUpdate.setDiscipline(rating.getDiscipline());
        update(rating);
    }

}
