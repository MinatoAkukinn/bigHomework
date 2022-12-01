package com.example;

import com.example.entity.Queries;
import com.example.entity.Users;
import com.example.mapper.SearchMapper;
import com.example.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class DemoApplicationTests {
    //写入数据库
    @Autowired
    private DataSource dataSource;
    //语法错误,但是本身没有错误
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SearchMapper searchMapper;
    @Test
    void contextLoads() {
    }
//测试数据库链接是否成功
    @Test
    void getConnect() throws SQLException{
        System.out.println(dataSource.getConnection());
    }
    //测试持久层是否映射成功
    @Test
    public void insert(){
        Users user=new Users();
        user.setUserName("Aurora");

        user.setUserPass("123456");
        user.setEmail("10000@qq.com");
        //insert方法返回影响的行数,如果为1则成功,为0则失败,之后系统输出即可查看
        Integer row= userMapper.insert(user);
        System.out.println(row);
    }
    @Test
    public void findByUsername(){
        Users user=userMapper.findByUsername("小玉");
        System.out.println(user);
    }
    @Test
    public void search(){
        Queries queries=new Queries();
        queries.setSearch("IPAD");
        System.out.println(searchMapper.countBySearch(queries));
    }
    @Test
    public void searchReal(){
        Queries queries=new Queries();
        queries.setSearch("IPAD");
        queries.setPage(1);
        queries.setSize(5);
        System.out.println(searchMapper.selectBySearch(queries));
    }
    @Test
    public void fenlei(){
        Queries queries=new Queries();
        queries.setSearch("电脑");
        queries.setPage(1);
        queries.setSize(5);
        System.out.println(searchMapper.selectByType(queries));
    }
}
