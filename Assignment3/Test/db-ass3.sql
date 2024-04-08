-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: assignment3
-- ------------------------------------------------------
-- Server version	5.7.31-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `adminID` int(11) NOT NULL DEFAULT '0',
  `adminUserName` varchar(45) NOT NULL,
  `adminPassword` varchar(45) NOT NULL,
  `adminName` varchar(45) NOT NULL,
  PRIMARY KEY (`adminID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'admin01','123456','admin01'),(2,'admin02','123456','admin02');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lecture`
--

DROP TABLE IF EXISTS `lecture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lecture` (
  `lectureID` int(11) NOT NULL AUTO_INCREMENT,
  `lectureName` varchar(45) DEFAULT NULL,
  `lectureSemester` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`lectureID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lecture`
--

LOCK TABLES `lecture` WRITE;
/*!40000 ALTER TABLE `lecture` DISABLE KEYS */;
INSERT INTO `lecture` VALUES (0,'Data','1'),(1,'Math','1'),(2,'Art','1'),(3,'Sport','2'),(4,'Film','2'),(5,'Bake','1'),(6,'Java','2'),(7,'C++','3'),(8,'C#','2'),(9,'Spring','1'),(10,'VUE','2'),(11,'Python','1'),(18,'test','3'),(19,'test02','3');
/*!40000 ALTER TABLE `lecture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `studentID` int(11) NOT NULL AUTO_INCREMENT,
  `studentUserName` varchar(45) DEFAULT NULL,
  `studentPassword` varchar(45) DEFAULT NULL,
  `studentName` varchar(45) DEFAULT NULL,
  `studentPhone` varchar(45) DEFAULT NULL,
  `studentAddress` varchar(45) DEFAULT NULL,
  `studentAge` int(11) DEFAULT NULL,
  PRIMARY KEY (`studentID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'user1','password1','John Doe','123-456-7890','123 Main St',20),(2,'user2','password2','Jane Smith','456-789-0123','456 Oak Ave',22),(3,'user3','password3','Michael Johnson','789-012-3456','789 Elm St',21),(4,'user4','password4','Emily Davis','012-345-6789','012 Maple St',19),(5,'user5','password5','Chris Brown','234-567-8901','234 Pine St',23),(14,'123','123','123','123','123',123),(15,'test','test','test','test','test',123),(16,'admin01','admin01','admin01','admin01','admin01',123);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_lecture`
--

DROP TABLE IF EXISTS `student_lecture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_lecture` (
  `studentID` int(11) NOT NULL,
  `lectureID` int(11) NOT NULL,
  `studentQuiz` double DEFAULT '-1',
  `studentAssignment` double DEFAULT '-1',
  `studentFinal` double DEFAULT '-1',
  PRIMARY KEY (`studentID`,`lectureID`),
  KEY `lectureID_idx` (`lectureID`),
  CONSTRAINT `lectureID` FOREIGN KEY (`lectureID`) REFERENCES `lecture` (`lectureID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `studentID` FOREIGN KEY (`studentID`) REFERENCES `student` (`studentID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_lecture`
--

LOCK TABLES `student_lecture` WRITE;
/*!40000 ALTER TABLE `student_lecture` DISABLE KEYS */;
INSERT INTO `student_lecture` VALUES (1,0,23,33,99),(1,1,85.5,90,45),(1,2,78,12,68),(1,3,-1,-1,-1),(1,4,-1,-1,-1),(1,5,-1,-1,-1),(1,6,-1,-1,-1),(1,7,-1,-1,-1),(1,8,-1,-1,3),(1,9,-1,-1,-1),(1,10,-1,-1,-1),(1,11,-1,-1,-1),(1,18,-1,-1,-1),(2,1,85.5,90,65),(2,2,78,12,99),(3,1,85.5,90,-1),(3,2,78,12,-1),(4,1,86.5,90,11),(4,2,78,12,80),(5,1,90,88,-1),(5,2,82.5,80,75);
/*!40000 ALTER TABLE `student_lecture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `teacherID` int(11) NOT NULL AUTO_INCREMENT,
  `teacherName` varchar(45) DEFAULT NULL,
  `teacherPhone` varchar(45) DEFAULT NULL,
  `teacherAddress` varchar(45) DEFAULT NULL,
  `teacherAge` int(11) DEFAULT NULL,
  `teacherUserName` varchar(45) DEFAULT NULL,
  `teacherPassword` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`teacherID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'Alice Johnson','123-456-7890','123 Main St',35,'alice_teacher','password1'),(2,'Bob Smith','456-789-0123','456 Oak Ave',40,'bob_teacher','password2'),(3,'Charlie Brown','789-012-3456','789 Elm St',38,'charlie_teacher','password3'),(4,'Diana Davis','012-345-6789','012 Maple St',42,'diana_teacher','password4'),(5,'Eva Wilson','234-567-8901','234 Pine St',37,'eva_teacher','password5'),(6,'test','test','test',2,'test','test'),(7,'test02','test02','test02',12,'test02','test02'),(8,'test','test','test',123,'test','test'),(9,'test2','test2','test2',123,'test2','test2');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_lecture`
--

DROP TABLE IF EXISTS `teacher_lecture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher_lecture` (
  `teacherID` int(11) NOT NULL,
  `lectureID` int(11) NOT NULL,
  PRIMARY KEY (`teacherID`,`lectureID`),
  KEY `lecture1ID_idx` (`lectureID`),
  CONSTRAINT `lecture1ID` FOREIGN KEY (`lectureID`) REFERENCES `lecture` (`lectureID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `teacherID` FOREIGN KEY (`teacherID`) REFERENCES `teacher` (`teacherID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_lecture`
--

LOCK TABLES `teacher_lecture` WRITE;
/*!40000 ALTER TABLE `teacher_lecture` DISABLE KEYS */;
INSERT INTO `teacher_lecture` VALUES (1,0),(1,1),(2,1),(5,1),(1,2),(5,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(2,8),(1,9),(1,10),(1,11),(1,18);
/*!40000 ALTER TABLE `teacher_lecture` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-27 14:53:46
