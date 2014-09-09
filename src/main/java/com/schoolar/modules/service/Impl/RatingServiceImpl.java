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
public class RatingServiceImpl extends BasicServiceImpl<Rating, Integer> implements RatingService {

    @Autowired
    @Qualifier(value = "ratingDao")
    private RatingDao ratingDao;

    public RatingServiceImpl() {
    }

    @Override
    public void updateRating(Rating rating) {
        ratingDao.updateRating(rating);
    }
}
