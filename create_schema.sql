/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  smahapat
 * Created: Feb 23, 2016
 */

DROP DATABASE IF EXISTS divyadrushti;
CREATE DATABASE divyadrushti;
USE divyadrushti;

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `email` varchar(64) NOT NULL,
  `mobileNumber` char(13) CHARACTER SET latin1 DEFAULT NULL,
  `billingAddress` varchar(1024) DEFAULT NULL,
  `shippingAddress` varchar(1024) DEFAULT NULL,
  `loginPassword` char(32) CHARACTER SET latin1 NOT NULL,
  `devicePassword` char(32) CHARACTER SET latin1 DEFAULT NULL,
  `active` int(11) NOT NULL DEFAULT '1',
  `whenCreated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `whenUpdated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `tmpRoleForAuth` char(16) CHARACTER SET latin1 NOT NULL DEFAULT 'ALL',
  `whyNotActiveId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(64) NOT NULL,
  `role` char(16) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

insert into users (name, email, loginPassword) values ('Divyadrushti', 'dd@dd.com', 'dd');
insert into user_role (email, role) values ('dd@dd.com', 'owner')
