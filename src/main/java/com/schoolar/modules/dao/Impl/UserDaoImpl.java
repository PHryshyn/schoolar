package com.schoolar.modules.dao.Impl;

import com.schoolar.modules.dao.UserDao;
import com.schoolar.modules.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends BasicCrudDaoImpl<User, Integer> implements UserDao {

    protected UserDaoImpl(){
        super(User.class);
    }

    @Override
    public void saveUser(User user) {
        save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        User user = findById(id);
        if (user != null)
        delete(user);
    }

    @Override
    public void updateUser(User user) {
        User userToUpdate = findByIdUser(user.getId());
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setRole(user.getRole());
        update(userToUpdate);
    }


    @Override
    public User findByIdUser(Integer id) {
        return findById(id);
    }

    @SuppressWarnings("unchecked")
    public List<User> getUserList(){
        return getCurrentSession().createCriteria(User.class).list();
    }




}
