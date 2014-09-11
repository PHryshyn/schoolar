package com.schoolar.modules.dao.Impl;

import com.schoolar.modules.dao.UserDao;
import com.schoolar.modules.model.Role;
import com.schoolar.modules.model.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends BasicCrudDaoImpl<User, Integer> implements UserDao {

    protected UserDaoImpl(){
        super(User.class);
    }

    @Override
    public void updateUser(User user) {
        User userToUpdate = findById(user.getId());
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setAdress(user.getAdress());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setFullNamePar1(user.getFullNamePar1());
        userToUpdate.setFullNamePar2(user.getFullNamePar2());
        user.setPhone(user.getPhone());
        update(userToUpdate);
    }

    @Override
    public void saveUser(User user){
        user.setEnabled(1);
        user.setRole(Role.ROLE_USER);
        save(user);
    }

}
