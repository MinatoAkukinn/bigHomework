package com.example.service.impl;

import com.example.entity.Users;
import com.example.mapper.UserMapper;
import com.example.service.IUserService;
import com.example.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    //核心为调用mapper层方法写入数据库,声明一个userMapper
    private UserMapper userMapper;

    @Override
    public void reg(Users user) {
        String username=user.getUserName();
        Users result=userMapper.findByUsername(username);
        if(result!=null){
            throw new UsernameDuplicatedException();
        }
        Integer row=userMapper.insert(user);
        if(row!=1){
            throw new InsertException();
        }
    }

    @Override
    public Users login(String username, String password) {
        Users result=userMapper.findByUsername(username);
        //寻找账号是否存在
        if(result==null){
            throw new UsernameNotFoundException("用户不存在");
        }
        //寻找密码是否存在
        String inputPassword=password;
        if(!result.getUserPass().equals(inputPassword)){
            throw new PasswordNotMatchException("用户密码不存在");
        }


        return result;

    }

    @Override
    public void changePass(Integer userId,String oldPass, String userPass) {
        Users user=userMapper.findByUserId(userId);
        if(user==null) throw new UsernameNotFoundException("用户数据不存在");
        String oldPassword=user.getUserPass();
        if(!oldPassword.equals(oldPass)) throw new PasswordNotMatchException("输入原密码错误");

        Integer row=userMapper.updatePasswordByUid(userId,userPass);
        if(row!=1) throw new UpdateException("未知异常");


    }

    @Override
    public Users getByUid(Integer userId) {
        Users users=userMapper.findByUserId(userId);
        if(users==null) throw new UsernameNotFoundException("用户不存在");

        return users;
    }

    @Override
    public void changeInfo(Integer userId, Users user) {
        Users u=userMapper.findByUserId(userId);
        if(u==null) throw new UsernameNotFoundException("用户不存在");
        //不是很理解为啥要手动注入..但是确实要手动注入...
        //现在懂了!
        user.setUserId(userId);
        System.out.println(user);
        Integer row=userMapper.updateInfoByUid(user);
        if(row!=1) throw new UpdateException("更新数据异常");
    }

    @Override
    public void updatePhotoByUserId(Integer userId, String photo) {
        Users u=userMapper.findByUserId(userId);
        if(u==null) throw new UsernameNotFoundException("用户数据不存在" );
        Integer row=userMapper.updatePhotoByUserId(userId,photo);
        if(row!=1){
            throw new UpdateException("更新时出现异常");
        }
    }

}
