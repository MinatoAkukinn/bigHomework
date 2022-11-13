package dao.impl;

import dao.UserDao;
import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.taglibs.standard.tag.common.sql.DataSourceUtil;
import utils.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    @Override
    /*

    用户注册
     */
    public void saveEmail(User user) throws Exception {
        //    create table User
//  (
//    UserID               int not null auto_increment,
//    UserName             varchar(16) not null,
//    UserPass             varchar(16) not null,

//    RealName             varchar(16),
//    Sex                  varchar(2),
//    StuNo                varchar(16),

//    Phone                varchar(16),
//    Photo                longblob,
//    Email                varchar(64),

//    primary key (UserID),
//    unique key AK_AK (StuNo, Phone, Email)
//);
        QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="insert into user(UserName,UserPass,Email) values(?,?,?)";
        qr.update(sql,user.getUserName(),user.getUserPass(),user.getEmail());
        //test
        System.out.println(sql);



    }

    @Override
    public User getByUsernameAndPwd(String userName, String userPass) throws Exception {
        QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from user where username = ? and userPass = ?";
        return qr.query(sql,new BeanHandler<>(User.class),userName,userPass);

    }

    @Override
    public User findByUsername(String userName) throws SQLException {
        //建立查询语句
        QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from user where username = ? ";
        //返回结果
        return qr.query(sql,new BeanHandler<>(User.class),userName);
    }
}
