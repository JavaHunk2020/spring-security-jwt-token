/*
Navicat MySQL Data Transfer

Source Server         : LOCAL
Source Server Version : 50730
Source Host           : localhost:3306
Source Database       : cubic9001_db

Target Server Type    : MYSQL
Target Server Version : 50730
File Encoding         : 65001

Date: 2023-06-01 05:12:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `dogs_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `dogs_tbl`;
CREATE TABLE `dogs_tbl` (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `color` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of dogs_tbl
-- ----------------------------
INSERT INTO `dogs_tbl` VALUES ('1', 'Tikku', 'white');
INSERT INTO `dogs_tbl` VALUES ('2', 'Pockuy', 'red');
INSERT INTO `dogs_tbl` VALUES ('3', 'Rocky', 'blue');
INSERT INTO `dogs_tbl` VALUES ('4', 'Tommy', 'pink');
INSERT INTO `dogs_tbl` VALUES ('5', 'Tommy', 'pink');
INSERT INTO `dogs_tbl` VALUES ('6', 'laoao', 'white');

-- ----------------------------
-- Table structure for `hibernate_sequence`
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('9');

-- ----------------------------
-- Table structure for `signup_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `signup_tbl`;
CREATE TABLE `signup_tbl` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(250) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `mobile` varchar(15) DEFAULT NULL,
  `image` varchar(1000) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `address` varchar(300) DEFAULT NULL,
  `role` varchar(30) DEFAULT 'CUSTOMER',
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of signup_tbl
-- ----------------------------
INSERT INTO `signup_tbl` VALUES ('2', 'nagendra222', 'test', 'nagen@gmail.com', '99888888', 'http://localhost:4200/assets/images/programs-child-img-view.png', 'Male', 'dddd', 'CUSTOMER');
INSERT INTO `signup_tbl` VALUES ('3', 'Amishaw22', 'wqeq', 'mohit@gmail.com', '13212', 'qeqw', 'Male', 'qwe', 'CUSTOMER');
INSERT INTO `signup_tbl` VALUES ('4', 'nagendraqwe423', '$2a$10$MX/FT.zI9bkU/95DkeJdUeZURiEGE0ojcG4tL9jOt3dbwyAHZl3aa', 'nagendra.yadav.niit@gmail.com', '234234', 'http://localhost:4200/assets/images/programs-child-img-view.png', 'Male', 'H02020', null);
INSERT INTO `signup_tbl` VALUES ('5', 'jack', '$2a$10$4j6DtOM7aBJ4tiCX7v8Pruvo5p1FlUJEyV1i2c6pJrLiLDVWUMneO', 'technohunk444@gmail.com', null, '123', 'Female', 'we', 'CUSTOMER');
INSERT INTO `signup_tbl` VALUES ('6', 'nagendra', '$2a$10$8k0MsD2OOuDti0wwERY6wu/6HrSB1E1tUDei3oAf5eXErcUIlj8pm', 'technohunk444@gmail.com', null, null, 'Female', '12313', 'CUSTOMER');
INSERT INTO `signup_tbl` VALUES ('7', 'test100', '$2a$10$8k0MsD2OOuDti0wwERY6wu/6HrSB1E1tUDei3oAf5eXErcUIlj8pm', 'test@gmail.com', '2020202', null, 'Female', 'qwe', 'ADMIN');
INSERT INTO `signup_tbl` VALUES ('8', 'astha', '$2a$10$LrTq.mHiAdWe/cS.DDvIi.1OPBP1zxaPyRBMRYfvOewnutS79I10a', 'astha@gmail.com', '21313213', null, 'Female', 'qqwew', 'CUSTOMER');
INSERT INTO `signup_tbl` VALUES ('21', 'Amisha', '$2a$10$eDqII5GKfpI897IzYoyE/uKLreiPS.8zwwixy7VIZabvp3Z.el0aC', 'Amisha@gmail.com', '9873003723', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRKigj88VHSdveHVYzwahTfMwxyjXivIWbgMw&usqp=CAU', 'Female', 'India , 292', 'CUSTOMER');
