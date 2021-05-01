-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: trabajodad
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `carrito`
--

DROP TABLE IF EXISTS `carrito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carrito` (
  `id` bigint NOT NULL,
  `carrito` longblob,
  `precio_total` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrito`
--

LOCK TABLES `carrito` WRITE;
/*!40000 ALTER TABLE `carrito` DISABLE KEYS */;
INSERT INTO `carrito` VALUES (2,_binary '¨\Ì\0sr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0\0w\0\0\0\0x',0),(4,_binary '¨\Ì\0sr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0\0w\0\0\0\0x',0),(6,_binary '¨\Ì\0sr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0\0w\0\0\0\0x',0);
/*!40000 ALTER TABLE `carrito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente_roles`
--

DROP TABLE IF EXISTS `cliente_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente_roles` (
  `cliente_id` bigint NOT NULL,
  `roles` varchar(255) DEFAULT NULL,
  KEY `FKnhfkgmrs7d7xjwfhvaftme5aa` (`cliente_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente_roles`
--

LOCK TABLES `cliente_roles` WRITE;
/*!40000 ALTER TABLE `cliente_roles` DISABLE KEYS */;
INSERT INTO `cliente_roles` VALUES (1,'ROLE_USER'),(3,'ROLE_USER'),(5,'ROLE_USER'),(5,'ROLE_ADMIN');
/*!40000 ALTER TABLE `cliente_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `id` bigint NOT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `historial` longblob,
  `nombre` varchar(255) DEFAULT NULL,
  `password_hash` varchar(255) DEFAULT NULL,
  `carritoh_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKd7jkxujgb5jek59b507v942rn` (`carritoh_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'pepe@bylup.com',_binary '¨\Ì\0sr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0\0w\0\0\0\0x','Pepe','$2a$10$rX2VienBxpqExwreFjDhtevrNpAInmcV6rtygebGZaVl5ectBhyz2',2),(3,'pepa@bylup.com',_binary '¨\Ì\0sr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0\0w\0\0\0\0x','Pepa','$2a$10$dluQmhpxxnRNUEgOZqf/2e/OB24VXvFtetNl.cAtX/YeF7OJzdPXG',4),(5,'pepo@bylup.com',_binary '¨\Ì\0sr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0\0w\0\0\0\0x','Pepo','$2a$10$0kuH7mcdAhe/qbDWbLlltOouGBx5ycfu7.PiAvNUPtDGCGLUsZs36',6);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (21);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `id` bigint NOT NULL,
  `categoria` varchar(255) DEFAULT NULL,
  `clave` longblob,
  `nombre` varchar(255) DEFAULT NULL,
  `plataforma` varchar(255) DEFAULT NULL,
  `precio` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (7,'Accion',_binary '¨\Ì\0sr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0w\0\0\0t\0	cyberps41t\0	cyberps42t\0	cyberps43x','Cyberpunk 2077','PC',70),(8,'Deporte',_binary '¨\Ì\0sr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0w\0\0\0t\0fifaps41t\0fifaps42t\0	fifaps413x','FIFA 21','PC',60),(9,'Plataformas',_binary '¨\Ì\0sr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0w\0\0\0t\0\rminecraftps41t\0\rminecraftps42t\0minecraftps413x','Minecraft','PS4',20),(10,'Simulador',_binary '¨\Ì\0sr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0w\0\0\0t\0\rflightsimu123t\0\rflightsimu456t\0minecraftps789x','Flight Simulator 2020 Deluxe Edition','PC',90),(11,'Terror',_binary '¨\Ì\0sr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0w\0\0\0t\0re32434t\0re34566t\0re11111x','Resident Evil 7','XBOX ONE',50),(12,'Deporte',_binary '¨\Ì\0sr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0w\0\0\0t\0	forza7654t\0	forza7543t\0	forza7341x','Forza Motosport 7','XBOX ONE',60),(13,'Simulador',_binary '¨\Ì\0sr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0w\0\0\0t\0bus49504t\0bus39405t\0bus20394x','Bus Simulator 18','PC',15),(14,'Accion',_binary '¨\Ì\0sr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0w\0\0\0t\0\rcontrol412341t\0\rcontrol323454t\0\rcontrol094933x','Control','XBOX ONE',15);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `valoraciones`
--

DROP TABLE IF EXISTS `valoraciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `valoraciones` (
  `id` bigint NOT NULL,
  `comentario` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `productoh_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlpq2sscpd005bavd31pmpb6r9` (`productoh_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `valoraciones`
--

LOCK TABLES `valoraciones` WRITE;
/*!40000 ALTER TABLE `valoraciones` DISABLE KEYS */;
INSERT INTO `valoraciones` VALUES (15,'Muy contento con la compra','Pepe',7),(16,'Hay un juego en este bug','Pepa',7),(17,'Un poco igual al 20 no?','Pepe',8),(18,'Mucho susto','Pepo',11),(19,'Fui a sobrevolar mi casa y me estrell√© sin querer','Pepa',10),(20,'Los pasos de cebra est√°n mal pintados','Pepo',13);
/*!40000 ALTER TABLE `valoraciones` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-25 14:00:17
