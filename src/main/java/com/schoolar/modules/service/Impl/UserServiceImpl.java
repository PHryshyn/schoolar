package com.schoolar.modules.service.Impl;

import com.schoolar.modules.dao.UserDao;
import com.schoolar.modules.model.User;
import com.schoolar.modules.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl extends BasicServiceImpl<User, Integer> implements UserService {

    @Autowired
    @Qualifier(value = "userDao")
    private UserDao userDao;

    public UserServiceImpl() {
    }


    @Override
    @Transactional(readOnly = false)
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    @Transactional(readOnly = false)
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    @Transactional
    public List<User> getList() {return userDao.getList();}
}
