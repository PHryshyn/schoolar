package com.hryshyn.dao;

import com.hryshyn.model.UserModel;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl implements UserDao {
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public UserModel findByUserName(String username) {

        List<UserModel> users = new ArrayList<UserModel>();

        users = getSessionFactory().getCurrentSession()
                .createQuery("from User where username=?")
                .setParameter(0, username).list();

        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
