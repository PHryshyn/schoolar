package com.scholar.service;


import com.schoolar.modules.model.Role;
import com.schoolar.modules.model.User;
import com.schoolar.modules.service.UserService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:core-spring-config.xml")
@Transactional
public class UserServiseTest {

    @Autowired
    private UserService userService;

    private final String username = "user01";
    private final Integer id = 100;

    @After
    public void tearDown() throws Exception {
        userService.delete(id);
    }

    @Test
    public void testSaveUser() throws Exception {
        User user = createUser();
        User found = userService.findByUsername(user.getUsername());
        Assert.assertEquals(user, found);
    }

    private User createUser() {
        User user = new User(id, username, "password", "firstName", "lastName", Role.ROLE_USER);
        userService.saveUser(user);
        return user;
    }

    @Test
    public void testUpdateUser() {
        createUser();
        User user01 = userService.findByUsername("user01");
        Assert.assertNotNull(user01);
        Assert.assertEquals("firstName", user01.getFirstName());
        Assert.assertEquals("lastName", user01.getLastName());

        user01.setFirstName("newFirstName");
        user01.setLastName("newLastName");
        userService.updateUser(user01);
        User found = userService.findByUsername("user01");
        Assert.assertNotNull(found);
        Assert.assertEquals("newFirstName", found.getFirstName());
        Assert.assertEquals("newLastName", found.getLastName());
    }

    @Test
    public void testGetUserListByLastName() throws Exception {
        createUser();
        List<User> users = userService.getUserListByLastName();
        Assert.assertEquals(1, users.size());
        Assert.assertEquals("user01", users.iterator().next().getUsername());

    }

    @Test
    public void testDeleteUser() throws Exception {
        createUser();
        Assert.assertNotNull(userService.findById(id));
        userService.delete(id);
        Assert.assertNull(userService.findById(id));
    }

    @Test
    public void testFindById() throws Exception {
        User user = createUser();
        User found = userService.findById(id);
        Assert.assertEquals(user, found);
    }
}




