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
    public void updateDiscipline(Discipline discipline) {
        Discipline disciplineToUpdate = findById(discipline.getDisciplineId());
        disciplineToUpdate.setDiscipline(discipline.getDiscipline());
        update(disciplineToUpdate);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Discipline> disciplineList() {
      //  return  getCurrentSession().createCriteria(Discipline.class).list();
      return (List<Discipline>)  getCurrentSession().createCriteria(Discipline.class).list();
    }
}
