package com.schoolar.modules.service;

import com.schoolar.modules.model.User;

public interface UserService {
    void saveUser(User user);
    void deleteUser(String username);
    void updateUser(User user);
   // User findByIdUser(Integer id);
   User findByUsername(String username);

}
