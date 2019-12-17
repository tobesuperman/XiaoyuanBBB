/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : xiaoyuanbbb

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2019-11-07 16:58:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `wx_name` varchar(255) DEFAULT NULL,
  `wx_img` varchar(255) DEFAULT NULL,
  `gender` varchar(255) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `type` int(11) DEFAULT 1 NOT NULL,
  `student_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `student_id` (`student_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
