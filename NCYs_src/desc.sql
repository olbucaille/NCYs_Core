SET DATABASE UNIQUE NAME HSQLDB53E812D53F
SET DATABASE GC 0
SET DATABASE DEFAULT RESULT MEMORY ROWS 0
SET DATABASE EVENT LOG LEVEL 0
SET DATABASE SQL NAMES FALSE
SET DATABASE SQL REFERENCES FALSE
SET DATABASE SQL SIZE TRUE
SET DATABASE SQL TYPES FALSE
SET DATABASE SQL TDC DELETE TRUE
SET DATABASE SQL TDC UPDATE TRUE
SET DATABASE SQL TRANSLATE TTI TYPES TRUE
SET DATABASE SQL CONCAT NULLS TRUE
SET DATABASE SQL UNIQUE NULLS TRUE
SET DATABASE SQL CONVERT TRUNCATE TRUE
SET DATABASE SQL DOUBLE NAN TRUE
SET DATABASE SQL LONGVAR IS LOB FALSE
SET DATABASE TRANSACTION CONTROL MVCC
SET DATABASE DEFAULT ISOLATION LEVEL READ COMMITTED
SET DATABASE TRANSACTION ROLLBACK ON DEADLOCK TRUE
SET DATABASE TEXT TABLE DEFAULTS ''
SET FILES WRITE DELAY 500 MILLIS
SET FILES BACKUP INCREMENT TRUE
SET FILES CACHE SIZE 10000
SET FILES CACHE ROWS 50000
SET FILES SCALE 32
SET FILES LOB SCALE 32
SET FILES DEFRAG 0
SET FILES NIO TRUE
SET FILES NIO SIZE 256
SET FILES LOG TRUE
SET FILES LOG SIZE 50
CREATE USER SA PASSWORD DIGEST 'd41d8cd98f00b204e9800998ecf8427e'
ALTER USER SA SET LOCAL TRUE
CREATE SCHEMA PUBLIC AUTHORIZATION DBA
SET SCHEMA PUBLIC
CREATE MEMORY TABLE PUBLIC.APPLICATION(ID_APPLICATION INTEGER NOT NULL PRIMARY KEY,NAME VARCHAR(25),NATIVE VARCHAR(25))
CREATE MEMORY TABLE PUBLIC.CONFIGURATION(ID_PROFILE INTEGER,ID_APPLICATION INTEGER,POSITION VARCHAR(25),ACTIVE VARCHAR(25))
CREATE MEMORY TABLE PUBLIC.PROFILE(ID_PROFILE INTEGER NOT NULL PRIMARY KEY,NAME VARCHAR(30))
ALTER SEQUENCE SYSTEM_LOBS.LOB_ID RESTART WITH 1
SET DATABASE DEFAULT INITIAL SCHEMA PUBLIC
GRANT USAGE ON DOMAIN INFORMATION_SCHEMA.YES_OR_NO TO PUBLIC
GRANT USAGE ON DOMAIN INFORMATION_SCHEMA.TIME_STAMP TO PUBLIC
GRANT USAGE ON DOMAIN INFORMATION_SCHEMA.CARDINAL_NUMBER TO PUBLIC
GRANT USAGE ON DOMAIN INFORMATION_SCHEMA.CHARACTER_DATA TO PUBLIC
GRANT USAGE ON DOMAIN INFORMATION_SCHEMA.SQL_IDENTIFIER TO PUBLIC
GRANT DBA TO SA
SET SCHEMA SYSTEM_LOBS
INSERT INTO BLOCKS VALUES(0,2147483647,0)
SET SCHEMA PUBLIC
INSERT INTO APPLICATION VALUES(1,'Clock','True')
INSERT INTO CONFIGURATION VALUES(1,1,'500.1000','True')
INSERT INTO PROFILE VALUES(1,'Default')
