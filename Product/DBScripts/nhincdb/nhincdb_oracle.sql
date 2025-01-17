--------------------------------------------------------
--  File created - Tuesday-February-25-2014   
--------------------------------------------------------

 CREATE USER nhincuser identified by nhincpass;
 
 GRANT RESOURCE,CONNECT to nhincuser;
 
--------------------------------------------------------
--  DDL for Sequence HIBERNATE_SEQUENCE
--------------------------------------------------------

   CREATE SEQUENCE  "NHINCUSER"."HIBERNATE_SEQUENCE"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 2961 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table AA_TO_HOME_COMMUNITY_MAPPING
--------------------------------------------------------

  CREATE TABLE "NHINCUSER"."AA_TO_HOME_COMMUNITY_MAPPING" 
   (	"ID" NUMBER(10,0), 
	"ASSIGNINGAUTHORITYID" VARCHAR2(64 BYTE), 
	"HOMECOMMUNITYID" VARCHAR2(64 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Table ADDRESS
--------------------------------------------------------

  CREATE TABLE "NHINCUSER"."ADDRESS" 
   (	"ADDRESSID" NUMBER(11,0), 
	"PATIENTID" NUMBER(11,0), 
	"STREET1" VARCHAR2(128 BYTE), 
	"STREET2" VARCHAR2(128 BYTE), 
	"CITY" VARCHAR2(128 BYTE), 
	"STATE" VARCHAR2(128 BYTE), 
	"POSTAL" VARCHAR2(45 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Table ASYNCMSGREPO
--------------------------------------------------------

  CREATE TABLE "NHINCUSER"."ASYNCMSGREPO" 
   (	"ID" NUMBER(10,0), 
	"MESSAGEID" VARCHAR2(100 BYTE), 
	"CREATIONTIME" DATE, 
	"RESPONSETIME" DATE, 
	"DURATION" NUMBER(10,0), 
	"SERVICENAME" VARCHAR2(45 BYTE), 
	"DIRECTION" VARCHAR2(10 BYTE), 
	"COMMUNITYID" VARCHAR2(100 BYTE), 
	"STATUS" VARCHAR2(45 BYTE), 
	"RESPONSETYPE" VARCHAR2(10 BYTE), 
	"RESERVED" VARCHAR2(100 BYTE), 
	"MSGDATA" BLOB, 
	"RSPDATA" BLOB, 
	"ACKDATA" BLOB
   ) ;
--------------------------------------------------------
--  DDL for Table AUDITREPOSITORY
--------------------------------------------------------

  CREATE TABLE "NHINCUSER"."AUDITREPOSITORY" 
   (	"ID" NUMBER, 
	"AUDIT_TIMESTAMP" DATE, 
	"EVENTID" NUMBER, 
	"USERID" VARCHAR2(100 BYTE), 
	"PARTICIPATIONTYPECODE" NUMBER, 
	"PARTICIPATIONTYPECODEROLE" NUMBER, 
	"PARTICIPATIONIDTYPECODE" VARCHAR2(100 BYTE), 
	"RECEIVERPATIENTID" VARCHAR2(128 BYTE), 
	"SENDERPATIENTID" VARCHAR2(128 BYTE), 
	"COMMUNITYID" VARCHAR2(255 BYTE), 
	"MESSAGETYPE" VARCHAR2(100 BYTE), 
	"MESSAGE" BLOB
   ) ;
--------------------------------------------------------
--  DDL for Table CORRELATEDIDENTIFIERS
--------------------------------------------------------

  CREATE TABLE "NHINCUSER"."CORRELATEDIDENTIFIERS" 
   (	"CORRELATIONID" NUMBER(10,0), 
	"PATIENTASSIGNINGAUTHORITYID" VARCHAR2(64 BYTE), 
	"PATIENTID" VARCHAR2(128 BYTE), 
	"CORRELATEDPATIENTASSIGNAUTHID" VARCHAR2(64 BYTE), 
	"CORRELATEDPATIENTID" VARCHAR2(128 BYTE), 
	"CORRELATIONEXPIRATIONDATE" DATE
   ) ;
--------------------------------------------------------
--  DDL for Table DOCUMENT
--------------------------------------------------------

  CREATE TABLE "NHINCUSER"."DOCUMENT" 
   (	"DOCUMENTID" NUMBER(11,0), 
	"DOCUMENTUNIQUEID" VARCHAR2(64 BYTE), 
	"DOCUMENTTITLE" VARCHAR2(128 BYTE) DEFAULT NULL, 
	"AUTHORPERSON" VARCHAR2(64 BYTE) DEFAULT NULL, 
	"AUTHORINSTITUTION" VARCHAR2(64 BYTE) DEFAULT NULL, 
	"AUTHORROLE" VARCHAR2(64 BYTE) DEFAULT NULL, 
	"AUTHORSPECIALTY" VARCHAR2(64 BYTE) DEFAULT NULL, 
	"AVAILABILITYSTATUS" VARCHAR2(64 BYTE) DEFAULT NULL, 
	"CLASSCODE" VARCHAR2(64 BYTE) DEFAULT NULL, 
	"CLASSCODESCHEME" VARCHAR2(64 BYTE) DEFAULT NULL, 
	"CLASSCODEDISPLAYNAME" VARCHAR2(64 BYTE) DEFAULT NULL, 
	"CONFIDENTIALITYCODE" VARCHAR2(64 BYTE) DEFAULT NULL, 
	"CONFIDENTIALITYCODESCHEME" VARCHAR2(64 BYTE) DEFAULT NULL, 
	"CONFIDENTIALITYCODEDISPLAYNAME" VARCHAR2(64 BYTE) DEFAULT NULL, 
	"CREATIONTIME" DATE DEFAULT NULL, 
	"FORMATCODE" VARCHAR2(64 BYTE) DEFAULT NULL, 
	"FORMATCODESCHEME" VARCHAR2(64 BYTE) DEFAULT NULL, 
	"FORMATCODEDISPLAYNAME" VARCHAR2(64 BYTE) DEFAULT NULL, 
	"PATIENTID" VARCHAR2(128 BYTE) DEFAULT NULL, 
	"SERVICESTARTTIME" DATE DEFAULT NULL, 
	"SERVICESTOPTIME" DATE DEFAULT NULL, 
	"STATUS" VARCHAR2(64 BYTE) DEFAULT NULL, 
	"COMMENTS" VARCHAR2(256 BYTE) DEFAULT NULL, 
	"HASH" VARCHAR2(1028 BYTE) DEFAULT NULL, 
	"FACILITYCODE" VARCHAR2(64 BYTE) DEFAULT NULL, 
	"FACILITYCODESCHEME" VARCHAR2(64 BYTE) DEFAULT NULL, 
	"FACILITYCODEDISPLAYNAME" VARCHAR2(64 BYTE) DEFAULT NULL, 
	"INTENDEDRECIPIENTPERSON" VARCHAR2(128 BYTE) DEFAULT NULL, 
	"INTENDEDRECIPIENTORGANIZATION" VARCHAR2(128 BYTE) DEFAULT NULL, 
	"LANGUAGECODE" VARCHAR2(64 BYTE) DEFAULT NULL, 
	"LEGALAUTHENTICATOR" VARCHAR2(128 BYTE) DEFAULT NULL, 
	"MIMETYPE" VARCHAR2(32 BYTE) DEFAULT NULL, 
	"PARENTDOCUMENTID" VARCHAR2(64 BYTE) DEFAULT NULL, 
	"PARENTDOCUMENTRELATIONSHIP" VARCHAR2(64 BYTE) DEFAULT NULL, 
	"PRACTICESETTING" VARCHAR2(64 BYTE) DEFAULT NULL, 
	"PRACTICESETTINGSCHEME" VARCHAR2(64 BYTE) DEFAULT NULL, 
	"PRACTICESETTINGDISPLAYNAME" VARCHAR2(64 BYTE) DEFAULT NULL, 
	"DOCUMENTSIZE" NUMBER(11,0) DEFAULT NULL, 
	"SOURCEPATIENTID" VARCHAR2(128 BYTE) DEFAULT NULL, 
	"PID3" VARCHAR2(128 BYTE) DEFAULT NULL, 
	"PID5" VARCHAR2(128 BYTE) DEFAULT NULL, 
	"PID7" VARCHAR2(128 BYTE) DEFAULT NULL, 
	"PID8" VARCHAR2(128 BYTE) DEFAULT NULL, 
	"PID11" VARCHAR2(128 BYTE) DEFAULT NULL, 
	"TYPECODE" VARCHAR2(64 BYTE) DEFAULT NULL, 
	"TYPECODESCHEME" VARCHAR2(64 BYTE) DEFAULT NULL, 
	"TYPECODEDISPLAYNAME" VARCHAR2(64 BYTE) DEFAULT NULL, 
	"DOCUMENTURI" VARCHAR2(128 BYTE) DEFAULT NULL, 
	"RAWDATA" BLOB, 
	"PERSISTENT" NUMBER(11,0), 
	"ONDEMAND" NUMBER(1,0), 
	"NEWDOCUMENTUNIQUEID" VARCHAR2(128 BYTE) DEFAULT NULL, 
	"NEWREPOSITORYUNIQUEID" VARCHAR2(128 BYTE) DEFAULT NULL
   ) ;
--------------------------------------------------------
--  DDL for Table EVENT
--------------------------------------------------------

  CREATE TABLE "NHINCUSER"."EVENT" 
   (	"ID" NUMBER(11,0), 
	"NAME" VARCHAR2(100 BYTE), 
	"TRANSACTIONID" VARCHAR2(100 BYTE), 
	"MESSAGEID" VARCHAR2(100 BYTE),
	"SERVICETYPE" VARCHAR2(100 BYTE),
	"INITIATINGHCID" VARCHAR2(100 BYTE),
	"RESPONDINGHCIDS" VARCHAR2(100 BYTE),
	"EVENTTIME" DATE, 
	"DESCRIPTION" VARCHAR2(4000 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Table EVENTCODE
--------------------------------------------------------

  CREATE TABLE "NHINCUSER"."EVENTCODE" 
   (	"EVENTCODEID" NUMBER(11,0), 
	"DOCUMENTID" NUMBER(11,0), 
	"EVENTCODE" VARCHAR2(64 BYTE) DEFAULT NULL, 
	"EVENTCODESCHEME" VARCHAR2(64 BYTE) DEFAULT NULL, 
	"EVENTCODEDISPLAYNAME" VARCHAR2(64 BYTE) DEFAULT NULL
   ) ;
--------------------------------------------------------
--  DDL for Table IDENTIFIER
--------------------------------------------------------

  CREATE TABLE "NHINCUSER"."IDENTIFIER" 
   (	"IDENTIFIERID" NUMBER(11,0), 
	"PATIENTID" NUMBER(11,0), 
	"ID" VARCHAR2(64 BYTE), 
	"ORGANIZATIONID" VARCHAR2(64 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Table PATIENT
--------------------------------------------------------

  CREATE TABLE "NHINCUSER"."PATIENT" 
   (	"PATIENTID" NUMBER(11,0), 
	"DATEOFBIRTH" DATE, 
	"GENDER" CHAR(2 BYTE), 
	"SSN" CHAR(9 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Table PDDEFERREDCORRELATION
--------------------------------------------------------

  CREATE TABLE "NHINCUSER"."PDDEFERREDCORRELATION" 
   (	"ID" NUMBER(11,0), 
	"MESSAGEID" VARCHAR2(100 BYTE), 
	"ASSIGNINGAUTHORITYID" VARCHAR2(64 BYTE), 
	"PATIENTID" VARCHAR2(128 BYTE), 
	"CREATIONTIME" DATE
   ) ;
--------------------------------------------------------
--  DDL for Table PERSONNAME
--------------------------------------------------------

  CREATE TABLE "NHINCUSER"."PERSONNAME" 
   (	"PERSONNAMEID" NUMBER(11,0), 
	"PATIENTID" NUMBER(11,0), 
	"PREFIX" VARCHAR2(64 BYTE), 
	"FIRSTNAME" VARCHAR2(64 BYTE), 
	"MIDDLENAME" VARCHAR2(64 BYTE), 
	"LASTNAME" VARCHAR2(64 BYTE), 
	"SUFFIX" VARCHAR2(64 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Table PHONENUMBER
--------------------------------------------------------

  CREATE TABLE "NHINCUSER"."PHONENUMBER" 
   (	"PHONENUMBERID" NUMBER(11,0), 
	"PATIENTID" NUMBER(11,0), 
	"VALUE" VARCHAR2(64 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Table TRANSACTIONREPOSITORY
--------------------------------------------------------

  CREATE TABLE "NHINCUSER"."TRANSACTIONREPOSITORY" 
   (	"ID" NUMBER(11,0), 
	"TRANSACTIONID" VARCHAR2(100 BYTE), 
	"MESSAGEID" VARCHAR2(100 BYTE), 
	"TRANSACTIONTIME" DATE
   ) ;
--------------------------------------------------------
--  DDL for Table TRANSFER_DATA
--------------------------------------------------------

  CREATE TABLE "NHINCUSER"."TRANSFER_DATA" 
   (	"ID" NUMBER, 
	"REQUESTKEYGUID" VARCHAR2(64 BYTE), 
	"TRANSFERSTATE" VARCHAR2(32 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Table USERLOGIN
--------------------------------------------------------

  CREATE TABLE "NHINCUSER"."USERLOGIN"
   (	"ID" NUMBER,
	"SALT" VARCHAR2(100 BYTE),
	"SHA1" VARCHAR2(100 BYTE),
	"USERNAME" VARCHAR2(100 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Index MESSAGEID_IDX
--------------------------------------------------------

  CREATE UNIQUE INDEX "NHINCUSER"."MESSAGEID_IDX" ON "NHINCUSER"."TRANSACTIONREPOSITORY" ("MESSAGEID") 
  ;
--------------------------------------------------------
--  Constraints for Table CORRELATEDIDENTIFIERS
--------------------------------------------------------

  ALTER TABLE "NHINCUSER"."CORRELATEDIDENTIFIERS" ADD PRIMARY KEY ("CORRELATIONID") ENABLE;
  ALTER TABLE "NHINCUSER"."CORRELATEDIDENTIFIERS" MODIFY ("CORRELATEDPATIENTID" NOT NULL ENABLE);
  ALTER TABLE "NHINCUSER"."CORRELATEDIDENTIFIERS" MODIFY ("CORRELATEDPATIENTASSIGNAUTHID" NOT NULL ENABLE);
  ALTER TABLE "NHINCUSER"."CORRELATEDIDENTIFIERS" MODIFY ("PATIENTID" NOT NULL ENABLE);
  ALTER TABLE "NHINCUSER"."CORRELATEDIDENTIFIERS" MODIFY ("PATIENTASSIGNINGAUTHORITYID" NOT NULL ENABLE);
  ALTER TABLE "NHINCUSER"."CORRELATEDIDENTIFIERS" MODIFY ("CORRELATIONID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table AUDITREPOSITORY
--------------------------------------------------------

  ALTER TABLE "NHINCUSER"."AUDITREPOSITORY" ADD PRIMARY KEY ("ID") ENABLE;
  ALTER TABLE "NHINCUSER"."AUDITREPOSITORY" MODIFY ("MESSAGETYPE" NOT NULL ENABLE);
  ALTER TABLE "NHINCUSER"."AUDITREPOSITORY" MODIFY ("EVENTID" NOT NULL ENABLE);
  ALTER TABLE "NHINCUSER"."AUDITREPOSITORY" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PATIENT
--------------------------------------------------------

  ALTER TABLE "NHINCUSER"."PATIENT" ADD PRIMARY KEY ("PATIENTID") ENABLE;
  ALTER TABLE "NHINCUSER"."PATIENT" MODIFY ("PATIENTID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table ADDRESS
--------------------------------------------------------

  ALTER TABLE "NHINCUSER"."ADDRESS" ADD PRIMARY KEY ("ADDRESSID") ENABLE;
  ALTER TABLE "NHINCUSER"."ADDRESS" MODIFY ("PATIENTID" NOT NULL ENABLE);
  ALTER TABLE "NHINCUSER"."ADDRESS" MODIFY ("ADDRESSID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table IDENTIFIER
--------------------------------------------------------

  ALTER TABLE "NHINCUSER"."IDENTIFIER" ADD PRIMARY KEY ("IDENTIFIERID") ENABLE;
  ALTER TABLE "NHINCUSER"."IDENTIFIER" MODIFY ("PATIENTID" NOT NULL ENABLE);
  ALTER TABLE "NHINCUSER"."IDENTIFIER" MODIFY ("IDENTIFIERID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table EVENTCODE
--------------------------------------------------------

  ALTER TABLE "NHINCUSER"."EVENTCODE" ADD PRIMARY KEY ("EVENTCODEID") ENABLE;
  ALTER TABLE "NHINCUSER"."EVENTCODE" MODIFY ("DOCUMENTID" NOT NULL ENABLE);
  ALTER TABLE "NHINCUSER"."EVENTCODE" MODIFY ("EVENTCODEID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PERSONNAME
--------------------------------------------------------

  ALTER TABLE "NHINCUSER"."PERSONNAME" ADD PRIMARY KEY ("PERSONNAMEID") ENABLE;
  ALTER TABLE "NHINCUSER"."PERSONNAME" MODIFY ("PATIENTID" NOT NULL ENABLE);
  ALTER TABLE "NHINCUSER"."PERSONNAME" MODIFY ("PERSONNAMEID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table EVENT
--------------------------------------------------------

  ALTER TABLE "NHINCUSER"."EVENT" ADD PRIMARY KEY ("ID") ENABLE;
  ALTER TABLE "NHINCUSER"."EVENT" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "NHINCUSER"."EVENT" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TRANSFER_DATA
--------------------------------------------------------

  ALTER TABLE "NHINCUSER"."TRANSFER_DATA" ADD PRIMARY KEY ("ID") ENABLE;
  ALTER TABLE "NHINCUSER"."TRANSFER_DATA" MODIFY ("TRANSFERSTATE" NOT NULL ENABLE);
  ALTER TABLE "NHINCUSER"."TRANSFER_DATA" MODIFY ("REQUESTKEYGUID" NOT NULL ENABLE);
  ALTER TABLE "NHINCUSER"."TRANSFER_DATA" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table DOCUMENT
--------------------------------------------------------

  ALTER TABLE "NHINCUSER"."DOCUMENT" ADD PRIMARY KEY ("DOCUMENTID") ENABLE;
  ALTER TABLE "NHINCUSER"."DOCUMENT" MODIFY ("ONDEMAND" NOT NULL ENABLE);
  ALTER TABLE "NHINCUSER"."DOCUMENT" MODIFY ("PERSISTENT" NOT NULL ENABLE);
  ALTER TABLE "NHINCUSER"."DOCUMENT" MODIFY ("DOCUMENTUNIQUEID" NOT NULL ENABLE);
  ALTER TABLE "NHINCUSER"."DOCUMENT" MODIFY ("DOCUMENTID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TRANSACTIONREPOSITORY
--------------------------------------------------------

  ALTER TABLE "NHINCUSER"."TRANSACTIONREPOSITORY" ADD PRIMARY KEY ("ID") ENABLE;
  ALTER TABLE "NHINCUSER"."TRANSACTIONREPOSITORY" MODIFY ("MESSAGEID" NOT NULL ENABLE);
  ALTER TABLE "NHINCUSER"."TRANSACTIONREPOSITORY" MODIFY ("TRANSACTIONID" NOT NULL ENABLE);
  ALTER TABLE "NHINCUSER"."TRANSACTIONREPOSITORY" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table AA_TO_HOME_COMMUNITY_MAPPING
--------------------------------------------------------

  ALTER TABLE "NHINCUSER"."AA_TO_HOME_COMMUNITY_MAPPING" ADD PRIMARY KEY ("ID", "ASSIGNINGAUTHORITYID") ENABLE;
  ALTER TABLE "NHINCUSER"."AA_TO_HOME_COMMUNITY_MAPPING" MODIFY ("HOMECOMMUNITYID" NOT NULL ENABLE);
  ALTER TABLE "NHINCUSER"."AA_TO_HOME_COMMUNITY_MAPPING" MODIFY ("ASSIGNINGAUTHORITYID" NOT NULL ENABLE);
  ALTER TABLE "NHINCUSER"."AA_TO_HOME_COMMUNITY_MAPPING" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PDDEFERREDCORRELATION
--------------------------------------------------------

  ALTER TABLE "NHINCUSER"."PDDEFERREDCORRELATION" ADD PRIMARY KEY ("ID") ENABLE;
  ALTER TABLE "NHINCUSER"."PDDEFERREDCORRELATION" MODIFY ("CREATIONTIME" NOT NULL ENABLE);
  ALTER TABLE "NHINCUSER"."PDDEFERREDCORRELATION" MODIFY ("PATIENTID" NOT NULL ENABLE);
  ALTER TABLE "NHINCUSER"."PDDEFERREDCORRELATION" MODIFY ("ASSIGNINGAUTHORITYID" NOT NULL ENABLE);
  ALTER TABLE "NHINCUSER"."PDDEFERREDCORRELATION" MODIFY ("MESSAGEID" NOT NULL ENABLE);
  ALTER TABLE "NHINCUSER"."PDDEFERREDCORRELATION" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PHONENUMBER
--------------------------------------------------------

  ALTER TABLE "NHINCUSER"."PHONENUMBER" ADD PRIMARY KEY ("PHONENUMBERID") ENABLE;
  ALTER TABLE "NHINCUSER"."PHONENUMBER" MODIFY ("PATIENTID" NOT NULL ENABLE);
  ALTER TABLE "NHINCUSER"."PHONENUMBER" MODIFY ("PHONENUMBERID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table ASYNCMSGREPO
--------------------------------------------------------

  ALTER TABLE "NHINCUSER"."ASYNCMSGREPO" ADD PRIMARY KEY ("ID") ENABLE;
  ALTER TABLE "NHINCUSER"."ASYNCMSGREPO" MODIFY ("CREATIONTIME" NOT NULL ENABLE);
  ALTER TABLE "NHINCUSER"."ASYNCMSGREPO" MODIFY ("MESSAGEID" NOT NULL ENABLE);
  ALTER TABLE "NHINCUSER"."ASYNCMSGREPO" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table USERLOGIN
--------------------------------------------------------

  ALTER TABLE "NHINCUSER"."USERLOGIN" ADD PRIMARY KEY ("ID") ENABLE;
  ALTER TABLE "NHINCUSER"."USERLOGIN" MODIFY ("SALT" NOT NULL ENABLE);
  ALTER TABLE "NHINCUSER"."USERLOGIN" MODIFY ("SHA1" NOT NULL ENABLE);
  ALTER TABLE "NHINCUSER"."USERLOGIN" MODIFY ("USERNAME" NOT NULL ENABLE);

  INSERT INTO NHINCUSER.USERLOGIN
    (ID, SALT, SHA1, USERNAME)
  VALUES
    (1, "ABCD", "TxMu4SPUdek0XU5NovS9U2llt3Q=", "CONNECTAdmin");
