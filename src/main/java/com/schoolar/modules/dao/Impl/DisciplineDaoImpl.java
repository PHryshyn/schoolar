package com.schoolar.modules.dao.Impl;

import com.schoolar.modules.dao.DisciplineDao;
import com.schoolar.modules.model.Discipline;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("disciplineDao")
public class DisciplineDaoImpl extends BasicCrudDaoImpl<Discipline, Integer> implements DisciplineDao {

    public DisciplineDaoImpl() {
        super(Discipline.class);
    }


    @Override
    public void saveDiscipline(Discipline discipline) {
        save(discipline);
    }

    @Override
    public void updateDiscipline(Discipline discipline) {
        update(discipline);
    }

    @Override
    public Discipline findByIdDiscipline(int disciplineId) {
        return findById(disciplineId);
    }

    @Override
    public void deleteDiscipline(int disciplineId) {
        Discipline discipline = findByIdDiscipline(disciplineId);
        if (discipline != null)
        delete(discipline);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Discipline> getDisciplineList() {
        return getCurrentSession().createCriteria(Discipline.class).list();
    }
}
