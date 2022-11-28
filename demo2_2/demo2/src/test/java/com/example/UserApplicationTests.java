package com.example;

import com.example.entity.Users;
import com.example.mapper.UserMapper;
import com.example.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest

public class UserApplicationTests {
    @Autowired(required = false)
    private UserMapper userMapper;
    @Autowired
    private IUserService userService;


    @Test
    //mapper层测试
    public void insert(){
        Users user=new Users();
        user.setUserName("Aurora");

        user.setRealName("小叶");
        user.setUserPass("123456");
        user.setEmail("10000@qq.com");
        user.setStuNo("2020151033");
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
    //测试service
    public void reg(){
        try{
            Users user=new Users();
            user.setUserName("Av2a");

            user.setRealName("小绿");
            user.setUserPass("1234256");
            user.setEmail("10000233@qq.com");
            user.setStuNo("2021151013");
            userService.reg(user);
            System.out.println("ok");
        }catch(Exception e){
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }

    }
    //测试login service
    @Test
    public void login(){
try{
    //        //正常登录
//        Users u=userService.login("Aurora","123456");
//        System.out.println(u);
//        //错误用户
//        Users u=userService.login("Auror2a","123456");
//        System.out.println(u);
        //密码不匹配
        Users u=userService.login("2423","12456");
        System.out.println(u);
}catch (Exception e){
    System.out.println(e.getClass().getSimpleName());
    System.out.println(e.getMessage());
}

    }
//测试密码mapper
    @Test
    public void updatePasswordByUid(){
        userMapper.updatePasswordByUid(1,"123455");

    }
    @Test
    public void findByUserId(){
        System.out.println(userMapper.findByUserId(1));
    }
//测试密码service
    @Test
    public void serviceUpdatePasswordByUid(){
        try{
            userService.changePass(1,"123455","123333");
        }
        catch(Exception e){
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }


    }
    @Test
    public void updateInfoByUid(){
       Users user=new Users();
       user.setUserId(1);
       user.setPhone("99612344");
       user.setRealName("xiaoye");
      user.setEmail("1231231@qq.com");
       user.setUserInfo("喜欢你,还有大家!");
        System.out.println(user);
       userMapper.updateInfoByUid(user);

    }
    @Test
    public void ServiceUpdateInfoByUid(){
        Users user=new Users();
        user.setRealName("xiaoye");
        user.setPhone("996122344");
        user.setEmail("12312313@qq.com");
        user.setUserInfo("喜欢你,还有大家!");
        System.out.println(user);
       userService.changeInfo(1,user);

    }
    @Test
    public  void updatePhoto(){
        userMapper.updatePhotoByUserId(1,"2233");

    }
    @Test
    public  void updatePhotoService(){
        userService.updatePhotoByUserId(22,"22222");

    }
}
