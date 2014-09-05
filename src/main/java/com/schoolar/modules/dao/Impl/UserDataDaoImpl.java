package com.schoolar.modules.dao.Impl;

import com.schoolar.modules.dao.UserDataDao;
import com.schoolar.modules.model.UserData;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDataDao")
public class UserDataDaoImpl implements UserDataDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addUserData(UserData userData) {
        sessionFactory.getCurrentSession().save(userData);
    }

    public void updateUserData(UserData userData) {
        UserData userDataToUpdate = getOneUserData(userData.getId());
        userDataToUpdate.setLastName(userData.getLastName());
        sessionFactory.getCurrentSession().update(userDataToUpdate);

    }

    public UserData getOneUserData(int id) {
        UserData userData = (UserData) sessionFactory.getCurrentSession().get(UserData.class, id);
        return userData;
    }

    public void deleteUserData(int id) {
        UserData userData = getOneUserData(id);
        if (userData != null)
            sessionFactory.getCurrentSession().delete(userData);
    }

    @SuppressWarnings("unchecked")
    public List<UserData> getUserData() {
        return sessionFactory.getCurrentSession().createCriteria(UserData.class).list();
    }

}
