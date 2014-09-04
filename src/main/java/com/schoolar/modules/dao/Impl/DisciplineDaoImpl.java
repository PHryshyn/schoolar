package com.schoolar.modules.dao.Impl;

import com.schoolar.modules.dao.DisciplineDao;
import com.schoolar.modules.model.Discipline;
import com.schoolar.modules.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("disciplineDao")
public class DisciplineDaoImpl implements DisciplineDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addDiscipline(Discipline discipline) {
        sessionFactory.getCurrentSession().save(discipline);
    }

    public void updateDiscipline(Discipline discipline) {
        Discipline disciplineToUpdate = getDiscipline(discipline.getDisciplineId());
        disciplineToUpdate.setDiscipline(discipline.getDiscipline());
        sessionFactory.getCurrentSession().update(disciplineToUpdate);

    }

    public Discipline getDiscipline(int disciplineId) {
        Discipline discipline = (Discipline) sessionFactory.getCurrentSession().get(Discipline.class, disciplineId);
        return discipline;
    }

    public void deleteDiscipline(int disciplineId) {
        Discipline discipline = getDiscipline(disciplineId);
        if (discipline != null)
            sessionFactory.getCurrentSession().delete(discipline);
    }

    @SuppressWarnings("unchecked")
    public List<Discipline> getDisciplines() {
        return sessionFactory.getCurrentSession().createCriteria(Discipline.class).list();
    }

}
