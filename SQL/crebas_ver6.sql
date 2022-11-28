/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     12/11/2022 16:23:47                          */
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
   CommentID            int not null,
   primary key (CommentID)
);

/*==============================================================*/
/* Table: Object                                                */
/*==============================================================*/
create table Object
(
   ObjectID             int not null,
   UserID               int not null,
   ObjectName           char(24) not null,
   ObjectIntro          text not null,
   ObjectType           char(24) not null,
   ObjectPhoto          longblob not null,
   primary key (ObjectID)
);

/*==============================================================*/
/* Table: Purchase                                              */
/*==============================================================*/
create table Purchase
(
   ObjectID             int not null,
   UserID               int not null,
   PurchaseID           int not null,
   StartTime            date,
   EndTime              date,
   primary key (PurchaseID)
);

/*==============================================================*/
/* Table: User                                                  */
/*==============================================================*/
create table User
(
   UserID               int not null,
   UserName             char(16) not null,
   UserPass             char(16) not null,
   RealName             char(16),
   Sex                  char(2),
   StuNo                char(16),
   Phone                char(16),
   Photo                longblob,
   primary key (UserID)
);

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

