package com.schoolar.modules.dao.Impl;

import com.schoolar.modules.dao.HomeworkDao;
import com.schoolar.modules.model.Discipline;
import com.schoolar.modules.model.Homework;
import com.schoolar.modules.service.DisciplineService;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("homeworkDao")
public class HomeworkDaoImpl extends BasicCrudDaoImpl<Homework, Integer> implements HomeworkDao {

    @Autowired
    private DisciplineService disciplineService;

    protected HomeworkDaoImpl() {
        super(Homework.class);
    }

    @Override
    public void updateHomework(Homework homework) {
        //Discipline discipline = disciplineService.findById(homework.getDiscipline().getDisciplineId());
        Homework homeworkToUpdate = findById(homework.getHomeworkId());
        homeworkToUpdate.setHomework(homework.getHomework());
        homeworkToUpdate.setDiscipline(homework.getDiscipline());
        homeworkToUpdate.setHomeworkDate(homework.getHomeworkDate());
        update(homework);
    }

    @Override
    public void saveHomework(Homework homework) {
        Discipline discipline = disciplineService.findById(homework.getDiscipline().getDisciplineId());
        homework.setDiscipline(discipline);
        save(homework);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Homework> getHomeworkListByDate() {

        return (List<Homework>) getCurrentSession().createCriteria(Homework.class).addOrder(Order.desc("homeworkDate")).setMaxResults(50).list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Homework> getHomeworkListByDiscipline() {
        Homework homework = new Homework();
        List homeworkList1 = (List<Homework>) getCurrentSession().createCriteria(Homework.class)
                .add( Restrictions.like("discipline", homework.getDiscipline().getDiscipline()) )
                .addOrder(Order.asc("discipline"))
                .list();
        return homeworkList1;

    }
}
