/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     6/11/2022 23:40:03                           */
/*==============================================================*/


drop table if exists 物品;

drop table if exists 用户;

drop table if exists 订单;

drop table if exists 评论;

/*==============================================================*/
/* Table: 物品                                                    */
/*==============================================================*/
create table 物品
(
   物品ID                 int not null auto_increment,
   用户ID                 int not null,
   物品名字                 char(24) not null,
   物品介绍                 text not null,
   物品种类                 char(24) not null,
   物品图片                 longblob not null,
   primary key (物品ID)
);

/*==============================================================*/
/* Table: 用户                                                    */
/*==============================================================*/
create table 用户
(
   用户ID                 int not null auto_increment,
   用户名                  char(16) not null,
   密码                   char(16) not null,
   姓名                   char(16),
   性别                   char(2),
   学号                   char(16),
   手机号                  char(16),
   头像                   char(256),
   primary key (用户ID)
);

/*==============================================================*/
/* Table: 订单                                                    */
/*==============================================================*/
create table 订单
(
   物品ID                 int not null,
   用户ID                 int not null,
   订单ID                 int not null auto_increment,
   开始时间                 date,
   结束时间                 date,
   primary key (订单ID)
);

/*==============================================================*/
/* Table: 评论                                                    */
/*==============================================================*/
create table 评论
(
   用户ID                 int not null,
   被评论用户ID              int not null,
   评论内容                 text,
   评论时间                 date,
   评论ID                 int not null auto_increment,
   primary key (评论ID)
);

alter table 物品 add constraint FK_Relationship_1 foreign key (用户ID)
      references 用户 (用户ID) on delete restrict on update restrict;

alter table 订单 add constraint FK_Relationship_3 foreign key (用户ID)
      references 用户 (用户ID) on delete restrict on update restrict;

alter table 订单 add constraint FK_Relationship_4 foreign key (物品ID)
      references 物品 (物品ID) on delete restrict on update restrict;

alter table 评论 add constraint FK_Relationship_6 foreign key (被评论用户ID)
      references 用户 (用户ID) on delete restrict on update restrict;

alter table 评论 add constraint FK_Relationship_7 foreign key (用户ID)
      references 用户 (用户ID) on delete restrict on update restrict;

