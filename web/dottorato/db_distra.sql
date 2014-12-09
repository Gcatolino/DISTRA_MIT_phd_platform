-- phpMyAdmin SQL Dump
-- version 4.2.13
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dic 09, 2014 alle 22:05
-- Versione del server: 10.0.14-MariaDB
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `db_distra`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `account`
--

CREATE TABLE IF NOT EXISTS `account` (
  `email` varchar(100) NOT NULL COMMENT 'Nome con il quale l''utente viene riconosciuto da un',
  `password` varchar(45) NOT NULL,
  `typeOfAccount` varchar(45) NOT NULL,
  `active` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabella adibita alla gestione dei dati principali per l''acesso al sistema';

--
-- Dump dei dati per la tabella `account`
--

INSERT INTO `account` (`email`, `password`, `typeOfAccount`, `active`) VALUES
('elisa.deugenio@gmail.com', 'elisa', 'studente magistrale', 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `allegato`
--

CREATE TABLE IF NOT EXISTS `allegato` (
`ID` int(11) NOT NULL,
  `Oggetto` varchar(255) NOT NULL,
  `ID_Tesi` int(11) NOT NULL,
  `Stato` enum('0','1') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `annuncio`
--

CREATE TABLE IF NOT EXISTS `annuncio` (
`ID` int(11) NOT NULL,
  `Testo` text NOT NULL,
  `ID_Docente` varchar(16) NOT NULL,
  `Data_Annuncio` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `class`
--

CREATE TABLE IF NOT EXISTS `class` (
  `title` varchar(50) NOT NULL,
  `teaching_matricula` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `class_event`
--

CREATE TABLE IF NOT EXISTS `class_event` (
  `FK_Class` int(11) NOT NULL,
  `FK_Event` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `class_notice`
--

CREATE TABLE IF NOT EXISTS `class_notice` (
  `FK_Class` int(11) NOT NULL,
  `FK_Event` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `collaboration`
--

CREATE TABLE IF NOT EXISTS `collaboration` (
  `idCollaboration` int(20) NOT NULL,
  `istitution` varchar(45) NOT NULL,
  `description` text NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL,
  `FK_Student` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `cronologia`
--

CREATE TABLE IF NOT EXISTS `cronologia` (
`ID` int(11) NOT NULL,
  `Testo` varchar(255) NOT NULL,
  `ID_Docente` varchar(16) NOT NULL,
  `ID_Studente` varchar(16) NOT NULL,
  `Data_Notifica` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `curriculum`
--

CREATE TABLE IF NOT EXISTS `curriculum` (
  `title` varchar(100) NOT NULL,
  `matricula` varchar(45) NOT NULL,
  `degree_matricula` varchar(5) NOT NULL,
  `active` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `curriculum_teaching`
--

CREATE TABLE IF NOT EXISTS `curriculum_teaching` (
  `curriculum_matricula` varchar(45) NOT NULL,
  `teaching_matricula` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `cycle`
--

CREATE TABLE IF NOT EXISTS `cycle` (
  `cycle_number` int(11) NOT NULL,
  `title` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `cycle`
--

INSERT INTO `cycle` (`cycle_number`, `title`) VALUES
(2, 'studente magstrale');

-- --------------------------------------------------------

--
-- Struttura della tabella `degree`
--

CREATE TABLE IF NOT EXISTS `degree` (
  `title` varchar(500) NOT NULL,
  `matricula` varchar(5) NOT NULL,
  `link` varchar(500) DEFAULT NULL,
  `department_abbreviation` varchar(100) NOT NULL,
  `cycle_number` int(11) NOT NULL,
  `active` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `department`
--

CREATE TABLE IF NOT EXISTS `department` (
  `abbreviation` varchar(50) NOT NULL,
  `title` varchar(500) DEFAULT NULL,
  `url_moodle` varchar(1000) DEFAULT NULL,
  `token` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `department`
--

INSERT INTO `department` (`abbreviation`, `title`, `url_moodle`, `token`) VALUES
('distra', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Struttura della tabella `event`
--

CREATE TABLE IF NOT EXISTS `event` (
  `idEvent` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `description` text NOT NULL,
  `hours` int(1) NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL,
  `type` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `event_professor`
--

CREATE TABLE IF NOT EXISTS `event_professor` (
  `FK_Event` int(11) NOT NULL,
  `FK_Professor` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `lesson`
--

CREATE TABLE IF NOT EXISTS `lesson` (
  `idLesson` int(20) NOT NULL,
  `name` varchar(45) NOT NULL,
  `speaker` varchar(45) NOT NULL,
  `date` date NOT NULL,
  `startTime` time NOT NULL,
  `endTime` time NOT NULL,
  `place` varchar(45) NOT NULL,
  `FK_Event` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `lesson_student`
--

CREATE TABLE IF NOT EXISTS `lesson_student` (
  `FK_Lesson` int(20) NOT NULL,
  `FK_Student` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `mission`
--

CREATE TABLE IF NOT EXISTS `mission` (
  `idMission` int(20) NOT NULL,
  `place` varchar(45) NOT NULL,
  `description` text NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL,
  `FK_Student` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `module`
--

CREATE TABLE IF NOT EXISTS `module` (
  `title` varchar(50) NOT NULL,
  `teaching_matricula` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `notice`
--

CREATE TABLE IF NOT EXISTS `notice` (
  `idNotice` int(11) NOT NULL,
  `object` varchar(45) NOT NULL,
  `text` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `offer_training`
--

CREATE TABLE IF NOT EXISTS `offer_training` (
`id_offer_training` int(11) NOT NULL,
  `description` longtext,
  `fk_organization` int(11) DEFAULT NULL,
  `fk_person` varchar(16) NOT NULL,
  `fk_department` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `organization`
--

CREATE TABLE IF NOT EXISTS `organization` (
`id_organization` int(11) NOT NULL,
  `companyName` varchar(45) NOT NULL,
  `city` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `fk_account` varchar(100) NOT NULL,
  `fk_externaltutor` varchar(16) DEFAULT NULL,
  `fk_professor` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `pending_acceptance`
--

CREATE TABLE IF NOT EXISTS `pending_acceptance` (
`id_pending_acceptance` int(11) NOT NULL,
  `date_request` date DEFAULT NULL,
  `fk_person` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `person`
--

CREATE TABLE IF NOT EXISTS `person` (
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
  `position` varchar(50) NOT NULL,
  `cycle` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `person`
--

INSERT INTO `person` (`SSN`, `name`, `surname`, `phone`, `city`, `address`, `zip_code`, `gender`, `citizenship`, `Account_email`, `Department_abbreviation`, `web_page`, `university`, `matricula`, `position`, `cycle`) VALUES
('ertghyuijhtredfg', 'Elisa', 'D''Eugenio', NULL, NULL, NULL, NULL, NULL, NULL, 'elisa.deugenio@gmail.com', 'distra', NULL, NULL, NULL, 'studente', 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `phdclass`
--

CREATE TABLE IF NOT EXISTS `phdclass` (
`idClass` int(20) NOT NULL,
  `FK_PhdCycle` int(11) NOT NULL,
  `FK_PhdCurriculum` varchar(45) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `phdclass`
--

INSERT INTO `phdclass` (`idClass`, `FK_PhdCycle`, `FK_PhdCurriculum`) VALUES
(2, 15, 'Informatica, Sistemi Informativi e Tecnologie'),
(3, 15, 'Marketing e Comunicazione');

-- --------------------------------------------------------

--
-- Struttura della tabella `phdcurriculum`
--

CREATE TABLE IF NOT EXISTS `phdcurriculum` (
  `name` varchar(45) NOT NULL,
  `description` text,
  `FK_Professor` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `phdcurriculum`
--

INSERT INTO `phdcurriculum` (`name`, `description`, `FK_Professor`) VALUES
('Informatica, Sistemi Informativi e Tecnologie', 'Il curriculum, Informatica, Sistemi Informativi e Tecnologie del Software, ha l’obiettivo di formare figure professionali dotate di una preparazione scientifica teorica e pratica idonea ad operare con piena professionalità e competenza, sia in ambito accademico che industriale, nelle varie fasi che caratterizzano la ricerca, lo sviluppo, il controllo di qualità e la produzione nel settore dei sistemi informativi e delle tecnologie del software. In particolare, il corso di dottorato di ricerca mira alla formazione di ricercatori con elevata conoscenza degli aspetti teorici, metodologici, sperimentali e applicativi di settore quali quelli dei sistemi informativi e delle basi di dati, dell’ingegneria del software, dell''ingegneria della conoscenza, del web engineering e dell''interazione uomo-macchina, con una elevata capacità di trasferire i risultati della ricerca in ambito industriale e di applicarli ai settori dell’economia e del management aziendale, del marketing e della comunicazione.\r\n\r\n  Le tematiche scientifiche del curriculum includono:\r\n\r\nProject management\r\nSoftware quality assurance\r\nMetodi per la stima dei costi\r\nSistemi a supporto delle decisioni e business intelligence\r\nData warehousing\r\nBig data\r\nOpen data\r\nDocument and content management\r\nWorkflow and process management\r\nModellazione e analisi delle prestazioni dei processi\r\nBusiness process reengineering\r\nWeb engineering\r\nSistemi cloud-based\r\nIngegneria dei requisiti e progettazione di sistemi software\r\nManutenzione ed evoluzione di sistemi software\r\nAnalisi e testing del software\r\nIngegneria del software empirica\r\nMetodi e strumenti per il lavoro collaborativo\r\nLinguaggi visuali e interazione uomo-macchina\r\nComputer graphics e realtà virtuale\r\nInterfacce web avanzate, immersive, 3D e aptiche\r\nDomotica e sistemi di videosorveglianza intelligenti.\r\nInterfacce per sistemi domotici\r\nRiconoscimento di immagini e sistemi biometrici\r\nComputational intelligence\r\nInformation retrieval\r\nTecniche di clustering e data mining, machine learning e classificazione\r\nSistemi informativi geografici e territoriali\r\nE-learning e tecnologie per la didattica a distanza\r\nModelli matematici e ottimizzazione\r\nModellazione ed analisi di prestazioni e affidabilità dei sistemi\r\nIl Dottore di Ricerca con curriculum in Informatica, Sistemi Informativi e Tecnologie del Software potrà avere diversi sbocchi professionali, che non si fermano a quello di ricercatore accademico o nei centri di ricerca di organizzazioni ed aziende. Infatti, grazie anche alle competenze acquisite con la formazione di tipo manageriale acquisita durante il corso di dottorato, il Dottore di Ricerca potrà ricoprire ruoli di consulente ed esperto di innovazione e trasferimento tecnologico per le aziende del comparto ICT, nonché ruoli di direzione di progetti di ricerca e funzioni direzionali in aziende del comparto ICT.', 'ertghyuijhtredfg'),
('Marketing e Comunicazione', '\r\nIl curriculum “Marketing e Comunicazione” mira a trasferire conoscenze e approcci metodologici relativi a principi, teorie e modelli di ideazione e governo delle strategie e delle politiche di marketing e della comunicazione. Il principale obiettivo è formare figure professionali dotate di una solida preparazione scientifica, teorica e pratica idonea ad operare nelle università, nei centri di ricerca, negli enti pubblici e nelle imprese private e pubbliche svolgendo attività di ricerca qualificata nelle seguenti aree disciplinari e professionali: marketing strategico e operativo, analisi di mercato e del consumo, comunicazione istituzionale e d''impresa.\r\n\r\nIl programma formativo si riferisce all’ambito disciplinare dell''Economia d''Impresa e prevede che i frequentanti, al termine del percorso di apprendimento, acquisiscano un uso agevole delle più avanzate ed affidabili metodologie di ricerca scientifica in campo economico-sociale, oltre ad un’approfondita conoscenza delle teorie e delle più recenti ed innovative impostazioni riguardo al marketing ed alla comunicazione.\r\n\r\nParticolare attenzione di studio viene rivolta all’area dei social media e della rete per supportare le scelte strategiche di marketing e di comunicazione delle organizzazioni imprenditoriali e delle istituzioni.\r\n\r\nLe tematiche scientifiche del curriculum includono:\r\n\r\nMarketing Strategy;\r\nCompetition dynamics;\r\nChannel management;\r\nSalesforce management;\r\nMarketing e performance aziendali;\r\nBehavioral Constructs;\r\nDecision making;\r\nConsumer judgment;\r\nCorporate Communication;\r\nCorporate identity;\r\nOrganizational culture;\r\nReputation management;\r\nIntegrated Marketing Communication;\r\nDigital communication;\r\nValue creation and innovation;\r\nOn-line reputation;\r\nWeb customer experience.\r\nIn definitiva, il Dottore di Ricerca con curriculum in Marketing e Comunicazione si potrà orientare professionalmente verso le seguenti figure: studioso ed esperto di marketing e comunicazione per lo sviluppo della ricerca scientifica, sia nel mondo accademico che più in generale nelle organizzazioni di ricerca; consulente professionale per le imprese pubbliche, private e per le istituzioni nel supportare i processi di marketing e di comunicazione; ricoprire funzioni direzionali all’interno delle organizzazioni imprenditoriali e delle istituzioni nel ruolo di sviluppo delle strategie di marketing e della comunicazione.', 'ertghyuijhtredfg'),
('test', 'test', NULL);

-- --------------------------------------------------------

--
-- Struttura della tabella `phdcycle`
--

CREATE TABLE IF NOT EXISTS `phdcycle` (
  `idPhdCycle` int(11) NOT NULL,
  `description` text,
  `year` year(4) NOT NULL,
  `FK_Professor` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `phdcycle`
--

INSERT INTO `phdcycle` (`idPhdCycle`, `description`, `year`, `FK_Professor`) VALUES
(15, 'Il corso di Dottorato di Ricerca in Management & Information Technology ha come obiettivo la formazione di specialisti della ricerca in ambito economico-aziendale ed informatico. Il corso è strutturato in tre curricula, denominati (i) Economia e Direzione delle Aziende Pubbliche, (i) Marketing e Comunicazione e (iii) Informatica, Sistemi Informativi e Tecnologie del Software. Attraverso i tre curricula, il corso di Dottorato intende formare figure professionali diverse, ma che riescano ad interagire per la soluzione di problemi complessi in ambito economico-aziendale, grazie all''utilizzo di tecnologie dell''informazione innovative e ad un approccio inter-disciplinare che favorisca la reciproca condivisione di idee e competenze. Il primo curriculum mira a formare specialisti nel settore del management di enti, istituzioni ed aziende afferenti al settore pubblico, con conoscenze relative a principi, teorie e modelli di gestione dei processi di innovazione nella Pubblica Amministrazione. Il secondo curriculum mira a formare specialisti in grado di utilizzare le più avanzate, innovative ed affidabili metodologie di ricerca scientifica in campo economico-sociale, con particolare riferimento al marketing ed alla comunicazione. Infine, il terzo curriculum mira a formare specialisti nel settore dell''Informatica, con conoscenza degli aspetti teorici, metodologici e sperimentali dei sistemi informativi, dell''ingegneria del software, dei dati e della conoscenza, dell''elaborazione di immagini e dell''interazione uomo-macchina, con applicazioni in particolare alla economia e alla gestione aziendale.\r\n\r\nIl completamento del Corso di Dottorato ed il superamento dell''esame finale consente per tutti e tre i curricula lo svolgimento di attività di ricerca in ambito accademico, nei settori dell''economia aziendale e dell''informatica, costituendo un titolo legalmente riconosciuto nei concorsi universitari, nonché in enti di ricerca e nelle divisioni ricerca e sviluppo di aziende. Inoltre, la qualità del percorso formativo e le competenze specialistiche acquisite consentono l''inserimento dei dottori di ricerca anche nel mondo del lavoro e delle professioni, nella Pubblica Amministrazione e nelle aziende.', 2014, 'ertghyuijhtredfg');

-- --------------------------------------------------------

--
-- Struttura della tabella `professor_phdcycle`
--

CREATE TABLE IF NOT EXISTS `professor_phdcycle` (
  `FK_Professor` varchar(16) NOT NULL,
  `FK_PhdCycle` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `prof_module_class`
--

CREATE TABLE IF NOT EXISTS `prof_module_class` (
`ID` int(11) NOT NULL,
  `class_title` varchar(50) NOT NULL,
  `teaching_matricula` varchar(10) NOT NULL,
  `module_title` varchar(50) NOT NULL,
  `email_account` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `publication`
--

CREATE TABLE IF NOT EXISTS `publication` (
  `idPublication` int(20) NOT NULL,
  `title` varchar(45) NOT NULL,
  `authors` varchar(45) NOT NULL,
  `abstract` text NOT NULL,
  `file` longblob NOT NULL,
  `year` year(4) NOT NULL,
  `type` varchar(45) NOT NULL,
  `publicationIssue` varchar(45) NOT NULL,
  `numberPages` int(11) NOT NULL,
  `FK_Student` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `rejected_training_message`
--

CREATE TABLE IF NOT EXISTS `rejected_training_message` (
`id_rejected_training_message` int(11) NOT NULL,
  `description` longtext,
  `fk_person` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `relatori_tesi`
--

CREATE TABLE IF NOT EXISTS `relatori_tesi` (
  `ID_Tesi` int(11) NOT NULL,
  `ID_Docente` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `student_information`
--

CREATE TABLE IF NOT EXISTS `student_information` (
  `curriculum_vitae_path` varchar(200) DEFAULT NULL,
  `accademic_transcript_path` varchar(200) DEFAULT NULL,
  `SSN` varchar(16) NOT NULL,
  `fk_student_status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `student_phdclass`
--

CREATE TABLE IF NOT EXISTS `student_phdclass` (
  `FK_Student` varchar(16) CHARACTER SET utf8 NOT NULL,
  `FK_PhdClass` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `student_status`
--

CREATE TABLE IF NOT EXISTS `student_status` (
`id_student_status` int(11) NOT NULL,
  `description` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `tag`
--

CREATE TABLE IF NOT EXISTS `tag` (
`ID` int(11) NOT NULL,
  `Nome` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `tag_tesi`
--

CREATE TABLE IF NOT EXISTS `tag_tesi` (
  `ID_tesi` int(11) NOT NULL,
  `ID_tag` int(11) NOT NULL,
`ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `teaching`
--

CREATE TABLE IF NOT EXISTS `teaching` (
  `matricula` varchar(10) NOT NULL,
  `title` varchar(500) NOT NULL,
  `abbreviation` varchar(10) NOT NULL,
  `link` varchar(500) NOT NULL,
  `year` int(11) NOT NULL,
  `semester` int(11) NOT NULL,
  `active` tinyint(1) NOT NULL,
  `esse3_content` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `tesi`
--

CREATE TABLE IF NOT EXISTS `tesi` (
`ID` int(11) NOT NULL,
  `Data_Inizio` date NOT NULL,
  `Data_Fine` date NOT NULL,
  `Data_Fine_Prevista` date NOT NULL,
  `Titolo` varchar(255) NOT NULL,
  `Abstract` varchar(45) NOT NULL,
  `Descrizione` varchar(255) NOT NULL,
  `ID_Studente` varchar(16) NOT NULL,
  `Stato_Tesi` enum('0','1','2','3') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `training_request`
--

CREATE TABLE IF NOT EXISTS `training_request` (
`id_training_request` int(11) NOT NULL,
  `description` longtext,
  `title` varchar(45) DEFAULT NULL,
  `fk_training_status` int(11) NOT NULL,
  `fk_person` varchar(16) NOT NULL,
  `fk_organization` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `training_status`
--

CREATE TABLE IF NOT EXISTS `training_status` (
`id_training_status` int(11) NOT NULL,
  `description` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
 ADD PRIMARY KEY (`email`);

--
-- Indexes for table `allegato`
--
ALTER TABLE `allegato`
 ADD PRIMARY KEY (`ID`), ADD KEY `ID_Tesi` (`ID_Tesi`);

--
-- Indexes for table `annuncio`
--
ALTER TABLE `annuncio`
 ADD PRIMARY KEY (`ID`), ADD KEY `ID_Docente` (`ID_Docente`);

--
-- Indexes for table `class`
--
ALTER TABLE `class`
 ADD PRIMARY KEY (`title`,`teaching_matricula`), ADD KEY `title` (`title`), ADD KEY `teaching_matricula` (`teaching_matricula`);

--
-- Indexes for table `class_event`
--
ALTER TABLE `class_event`
 ADD PRIMARY KEY (`FK_Class`,`FK_Event`), ADD KEY `FK_Event` (`FK_Event`), ADD KEY `FK_Class` (`FK_Class`);

--
-- Indexes for table `class_notice`
--
ALTER TABLE `class_notice`
 ADD PRIMARY KEY (`FK_Class`,`FK_Event`), ADD KEY `FK_Event` (`FK_Event`), ADD KEY `FK_Class` (`FK_Class`);

--
-- Indexes for table `collaboration`
--
ALTER TABLE `collaboration`
 ADD PRIMARY KEY (`idCollaboration`), ADD KEY `FK_Student` (`FK_Student`);

--
-- Indexes for table `cronologia`
--
ALTER TABLE `cronologia`
 ADD PRIMARY KEY (`ID`), ADD UNIQUE KEY `fk_person1` (`ID_Studente`), ADD UNIQUE KEY `fk_person2` (`ID_Docente`);

--
-- Indexes for table `curriculum`
--
ALTER TABLE `curriculum`
 ADD PRIMARY KEY (`matricula`), ADD KEY `fk_curriculum_degree1_idx` (`degree_matricula`);

--
-- Indexes for table `curriculum_teaching`
--
ALTER TABLE `curriculum_teaching`
 ADD KEY `curriculum_matricula` (`curriculum_matricula`), ADD KEY `teaching_matricula` (`teaching_matricula`);

--
-- Indexes for table `cycle`
--
ALTER TABLE `cycle`
 ADD PRIMARY KEY (`cycle_number`);

--
-- Indexes for table `degree`
--
ALTER TABLE `degree`
 ADD PRIMARY KEY (`matricula`), ADD KEY `fk_degree_department1_idx` (`department_abbreviation`), ADD KEY `fk_degree_cycle1_idx` (`cycle_number`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
 ADD PRIMARY KEY (`abbreviation`);

--
-- Indexes for table `event`
--
ALTER TABLE `event`
 ADD PRIMARY KEY (`idEvent`);

--
-- Indexes for table `event_professor`
--
ALTER TABLE `event_professor`
 ADD PRIMARY KEY (`FK_Event`,`FK_Professor`), ADD KEY `FK_Professor` (`FK_Professor`), ADD KEY `FK_Event` (`FK_Event`);

--
-- Indexes for table `lesson`
--
ALTER TABLE `lesson`
 ADD PRIMARY KEY (`idLesson`), ADD KEY `FK_Event` (`FK_Event`);

--
-- Indexes for table `lesson_student`
--
ALTER TABLE `lesson_student`
 ADD PRIMARY KEY (`FK_Lesson`,`FK_Student`), ADD KEY `FK_Student` (`FK_Student`), ADD KEY `FK_Lesson` (`FK_Lesson`);

--
-- Indexes for table `mission`
--
ALTER TABLE `mission`
 ADD PRIMARY KEY (`idMission`), ADD KEY `FK_Student` (`FK_Student`);

--
-- Indexes for table `module`
--
ALTER TABLE `module`
 ADD PRIMARY KEY (`title`,`teaching_matricula`), ADD KEY `fk_module_teaching1_idx` (`teaching_matricula`);

--
-- Indexes for table `notice`
--
ALTER TABLE `notice`
 ADD PRIMARY KEY (`idNotice`);

--
-- Indexes for table `offer_training`
--
ALTER TABLE `offer_training`
 ADD PRIMARY KEY (`id_offer_training`), ADD KEY `fk_OfferTraining_Organization1_idx` (`fk_organization`), ADD KEY `fk_OfferTraining_Professor1_idx` (`fk_person`), ADD KEY `fk_OfferTraining_Department1_idx` (`fk_department`);

--
-- Indexes for table `organization`
--
ALTER TABLE `organization`
 ADD PRIMARY KEY (`id_organization`), ADD KEY `fk_acc` (`fk_account`), ADD KEY `fk_tutor` (`fk_externaltutor`), ADD KEY `fk_prof` (`fk_professor`);

--
-- Indexes for table `pending_acceptance`
--
ALTER TABLE `pending_acceptance`
 ADD PRIMARY KEY (`id_pending_acceptance`), ADD KEY `fk_StudentAttendence_Student1_idx` (`fk_person`);

--
-- Indexes for table `person`
--
ALTER TABLE `person`
 ADD PRIMARY KEY (`SSN`), ADD KEY `fk_Person_Account_idx` (`Account_email`), ADD KEY `fk_Person_Department1_idx` (`Department_abbreviation`), ADD KEY `fk_cycle` (`cycle`);

--
-- Indexes for table `phdclass`
--
ALTER TABLE `phdclass`
 ADD PRIMARY KEY (`idClass`), ADD KEY `FK_PhdCurriculum` (`FK_PhdCurriculum`), ADD KEY `FK_cycle` (`FK_PhdCycle`);

--
-- Indexes for table `phdcurriculum`
--
ALTER TABLE `phdcurriculum`
 ADD PRIMARY KEY (`name`), ADD KEY `FK_Professor` (`FK_Professor`);

--
-- Indexes for table `phdcycle`
--
ALTER TABLE `phdcycle`
 ADD PRIMARY KEY (`idPhdCycle`), ADD KEY `FK_Professor` (`FK_Professor`);

--
-- Indexes for table `professor_phdcycle`
--
ALTER TABLE `professor_phdcycle`
 ADD PRIMARY KEY (`FK_Professor`,`FK_PhdCycle`), ADD KEY `FK_PhdCycle` (`FK_PhdCycle`), ADD KEY `FK_Professor` (`FK_Professor`);

--
-- Indexes for table `prof_module_class`
--
ALTER TABLE `prof_module_class`
 ADD PRIMARY KEY (`ID`), ADD KEY `class_title` (`class_title`), ADD KEY `module_teaching_matricula` (`teaching_matricula`), ADD KEY `module_title` (`module_title`), ADD KEY `email_account` (`email_account`);

--
-- Indexes for table `publication`
--
ALTER TABLE `publication`
 ADD PRIMARY KEY (`idPublication`), ADD KEY `FK_Student` (`FK_Student`), ADD KEY `FK_Student_2` (`FK_Student`), ADD KEY `FK_Student_3` (`FK_Student`);

--
-- Indexes for table `rejected_training_message`
--
ALTER TABLE `rejected_training_message`
 ADD PRIMARY KEY (`id_rejected_training_message`), ADD KEY `fk_RejectedTrainingMessage_Student1_idx` (`fk_person`);

--
-- Indexes for table `relatori_tesi`
--
ALTER TABLE `relatori_tesi`
 ADD KEY `ID_Tesi` (`ID_Tesi`), ADD KEY `ID_Docente` (`ID_Docente`);

--
-- Indexes for table `student_information`
--
ALTER TABLE `student_information`
 ADD PRIMARY KEY (`SSN`), ADD UNIQUE KEY `fk_status` (`fk_student_status`);

--
-- Indexes for table `student_phdclass`
--
ALTER TABLE `student_phdclass`
 ADD PRIMARY KEY (`FK_Student`,`FK_PhdClass`), ADD UNIQUE KEY `FK_Student` (`FK_Student`), ADD KEY `FK_PhdClass` (`FK_PhdClass`);

--
-- Indexes for table `student_status`
--
ALTER TABLE `student_status`
 ADD PRIMARY KEY (`id_student_status`);

--
-- Indexes for table `tag`
--
ALTER TABLE `tag`
 ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `tag_tesi`
--
ALTER TABLE `tag_tesi`
 ADD PRIMARY KEY (`ID`), ADD UNIQUE KEY `fk_tesi` (`ID_tesi`), ADD UNIQUE KEY `fk_tag` (`ID_tag`);

--
-- Indexes for table `teaching`
--
ALTER TABLE `teaching`
 ADD PRIMARY KEY (`matricula`);

--
-- Indexes for table `tesi`
--
ALTER TABLE `tesi`
 ADD PRIMARY KEY (`ID`), ADD UNIQUE KEY `fk_person` (`ID_Studente`);

--
-- Indexes for table `training_request`
--
ALTER TABLE `training_request`
 ADD PRIMARY KEY (`id_training_request`), ADD KEY `fk_ClaimTraining_ClaimStatus1_idx` (`fk_training_status`), ADD KEY `fk_ClaimTraining_Professor1_idx` (`fk_person`), ADD KEY `fk_ClaimTraining_Organization1_idx` (`fk_organization`);

--
-- Indexes for table `training_status`
--
ALTER TABLE `training_status`
 ADD PRIMARY KEY (`id_training_status`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `allegato`
--
ALTER TABLE `allegato`
MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `annuncio`
--
ALTER TABLE `annuncio`
MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `cronologia`
--
ALTER TABLE `cronologia`
MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `offer_training`
--
ALTER TABLE `offer_training`
MODIFY `id_offer_training` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `organization`
--
ALTER TABLE `organization`
MODIFY `id_organization` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pending_acceptance`
--
ALTER TABLE `pending_acceptance`
MODIFY `id_pending_acceptance` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `phdclass`
--
ALTER TABLE `phdclass`
MODIFY `idClass` int(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `prof_module_class`
--
ALTER TABLE `prof_module_class`
MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `rejected_training_message`
--
ALTER TABLE `rejected_training_message`
MODIFY `id_rejected_training_message` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `student_status`
--
ALTER TABLE `student_status`
MODIFY `id_student_status` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tag`
--
ALTER TABLE `tag`
MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tag_tesi`
--
ALTER TABLE `tag_tesi`
MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tesi`
--
ALTER TABLE `tesi`
MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `training_request`
--
ALTER TABLE `training_request`
MODIFY `id_training_request` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `training_status`
--
ALTER TABLE `training_status`
MODIFY `id_training_status` int(11) NOT NULL AUTO_INCREMENT;
--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `allegato`
--
ALTER TABLE `allegato`
ADD CONSTRAINT `allegato_ibfk_1` FOREIGN KEY (`ID_Tesi`) REFERENCES `tesi` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Limiti per la tabella `annuncio`
--
ALTER TABLE `annuncio`
ADD CONSTRAINT `annuncio_ibfk_1` FOREIGN KEY (`ID_Docente`) REFERENCES `person` (`SSN`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Limiti per la tabella `class`
--
ALTER TABLE `class`
ADD CONSTRAINT `fk_class_teaching1` FOREIGN KEY (`teaching_matricula`) REFERENCES `teaching` (`matricula`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `class_event`
--
ALTER TABLE `class_event`
ADD CONSTRAINT `class_event_ibfk_2` FOREIGN KEY (`FK_Event`) REFERENCES `event` (`idEvent`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `class_event_ibfk_3` FOREIGN KEY (`FK_Class`) REFERENCES `phdclass` (`idClass`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `class_notice`
--
ALTER TABLE `class_notice`
ADD CONSTRAINT `class_notice_ibfk_1` FOREIGN KEY (`FK_Event`) REFERENCES `event` (`idEvent`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `class_notice_ibfk_2` FOREIGN KEY (`FK_Class`) REFERENCES `phdclass` (`idClass`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `collaboration`
--
ALTER TABLE `collaboration`
ADD CONSTRAINT `collaboration_ibfk_1` FOREIGN KEY (`FK_Student`) REFERENCES `person` (`SSN`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `cronologia`
--
ALTER TABLE `cronologia`
ADD CONSTRAINT `cronologia_ibfk_1` FOREIGN KEY (`ID_Docente`) REFERENCES `person` (`SSN`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `cronologia_ibfk_2` FOREIGN KEY (`ID_Studente`) REFERENCES `person` (`SSN`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limiti per la tabella `curriculum`
--
ALTER TABLE `curriculum`
ADD CONSTRAINT `fk_curriculum_degree1` FOREIGN KEY (`degree_matricula`) REFERENCES `degree` (`matricula`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `curriculum_teaching`
--
ALTER TABLE `curriculum_teaching`
ADD CONSTRAINT `curriculum_teaching_ibfk_1` FOREIGN KEY (`curriculum_matricula`) REFERENCES `curriculum` (`matricula`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `curriculum_teaching_ibfk_2` FOREIGN KEY (`teaching_matricula`) REFERENCES `teaching` (`matricula`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `degree`
--
ALTER TABLE `degree`
ADD CONSTRAINT `fk_degree_cycle1` FOREIGN KEY (`cycle_number`) REFERENCES `cycle` (`cycle_number`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_degree_department1` FOREIGN KEY (`department_abbreviation`) REFERENCES `department` (`abbreviation`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limiti per la tabella `event_professor`
--
ALTER TABLE `event_professor`
ADD CONSTRAINT `event_professor_ibfk_1` FOREIGN KEY (`FK_Event`) REFERENCES `event` (`idEvent`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `event_professor_ibfk_2` FOREIGN KEY (`FK_Professor`) REFERENCES `person` (`SSN`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `lesson`
--
ALTER TABLE `lesson`
ADD CONSTRAINT `lesson_ibfk_1` FOREIGN KEY (`FK_Event`) REFERENCES `event` (`idEvent`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `lesson_student`
--
ALTER TABLE `lesson_student`
ADD CONSTRAINT `lesson_student_ibfk_1` FOREIGN KEY (`FK_Student`) REFERENCES `person` (`SSN`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `lesson_student_ibfk_2` FOREIGN KEY (`FK_Lesson`) REFERENCES `lesson` (`idLesson`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `mission`
--
ALTER TABLE `mission`
ADD CONSTRAINT `mission_ibfk_1` FOREIGN KEY (`FK_Student`) REFERENCES `person` (`SSN`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `module`
--
ALTER TABLE `module`
ADD CONSTRAINT `fk_module_teaching1` FOREIGN KEY (`teaching_matricula`) REFERENCES `teaching` (`matricula`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limiti per la tabella `offer_training`
--
ALTER TABLE `offer_training`
ADD CONSTRAINT `fk_OfferTraining_Department1` FOREIGN KEY (`fk_department`) REFERENCES `department` (`abbreviation`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_OfferTraining_Organization1` FOREIGN KEY (`fk_organization`) REFERENCES `organization` (`id_organization`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_OfferTraining_Professor1` FOREIGN KEY (`fk_person`) REFERENCES `person` (`SSN`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limiti per la tabella `organization`
--
ALTER TABLE `organization`
ADD CONSTRAINT `fk_acc` FOREIGN KEY (`fk_account`) REFERENCES `account` (`email`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_prof` FOREIGN KEY (`fk_professor`) REFERENCES `person` (`SSN`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_tutor` FOREIGN KEY (`fk_externaltutor`) REFERENCES `person` (`SSN`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limiti per la tabella `pending_acceptance`
--
ALTER TABLE `pending_acceptance`
ADD CONSTRAINT `fk_StudentAttendence_Student1` FOREIGN KEY (`fk_person`) REFERENCES `person` (`SSN`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limiti per la tabella `person`
--
ALTER TABLE `person`
ADD CONSTRAINT `fk_Person_Account` FOREIGN KEY (`Account_email`) REFERENCES `account` (`email`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_Person_Department1` FOREIGN KEY (`Department_abbreviation`) REFERENCES `department` (`abbreviation`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `person_ibfk_1` FOREIGN KEY (`cycle`) REFERENCES `cycle` (`cycle_number`);

--
-- Limiti per la tabella `phdclass`
--
ALTER TABLE `phdclass`
ADD CONSTRAINT `phdclass_ibfk_1` FOREIGN KEY (`FK_PhdCycle`) REFERENCES `phdcycle` (`idPhdCycle`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `phdclass_ibfk_2` FOREIGN KEY (`FK_PhdCurriculum`) REFERENCES `phdcurriculum` (`name`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `phdcurriculum`
--
ALTER TABLE `phdcurriculum`
ADD CONSTRAINT `phdcurriculum_ibfk_1` FOREIGN KEY (`FK_Professor`) REFERENCES `person` (`SSN`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Limiti per la tabella `phdcycle`
--
ALTER TABLE `phdcycle`
ADD CONSTRAINT `phdcycle_ibfk_1` FOREIGN KEY (`FK_Professor`) REFERENCES `person` (`SSN`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Limiti per la tabella `professor_phdcycle`
--
ALTER TABLE `professor_phdcycle`
ADD CONSTRAINT `professor_phdcycle_ibfk_1` FOREIGN KEY (`FK_Professor`) REFERENCES `person` (`SSN`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `professor_phdcycle_ibfk_2` FOREIGN KEY (`FK_PhdCycle`) REFERENCES `phdcycle` (`idPhdCycle`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `publication`
--
ALTER TABLE `publication`
ADD CONSTRAINT `publication_ibfk_1` FOREIGN KEY (`FK_Student`) REFERENCES `person` (`SSN`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `rejected_training_message`
--
ALTER TABLE `rejected_training_message`
ADD CONSTRAINT `rejected_training_message_ibfk_1` FOREIGN KEY (`fk_person`) REFERENCES `person` (`SSN`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `relatori_tesi`
--
ALTER TABLE `relatori_tesi`
ADD CONSTRAINT `relatori_tesi_ibfk_1` FOREIGN KEY (`ID_Tesi`) REFERENCES `tesi` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION,
ADD CONSTRAINT `relatori_tesi_ibfk_2` FOREIGN KEY (`ID_Docente`) REFERENCES `person` (`SSN`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limiti per la tabella `student_information`
--
ALTER TABLE `student_information`
ADD CONSTRAINT `student_information_ibfk_1` FOREIGN KEY (`SSN`) REFERENCES `person` (`SSN`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `student_information_ibfk_2` FOREIGN KEY (`fk_student_status`) REFERENCES `student_status` (`id_student_status`) ON UPDATE CASCADE;

--
-- Limiti per la tabella `student_phdclass`
--
ALTER TABLE `student_phdclass`
ADD CONSTRAINT `student_phdclass_ibfk_2` FOREIGN KEY (`FK_Student`) REFERENCES `person` (`SSN`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `student_phdclass_ibfk_3` FOREIGN KEY (`FK_PhdClass`) REFERENCES `phdclass` (`idClass`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `tag_tesi`
--
ALTER TABLE `tag_tesi`
ADD CONSTRAINT `tag_tesi_ibfk_1` FOREIGN KEY (`ID_tesi`) REFERENCES `tesi` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION,
ADD CONSTRAINT `tag_tesi_ibfk_2` FOREIGN KEY (`ID_tag`) REFERENCES `tag` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Limiti per la tabella `tesi`
--
ALTER TABLE `tesi`
ADD CONSTRAINT `tesi_ibfk_1` FOREIGN KEY (`ID_Studente`) REFERENCES `person` (`SSN`);

--
-- Limiti per la tabella `training_request`
--
ALTER TABLE `training_request`
ADD CONSTRAINT `fk_ClaimTraining_ClaimStatus1` FOREIGN KEY (`fk_training_status`) REFERENCES `training_status` (`id_training_status`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `training_request_ibfk_1` FOREIGN KEY (`fk_person`) REFERENCES `person` (`SSN`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `training_request_ibfk_2` FOREIGN KEY (`fk_organization`) REFERENCES `organization` (`id_organization`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
