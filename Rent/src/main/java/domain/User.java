package domain;

import java.awt.*;

public class User {
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
    private Integer UserID;
    private String UserName;
    private String UserPass;

    private String RealName;
    private String Sex;
    private String StuNo;

    private String Phone;
    private Image Photo;
    private String Email;

    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer userID) {
        UserID = userID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserPass() {
        return UserPass;
    }

    public void setUserPass(String userPass) {
        UserPass = userPass;
    }

    public String getRealName() {
        return RealName;
    }

    public void setRealName(String realName) {
        RealName = realName;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getStuNo() {
        return StuNo;
    }

    public void setStuNo(String stuNo) {
        StuNo = stuNo;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public Image getPhoto() {
        return Photo;
    }

    public void setPhoto(Image photo) {
        Photo = photo;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserID=" + UserID +
                ", UserName='" + UserName + '\'' +
                ", UserPass='" + UserPass + '\'' +
                ", RealName='" + RealName + '\'' +
                ", Sex='" + Sex + '\'' +
                ", StuNo='" + StuNo + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Photo=" + Photo +
                ", Email='" + Email + '\'' +
                '}';
    }
}
