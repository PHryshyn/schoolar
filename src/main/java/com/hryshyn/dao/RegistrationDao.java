package com.hryshyn.dao;


import com.hryshyn.model.RegistrationModel;

import java.sql.SQLException;

public interface RegistrationDao {
    RegistrationModel saveUsername(String username) throws SQLException;
}
