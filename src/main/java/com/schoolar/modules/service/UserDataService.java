package com.schoolar.modules.service;

import com.schoolar.modules.model.UserData;

import java.util.List;

public interface UserDataService extends BasicService<UserData, Integer>{

    public void updateUserData(UserData userData);

}
