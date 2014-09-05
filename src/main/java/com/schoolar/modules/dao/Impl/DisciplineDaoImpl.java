package com.schoolar.modules.dao.Impl;

import com.schoolar.modules.dao.CrudInterface;
import com.schoolar.modules.dao.DisciplineDao;
import com.schoolar.modules.model.Discipline;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("disciplineDao")
public class DisciplineDaoImpl implements DisciplineDao {

    @Autowired
    private SessionFactory sessionFactory;



    public void update(Discipline discipline) {
        Discipline disciplineToUpdate = getOne(discipline.getDisciplineId());
        disciplineToUpdate.setDiscipline(discipline.getDiscipline());
        sessionFactory.getCurrentSession().update(disciplineToUpdate);

    }

    @Override
    public void add(Discipline discipline) {
        sessionFactory.getCurrentSession().save(discipline);

    }


    @Override
    public Discipline getOne(int disciplineId) {
        Discipline discipline = (Discipline) sessionFactory.getCurrentSession().get(Discipline.class, disciplineId);
        return discipline;
    }

    @Override
    public void delete(int disciplineId) {
        Discipline discipline = getOne(disciplineId);
        if (discipline != null)
            sessionFactory.getCurrentSession().delete(discipline);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Discipline> getList() {
        return sessionFactory.getCurrentSession().createCriteria(Discipline.class).list();
    }
}
