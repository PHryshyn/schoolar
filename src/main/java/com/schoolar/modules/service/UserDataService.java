package com.schoolar.modules.service;

import com.schoolar.modules.model.UserData;

import java.util.List;

public interface UserDataService {
    public void addUserData(UserData userData);
    public void updateUserData(UserData userData);
    public UserData getOneUserData(int id);
    public void deleteUserData(int id);
    public List<UserData> getUserData();
}
