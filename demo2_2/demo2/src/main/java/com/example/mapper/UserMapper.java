package com.example.mapper;

import com.example.entity.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
//com.example.mapper.UserMapper.insert
public interface UserMapper {
    //插入语句
    Integer insert(Users user);
    //判断是否有该用户
    Users findByUsername(String userName);
    //修改密码相关
    Integer updatePasswordByUid(Integer userId,String userPass);
    Users findByUserId(Integer userId);

    Integer updateInfoByUid(Users user);
    Integer updatePhotoByUserId(Integer userId,String photo);


}
