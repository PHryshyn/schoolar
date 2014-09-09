package com.schoolar.modules.service;

import com.schoolar.modules.model.User;

public interface UserService extends BasicService<User, Integer> {

    void updateUser(User user);

}
