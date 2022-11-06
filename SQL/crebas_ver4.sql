/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     6/11/2022 23:40:03                           */
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
   ��ƷID                 int not null auto_increment,
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
   �û�ID                 int not null auto_increment,
   �û���                  char(16) not null,
   ����                   char(16) not null,
   ����                   char(16),
   �Ա�                   char(2),
   ѧ��                   char(16),
   �ֻ���                  char(16),
   ͷ��                   char(256),
   primary key (�û�ID)
);

/*==============================================================*/
/* Table: ����                                                    */
/*==============================================================*/
create table ����
(
   ��ƷID                 int not null,
   �û�ID                 int not null,
   ����ID                 int not null auto_increment,
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
   ����ʱ��                 date,
   ����ID                 int not null auto_increment,
   primary key (����ID)
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

