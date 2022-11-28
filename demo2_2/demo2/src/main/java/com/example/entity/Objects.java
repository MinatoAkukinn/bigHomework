package com.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@ApiModel(value = "Objects",description = "商品对象")
@NoArgsConstructor
@AllArgsConstructor
public class Objects {
//    create table Object
//            (
//                    ObjectID             int not null auto_increment,
//                    UserID               int not null,
//                    ObjectName           varchar(16) not null,
//    ObjectIntro          text,
//    ObjectType           varchar(16) not null,
//    ObjectPhoto          varchar(250) not null,
//    Status               boolean not null,
//    ShelfTime            datetime,
//    primary key (ObjectID)
//)DEFAULT CHARSET=utf8;

    @ApiModelProperty(value = "物品id")
    private Integer objectId;

    @ApiModelProperty(value = "持有人id")
    private Integer userId;

    @ApiModelProperty(value = "物品名")
    private String objectName;

    @ApiModelProperty(value = "物品状态")
    private boolean status;

    @ApiModelProperty(value = "物品介绍")
    private String objectIntro;

    @ApiModelProperty(value = "物品种类")
    private String objectType;

    @ApiModelProperty(value = "物品图片")
    private String objectPhoto;

    @ApiModelProperty(value = "上架时间")
    private Date shelfTime;

}
