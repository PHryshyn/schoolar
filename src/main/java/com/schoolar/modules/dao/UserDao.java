package com.schoolar.modules.dao;

import com.schoolar.modules.model.User;

public interface UserDao extends BasicCrudDao<User, String> {

    void saveUser(User user);
    void deleteUser(String username);
    void updateUser(User user);
  //  User findByIdUser(Integer id);


}
