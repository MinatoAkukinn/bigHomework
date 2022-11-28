package com.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Data
@ApiModel(value = "Users",description = "用户对象")
@NoArgsConstructor
@AllArgsConstructor
public class Users {
//    CREATE TABLE `users` (
//   `UserID` int(11) NOT NULL AUTO_INCREMENT,
//  `UserName` varchar(16) NOT NULL,
//  `UserPass` varchar(16) NOT NULL,
//  `RealName` varchar(16) NOT NULL,
//  `Sex` varchar(2) NOT NULL,
//  `StuNo` varchar(16) NOT NULL,
//  `Phone` varchar(16) DEFAULT NULL,
//  `Photo` varchar(250) DEFAULT NULL,
//  `Email` varchar(64) DEFAULT NULL,
//  `UserInfo` varchar(250) DEFAULT NULL,
//    PRIMARY KEY (`UserID`),
//    UNIQUE KEY `UserName` (`UserName`),
//    UNIQUE KEY `StuNo` (`StuNo`)
//            ) ENGINE=InnoDB DEFAULT CHARSET=utf8

    @ApiModelProperty(value = "用户id")
    private int userId;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "用户密码")
    private String userPass;

    @ApiModelProperty(value = "真名")
    private String realName;


    @ApiModelProperty(value = "学生号")
    private String stuNo;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "头像")
    private String photo;

    @ApiModelProperty(value = "用户邮箱")
    private String email;
    @ApiModelProperty(value = "用户个人介绍")

    private String userInfo;



}
