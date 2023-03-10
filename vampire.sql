# HeidiSQL Dump 
#
# --------------------------------------------------------
# Host:                 127.0.0.1
# Database:             vampire
# Server version:       5.4.1-beta-community
# Server OS:            Win32
# Target-Compatibility: Standard ANSI SQL
# HeidiSQL version:     3.1 RC1 Revision: 1064
# --------------------------------------------------------

/*!40100 SET CHARACTER SET latin1;*/
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ANSI';*/
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;*/


#
# Database structure for database 'vampire'
#

CREATE DATABASE /*!32312 IF NOT EXISTS*/ "vampire" /*!40100 DEFAULT CHARACTER SET latin1 */;

USE "vampire";


#
# Table structure for table 'logininfo'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "logininfo" (
  "name" varchar(50) NOT NULL,
  "ipaddress" varchar(50) NOT NULL,
  "portnumber" varchar(50) NOT NULL,
  "time" timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  "attack" varchar(50) DEFAULT NULL,
  "attacktype" varchar(50) DEFAULT NULL,
  "actualenergy" int(20) unsigned DEFAULT NULL,
  "energy" int(20) unsigned DEFAULT NULL
) /*!40100 DEFAULT CHARSET=latin1*/;



#
# Dumping data for table 'logininfo'
#

/*!40000 ALTER TABLE "logininfo" DISABLE KEYS;*/
LOCK TABLES "logininfo" WRITE;
REPLACE INTO "logininfo" ("name", "ipaddress", "portnumber", "time", "attack", "attacktype", "actualenergy", "energy") VALUES
	('A','localhost','4001','2014-01-20 20:35:27','NO',NULL,'1000','980');
REPLACE INTO "logininfo" ("name", "ipaddress", "portnumber", "time", "attack", "attacktype", "actualenergy", "energy") VALUES
	('B','localhost','4002','2014-01-20 20:35:32','NO',NULL,'1000','980');
REPLACE INTO "logininfo" ("name", "ipaddress", "portnumber", "time", "attack", "attacktype", "actualenergy", "energy") VALUES
	('C','localhost','4003','2014-01-20 20:35:39','YES','carousel','1000','940');
REPLACE INTO "logininfo" ("name", "ipaddress", "portnumber", "time", "attack", "attacktype", "actualenergy", "energy") VALUES
	('D','localhost','4004','2014-01-20 20:35:44','NO',NULL,'1000','980');
UNLOCK TABLES;
/*!40000 ALTER TABLE "logininfo" ENABLE KEYS;*/


#
# Table structure for table 'loginmaintain'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "loginmaintain" (
  "name" varchar(50) NOT NULL,
  "ipaddress" varchar(50) NOT NULL,
  "portnumber" varchar(50) NOT NULL,
  "time" timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) /*!40100 DEFAULT CHARSET=latin1*/;



#
# Dumping data for table 'loginmaintain'
#

/*!40000 ALTER TABLE "loginmaintain" DISABLE KEYS;*/
LOCK TABLES "loginmaintain" WRITE;
REPLACE INTO "loginmaintain" ("name", "ipaddress", "portnumber", "time") VALUES
	('A','localhost','4001','2014-01-20 20:35:50');
REPLACE INTO "loginmaintain" ("name", "ipaddress", "portnumber", "time") VALUES
	('B','localhost','4002','2014-01-20 20:35:56');
REPLACE INTO "loginmaintain" ("name", "ipaddress", "portnumber", "time") VALUES
	('C','localhost','4003','2014-01-20 20:36:00');
REPLACE INTO "loginmaintain" ("name", "ipaddress", "portnumber", "time") VALUES
	('D','localhost','4004','2014-01-20 20:36:05');
UNLOCK TABLES;
/*!40000 ALTER TABLE "loginmaintain" ENABLE KEYS;*/


#
# Table structure for table 'pathinfo'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "pathinfo" (
  "paths" varchar(50) DEFAULT NULL,
  "time" int(50) DEFAULT NULL
) /*!40100 DEFAULT CHARSET=latin1*/;



#
# Dumping data for table 'pathinfo'
#

/*!40000 ALTER TABLE "pathinfo" DISABLE KEYS;*/
LOCK TABLES "pathinfo" WRITE;
REPLACE INTO "pathinfo" ("paths", "time") VALUES
	('B=>D',9);
REPLACE INTO "pathinfo" ("paths", "time") VALUES
	('B=>A=>D',22);
REPLACE INTO "pathinfo" ("paths", "time") VALUES
	('B=>C=>D',36);
REPLACE INTO "pathinfo" ("paths", "time") VALUES
	('B=>A=>C=>D',54);
REPLACE INTO "pathinfo" ("paths", "time") VALUES
	('B=>C=>A=>D',72);
UNLOCK TABLES;
/*!40000 ALTER TABLE "pathinfo" ENABLE KEYS;*/


#
# Table structure for table 'topology'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "topology" (
  "source" varchar(50) DEFAULT NULL,
  "destination" varchar(50) DEFAULT NULL,
  "distance" varchar(50) DEFAULT NULL
) /*!40100 DEFAULT CHARSET=latin1*/;



#
# Dumping data for table 'topology'
#

/*!40000 ALTER TABLE "topology" DISABLE KEYS;*/
LOCK TABLES "topology" WRITE;
REPLACE INTO "topology" ("source", "destination", "distance") VALUES
	('A','B','4');
REPLACE INTO "topology" ("source", "destination", "distance") VALUES
	('A','C','5');
REPLACE INTO "topology" ("source", "destination", "distance") VALUES
	('A','D','6');
REPLACE INTO "topology" ("source", "destination", "distance") VALUES
	('B','A','7');
REPLACE INTO "topology" ("source", "destination", "distance") VALUES
	('B','C','8');
REPLACE INTO "topology" ("source", "destination", "distance") VALUES
	('B','D','9');
REPLACE INTO "topology" ("source", "destination", "distance") VALUES
	('C','A','4');
REPLACE INTO "topology" ("source", "destination", "distance") VALUES
	('C','B','5');
REPLACE INTO "topology" ("source", "destination", "distance") VALUES
	('C','D','6');
REPLACE INTO "topology" ("source", "destination", "distance") VALUES
	('D','A','7');
REPLACE INTO "topology" ("source", "destination", "distance") VALUES
	('D','B','8');
REPLACE INTO "topology" ("source", "destination", "distance") VALUES
	('D','C','9');
UNLOCK TABLES;
/*!40000 ALTER TABLE "topology" ENABLE KEYS;*/
/*!40101 SET SQL_MODE=@OLD_SQL_MODE;*/
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;*/
