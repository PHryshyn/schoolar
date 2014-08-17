package com.hryshyn.dao;

import com.hryshyn.model.UserModel;


public interface UserDao {
    UserModel findByUserName(String username);
}
