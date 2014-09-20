package com.schoolar.modules.dao;


import com.schoolar.modules.model.Homework;

import java.util.List;

public interface HomeworkDao extends BasicCrudDao<Homework, Integer> {

    public void updateHomework(Homework homework);
    public void saveHomework(Homework homework);
    List<Homework> getHomeworkListByDate();
    List<Homework> getHomeworkListByDiscipline();

}
