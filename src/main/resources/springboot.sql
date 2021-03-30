-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: databasesales
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `classify`
--

DROP TABLE IF EXISTS `classify`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classify` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `createdate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classify`
--

LOCK TABLES `classify` WRITE;
/*!40000 ALTER TABLE `classify` DISABLE KEYS */;
INSERT INTO `classify` VALUES (1,'2020-08-05 17:39:22','adminall','adminall','2020-08-05 19:17:50','ao-nu','','Áo nữ'),(2,'2020-08-05 19:14:13','adminall','adminall','2020-08-05 19:14:13','ao-nam','','Áo nam'),(3,'2020-08-05 19:18:26','adminall','adminall','2020-08-05 19:18:26','ao-nam','','Áo nam');
/*!40000 ALTER TABLE `classify` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `createdate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL,
  `itemid` bigint DEFAULT NULL,
  `userid` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbwl3fihyiilv08y5jrxe5qkgp` (`itemid`),
  KEY `FKe7pshbkin4984x23q4wboi5ka` (`userid`),
  CONSTRAINT `FKbwl3fihyiilv08y5jrxe5qkgp` FOREIGN KEY (`itemid`) REFERENCES `item` (`id`),
  CONSTRAINT `FKe7pshbkin4984x23q4wboi5ka` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (6,'2020-08-03 13:07:12','user','user','2020-08-03 13:07:12','hahahaha',1,33),(7,'2020-08-03 17:00:32','user','user','2020-08-03 17:00:32','hahahaha',1,33),(11,'2020-08-03 21:52:08','user','user','2020-08-03 21:52:08','hahahaha',1,33),(12,'2020-08-03 22:56:27','user','user','2020-08-03 22:56:27','hahahaha',1,33);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detailuser`
--

DROP TABLE IF EXISTS `detailuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detailuser` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `createdate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `dateofbirth` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `sdt` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2qoai35td2wmoqthyc5v88nif` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detailuser`
--

LOCK TABLES `detailuser` WRITE;
/*!40000 ALTER TABLE `detailuser` DISABLE KEYS */;
/*!40000 ALTER TABLE `detailuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `help`
--

DROP TABLE IF EXISTS `help`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `help` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `createdate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `reply` varchar(255) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `userid` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5g8rp0hohg8vhspn4fjbpdxyj` (`userid`),
  CONSTRAINT `FK5g8rp0hohg8vhspn4fjbpdxyj` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `help`
--

