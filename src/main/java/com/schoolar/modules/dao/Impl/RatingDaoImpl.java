package com.schoolar.modules.dao.Impl;

import com.schoolar.modules.dao.RatingDao;
import com.schoolar.modules.model.Rating;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ratingDao")
public class RatingDaoImpl extends BasicCrudDaoImpl<Rating, Integer> implements RatingDao {

    protected RatingDaoImpl() {
        super(Rating.class);
    }

    @Override
    public void saveRating(Rating rating) {
        save(rating);
    }

    @Override
    public Rating findByIdRating(int ratingId) {
        return findById(ratingId);
    }

    @Override
    public void updateRating(Rating rating) {
        Rating ratingToUpdate = findByIdRating(rating.getRatingId());
        ratingToUpdate.setRating(rating.getRating());
        ratingToUpdate.setRatingDate(rating.getRatingDate());
        ratingToUpdate.setUser(rating.getUser());
        ratingToUpdate.setDiscipline(rating.getDiscipline());
        update(rating);
    }

    @Override
    public void deleteRating(int ratingId) {
        Rating rating = findByIdRating(ratingId);
        if (rating != null)
            delete(rating);

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Rating> getRatingList() {
        return getCurrentSession().createCriteria(Rating.class).list();
    }
}
