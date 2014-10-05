package com.scholar.dao;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.schoolar.modules.dao.UserDao;
import com.schoolar.modules.model.Role;
import com.schoolar.modules.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:core-spring-config.xml")
@Transactional
public class userDaoTest {

    public static final String INITIAL_DATA_LOCATION = "/testdata/initial/user";
    public static final String EXPECTED_DATA_LOCATION = "/testdata/expected/user";
    @Autowired
    private UserDao userDao;

    @Test
    @DatabaseSetup(INITIAL_DATA_LOCATION + "/getUser.xml")
    public void testFindUserById() {
        User expectedUser = new User(1, "testUsername", "testPassword", "testFirstName", "testLastName", Role.ROLE_ADMIN);
        User actualUser = userDao.findById(1);


        Assert.assertEquals(expectedUser, actualUser);
    }

 /*   @Test
    @DatabaseSetup(INITIAL_DATA_LOCATION + "/getUser.xml")
    public void testFindUserByUsername() {
        User expectedUser = new User(10, "testUsername", "testPassword", "testFirstName", "testLastName", Role.ROLE_USER);
        User actualUser = userDao.findByUsername("testUsername");

        Assert.assertEquals(expectedUser, actualUser);
    }
*/

    @Test
    @DatabaseSetup(INITIAL_DATA_LOCATION + "/add.xml")
    @ExpectedDatabase(value = EXPECTED_DATA_LOCATION + "/add.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testAddUser() {
        User user = new User("testUsername", "testPassword", "testFirstName", "testLastName", Role.ROLE_USER);

        userDao.saveUser(user);

        Assert.assertNotNull(user);
    }

}
