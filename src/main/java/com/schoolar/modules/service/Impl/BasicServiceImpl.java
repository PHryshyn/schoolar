package com.schoolar.modules.service.Impl;

import com.schoolar.modules.dao.BasicCrudDao;
import com.schoolar.modules.service.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

public class BasicServiceImpl <E, I extends Serializable> implements BasicService<E, I> {

//    @Autowired
//    @Qualifier(value = "basicCrudDao")
    private BasicCrudDao basicCrudDao;

    public BasicServiceImpl() {
    }

    @Override
    @Transactional(readOnly = false)
    public void save(E e) {
        basicCrudDao.save(e);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(E e) {
        basicCrudDao.update(e);
    }

    @Override
    @Transactional
    public E findById(I id) {
        return (E) basicCrudDao.findById(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(I id) {
      basicCrudDao.delete(id);
    }

    @Override
    @Transactional
    public List<E> getList() {
        return basicCrudDao.getList();
    }
}
