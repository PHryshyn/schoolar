package com.schoolar.modules.dao.Impl;


import com.schoolar.modules.dao.SheduleDao;
import com.schoolar.modules.model.Shedule;
import com.schoolar.modules.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SheduleDaoImpl extends BasicCrudDaoImpl<Shedule, Integer> implements SheduleDao {

    @Autowired
    private DisciplineService disciplineService;

    public SheduleDaoImpl() {
        super(Shedule.class);
    }

    @Override
    public void updateShedule(Shedule shedule) {
        Shedule sheduleToUpdate = findById(shedule.getSheduleId());
        sheduleToUpdate.setDisciplines(shedule.getDisciplines());
        update(sheduleToUpdate);
    }
}
