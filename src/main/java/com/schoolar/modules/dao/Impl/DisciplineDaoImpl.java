package com.schoolar.modules.dao.Impl;

import com.schoolar.modules.dao.DisciplineDao;
import com.schoolar.modules.model.Discipline;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("disciplineDao")
public class DisciplineDaoImpl extends BasicCrudDaoImpl<Discipline, Integer> implements DisciplineDao {

    private static final Logger logger = LoggerFactory.getLogger(DisciplineDaoImpl.class);
    public DisciplineDaoImpl() {
        super(Discipline.class);
    }


    @Override
    public void updateDiscipline(Discipline discipline) {
        logger.info("Starting update discipline");
        Discipline disciplineToUpdate = findById(discipline.getDisciplineId());
        disciplineToUpdate.setDiscipline(discipline.getDiscipline());
        update(disciplineToUpdate);
        logger.info("Discipline updated successfully, Discipline Details="+disciplineToUpdate);

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Discipline> disciplineList() {

      //  return  getCurrentSession().createCriteria(Discipline.class).list();
      return (List<Discipline>)  getCurrentSession().createCriteria(Discipline.class).list();

    }
}
