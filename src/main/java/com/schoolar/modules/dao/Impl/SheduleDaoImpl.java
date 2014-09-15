package com.schoolar.modules.dao.Impl;


import com.schoolar.modules.dao.SheduleDao;
import com.schoolar.modules.model.Shedule;
import org.springframework.stereotype.Repository;

@Repository
public class SheduleDaoImpl extends BasicCrudDaoImpl<Shedule, Integer> implements SheduleDao {

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
