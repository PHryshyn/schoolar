package com.schoolar.modules.service.Impl;

import com.schoolar.modules.dao.UserDataDao;
import com.schoolar.modules.model.UserData;
import com.schoolar.modules.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserDataServiceImpl implements UserDataService {

    @Autowired
    @Qualifier(value = "userDataDao")
    private UserDataDao userDataDao;

    @Transactional
    public void addUserData(UserData userData) {
        userDataDao.addUserData(userData);
    }

    @Transactional
    public void updateUserData(UserData userData) {
        userDataDao.updateUserData(userData);
    }

    @Transactional
    public UserData getOneUserData(int id) {
        return userDataDao.getOneUserData(id);
    }

    @Transactional
    public void deleteUserData(int id) {
        userDataDao.deleteUserData(id);
    }

    @Transactional
    public List<UserData> getUserData() {
        return userDataDao.getUserData();
    }

    public UserDataServiceImpl() {
    }
}
