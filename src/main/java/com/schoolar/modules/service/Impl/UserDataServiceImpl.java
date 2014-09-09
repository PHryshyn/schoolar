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

@Service("userDataService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserDataServiceImpl extends BasicServiceImpl<UserData, Integer> implements UserDataService {

    @Autowired
    @Qualifier(value = "userDataDao")
    private UserDataDao userDataDao;

    public UserDataServiceImpl() {
    }

    @Override
    @Transactional(readOnly = false)
    public void updateUserData(UserData userData) {
        userDataDao.updateUserData(userData);
    }

}
