package com.schoolar.modules.dao.Impl;

import com.schoolar.modules.dao.UserDao;
import com.schoolar.modules.model.User;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl extends BasicCrudDaoImpl<User, String> implements UserDao {

    protected UserDaoImpl(){
        super(User.class);
    }

    @Override
    public void saveUser(User user) {
        save(user);
    }

    @Override
    public void deleteUser(String username) {
        User user = findById(username);
        if (user != null)
        delete(user);
    }

    @Override
    public void updateUser(User user) {
        update(user);
    }


  /*  @Override
    public User findByIdUser(Integer id) {
        return findById(id);
    }


*/

}
