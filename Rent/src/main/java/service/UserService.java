package service;

import domain.User;

import java.sql.SQLException;

public interface UserService {
    void regist(User user) throws Exception;

    User login(String userName, String userPass) throws Exception;

    User findByUsername(String userName) throws SQLException;

    User getById(String objectId) throws SQLException;
}
