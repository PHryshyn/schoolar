package com.schoolar.modules.dao.Impl;

import com.schoolar.modules.dao.UserDataDao;
import com.schoolar.modules.model.User;
import com.schoolar.modules.model.UserData;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDataDao")
public class UserDataDaoImpl extends BasicCrudDaoImpl<UserData, Integer> implements UserDataDao {

    protected UserDataDaoImpl() {
        super(UserData.class);
    }

    @Override
    public void updateUserData(UserData userData) {
        UserData userDataToUpdate = findById(userData.getId());
        userDataToUpdate.setFirstName(userData.getFirstName());
        userDataToUpdate.setLastName(userData.getLastName());
        userDataToUpdate.setAdress(userData.getAdress());
        userDataToUpdate.setEmail(userData.getEmail());
        userDataToUpdate.setFullNamePar1(userData.getFullNamePar1());
        userDataToUpdate.setFullNamePar2(userData.getFullNamePar2());
        userData.setPhone(userData.getPhone());
        update(userData);
    }

}
