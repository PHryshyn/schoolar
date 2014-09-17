package com.schoolar.modules.dao;

import com.schoolar.modules.model.User;

import java.util.List;

public interface UserDao extends BasicCrudDao<User, Integer> {

    void updateUser(User user);
    User saveUser(User user);
    List<User> getUserListByLastName();
    User findByUsername(String username);
    //User getProfile(String username);

}
