package com.schoolar.modules.service;


import com.schoolar.modules.model.Homework;

import java.util.List;

public interface HomeworkService {

    public void updateHomework(Homework homework);
    void save(Homework homework);
    Homework findById(Integer homeworkId);
    void delete(Integer homeworkId);
    List<Homework> getList();
    public void saveHomework(Homework homework);
    List<Homework> getHomeworkListByDate();
    List<Homework> getHomeworkListByDiscipline();

}
