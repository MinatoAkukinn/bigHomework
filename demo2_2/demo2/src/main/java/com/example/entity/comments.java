package com.example.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.sql.Date;

@Data
@ApiModel(value = "comments",description = "评论对象")
public class comments {
    public Integer CommentID;
    public Integer userID;
    public Integer userCommendID;
    public String CommentContent;
    public Date CommentTime;


}
