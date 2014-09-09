package com.schoolar.modules.dao;

import com.schoolar.modules.model.UserData;

import java.util.List;

public interface UserDataDao extends BasicCrudDao<UserData, Integer> {

    public void updateUserData(UserData userData);

}
