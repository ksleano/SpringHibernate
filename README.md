# SpringHibernate
Customer Web Tracker using Spring MVC with Hibernate

# SpringHibernate
Customer Web Tracker using Spring MVC with Hibernate

CREATE DATABASE  IF NOT EXISTS `web_customer_tracker`
USE `web_customer_tracker`;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

## Customer List
![customerlist](https://user-images.githubusercontent.com/6089566/38180125-f30b972a-35de-11e8-98bc-6d3aa874173b.png)

## Save Customer
![savecustomer](https://user-images.githubusercontent.com/6089566/38180135-0b40e584-35df-11e8-8686-ef1cba35cccf.png)

