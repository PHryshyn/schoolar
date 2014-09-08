package com.schoolar.modules.dao;

import com.schoolar.modules.model.UserData;

import java.util.List;

public interface UserDataDao extends BasicCrudDao<UserData, Integer> {

    public void saveUserData(UserData userData);
    public void updateUserData(UserData userData);
    public UserData findByIdUserData(Integer id);
    public void deleteUserData(Integer id);
    public List<UserData> getUserDataList();
}
