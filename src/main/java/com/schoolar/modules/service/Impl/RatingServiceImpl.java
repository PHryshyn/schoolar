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

    public RatingServiceImpl() {
    }

    @Transactional(readOnly = false)
    @Override
    public void updateRating(Rating rating) {
        ratingDao.updateRating(rating);
    }

    @Transactional(readOnly = false)
    @Override
    public void saveRating(Rating rating) {
        ratingDao.saveRating(rating);
    }

    @Transactional
    @Override
    public List<Rating> getRatingListByDate() {
        return ratingDao.getRatingListByDate();
    }

    @Transactional
    @Override
    public Rating findById(Integer ratingId) {
        return ratingDao.findById(ratingId);
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(Integer ratingId) {
        ratingDao.delete(ratingId);
    }

    @Transactional
    @Override
    public List<Rating> getRatingListByUser() {
        return ratingDao.getRatingListByUser();
    }
}
