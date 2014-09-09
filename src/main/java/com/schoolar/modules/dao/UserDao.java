package com.schoolar.modules.dao;

import com.schoolar.modules.model.User;

public interface UserDao extends BasicCrudDao<User, Integer> {

    void saveUser(User user);
    void deleteUser(Integer id);
    void updateUser(User user);
    User findByIdUser(Integer id);


}
