package com.schoolar.modules.service;

import com.schoolar.modules.model.User;

import java.util.List;

public interface UserService {

    void updateUser(User user);
    User saveUser(User user);
    List<User> getList();
    List<User> getUserListByLastName();
    void delete(Integer id);
}
