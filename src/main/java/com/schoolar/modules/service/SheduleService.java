package com.schoolar.modules.service;


import com.schoolar.modules.model.Shedule;

import java.util.List;

public interface SheduleService {
    void updateShedule(Shedule shedule);
    List<Shedule> getList();
    void save(Shedule shedule);
    void delete(Integer sheduleId);
}
