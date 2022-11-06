/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     6/11/2022 18:23:27                           */
/*==============================================================*/


drop table if exists ��Ʒ;

drop table if exists �û�;

drop table if exists ����;

/*==============================================================*/
/* Table: ��Ʒ                                                    */
/*==============================================================*/
create table ��Ʒ
(
   ��ƷID                 int not null,
   �û�ID                 int not null,
   ��Ʒ����                 char(24) not null,
   ��Ʒ����                 char(256) not null,
   ��Ʒ����                 char(24) not null,
   ��ƷͼƬ                 longblob not null,
   primary key (��ƷID)
);

/*==============================================================*/
/* Table: �û�                                                    */
/*==============================================================*/
create table �û�
(
   �û�ID                 int not null,
   �û���                  char(16) not null,
   ����                   char(16) not null,
   ����                   char(16) not null,
   �Ա�                   char(2) not null,
   ѧ��                   char(16) not null,
   �ֻ���                  char(16) not null,
   ͷ��                   char(256) not null,
   primary key (�û�ID),
   unique (ѧ��, �ֻ���, �û���)
);

/*==============================================================*/
/* Table: ����                                                    */
/*==============================================================*/
create table ����
(
   ��ƷID                 int not null,
   �û�ID                 int not null,
   ����ID                 int,
   ��ʼʱ��                 date,
   ����ʱ��                 date,
   primary key (��ƷID, �û�ID)
);

alter table ��Ʒ add constraint FK_Relationship_1 foreign key (�û�ID)
      references �û� (�û�ID) on delete restrict on update restrict;

alter table ���� add constraint FK_Relationship_3 foreign key (�û�ID)
      references �û� (�û�ID) on delete restrict on update restrict;

alter table ���� add constraint FK_Relationship_4 foreign key (��ƷID)
      references ��Ʒ (��ƷID) on delete restrict on update restrict;

