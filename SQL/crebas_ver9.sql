/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     16/11/2022 2:27:23                           */
/*==============================================================*/


drop table if exists Comment;

drop table if exists Object;

drop table if exists Purchase;

drop table if exists User;

/*==============================================================*/
/* Table: Comment                                               */
/*==============================================================*/
create table Comment
(
   CommentID            int not null auto_increment,
   UserID               int not null,
   UserCommedID         int not null,
   CommentContent       text not null,
   CommentTime          date not null,
   primary key (CommentID)
)DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: Object                                                */
/*==============================================================*/
create table Object
(
   ObjectID             int not null auto_increment,
   UserID               int not null,
   ObjectName           varchar(16) not null,
   ObjectIntro          text,
   ObjectType           varchar(16) not null,
   ObjectPhoto          varchar(250) not null,
   Status               boolean not null,
   ShelfTime            datetime,
   primary key (ObjectID)
)DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: Purchase                                              */
/*==============================================================*/
create table Purchase
(
   ObjectID             int not null,
   UserID               int not null,
   PurchaseID           int not null auto_increment,
   StartTime            date,
   EndTime              date,
   primary key (PurchaseID)
)DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: User                                                  */
/*==============================================================*/
create table Users
(
   UserID               int not null auto_increment,
   UserName             varchar(16) not null unique,
   UserPass             varchar(16) not null,
   RealName             varchar(16) not null,
   Sex                  varchar(2) not null,
   StuNo                varchar(16) not null unique,
   Phone                varchar(16),
   Photo                varchar(250),
   Email                varchar(64),
   UserInfo             varchar(250),
   primary key (UserID),
)DEFAULT CHARSET=utf8;

alter table Comment add constraint FK_Relationship_6 foreign key (UserCommedID)
      references Users (UserID) on delete restrict on update restrict;

alter table Comment add constraint FK_Relationship_7 foreign key (UserID)
      references Users (UserID) on delete restrict on update restrict;

alter table Object add constraint FK_Relationship_1 foreign key (UserID)
      references Users (UserID) on delete restrict on update restrict;

alter table Purchase add constraint FK_Relationship_3 foreign key (UserID)
      references Users (UserID) on delete restrict on update restrict;

alter table Purchase add constraint FK_Relationship_4 foreign key (ObjectID)
      references Object (ObjectID) on delete restrict on update restrict;

