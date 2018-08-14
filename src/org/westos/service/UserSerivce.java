package org.westos.service;

import org.westos.bean.User;
import org.westos.dao.UserDao;

import java.sql.SQLException;

public class UserSerivce {
    public boolean addUser(User user) throws SQLException {
        //业务层组织业务逻辑
        UserDao dao = new UserDao();
        boolean b = dao.findUser(user);
        if(b){
            dao.addUser(user);
        }

        return b;
    }
}
