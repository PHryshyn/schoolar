package com.schoolar.modules.service.Impl;

import com.schoolar.modules.dao.LoginDao;
import com.schoolar.modules.dao.UserDao;
import com.schoolar.modules.model.Login;
import com.schoolar.modules.model.User;
import com.schoolar.modules.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class LoginServiceImpl implements LoginService {

    @Autowired
    @Qualifier(value = "loginDao")
    private LoginDao loginDao;

    @Transactional
    public void addUsername(Login username) {
        loginDao.addUsername(username);
    }
}
