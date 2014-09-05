package com.schoolar.modules.dao;

import com.schoolar.modules.model.UserData;

import java.util.List;

public interface UserDataDao {
    public void addUserData(UserData userData);
    public void updateUserData(UserData userData);
    public UserData getOneUserData(int id);
    public void deleteUserData(int id);
    public List<UserData> getUserData();
}
