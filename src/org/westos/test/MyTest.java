package org.westos.test;

import org.junit.Test;
import org.westos.bean.User;
import org.westos.dao.UserDao;

import java.sql.SQLException;

public class MyTest {
    @Test
    public void test() throws SQLException {
        UserDao dao = new UserDao();
        User user = new User();
        user.setUsername("zhangsan");
        boolean b = dao.findUser(user);
        System.out.println(b);
    }

    @Test
    public void test2() throws SQLException {
        UserDao dao = new UserDao();
        User user = new User();
        user.setUsername("zhangsan2");
        user.setPassword("556999");
        dao.addUser(user);

    }
}
