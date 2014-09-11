package com.schoolar.modules.dao;

import com.schoolar.modules.model.User;

public interface UserDao extends BasicCrudDao<User, Integer> {

    void updateUser(User user);
    void saveUser(User user);

}
