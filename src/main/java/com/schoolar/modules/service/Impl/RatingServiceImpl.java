package com.schoolar.modules.service.Impl;


import com.schoolar.modules.dao.RatingDao;
import com.schoolar.modules.model.Rating;
import com.schoolar.modules.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("ratingService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RatingServiceImpl implements RatingService {

    @Autowired
    @Qualifier(value = "ratingDao")
    private RatingDao ratingDao;


    @Override
    @Transactional(readOnly = false)
    public void saveRating(Rating rating) {
        ratingDao.saveRating(rating);
    }

    @Override
    @Transactional
    public Rating findByIdRating(int ratingId) {
        return ratingDao.findByIdRating(ratingId);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteRating(int ratingId) {
        ratingDao.deleteRating(ratingId);
    }

    @Override
    @Transactional
    public List<Rating> getRatingList() {
        return ratingDao.getRatingList();
    }

    public RatingServiceImpl() {
    }
}
