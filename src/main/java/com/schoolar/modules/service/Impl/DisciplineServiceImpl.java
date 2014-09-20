package com.schoolar.modules.service.Impl;

import com.schoolar.modules.dao.DisciplineDao;
import com.schoolar.modules.model.Discipline;
import com.schoolar.modules.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("disciplineService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DisciplineServiceImpl  implements DisciplineService {

    public DisciplineServiceImpl() {
    }

    @Autowired
    @Qualifier(value = "disciplineDao")
    private DisciplineDao disciplineDao;

    @Override
    @Transactional(readOnly = false)
    public void updateDiscipline(Discipline discipline) {
        disciplineDao.updateDiscipline(discipline);
    }

    @Transactional
    public List<Discipline> disciplineList() {
        return disciplineDao.disciplineList();
    }

    @Transactional(readOnly = false)
    @Override
    public void save(Discipline discipline) {
        disciplineDao.save(discipline);
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(Integer disciplineId) {
        disciplineDao.delete(disciplineId);
    }

    @Transactional
    @Override
    public Discipline findById(Integer disciplineId) {
        return disciplineDao.findById(disciplineId);
    }

    @Transactional
    @Override
    public List<Discipline> getList() {
        return disciplineDao.getList();
    }
}
