package com.schoolar.modules.dao.Impl;

import com.schoolar.modules.dao.UserDataDao;
import com.schoolar.modules.model.UserData;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDataDao")
public class UserDataDaoImpl extends BasicCrudDaoImpl<UserData, Integer> implements UserDataDao {

    protected UserDataDaoImpl() {
        super(UserData.class);
    }

    @Override
    public void saveUserData(UserData userData) {
        save(userData);
    }

    @Override
    public void updateUserData(UserData userData) {
        update(userData);
    }

    @Override
    public UserData findByIdUserData(Integer id) {
        return findById(id);
    }

    @Override
    public void deleteUserData(Integer id) {
        UserData userData = findByIdUserData(id);
        if (userData != null)
            delete(userData);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserData> getUserDataList() {
        return getCurrentSession().createCriteria(UserData.class).list();
    }


}
