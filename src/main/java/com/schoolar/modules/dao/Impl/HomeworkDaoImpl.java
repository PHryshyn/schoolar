package com.schoolar.modules.dao.Impl;

import com.schoolar.modules.dao.HomeworkDao;
import com.schoolar.modules.model.Homework;
import org.springframework.stereotype.Repository;

@Repository("homeworkDao")
public class HomeworkDaoImpl extends BasicCrudDaoImpl<Homework, Integer> implements HomeworkDao {

    protected HomeworkDaoImpl() {
        super(Homework.class);
    }

    @Override
    public void updateHomework(Homework homework) {
        Homework homeworkToUpdate = findById(homework.getHomeworkId());
        homeworkToUpdate.setHomework(homework.getHomework());
        homeworkToUpdate.setHomework(homework.getHomework());
        homeworkToUpdate.setDiscipline(homework.getDiscipline());
        homeworkToUpdate.setHomeworkDate(homework.getHomeworkDate());
        update(homework);
    }

}
