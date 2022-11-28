/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     12/11/2022 18:10:39                          */
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
   UserID               int not null,
   UserCommedID         int not null,
   CommentContent       text,
   CommentTime          date,
   CommentID            int not null auto_increment,
   primary key (CommentID)
)CHARACTER SET utf8 COLLATE utf8_general_ci;

/*==============================================================*/
/* Table: Object                                                */
/*==============================================================*/
create table Object
(
   ObjectID             int not null auto_increment,
   UserID               int not null,
   ObjectName           varchar(16) not null,
   ObjectIntro          text not null,
   ObjectType           varchar(16) not null,
   ObjectPhoto          longblob not null,
   primary key (ObjectID)
)CHARACTER SET utf8 COLLATE utf8_general_ci;

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
)CHARACTER SET utf8 COLLATE utf8_general_ci;

/*==============================================================*/
/* Table: User                                                  */
/*==============================================================*/
create table User
(
   UserID               int not null auto_increment,
   UserName             varchar(16) not null,
   UserPass             varchar(16) not null,
   RealName             varchar(16),
   Sex                  varchar(2),
   StuNo                varchar(16),
   Phone                varchar(16),
   Photo                longblob,
   Email                varchar(64),
   primary key (UserID),
   unique key AK_AK (StuNo, Phone, Email)
)CHARACTER SET utf8 COLLATE utf8_general_ci;

alter table Comment add constraint FK_Relationship_6 foreign key (UserCommedID)
      references User (UserID) on delete restrict on update restrict;

alter table Comment add constraint FK_Relationship_7 foreign key (UserID)
      references User (UserID) on delete restrict on update restrict;

alter table Object add constraint FK_Relationship_1 foreign key (UserID)
      references User (UserID) on delete restrict on update restrict;

alter table Purchase add constraint FK_Relationship_3 foreign key (UserID)
      references User (UserID) on delete restrict on update restrict;

alter table Purchase add constraint FK_Relationship_4 foreign key (ObjectID)
      references Object (ObjectID) on delete restrict on update restrict;

