package com.schoolar.modules.dao.Impl;


import com.schoolar.modules.dao.BasicCrudDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.metamodel.source.annotations.entity.EntityClass;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

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
    public void delete(I id) {
        E e = findById(id);
        if (e != null)
        getCurrentSession().delete(e);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<E> getList() {
        return (List<E>) getCurrentSession().createCriteria(EntityClass.class).list();
    }


}
