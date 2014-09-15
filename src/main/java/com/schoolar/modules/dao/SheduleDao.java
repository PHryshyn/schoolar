package com.schoolar.modules.dao;


import com.schoolar.modules.model.Shedule;

public interface SheduleDao extends BasicCrudDao<Shedule, Integer> {

    void updateShedule(Shedule shedule);
}
