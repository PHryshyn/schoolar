package com.schoolar.modules.dao.Impl;

import com.schoolar.modules.dao.UserDao;
import com.schoolar.modules.model.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends BasicCrudDaoImpl<User, Integer> implements UserDao {

    protected UserDaoImpl(){
        super(User.class);
    }

    @Override
    public void updateUser(User user) {
        User userToUpdate = findById(user.getId());
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setRole(user.getRole());
        update(userToUpdate);
    }

}
