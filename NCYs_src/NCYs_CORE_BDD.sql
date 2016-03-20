BEGIN TRANSACTION;
CREATE TABLE `Profile` (
	`Id_Profile`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`Name`	TEXT
);
INSERT INTO `Profile` (Id_Profile,Name) VALUES (1,'Default');
CREATE TABLE "Configuration" (
	`Id_Profile`	INTEGER,
	`Id_Application`	INTEGER,
	`Position`	TEXT,
	`Active`	TEXT
);
INSERT INTO `Configuration` (Id_Profile,Id_Application,Position,Active) VALUES (1,1,'500.1000','True');
CREATE TABLE `Application` (
	`Id_Application`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`Name`	TEXT,
	`Native`	TEXT
);
INSERT INTO `Application` (Id_Application,Name,Native) VALUES (1,'Clock','True');
COMMIT;
