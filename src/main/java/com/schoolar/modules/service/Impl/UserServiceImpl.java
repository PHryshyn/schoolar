package com.schoolar.modules.service.Impl;

import com.schoolar.modules.dao.UserDao;
import com.schoolar.modules.model.User;
import com.schoolar.modules.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

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


    @Transactional(readOnly = false)
    @Override
    public User saveUser(User user) {
        return userDao.saveUser(user);
    }


    @Transactional
    @Override
    public List<User> getList() {
        return userDao.getList();
    }

    @Transactional
    @Override
    public List<User> getUserListByLastName() {
        return userDao.getUserListByLastName();
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        userDao.delete(id);
    }

    @Transactional
    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Transactional
    @Override
    public User findByUsername(String username) {
       return userDao.findByUsername(username);
       // User user = userDao.findByUsername(username);
       // return userDao.findById(user.getId());
    }
}
