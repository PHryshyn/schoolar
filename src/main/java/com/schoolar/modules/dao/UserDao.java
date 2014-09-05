package com.schoolar.modules.dao;

import com.schoolar.modules.model.Role;
import com.schoolar.modules.model.User;

public interface UserDao {
    public void addUsername(User username);

    public void addRole(Role role);
}
