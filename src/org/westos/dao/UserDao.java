package org.westos.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.westos.bean.User;

import java.sql.*;

public class UserDao {
    public boolean findUser(User user) throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        Connection connection = dataSource.getConnection();
        String sql="select * from users where username=?";
        PreparedStatement statement =  connection.prepareStatement(sql);
        statement.setString(1,user.getUsername());
        ResultSet resultSet =  statement.executeQuery();
        boolean b = resultSet.next();
        dataSource.close();
        return !b;
    }

    public void addUser(User user) throws SQLException {

        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        Connection connection = dataSource.getConnection();
        String sql = "insert into users(username,password) values(?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,user.getUsername());
        statement.setString(2,user.getPassword());
        statement.executeUpdate();
        dataSource.close();
    }
}
