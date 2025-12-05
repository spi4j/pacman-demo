/******************************************************************/
/* Base de donnees:      H2                                       */
/* Application:          demo-dsfr-client-rest                    */
/* Date de creation:     03/12/2025 07:52:38                      */
/******************************************************************/

/******************************************************************/
/* Sequences                                                      */
/******************************************************************/
create sequence USERDEMO_SEQ start with 1;
create sequence REQUESTDEMO_SEQ start with 1;

/******************************************************************/
/* TABLE : USERDEMO                                               */
/******************************************************************/
create table USERDEMO
(
  /* PK de la table USERDEMO */
  USERDEMO_ID NUMBER(19) not null,
  FIRSTNAME VARCHAR(100) not null,
  LASTNAME VARCHAR(100) not null,
  PHONE VARCHAR(100),
  MAIL VARCHAR(100),
  CITY VARCHAR(100),
  ZIPCODE VARCHAR(100),
  LOGIN VARCHAR(100) not null,
  ADDRESS VARCHAR(100),
  CIVILITY VARCHAR(100) not null,
  DATEOFBIRTH TIMESTAMP,
  PASSWORD VARCHAR(100) not null,
  BUSINESSACTIVITY VARCHAR(100),
  constraint USERDEMO_PK1_1 primary key (USERDEMO_ID)
);

comment on column USERDEMO.USERDEMO_ID is 'Clé primaire pour la table USERDEMO';
comment on column USERDEMO.FIRSTNAME is 'Le prénom pour l''utilisateur';
comment on column USERDEMO.LASTNAME is 'Le nom de l''utilisateur';
comment on column USERDEMO.PHONE is 'Le téléphone pour l''utilisateur';
comment on column USERDEMO.MAIL is 'Le mail pour l''utilisateur';
comment on column USERDEMO.CITY is 'La ville pour l''utilisateur';
comment on column USERDEMO.ZIPCODE is 'Le code postal pour l''utilisateur';
comment on column USERDEMO.LOGIN is 'L''identifiant pour l''utilistateur';
comment on column USERDEMO.ADDRESS is 'L''adresse de l''utilistateur';
comment on column USERDEMO.CIVILITY is 'La civilité de l''utilisateur';
comment on column USERDEMO.DATEOFBIRTH is 'La date de naissance pour l''utilisateur';
comment on column USERDEMO.PASSWORD is 'Le mot de passe pour l''utilisateur';
comment on column USERDEMO.BUSINESSACTIVITY is 'La profession pour l''utilisateur';

/******************************************************************/
/* TABLE : REQUESTDEMO                                            */
/******************************************************************/
create table REQUESTDEMO
(
  /* PK de la table REQUESTDEMO */
  REQUESTDEMO_ID NUMBER(19) not null,
  TYPE VARCHAR(100) not null,
  REASON VARCHAR(100) not null,
  IDENTIFIER VARCHAR(100) not null,
  STATUS VARCHAR(100) not null,
  /* FK vers la table USERDEMO */
  USERDEMO_ID NUMBER(19) not null,
  constraint REQUESTDEMO_PK1_1 primary key (REQUESTDEMO_ID)
);
create index REQUESTDEMO_IDX1_1 on REQUESTDEMO(USERDEMO_ID);

comment on column REQUESTDEMO.REQUESTDEMO_ID is 'Clé primaire pour la table REQUESTDEMO';
comment on column REQUESTDEMO.TYPE is 'Le type de démarche';
comment on column REQUESTDEMO.REASON is 'La raison de la démarche';
comment on column REQUESTDEMO.IDENTIFIER is 'Le numéro de dossier pour la démarche';
comment on column REQUESTDEMO.STATUS is 'Le statut de la démarche';

/******************************************************************/
/* Contraintes                                                    */
/******************************************************************/
alter table REQUESTDEMO add constraint REQUESTDEMO_FK1_1 foreign key (USERDEMO_ID) references USERDEMO (USERDEMO_ID);
