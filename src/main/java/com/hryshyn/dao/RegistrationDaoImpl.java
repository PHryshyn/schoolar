package com.hryshyn.dao;


import com.hryshyn.model.RegistrationModel;
import org.hibernate.*;

import org.hibernate.Session;
import java.sql.SQLException;

public class RegistrationDaoImpl implements RegistrationDao {

// Edit
    public RegistrationModel saveUsername(String username) throws SQLException {

        Session sess = factory.openSession();
        Transaction tx;
        try {
            tx = sess.beginTransaction();
            //do some work
            ...
            tx.commit();
        }
        catch (Exception e) {
            if (tx!=null) tx.rollback();
            throw e;
        }
        finally {
            sess.close();
        }
        username = getSessionFactory().openSession();
        username.beginTransaction();
        username.save(username);
        username.getTransaction().commit();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
