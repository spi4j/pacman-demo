/******************************************************************/
/* Base de donnees:      h2                                       */
/* Application:          demo-dsfr-rest                           */
/* Date de creation:     04/12/2025 10:08:00                      */
/******************************************************************/

/******************************************************************/
/* Ne pas décommenter ce code.                                    */ 
/* Copier ce code d'exemple dans les balises User Code            */
/* en fin de fichier.                                             */
/******************************************************************/

/******************************************************************/
/* Insertions à recopier suite à regénération(s)                  */
/******************************************************************/
/**
insert into USERDEMO (USERDEMO_ID,FIRSTNAME,LASTNAME,PHONE,MAIL,CITY,ZIPCODE,LOGIN,ADDRESS,CIVILITY,DATEOFBIRTH,PASSWORD,BUSINESSACTIVITY) values (1000,'S','S','S','S','S','S','S','S','S',current_date,'S','S');
insert into REQUESTDEMO (REQUESTDEMO_ID,TYPE,REASON,IDENTIFIER,STATUS,USERDEMO_ID) values (1000,'S','S','S','S',1000);
*/

/** 
// Start of user code edf2d5dad6ff823226bc881ca0d02300
*/

/** Code insertions à recopier. */

insert into USERDEMO (USERDEMO_ID,FIRSTNAME,LASTNAME,PHONE,MAIL,CITY,ZIPCODE,LOGIN,ADDRESS,CIVILITY,DATEOFBIRTH,PASSWORD,BUSINESSACTIVITY) values (1000,'S','S','S','S','S','S','S','S','S',current_date,'S','S');
insert into REQUESTDEMO (REQUESTDEMO_ID,TYPE,REASON,IDENTIFIER,STATUS,USERDEMO_ID) values (1000,'S','S','S','S',1000);

/** Vos données de test. */

/**
// End of user code
*/

/******************************************************************/
/* Contraintes                                                    */
/******************************************************************/
alter table REQUESTDEMO add constraint REQUESTDEMO_FK1_1 foreign key (USERDEMO_ID) references USERDEMO (USERDEMO_ID);
