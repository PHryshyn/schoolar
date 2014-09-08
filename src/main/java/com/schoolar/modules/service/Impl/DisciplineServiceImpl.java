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
public class DisciplineServiceImpl implements DisciplineService {

    @Autowired
    @Qualifier(value = "disciplineDao")
    private DisciplineDao disciplineDao;

    @Override
    @Transactional(readOnly = false)
    public void saveDiscipline(Discipline discipline) {
        disciplineDao.saveDiscipline(discipline);
    }

    @Override
    @Transactional(readOnly = false)
    public void updateDiscipline(Discipline discipline) {
        disciplineDao.updateDiscipline(discipline);
    }

    @Override
    @Transactional
    public Discipline findByIdDiscipline(int disciplineId) {
        return disciplineDao.findByIdDiscipline(disciplineId);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteDiscipline(int disciplineId) {
        disciplineDao.deleteDiscipline(disciplineId);
    }

    @Override
    @Transactional
    public List<Discipline> getDisciplineList() {
        return disciplineDao.getDisciplineList();
    }

    public DisciplineServiceImpl() {
    }
}
