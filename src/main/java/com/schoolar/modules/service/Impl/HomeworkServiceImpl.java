package com.schoolar.modules.service.Impl;


import com.schoolar.modules.dao.HomeworkDao;
import com.schoolar.modules.model.Homework;
import com.schoolar.modules.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("notesService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class HomeworkServiceImpl implements HomeworkService {

    @Autowired
    @Qualifier(value = "homeworkDao")
    private HomeworkDao homeworkDao;

    public HomeworkServiceImpl() {
    }

    @Override
    @Transactional(readOnly = false)
    public void updateHomework(Homework homework) {
        homeworkDao.updateHomework(homework);
    }

    @Override
    public void save(Homework homework) {
        homeworkDao.save(homework);
    }

    @Override
    public Homework findById(Integer homeworkId) {
        return homeworkDao.findById(homeworkId);
    }

    @Override
    public void delete(Integer homeworkId) {
        homeworkDao.delete(homeworkId);
    }

    @Override
    public List<Homework> getList() {
        return homeworkDao.getList();
    }
}
