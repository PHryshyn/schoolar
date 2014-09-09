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
public class UserServiceImpl extends BasicServiceImpl<User, Integer> implements UserService {

    @Autowired
    @Qualifier(value = "userDao")
    private UserDao userDao;

    public UserServiceImpl() {
    }

    @Transactional(readOnly = false)
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

}
