package com.schoolar.modules.dao.Impl;

import com.schoolar.modules.dao.RatingDao;
import com.schoolar.modules.model.Rating;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ratingDao")
public class RatingDaoImpl implements RatingDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addRating(Rating rating) {
        sessionFactory.getCurrentSession().save(rating);
    }

    public Rating getOneRating(int ratingId) {
        Rating rating = (Rating) sessionFactory.getCurrentSession().get(Rating.class, ratingId);
        return rating;
    }

    public void deleteRating(int ratingId) {
       Rating rating = getOneRating(ratingId);
        if (rating != null)
            sessionFactory.getCurrentSession().delete(rating);
    }

    @SuppressWarnings("unchecked")
    public List<Rating> getRatingList() {
        return sessionFactory.getCurrentSession().createCriteria(Rating.class).list();
    }

}
