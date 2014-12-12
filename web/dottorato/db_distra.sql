# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.6.21)
# Database: db_distra
# Generation Time: 2014-12-12 16:54:09 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table account
# ------------------------------------------------------------

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `email` varchar(100) NOT NULL COMMENT 'Nome con il quale l''utente viene riconosciuto da un',
  `password` varchar(45) NOT NULL,
  `typeOfAccount` varchar(45) NOT NULL,
  `active` tinyint(1) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabella adibita alla gestione dei dati principali per l''acesso al sistema';

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;

INSERT INTO `account` (`email`, `password`, `typeOfAccount`, `active`)
VALUES
	('gemma.catolino91@gmail.com','CIAO','Bstudent',1);

/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table allegato
# ------------------------------------------------------------

DROP TABLE IF EXISTS `allegato`;

CREATE TABLE `allegato` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Oggetto` varchar(255) NOT NULL,
  `ID_Tesi` int(11) NOT NULL,
  `Stato` enum('0','1') NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  KEY `ID_Tesi` (`ID_Tesi`),
  CONSTRAINT `allegato_ibfk_1` FOREIGN KEY (`ID_Tesi`) REFERENCES `tesi` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table annuncio
# ------------------------------------------------------------

DROP TABLE IF EXISTS `annuncio`;

CREATE TABLE `annuncio` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Testo` text NOT NULL,
  `ID_Docente` varchar(16) NOT NULL,
  `Data_Annuncio` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  KEY `ID_Docente` (`ID_Docente`),
  CONSTRAINT `annuncio_ibfk_1` FOREIGN KEY (`ID_Docente`) REFERENCES `person` (`SSN`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table class
# ------------------------------------------------------------

DROP TABLE IF EXISTS `class`;

CREATE TABLE `class` (
  `title` varchar(50) NOT NULL,
  `teaching_matricula` varchar(10) NOT NULL,
  PRIMARY KEY (`title`,`teaching_matricula`),
  KEY `title` (`title`),
  KEY `teaching_matricula` (`teaching_matricula`),
  CONSTRAINT `fk_class_teaching1` FOREIGN KEY (`teaching_matricula`) REFERENCES `teaching` (`matricula`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table class_event
# ------------------------------------------------------------

DROP TABLE IF EXISTS `class_event`;

CREATE TABLE `class_event` (
  `FK_Class` int(11) NOT NULL,
  `FK_Event` int(11) NOT NULL,
  PRIMARY KEY (`FK_Class`,`FK_Event`),
  KEY `FK_Event` (`FK_Event`),
  KEY `FK_Class` (`FK_Class`),
  CONSTRAINT `class_event_ibfk_1` FOREIGN KEY (`FK_Class`) REFERENCES `phdclass` (`idClass`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `class_event_ibfk_2` FOREIGN KEY (`FK_Event`) REFERENCES `event` (`idEvent`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table class_notice
# ------------------------------------------------------------

DROP TABLE IF EXISTS `class_notice`;

CREATE TABLE `class_notice` (
  `FK_Class` int(11) NOT NULL,
  `FK_Event` int(11) NOT NULL,
  PRIMARY KEY (`FK_Class`,`FK_Event`),
  KEY `FK_Event` (`FK_Event`),
  KEY `FK_Class` (`FK_Class`),
  CONSTRAINT `class_notice_ibfk_1` FOREIGN KEY (`FK_Event`) REFERENCES `event` (`idEvent`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `class_notice_ibfk_2` FOREIGN KEY (`FK_Class`) REFERENCES `phdclass` (`idClass`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table collaboration
# ------------------------------------------------------------

DROP TABLE IF EXISTS `collaboration`;

CREATE TABLE `collaboration` (
  `idCollaboration` int(20) NOT NULL,
  `istitution` varchar(45) NOT NULL,
  `description` text NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL,
  `FK_Student` varchar(16) NOT NULL,
  PRIMARY KEY (`idCollaboration`),
  KEY `FK_Student` (`FK_Student`),
  CONSTRAINT `collaboration_ibfk_1` FOREIGN KEY (`FK_Student`) REFERENCES `person` (`SSN`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table cronologia
# ------------------------------------------------------------

DROP TABLE IF EXISTS `cronologia`;

CREATE TABLE `cronologia` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Testo` varchar(255) NOT NULL,
  `ID_Docente` varchar(16) NOT NULL,
  `ID_Studente` varchar(16) NOT NULL,
  `Data_Notifica` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `fk_person1` (`ID_Studente`),
  UNIQUE KEY `fk_person2` (`ID_Docente`),
  CONSTRAINT `cronologia_ibfk_1` FOREIGN KEY (`ID_Docente`) REFERENCES `person` (`SSN`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `cronologia_ibfk_2` FOREIGN KEY (`ID_Studente`) REFERENCES `person` (`SSN`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table curriculum
# ------------------------------------------------------------

DROP TABLE IF EXISTS `curriculum`;

CREATE TABLE `curriculum` (
  `title` varchar(100) NOT NULL,
  `matricula` varchar(45) NOT NULL,
  `degree_matricula` varchar(5) NOT NULL,
  `active` tinyint(1) NOT NULL,
  PRIMARY KEY (`matricula`),
  KEY `fk_curriculum_degree1_idx` (`degree_matricula`),
  CONSTRAINT `fk_curriculum_degree1` FOREIGN KEY (`degree_matricula`) REFERENCES `degree` (`matricula`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table curriculum_teaching
# ------------------------------------------------------------

DROP TABLE IF EXISTS `curriculum_teaching`;

CREATE TABLE `curriculum_teaching` (
  `curriculum_matricula` varchar(45) NOT NULL,
  `teaching_matricula` varchar(10) NOT NULL,
  KEY `curriculum_matricula` (`curriculum_matricula`),
  KEY `teaching_matricula` (`teaching_matricula`),
  CONSTRAINT `curriculum_teaching_ibfk_1` FOREIGN KEY (`curriculum_matricula`) REFERENCES `curriculum` (`matricula`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `curriculum_teaching_ibfk_2` FOREIGN KEY (`teaching_matricula`) REFERENCES `teaching` (`matricula`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table cycle
# ------------------------------------------------------------

DROP TABLE IF EXISTS `cycle`;

CREATE TABLE `cycle` (
  `cycle_number` int(11) NOT NULL,
  `title` varchar(20) NOT NULL,
  PRIMARY KEY (`cycle_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `cycle` WRITE;
/*!40000 ALTER TABLE `cycle` DISABLE KEYS */;

INSERT INTO `cycle` (`cycle_number`, `title`)
VALUES
	(1,'studente triennale'),
	(2,'studente magistrale'),
	(3,'phd student'),
	(4,'professore'),
	(5,'azienda');

/*!40000 ALTER TABLE `cycle` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table degree
# ------------------------------------------------------------

DROP TABLE IF EXISTS `degree`;

CREATE TABLE `degree` (
  `title` varchar(500) NOT NULL,
  `matricula` varchar(5) NOT NULL,
  `link` varchar(500) DEFAULT NULL,
  `department_abbreviation` varchar(100) NOT NULL,
  `cycle_number` int(11) NOT NULL,
  `active` tinyint(1) NOT NULL,
  PRIMARY KEY (`matricula`),
  KEY `fk_degree_department1_idx` (`department_abbreviation`),
  KEY `fk_degree_cycle1_idx` (`cycle_number`),
  CONSTRAINT `fk_degree_cycle1` FOREIGN KEY (`cycle_number`) REFERENCES `cycle` (`cycle_number`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_degree_department1` FOREIGN KEY (`department_abbreviation`) REFERENCES `department` (`abbreviation`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `degree` WRITE;
/*!40000 ALTER TABLE `degree` DISABLE KEYS */;

INSERT INTO `degree` (`title`, `matricula`, `link`, `department_abbreviation`, `cycle_number`, `active`)
VALUES
	('MIT','02255',NULL,'distra',2,1),
	('EM','03345',NULL,'distra',1,1),
	('CM','04453',NULL,'distra',2,1),
	('DMIT','88876',NULL,'distra',3,1);

/*!40000 ALTER TABLE `degree` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table department
# ------------------------------------------------------------

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `abbreviation` varchar(50) NOT NULL,
  `title` varchar(500) DEFAULT NULL,
  `url_moodle` varchar(1000) DEFAULT NULL,
  `token` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`abbreviation`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;

INSERT INTO `department` (`abbreviation`, `title`, `url_moodle`, `token`)
VALUES
	('distra',NULL,NULL,NULL);

/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table event
# ------------------------------------------------------------

DROP TABLE IF EXISTS `event`;

CREATE TABLE `event` (
  `idEvent` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `description` text NOT NULL,
  `hours` int(1) NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL,
  `type` varchar(10) NOT NULL,
  PRIMARY KEY (`idEvent`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table event_professor
# ------------------------------------------------------------

DROP TABLE IF EXISTS `event_professor`;

CREATE TABLE `event_professor` (
  `FK_Event` int(11) NOT NULL,
  `FK_Professor` varchar(16) NOT NULL,
  PRIMARY KEY (`FK_Event`,`FK_Professor`),
  KEY `FK_Professor` (`FK_Professor`),
  KEY `FK_Event` (`FK_Event`),
  CONSTRAINT `event_professor_ibfk_1` FOREIGN KEY (`FK_Event`) REFERENCES `event` (`idEvent`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `event_professor_ibfk_2` FOREIGN KEY (`FK_Professor`) REFERENCES `person` (`SSN`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table lesson
# ------------------------------------------------------------

DROP TABLE IF EXISTS `lesson`;

CREATE TABLE `lesson` (
  `idLesson` int(20) NOT NULL,
  `name` varchar(45) NOT NULL,
  `speaker` varchar(45) NOT NULL,
  `date` date NOT NULL,
  `startTime` time NOT NULL,
  `endTime` time NOT NULL,
  `place` varchar(45) NOT NULL,
  `FK_Event` int(11) NOT NULL,
  PRIMARY KEY (`idLesson`),
  KEY `FK_Event` (`FK_Event`),
  CONSTRAINT `lesson_ibfk_1` FOREIGN KEY (`FK_Event`) REFERENCES `event` (`idEvent`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table lesson_student
# ------------------------------------------------------------

DROP TABLE IF EXISTS `lesson_student`;

CREATE TABLE `lesson_student` (
  `FK_Lesson` int(20) NOT NULL,
  `FK_Student` varchar(16) NOT NULL,
  PRIMARY KEY (`FK_Lesson`,`FK_Student`),
  KEY `FK_Student` (`FK_Student`),
  KEY `FK_Lesson` (`FK_Lesson`),
  CONSTRAINT `lesson_student_ibfk_1` FOREIGN KEY (`FK_Student`) REFERENCES `person` (`SSN`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `lesson_student_ibfk_2` FOREIGN KEY (`FK_Lesson`) REFERENCES `lesson` (`idLesson`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table mission
# ------------------------------------------------------------

DROP TABLE IF EXISTS `mission`;

CREATE TABLE `mission` (
  `idMission` int(20) NOT NULL,
  `place` varchar(45) NOT NULL,
  `description` text NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL,
  `FK_Student` varchar(16) NOT NULL,
  PRIMARY KEY (`idMission`),
  KEY `FK_Student` (`FK_Student`),
  CONSTRAINT `mission_ibfk_1` FOREIGN KEY (`FK_Student`) REFERENCES `person` (`SSN`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table module
# ------------------------------------------------------------

DROP TABLE IF EXISTS `module`;

CREATE TABLE `module` (
  `title` varchar(50) NOT NULL,
  `teaching_matricula` varchar(10) NOT NULL,
  PRIMARY KEY (`title`,`teaching_matricula`),
  KEY `fk_module_teaching1_idx` (`teaching_matricula`),
  CONSTRAINT `fk_module_teaching1` FOREIGN KEY (`teaching_matricula`) REFERENCES `teaching` (`matricula`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table notice
# ------------------------------------------------------------

DROP TABLE IF EXISTS `notice`;

CREATE TABLE `notice` (
  `idNotice` int(11) NOT NULL,
  `object` varchar(45) NOT NULL,
  `text` text NOT NULL,
  PRIMARY KEY (`idNotice`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;



# Dump of table offer_training
# ------------------------------------------------------------

DROP TABLE IF EXISTS `offer_training`;

CREATE TABLE `offer_training` (
  `id_offer_training` int(11) NOT NULL AUTO_INCREMENT,
  `description` longtext,
  `fk_organization` int(11) DEFAULT NULL,
  `fk_person` varchar(16) NOT NULL,
  `fk_department` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_offer_training`),
  KEY `fk_OfferTraining_Organization1_idx` (`fk_organization`),
  KEY `fk_OfferTraining_Professor1_idx` (`fk_person`),
  KEY `fk_OfferTraining_Department1_idx` (`fk_department`),
  CONSTRAINT `fk_OfferTraining_Department1` FOREIGN KEY (`fk_department`) REFERENCES `department` (`abbreviation`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_OfferTraining_Organization1` FOREIGN KEY (`fk_organization`) REFERENCES `organization` (`id_organization`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_OfferTraining_Professor1` FOREIGN KEY (`fk_person`) REFERENCES `person` (`SSN`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table organization
# ------------------------------------------------------------

DROP TABLE IF EXISTS `organization`;

CREATE TABLE `organization` (
  `id_organization` int(11) NOT NULL AUTO_INCREMENT,
  `companyName` varchar(45) NOT NULL,
  `city` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `fk_account` varchar(100) NOT NULL,
  `fk_externaltutor` varchar(16) DEFAULT NULL,
  `fk_professor` varchar(16) NOT NULL,
  PRIMARY KEY (`id_organization`),
  KEY `fk_acc` (`fk_account`),
  KEY `fk_tutor` (`fk_externaltutor`),
  KEY `fk_prof` (`fk_professor`),
  CONSTRAINT `fk_acc` FOREIGN KEY (`fk_account`) REFERENCES `account` (`email`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_prof` FOREIGN KEY (`fk_professor`) REFERENCES `person` (`SSN`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tutor` FOREIGN KEY (`fk_externaltutor`) REFERENCES `person` (`SSN`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table pending_acceptance
# ------------------------------------------------------------

DROP TABLE IF EXISTS `pending_acceptance`;

CREATE TABLE `pending_acceptance` (
  `id_pending_acceptance` int(11) NOT NULL AUTO_INCREMENT,
  `date_request` date DEFAULT NULL,
  `fk_person` varchar(16) NOT NULL,
  PRIMARY KEY (`id_pending_acceptance`),
  KEY `fk_StudentAttendence_Student1_idx` (`fk_person`),
  CONSTRAINT `fk_StudentAttendence_Student1` FOREIGN KEY (`fk_person`) REFERENCES `person` (`SSN`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table person
# ------------------------------------------------------------

DROP TABLE IF EXISTS `person`;

CREATE TABLE `person` (
  `SSN` varchar(16) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `zip_code` varchar(45) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `citizenship` varchar(45) DEFAULT NULL,
  `Account_email` varchar(100) NOT NULL,
  `Department_abbreviation` varchar(50) NOT NULL,
  `web_page` varchar(300) DEFAULT NULL,
  `university` varchar(200) DEFAULT NULL,
  `matricula` varchar(10) DEFAULT NULL,
  `position` varchar(50) DEFAULT NULL,
  `cycle` int(11) DEFAULT NULL,
  `degree_matricula` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`SSN`),
  KEY `fk_Person_Account_idx` (`Account_email`),
  KEY `fk_Person_Department1_idx` (`Department_abbreviation`),
  KEY `fk_cycle` (`cycle`),
  KEY `degree_matricula` (`degree_matricula`),
  CONSTRAINT `fk_Person_Account` FOREIGN KEY (`Account_email`) REFERENCES `account` (`email`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Person_Department1` FOREIGN KEY (`Department_abbreviation`) REFERENCES `department` (`abbreviation`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `person_ibfk_1` FOREIGN KEY (`cycle`) REFERENCES `cycle` (`cycle_number`),
  CONSTRAINT `person_ibfk_2` FOREIGN KEY (`degree_matricula`) REFERENCES `degree` (`matricula`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;

INSERT INTO `person` (`SSN`, `name`, `surname`, `phone`, `city`, `address`, `zip_code`, `gender`, `citizenship`, `Account_email`, `Department_abbreviation`, `web_page`, `university`, `matricula`, `position`, `cycle`, `degree_matricula`)
VALUES
	('CTLGMM91A71B519A','Gemma','Catolino','3272844649','Baranello','Contrada Gaudo n. 27','86011','F','Italiana','gemma.catolino91@gmail.com','distra','null','UniversitÃ  degli Studi di Salerno','142524','null',1,'02255');

/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table phdclass
# ------------------------------------------------------------

DROP TABLE IF EXISTS `phdclass`;

CREATE TABLE `phdclass` (
  `idClass` int(20) NOT NULL,
  `FK_PhdCycle` int(11) NOT NULL,
  `FK_PhdCurriculum` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`idClass`),
  UNIQUE KEY `FK_cycle` (`FK_PhdCycle`),
  KEY `FK_PhdCurriculum` (`FK_PhdCurriculum`),
  CONSTRAINT `phdclass_ibfk_1` FOREIGN KEY (`FK_PhdCycle`) REFERENCES `phdcycle` (`idPhdCycle`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `phdclass_ibfk_2` FOREIGN KEY (`FK_PhdCurriculum`) REFERENCES `phdcurriculum` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table phdcurriculum
# ------------------------------------------------------------

DROP TABLE IF EXISTS `phdcurriculum`;

CREATE TABLE `phdcurriculum` (
  `name` varchar(45) NOT NULL,
  `description` text,
  `FK_Professor` varchar(16) DEFAULT '',
  PRIMARY KEY (`name`),
  KEY `FK_Professor` (`FK_Professor`),
  CONSTRAINT `phdcurriculum_ibfk_1` FOREIGN KEY (`FK_Professor`) REFERENCES `person` (`SSN`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table phdcycle
# ------------------------------------------------------------

DROP TABLE IF EXISTS `phdcycle`;

CREATE TABLE `phdcycle` (
  `idPhdCycle` int(11) NOT NULL,
  `description` text,
  `year` year(4) NOT NULL,
  `FK_Professor` varchar(16) DEFAULT '',
  PRIMARY KEY (`idPhdCycle`),
  KEY `FK_Professor` (`FK_Professor`),
  CONSTRAINT `phdcycle_ibfk_1` FOREIGN KEY (`FK_Professor`) REFERENCES `person` (`SSN`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table prof_module_class
# ------------------------------------------------------------

DROP TABLE IF EXISTS `prof_module_class`;

CREATE TABLE `prof_module_class` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `class_title` varchar(50) NOT NULL,
  `teaching_matricula` varchar(10) NOT NULL,
  `module_title` varchar(50) NOT NULL,
  `email_account` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `class_title` (`class_title`),
  KEY `module_teaching_matricula` (`teaching_matricula`),
  KEY `module_title` (`module_title`),
  KEY `email_account` (`email_account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table professor_phdcycle
# ------------------------------------------------------------

DROP TABLE IF EXISTS `professor_phdcycle`;

CREATE TABLE `professor_phdcycle` (
  `FK_Professor` varchar(16) NOT NULL,
  `FK_PhdCycle` int(11) NOT NULL,
  PRIMARY KEY (`FK_Professor`,`FK_PhdCycle`),
  KEY `FK_PhdCycle` (`FK_PhdCycle`),
  KEY `FK_Professor` (`FK_Professor`),
  CONSTRAINT `professor_phdcycle_ibfk_1` FOREIGN KEY (`FK_Professor`) REFERENCES `person` (`SSN`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `professor_phdcycle_ibfk_2` FOREIGN KEY (`FK_PhdCycle`) REFERENCES `phdcycle` (`idPhdCycle`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table publication
# ------------------------------------------------------------

DROP TABLE IF EXISTS `publication`;

CREATE TABLE `publication` (
  `idPublication` int(20) NOT NULL,
  `title` varchar(45) NOT NULL,
  `authors` varchar(45) NOT NULL,
  `abstract` text NOT NULL,
  `file` longblob NOT NULL,
  `year` year(4) NOT NULL,
  `type` varchar(45) NOT NULL,
  `publicationIssue` varchar(45) NOT NULL,
  `numberPages` int(11) NOT NULL,
  `FK_Student` varchar(16) NOT NULL,
  PRIMARY KEY (`idPublication`),
  KEY `FK_Student` (`FK_Student`),
  KEY `FK_Student_2` (`FK_Student`),
  KEY `FK_Student_3` (`FK_Student`),
  CONSTRAINT `publication_ibfk_1` FOREIGN KEY (`FK_Student`) REFERENCES `person` (`SSN`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table rejected_training_message
# ------------------------------------------------------------

DROP TABLE IF EXISTS `rejected_training_message`;

CREATE TABLE `rejected_training_message` (
  `id_rejected_training_message` int(11) NOT NULL AUTO_INCREMENT,
  `description` longtext,
  `fk_person` varchar(16) NOT NULL,
  PRIMARY KEY (`id_rejected_training_message`),
  KEY `fk_RejectedTrainingMessage_Student1_idx` (`fk_person`),
  CONSTRAINT `rejected_training_message_ibfk_1` FOREIGN KEY (`fk_person`) REFERENCES `person` (`SSN`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table relatori_tesi
# ------------------------------------------------------------

DROP TABLE IF EXISTS `relatori_tesi`;

CREATE TABLE `relatori_tesi` (
  `ID_Tesi` int(11) NOT NULL,
  `ID_Docente` varchar(16) NOT NULL,
  KEY `ID_Tesi` (`ID_Tesi`),
  KEY `ID_Docente` (`ID_Docente`),
  CONSTRAINT `relatori_tesi_ibfk_1` FOREIGN KEY (`ID_Tesi`) REFERENCES `tesi` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `relatori_tesi_ibfk_2` FOREIGN KEY (`ID_Docente`) REFERENCES `person` (`SSN`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table student_information
# ------------------------------------------------------------

DROP TABLE IF EXISTS `student_information`;

CREATE TABLE `student_information` (
  `curriculum_vitae_path` varchar(200) DEFAULT NULL,
  `accademic_transcript_path` varchar(200) DEFAULT NULL,
  `SSN` varchar(16) NOT NULL,
  `fk_student_status` int(11) NOT NULL,
  PRIMARY KEY (`SSN`),
  UNIQUE KEY `fk_status` (`fk_student_status`),
  CONSTRAINT `student_information_ibfk_1` FOREIGN KEY (`SSN`) REFERENCES `person` (`SSN`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `student_information_ibfk_2` FOREIGN KEY (`fk_student_status`) REFERENCES `student_status` (`id_student_status`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table student_phdclass
# ------------------------------------------------------------

DROP TABLE IF EXISTS `student_phdclass`;

CREATE TABLE `student_phdclass` (
  `FK_Student` varchar(16) CHARACTER SET utf8 NOT NULL,
  `FK_PhdClass` int(20) NOT NULL,
  PRIMARY KEY (`FK_Student`,`FK_PhdClass`),
  UNIQUE KEY `FK_Student` (`FK_Student`),
  KEY `FK_PhdClass` (`FK_PhdClass`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table student_status
# ------------------------------------------------------------

DROP TABLE IF EXISTS `student_status`;

CREATE TABLE `student_status` (
  `id_student_status` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_student_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table tag
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tag`;

CREATE TABLE `tag` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table tag_tesi
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tag_tesi`;

CREATE TABLE `tag_tesi` (
  `ID_tesi` int(11) NOT NULL,
  `ID_tag` int(11) NOT NULL,
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `fk_tesi` (`ID_tesi`),
  UNIQUE KEY `fk_tag` (`ID_tag`),
  CONSTRAINT `tag_tesi_ibfk_1` FOREIGN KEY (`ID_tesi`) REFERENCES `tesi` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `tag_tesi_ibfk_2` FOREIGN KEY (`ID_tag`) REFERENCES `tag` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table teaching
# ------------------------------------------------------------

DROP TABLE IF EXISTS `teaching`;

CREATE TABLE `teaching` (
  `matricula` varchar(10) NOT NULL,
  `title` varchar(500) NOT NULL,
  `abbreviation` varchar(10) NOT NULL,
  `link` varchar(500) NOT NULL,
  `year` int(11) NOT NULL,
  `semester` int(11) NOT NULL,
  `active` tinyint(1) NOT NULL,
  `esse3_content` longtext,
  PRIMARY KEY (`matricula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table tesi
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tesi`;

CREATE TABLE `tesi` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Data_Inizio` date DEFAULT NULL,
  `Data_Fine` date DEFAULT NULL,
  `Data_Fine_Prevista` date DEFAULT NULL,
  `Titolo` varchar(255) DEFAULT NULL,
  `Abstract` varchar(45) DEFAULT NULL,
  `Descrizione` varchar(255) DEFAULT NULL,
  `ID_Studente` varchar(16) NOT NULL,
  `Stato_Tesi` enum('0','1','2','3') DEFAULT '0',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `fk_person` (`ID_Studente`),
  CONSTRAINT `tesi_ibfk_1` FOREIGN KEY (`ID_Studente`) REFERENCES `person` (`SSN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table training_request
# ------------------------------------------------------------

DROP TABLE IF EXISTS `training_request`;

CREATE TABLE `training_request` (
  `id_training_request` int(11) NOT NULL AUTO_INCREMENT,
  `description` longtext,
  `title` varchar(45) DEFAULT NULL,
  `fk_training_status` int(11) NOT NULL,
  `fk_person` varchar(16) NOT NULL,
  `fk_organization` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_training_request`),
  KEY `fk_ClaimTraining_ClaimStatus1_idx` (`fk_training_status`),
  KEY `fk_ClaimTraining_Professor1_idx` (`fk_person`),
  KEY `fk_ClaimTraining_Organization1_idx` (`fk_organization`),
  CONSTRAINT `fk_ClaimTraining_ClaimStatus1` FOREIGN KEY (`fk_training_status`) REFERENCES `training_status` (`id_training_status`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `training_request_ibfk_1` FOREIGN KEY (`fk_person`) REFERENCES `person` (`SSN`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `training_request_ibfk_2` FOREIGN KEY (`fk_organization`) REFERENCES `organization` (`id_organization`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table training_status
# ------------------------------------------------------------

DROP TABLE IF EXISTS `training_status`;

CREATE TABLE `training_status` (
  `id_training_status` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_training_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
