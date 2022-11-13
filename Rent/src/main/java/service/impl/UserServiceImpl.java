package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import service.UserService;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoImpl();
    @Override
//    用户注册


    public void regist(User user) throws Exception {
        //1.调用dao
        UserDao ud=new UserDaoImpl();
        ud.saveEmail(user);
        //后续迭代-邮件/电话号码
        String emailMsg="恭喜恭喜恭喜你!";
//        MailUtils.senMail(user.getEmail(),emailMsg);
    }

    /*
    *
    * 登录
    *
    * */
    @Override
    public User login(String userName, String userPass) throws Exception {
        UserDao ud=new UserDaoImpl();

        return ud.getByUsernameAndPwd(userName,userPass);
    }

    @Override
    public User findByUsername(String userName) throws SQLException {
        return userDao.findByUsername(userName);
    }

    @Override
    public User getById(String objectId) throws SQLException {
        return null;
    }
}
