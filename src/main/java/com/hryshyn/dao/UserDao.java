package com.hryshyn.dao;

import com.hryshyn.model.User;


public interface UserDao {
    User findByUserName(String username);
}
