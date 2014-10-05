package com.schoolar.modules.dao.Impl;

import com.schoolar.modules.dao.RatingDao;
import com.schoolar.modules.model.Discipline;
import com.schoolar.modules.model.Rating;
import com.schoolar.modules.model.User;
import com.schoolar.modules.service.DisciplineService;
import com.schoolar.modules.service.UserService;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ratingDao")
public class RatingDaoImpl extends BasicCrudDaoImpl<Rating, Integer> implements RatingDao {

    @Autowired
    private DisciplineService disciplineService;

    @Autowired
    private UserService userService;

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

    @Override
    public void saveRating(Rating rating) {
        Discipline discipline = disciplineService.findById(rating.getDiscipline().getDisciplineId());
        User user = userService.findById(rating.getUser().getId());
        rating.setDiscipline(discipline);
        rating.setUser(user);
        save(rating);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Rating> getRatingListByDate() {

        return (List<Rating>) getCurrentSession().createCriteria(Rating.class).addOrder(Order.desc("ratingDate")).setMaxResults(50).list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Rating> getRatingListByUser() {
        Rating rating = new Rating();
        List ratingList = (List<Rating>) getCurrentSession().createCriteria(User.class)
                .add( Restrictions.eq("username",rating.getUser().getUsername()))
                .addOrder(Order.desc("ratingDate"))
                .list();
        return ratingList;
    }

}
