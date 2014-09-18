package com.schoolar.modules.dao;


import com.schoolar.modules.model.Homework;

public interface HomeworkDao extends BasicCrudDao<Homework, Integer> {

    public void updateHomework(Homework homework);

}
