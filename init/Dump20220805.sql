-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: medispatch
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `delivery`
--

DROP TABLE IF EXISTS `delivery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery` (
  `del_code` bigint NOT NULL AUTO_INCREMENT,
  `del_serial` int NOT NULL,
  `del_status` varchar(255) NOT NULL,
  `del_do_id` bigint DEFAULT NULL,
  `del_dr_code` bigint DEFAULT NULL,
  PRIMARY KEY (`del_code`),
  KEY `FKo733cn2eb6g1ku4q6655fr6of` (`del_do_id`),
  KEY `FK2gloqlh86mpx2jt69lc5cdhdi` (`del_dr_code`),
  CONSTRAINT `FK2gloqlh86mpx2jt69lc5cdhdi` FOREIGN KEY (`del_dr_code`) REFERENCES `drone` (`drn_code`),
  CONSTRAINT `FKo733cn2eb6g1ku4q6655fr6of` FOREIGN KEY (`del_do_id`) REFERENCES `delivery_order` (`do_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery`
--

LOCK TABLES `delivery` WRITE;
/*!40000 ALTER TABLE `delivery` DISABLE KEYS */;
INSERT INTO `delivery` VALUES (1,-1110514756,'READY',1,1);
/*!40000 ALTER TABLE `delivery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_item`
--

DROP TABLE IF EXISTS `delivery_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery_item` (
  `item_id` bigint NOT NULL AUTO_INCREMENT,
  `item_quantity` decimal(19,2) NOT NULL,
  `item_do_id` bigint DEFAULT NULL,
  `item_med_id` bigint DEFAULT NULL,
  PRIMARY KEY (`item_id`),
  KEY `FKoalbai2cp1n7fyx73hevhl7va` (`item_do_id`),
  KEY `FK8wb9avglkoas93pkhstn3645u` (`item_med_id`),
  CONSTRAINT `FK8wb9avglkoas93pkhstn3645u` FOREIGN KEY (`item_med_id`) REFERENCES `medication` (`med_id`),
  CONSTRAINT `FKoalbai2cp1n7fyx73hevhl7va` FOREIGN KEY (`item_do_id`) REFERENCES `delivery_order` (`do_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_item`
--

LOCK TABLES `delivery_item` WRITE;
/*!40000 ALTER TABLE `delivery_item` DISABLE KEYS */;
INSERT INTO `delivery_item` VALUES (1,2.00,1,1);
/*!40000 ALTER TABLE `delivery_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_order`
--

DROP TABLE IF EXISTS `delivery_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery_order` (
  `do_id` bigint NOT NULL AUTO_INCREMENT,
  `do_location` varchar(255) NOT NULL,
  `do_serial` varchar(255) NOT NULL,
  PRIMARY KEY (`do_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_order`
--

LOCK TABLES `delivery_order` WRITE;
/*!40000 ALTER TABLE `delivery_order` DISABLE KEYS */;
INSERT INTO `delivery_order` VALUES (1,'Lagos','ORD-00001');
/*!40000 ALTER TABLE `delivery_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drone`
--

DROP TABLE IF EXISTS `drone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `drone` (
  `drn_code` bigint NOT NULL AUTO_INCREMENT,
  `drn_batt_capcity` decimal(19,2) NOT NULL,
  `drn_model` varchar(255) NOT NULL,
  `drn_serial` varchar(255) NOT NULL,
  `drn_state` varchar(255) NOT NULL,
  `drn_weight_limit` decimal(19,2) NOT NULL,
  PRIMARY KEY (`drn_code`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drone`
--

LOCK TABLES `drone` WRITE;
/*!40000 ALTER TABLE `drone` DISABLE KEYS */;
INSERT INTO `drone` VALUES (1,100.00,'LIGHTWEIGHT','DILVERYDRONE-1','LOADED',500.00),(2,100.00,'LIGHTWEIGHT','DILVERYDRONE-2','LOADING',500.00),(3,100.00,'HEAVYWEIGHT','POWERDRONE-3','IDLE',500.00),(4,100.00,'MIDDLEWEIGHT','FLEXIDRONE-4','IDLE',500.00),(5,100.00,'CRUISERWEIGHT','BETADRONE-5','IDLE',500.00),(6,100.00,'HEAVYWEIGHT','POWERDRONE-6','IDLE',500.00),(7,100.00,'LIGHTWEIGHT','DELIVERYDRONE-7','IDLE',500.00),(8,100.00,'LIGHTWEIGHT','DELIVERYDRONE-8','IDLE',500.00),(9,100.00,'MIDDLEWEIGHT','FLEXIDRONE-9','IDLE',500.00),(10,100.00,'CRUISERWEIGHT','BETADRONE-10','IDLE',500.00);
/*!40000 ALTER TABLE `drone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medication`
--

DROP TABLE IF EXISTS `medication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medication` (
  `med_id` bigint NOT NULL AUTO_INCREMENT,
  `med_code` varchar(255) NOT NULL,
  `med_image` varchar(255) DEFAULT NULL,
  `med_name` varchar(255) NOT NULL,
  `med_weight` decimal(19,2) NOT NULL,
  PRIMARY KEY (`med_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medication`
--

LOCK TABLES `medication` WRITE;
/*!40000 ALTER TABLE `medication` DISABLE KEYS */;
INSERT INTO `medication` VALUES (1,'MED_0001','xxxxxx','Levothyroxine',50.00),(2,'MED_0002','xxxxxx','Lisinopril',20.00),(3,'MED_0003','xxxxxx','Metformin',5.00),(4,'MED_0004','xxxxxx','Hydrochlorothiazide',5.00),(5,'MED_0004','xxxxxx','Amoxicillin',9.00),(6,'MED_0005','xxxxxx','Ibuprofen',5.00),(7,'MED_0007','xxxxxx','Pregnacare',1.00),(8,'MED_0008','xxxxxx','Paracetamol',1.00),(9,'MED_0009','xxxxxx','Sensodyn',9.00),(10,'MED_0010','xxxxxx','Benilyn',15.00),(11,'MED_0011','xxxxxx','Augumentin',20.00),(12,'MED_0012','xxxxxx','Cocodamol',90.00),(13,'MED_0013','xxxxxx','Actifed',500.00),(14,'MED_0014','xxxxxx','Tylenol',200.00),(15,'MED_0015','xxxxxx','Buscopan',70.00),(16,'MED_0016','xxxxxx','Panadol',150.00),(17,'MED_0017','xxxxxx','Flugun',110.00),(18,'MED_0019','xxxxxx','Cocaine',600.00);
/*!40000 ALTER TABLE `medication` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'medispatch'
--

--
-- Dumping routines for database 'medispatch'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-05  3:08:48
