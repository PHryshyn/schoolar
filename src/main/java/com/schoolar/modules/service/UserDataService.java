package com.schoolar.modules.service;

import com.schoolar.modules.model.UserData;

import java.util.List;

public interface UserDataService {
    public void saveUserData(UserData userData);
    public void updateUserData(UserData userData);
    public UserData findByIdUserData(Integer id);
    public void deleteUserData(Integer id);
    public List<UserData> getUserDataList();
}
