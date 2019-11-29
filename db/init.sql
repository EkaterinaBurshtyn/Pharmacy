CREATE DATABASE  IF NOT EXISTS `pharmacy` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `pharmacy`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: pharmacy
-- ------------------------------------------------------
-- Server version	5.7.14-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `availabity`
--

DROP TABLE IF EXISTS `availabity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `availabity` (
  `a_id` int(11) NOT NULL,
  `pr_id` int(11) NOT NULL,
  `Quantity` double(10,5) NOT NULL,
  PRIMARY KEY (`a_id`),
  KEY `pr_id` (`pr_id`),
  CONSTRAINT `availabity_ibfk_1` FOREIGN KEY (`pr_id`) REFERENCES `preparation` (`pr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `contrind_ind`
--

DROP TABLE IF EXISTS `contrind_ind`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contrind_ind` (
  `pr_id` int(11) NOT NULL,
  `s_id` int(11) NOT NULL,
  `Contraindications` tinyint(1) DEFAULT NULL,
  `Indications` tinyint(1) DEFAULT NULL,
  KEY `pr_id` (`pr_id`),
  KEY `s_id` (`s_id`),
  CONSTRAINT `contrind_ind_ibfk_1` FOREIGN KEY (`pr_id`) REFERENCES `preparation` (`pr_id`),
  CONSTRAINT `contrind_ind_ibfk_2` FOREIGN KEY (`s_id`) REFERENCES `state` (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `group`
--

DROP TABLE IF EXISTS `group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group` (
  `gr_id` int(11) NOT NULL,
  `Name` varchar(100) NOT NULL,
  PRIMARY KEY (`gr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `modeofapplication`
--

DROP TABLE IF EXISTS `modeofapplication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modeofapplication` (
  `ma_id` int(11) NOT NULL,
  `Description` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`ma_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `modeofapplication_preparation`
--

DROP TABLE IF EXISTS `modeofapplication_preparation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modeofapplication_preparation` (
  `pr_id` int(11) NOT NULL,
  `ma_id` int(11) NOT NULL,
  KEY `pr_id` (`pr_id`),
  KEY `ma_id` (`ma_id`),
  CONSTRAINT `modeofapplication_preparation_ibfk_1` FOREIGN KEY (`pr_id`) REFERENCES `preparation` (`pr_id`),
  CONSTRAINT `modeofapplication_preparation_ibfk_2` FOREIGN KEY (`ma_id`) REFERENCES `modeofapplication` (`ma_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `preparation`
--

DROP TABLE IF EXISTS `preparation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `preparation` (
  `pr_id` int(11) NOT NULL,
  `gr_id` int(11) NOT NULL,
  `Name` varchar(100) NOT NULL,
  PRIMARY KEY (`pr_id`),
  KEY `gr_id` (`gr_id`),
  CONSTRAINT `preparation_ibfk_1` FOREIGN KEY (`gr_id`) REFERENCES `group` (`gr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sold`
--

DROP TABLE IF EXISTS `sold`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sold` (
  `so_id` int(11) NOT NULL,
  `pr_id` int(11) NOT NULL,
  `Price` double(10,5) NOT NULL,
  `Date` date NOT NULL,
  PRIMARY KEY (`so_id`),
  KEY `pr_id` (`pr_id`),
  CONSTRAINT `sold_ibfk_1` FOREIGN KEY (`pr_id`) REFERENCES `preparation` (`pr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `state`
--

DROP TABLE IF EXISTS `state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `state` (
  `s_id` int(11) NOT NULL,
  `Description` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `structure`
--

DROP TABLE IF EXISTS `structure`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `structure` (
  `st_id` int(11) NOT NULL,
  `Description` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`st_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
