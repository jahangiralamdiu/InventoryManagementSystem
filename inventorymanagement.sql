-- MySQL dump 10.13  Distrib 5.6.14, for Win64 (x86_64)
--
-- Host: localhost    Database: inventorymanagement
-- ------------------------------------------------------
-- Server version	5.6.14

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
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `client_id` int(11) NOT NULL,
  `client_type` varchar(20) DEFAULT NULL,
  `client_name` varchar(50) DEFAULT NULL,
  `client_address` varchar(100) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`client_id`),
  KEY `FK_clienttype` (`client_type`),
  CONSTRAINT `FK_clienttype` FOREIGN KEY (`client_type`) REFERENCES `client_type` (`client_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1001,'101','HMN','Germany','5888877','hmn@goo.com');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_type`
--

DROP TABLE IF EXISTS `client_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client_type` (
  `client_type` varchar(20) NOT NULL,
  `description` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`client_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_type`
--

LOCK TABLES `client_type` WRITE;
/*!40000 ALTER TABLE `client_type` DISABLE KEYS */;
INSERT INTO `client_type` VALUES ('101','Client'),('102','Customer');
/*!40000 ALTER TABLE `client_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `individual_order`
--

DROP TABLE IF EXISTS `individual_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `individual_order` (
  `order_serial` int(11) NOT NULL,
  `order_id` int(11) DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`order_serial`),
  KEY `FK_orderid` (`order_id`),
  KEY `FK_individual_order_clientid` (`client_id`),
  KEY `FK_individual_order_productid` (`product_id`),
  CONSTRAINT `FK_individual_order_clientid` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`),
  CONSTRAINT `FK_individual_order_productid` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `FK_orderid` FOREIGN KEY (`order_id`) REFERENCES `order_table` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `individual_order`
--

LOCK TABLES `individual_order` WRITE;
/*!40000 ALTER TABLE `individual_order` DISABLE KEYS */;
INSERT INTO `individual_order` VALUES (11,1,1001,3,2,2300,'2014-01-15'),(12,1,1001,2,2,1150,'2014-01-15'),(100021,10002,1001,3,2,2300,'2014-01-15');
/*!40000 ALTER TABLE `individual_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_table`
--

DROP TABLE IF EXISTS `order_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_table` (
  `order_id` int(11) NOT NULL,
  `order_type` varchar(15) DEFAULT NULL,
  `order_date` date DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `fk_ordertype` (`order_type`),
  KEY `FK_clientid` (`client_id`),
  CONSTRAINT `FK_clientid` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`),
  CONSTRAINT `fk_ordertype` FOREIGN KEY (`order_type`) REFERENCES `order_type` (`order_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_table`
--

LOCK TABLES `order_table` WRITE;
/*!40000 ALTER TABLE `order_table` DISABLE KEYS */;
INSERT INTO `order_table` VALUES (1,'101','2014-01-15',1001,3450),(10002,'102','2014-01-15',1001,2300);
/*!40000 ALTER TABLE `order_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_type`
--

DROP TABLE IF EXISTS `order_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_type` (
  `order_type` varchar(15) NOT NULL,
  `description` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`order_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_type`
--

LOCK TABLES `order_type` WRITE;
/*!40000 ALTER TABLE `order_type` DISABLE KEYS */;
INSERT INTO `order_type` VALUES ('101','Sale'),('102','Purchase');
/*!40000 ALTER TABLE `order_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment` (
  `payment_id` int(11) NOT NULL,
  `order_id` int(11) DEFAULT NULL,
  `payment_date` date DEFAULT NULL,
  `payment_amount` double DEFAULT NULL,
  `due` double DEFAULT NULL,
  PRIMARY KEY (`payment_id`),
  KEY `FK_payment_orderid` (`order_id`),
  CONSTRAINT `FK_payment_orderid` FOREIGN KEY (`order_id`) REFERENCES `order_table` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,1,'2014-01-15',3000,450),(10002,10002,'2014-01-15',2300,0);
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `product_id` int(11) NOT NULL,
  `product_name` varchar(50) DEFAULT NULL,
  `company_name` varchar(50) DEFAULT NULL,
  `group_id` int(11) DEFAULT NULL,
  `stock_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `FK_product_groupid` (`group_id`),
  KEY `FK_product_stockid` (`stock_id`),
  CONSTRAINT `FK_product_stockid` FOREIGN KEY (`stock_id`) REFERENCES `stock` (`stock_id`),
  CONSTRAINT `FK_product_groupid` FOREIGN KEY (`group_id`) REFERENCES `product_group` (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Full Black','Cates Eye',101,NULL),(2,'Bangla','Abru',101,1002),(3,'Anglico Blue','HMN',102,1003),(10004,'Long Panjabi','Sada Kalo',103,1004);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_group`
--

DROP TABLE IF EXISTS `product_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_group` (
  `group_id` int(11) NOT NULL,
  `group_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_group`
--

LOCK TABLES `product_group` WRITE;
/*!40000 ALTER TABLE `product_group` DISABLE KEYS */;
INSERT INTO `product_group` VALUES (101,'Tshirt'),(102,'Jeans'),(103,'Panjabi');
/*!40000 ALTER TABLE `product_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stock` (
  `stock_id` int(11) NOT NULL,
  `product_id` int(11) DEFAULT NULL,
  `avail_stock` int(11) DEFAULT NULL,
  `unit_price` double DEFAULT NULL,
  `sales_price` double DEFAULT NULL,
  `reorder_level` int(11) DEFAULT NULL,
  `reorder_date` date DEFAULT NULL,
  PRIMARY KEY (`stock_id`),
  KEY `FK_stock_productid` (`product_id`),
  CONSTRAINT `FK_stock_productid` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES (1001,1,20,500,700,20,'2014-01-15'),(1002,2,18,500,700,20,'2014-01-15'),(1003,3,50,1000,1500,50,'2014-01-15'),(1004,10004,10,1500,2000,10,'2014-01-15');
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-01-16 11:54:59
