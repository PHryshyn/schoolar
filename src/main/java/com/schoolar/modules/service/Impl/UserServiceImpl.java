package com.schoolar.modules.service.Impl;

import com.schoolar.modules.dao.UserDao;
import com.schoolar.modules.model.User;
import com.schoolar.modules.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier(value = "userDao")
    private UserDao userDao;

    @Transactional(readOnly = false)
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Transactional(readOnly = false)
    @Override
    public void deleteUser(String username) {
        userDao.deleteUser(username);

    }

    @Transactional(readOnly = false)
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

   /* @Transactional
    @Override
    public User findByIdUser(Integer id) {
        return findByIdUser(id);
    }*/

    @Override
    @Transactional
    public User findByUsername(String username) {
        return userDao.findById(username);
    }


    public UserServiceImpl() {
    }
}
