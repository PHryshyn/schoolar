package com.schoolar.modules.service.Impl;


import com.schoolar.modules.dao.Impl.SheduleDaoImpl;
import com.schoolar.modules.model.Shedule;
import com.schoolar.modules.service.SheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SheduleServiceImpl implements SheduleService {

    public SheduleServiceImpl() {
    }

    @Autowired
    private SheduleDaoImpl sheduleDao;

    @Override
    public void updateShedule(Shedule shedule) {
        sheduleDao.updateShedule(shedule);
    }

    @Override
    public List<Shedule> getList() {
        return sheduleDao.getList();
    }

    @Override
    public void save(Shedule shedule) {
        sheduleDao.save(shedule);
    }

    @Override
    public void delete(Integer sheduleId) {
        sheduleDao.delete(sheduleId);
    }
}
