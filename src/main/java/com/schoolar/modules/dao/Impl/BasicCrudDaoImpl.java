package com.schoolar.modules.dao.Impl;


import com.schoolar.modules.dao.BasicCrudDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class BasicCrudDaoImpl<E, I extends Serializable> implements BasicCrudDao<E, I> {

    private Class<E> entityClass;

    protected BasicCrudDaoImpl(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public void save(E e) {
        getCurrentSession().save(e);
    }

    @Override
    public void update(E e) {
        getCurrentSession().update(e);
    }

    @Override
    public E findById(I id) {
        return (E) getCurrentSession().get(entityClass, id);
    }

    @Override
    public void delete(E e) {
        getCurrentSession().delete(e);
    }


}
