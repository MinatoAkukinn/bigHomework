/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     6/11/2022 21:53:25                           */
/*==============================================================*/


drop table if exists ��Ʒ;

drop table if exists �û�;

drop table if exists ����;

drop table if exists ����;

/*==============================================================*/
/* Table: ��Ʒ                                                    */
/*==============================================================*/
create table ��Ʒ
(
   ��ƷID                 int not null,
   �û�ID                 int not null,
   ��Ʒ����                 char(24) not null,
   ��Ʒ����                 text not null,
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
   unique key AK_AK (ѧ��, �ֻ���)
);

/*==============================================================*/
/* Table: ����                                                    */
/*==============================================================*/
create table ����
(
   ��ƷID                 int not null,
   �û�ID                 int not null,
   ����ID                 int not null,
   ��ʼʱ��                 date,
   ����ʱ��                 date,
   primary key (����ID)
);

/*==============================================================*/
/* Table: ����                                                    */
/*==============================================================*/
create table ����
(
   �û�ID                 int not null,
   �������û�ID              int not null,
   ��������                 text,
   ����ʱ��                 date
);

alter table ��Ʒ add constraint FK_Relationship_1 foreign key (�û�ID)
      references �û� (�û�ID) on delete restrict on update restrict;

alter table ���� add constraint FK_Relationship_3 foreign key (�û�ID)
      references �û� (�û�ID) on delete restrict on update restrict;

alter table ���� add constraint FK_Relationship_4 foreign key (��ƷID)
      references ��Ʒ (��ƷID) on delete restrict on update restrict;

alter table ���� add constraint FK_Relationship_6 foreign key (�������û�ID)
      references �û� (�û�ID) on delete restrict on update restrict;

alter table ���� add constraint FK_Relationship_7 foreign key (�û�ID)
      references �û� (�û�ID) on delete restrict on update restrict;

