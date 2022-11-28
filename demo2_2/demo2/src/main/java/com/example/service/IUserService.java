package com.example.service;

import com.example.entity.Users;

public interface IUserService {
    void reg(Users user);
    Users login(String username,String password);

    void changePass(Integer userId,String oldPass,String userPass);
    Users getByUid(Integer userId);
    void changeInfo(Integer userId,Users user);
    void updatePhotoByUserId(Integer userId,String photo);
}
