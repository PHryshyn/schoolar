package com.schoolar.modules.dao.Impl;

import com.schoolar.modules.dao.UserDao;
import com.schoolar.modules.model.Role;
import com.schoolar.modules.model.User;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
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
    public User saveUser(User user){
        user.setEnabled(1);
        user.setRole(Role.ROLE_USER);
       // user.setShedule(user.getShedule());
        save(user);
        return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUserListByLastName() {
        List userList = (List<User>) getCurrentSession().createCriteria(User.class)
                .add( Restrictions.like("role", Role.ROLE_USER) )
                .addOrder(Order.asc("lastName"))
                .list();
        return userList;
    }

    @Override
    public User findByUsername(String username) {
        return (User)getCurrentSession().get(User.class, username);
      //  return findById(user.getId());
        //return (User) getCurrentSession().get(User.class, username);
    }
}
