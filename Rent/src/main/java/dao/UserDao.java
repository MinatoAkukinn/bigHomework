package dao;

import domain.User;

import java.sql.SQLException;

public interface UserDao {

    void saveEmail(User user) throws Exception;

    User getByUsernameAndPwd(String userName, String userPass) throws Exception;

    User findByUsername(String userName) throws SQLException;
}