LOCK TABLES `help` WRITE;
/*!40000 ALTER TABLE `help` DISABLE KEYS */;
INSERT INTO `help` VALUES (2,'2020-08-03 00:52:12','anonymousUser','adminhelp','2020-08-03 01:05:00','hoangnv.cx@gmail.com ','nguyen hoang','lo roi','ahahaha',1,'haha','hahah','anonymousUser',63),(3,'2020-08-03 01:04:42','adminhelp','adminhelp','2020-08-03 01:04:42',NULL,NULL,NULL,NULL,0,NULL,NULL,'adminhelp',NULL),(4,'2020-08-05 11:48:21','anonymousUser','adminhelp','2020-08-05 11:59:39','hoangnv.cx@gmail.com ','nguyen hoang','lo roi','ahahaha',1,'haha','hahah','anonymousUser',63),(5,'2020-08-05 12:07:48','anonymousUser','adminhelp','2020-08-05 12:08:13','hoangnv.cx@gmail.com ','nguyen hoang','lo roi','ahahaha',1,'haha','hahah','anonymousUser',63);
/*!40000 ALTER TABLE `help` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `createdate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` bigint DEFAULT NULL,
  `shortdescription` varchar(255) DEFAULT NULL,
  `thumbnail` varchar(255) DEFAULT NULL,
  `classify_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKchmk74mphql4cg7f92hbximr4` (`classify_id`),
  CONSTRAINT `FKchmk74mphql4cg7f92hbximr4` FOREIGN KEY (`classify_id`) REFERENCES `classify` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,'2020-07-31 23:39:41','a','adminall','2020-08-03 00:01:22','ao',25555,'hahaha','',3),(2,'2020-08-02 12:09:03','adminitem','adminall','2020-08-02 12:12:50','quaafn',250000,'áo cộc tay','',2),(3,'2020-08-02 12:13:02','adminall','adminall','2020-08-02 12:13:02','quaafn',250000,'áo cộc tay','',1),(4,'2020-08-02 12:13:29','adminitem','adminitem','2020-08-02 12:13:29','quaafn',250000,'áo cộc tay','',2),(5,'2020-08-02 17:03:59','adminitem','adminitem','2020-08-02 17:03:59','quaafn',250000,'áo cộc tay','',3),(6,'2020-08-02 23:53:12','adminall','adminall','2020-08-02 23:53:12','jean',250000,'quaafn nam nu','',1),(7,'2020-08-02 23:54:22','adminall','adminitem','2020-08-03 00:03:53','ao',25555,'hahaha','',2),(8,'2020-08-03 00:00:19','adminall','adminall','2020-08-03 00:00:19','jean',250000,'quaafn nam nu','',3),(9,'2020-08-03 00:02:57','adminall','adminall','2020-08-03 00:02:57','jean',250000,'quaafn nam nu','',1),(10,'2020-08-03 00:03:04','adminitem','adminitem','2020-08-03 00:03:04','jean',250000,'quaafn nam nu','',2);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `replycomment`
--

DROP TABLE IF EXISTS `replycomment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `replycomment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `createdate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `replycomment` varchar(255) DEFAULT NULL,
  `comment_id` bigint DEFAULT NULL,
  `userid` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtji9vu4m6rcyy4te00m1yi1v3` (`comment_id`),
  KEY `FKna0ogogbdmpq32qtafo4255u3` (`userid`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `replycomment`
--

LOCK TABLES `replycomment` WRITE;
/*!40000 ALTER TABLE `replycomment` DISABLE KEYS */;
INSERT INTO `replycomment` VALUES (1,'2020-08-03 21:52:17','user','user','2020-08-03 21:52:17','okeoke',6,33),(2,'2020-08-03 22:56:30','user','user','2020-08-03 22:56:30','okeoke',6,33),(3,'2020-08-03 22:56:35','user','user','2020-08-03 22:56:35','okeoke',7,33),(4,'2020-08-03 22:56:39','user','user','2020-08-03 22:56:39','okeoke',12,33),(5,'2020-08-03 22:56:41','user','user','2020-08-03 22:56:41','okeoke',12,33),(6,'2020-08-03 22:56:44','user','user','2020-08-03 22:56:44','okefgdfoke',12,33),(7,'2020-08-03 22:56:46','user','user','2020-08-03 22:56:46','okeffdgdfgdgdfoke',12,33);
/*!40000 ALTER TABLE `replycomment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `createdate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,NULL,NULL,NULL,NULL,'USER','Người dùng'),(2,NULL,NULL,NULL,NULL,'ADMIN','Quản trị'),(3,NULL,NULL,NULL,NULL,'ADMIN-ALL','Quản trị chung'),(4,NULL,NULL,NULL,NULL,'ADMIN-USER','Quản trị tài khoản'),(5,NULL,NULL,NULL,NULL,'ADMIN-ITEM','Quản trị sản phẩm'),(6,NULL,NULL,NULL,NULL,'ADMIN-HELP','Quản trị trợ giúp'),(7,NULL,NULL,NULL,NULL,'ADMIN-COMMENT','Quản trị bình luận');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `createdate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (21,'2020-07-31 14:09:46','a','a','2020-07-31 14:09:46','$2a$10$Q.qlgpqTl/lRBjpxklXRT.QTv.FKV6fUv3XyywNtJCdCfL2.momn.','adminall'),(22,'2020-07-31 14:31:01','a','adminall','2020-08-03 01:02:59','$2a$10$/xTf9ZihxdFcVeiu89hR7.v.RxyYKZhTp0dOyrsLmKtwx/dcybtle','adminuser'),(23,'2020-07-31 14:31:24','a','anonymousUser','2020-08-03 11:59:59','$2a$10$i15tmTkflvPd4NTJFL/7pOKwFi4WxIHgmASZgB9zYZm7rGoLwtwxi','adminitem'),(24,'2020-07-31 14:32:42','a','adminall','2020-08-03 01:02:41','$2a$10$6TWB6v5x7k1I6Zpr5xKvkurLbWBBG54Q8g0FOWuabtDhJktISdONG','adminuseritem'),(33,'2020-08-01 20:14:19','anonymousUser','anonymousUser','2020-08-01 20:14:19','$2a$10$SUHXak238YFXy17.I6i2f.pdNaTl5zLQ8G20C.yPATHcj4Mlm8mk.','user'),(63,'2020-08-03 01:03:55','adminuser','adminuser','2020-08-03 01:03:55','$2a$10$MfgXN7hibxiBVnLE53yXyuFyhXTO6vU57D90C/8bnmEsvam2OkUiK','adminhelp'),(64,'2020-08-03 11:59:27','anonymousUser','anonymousUser','2020-08-03 11:59:27','$2a$10$XEEatwKbFfSUr6eY7AZOu.FZTTAkFjdc1o1nEqHV7tmeIRTlitXGy','test1'),(65,'2020-08-03 12:43:22','adminuser','adminuser','2020-08-03 12:43:22','$2a$10$v4C0enrlXTKybrhIRKSEkeEQ0R6jDErEZwInKtsBPd5v0lt1dJPDu','aaaaa'),(66,'2020-08-04 00:58:41','adminuser','adminuser','2020-08-04 00:58:41','$2a$10$ZtePxzV99pC9hzU48.ZLoOHkakECRkyjkqe9/iZhiPo8Sk5lSg.Ve','admincomment'),(72,'2020-08-05 17:04:06','anonymousUser','anonymousUser','2020-08-05 17:04:06','$2a$10$Hp4HLhHLiYBW3SoHOdOiEeZL4Q9mzaJrZxGJknl2j5qCYnM5YbOyu','test11'),(73,'2020-08-11 13:36:39','anonymousUser','anonymousUser','2020-08-11 13:36:39','$2a$10$e6G3zni2jnl3jixPk.XeXu/XjgQk5OaXJ16mzdLy4hLz8RFwcG6UK','aaaaaaa');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  KEY `FK859n2jvi8ivhui0rl0esws6o` (`user_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (21,3),(33,1),(24,4),(24,5),(22,4),(63,6),(64,1),(23,1),(65,6),(66,7),(72,1),(73,1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-13 20:22:48
