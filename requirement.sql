/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : xiaoyuanbbb

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2019-11-07 16:58:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `requirement`
-- ----------------------------
DROP TABLE IF EXISTS `requirement`;
CREATE TABLE `requirement` (
  `requirement_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `type` int(11) NOT NULL,
  `content` text NOT NULL,
  `address` varchar(255) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `visible` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `releaser_id` int(11) NOT NULL,
  `receiver_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`requirement_id`),
  KEY `releaser_id` (`releaser_id`),
  KEY `receiver_id` (`receiver_id`),
  CONSTRAINT `requirement_ibfk_1` FOREIGN KEY (`releaser_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `requirement_ibfk_2` FOREIGN KEY (`receiver_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of requirement
-- ----------------------------
