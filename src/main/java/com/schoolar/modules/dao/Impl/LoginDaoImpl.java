package com.schoolar.modules.dao.Impl;

import com.schoolar.modules.dao.LoginDao;
import com.schoolar.modules.model.Login;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addUsername(Login username) {
        sessionFactory.getCurrentSession().save(username);
    }
}
