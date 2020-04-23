/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50614
Source Host           : localhost:3306
Source Database       : empsystem

Target Server Type    : MYSQL
Target Server Version : 50614
File Encoding         : 65001

Date: 2019-06-27 23:48:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for config
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `start` time NOT NULL,
  `end` time DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `config_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of config
-- ----------------------------
INSERT INTO `config` VALUES ('7', '08:30:00', '17:30:00', '2017-05-05 12:41:16', '2017-05-05 12:41:16');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `desc` varchar(200) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `department_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '人事部', '负责公司人事管理', '2017-05-02 16:13:08', '2017-05-02 16:13:09');
INSERT INTO `department` VALUES ('2', '技术部', '负责公司技术研发', '2017-05-02 16:13:23', '2017-05-02 16:13:24');
INSERT INTO `department` VALUES ('3', '市场部', '负责市场工作', '2019-06-27 23:45:08', '2019-06-27 23:45:08');

-- ----------------------------
-- Table structure for holiday
-- ----------------------------
DROP TABLE IF EXISTS `holiday`;
CREATE TABLE `holiday` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `time` datetime NOT NULL,
  `remark` varchar(50) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `holiday_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of holiday
-- ----------------------------
INSERT INTO `holiday` VALUES ('1', '2017-05-06 00:00:00', '双休日', '2017-05-05 12:42:02', '2017-05-05 12:42:02');
INSERT INTO `holiday` VALUES ('2', '2017-05-07 00:00:00', '双休日', '2017-05-05 12:42:11', '2017-05-05 12:42:11');
INSERT INTO `holiday` VALUES ('3', '2017-05-24 00:00:00', '团建', '2017-05-05 12:42:31', '2017-05-05 12:42:31');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级管理员', '2017-05-02 09:18:28', '2017-05-02 09:18:29');
INSERT INTO `role` VALUES ('2', '人事管理员', '2017-05-05 12:06:03', '2017-05-05 12:06:04');
INSERT INTO `role` VALUES ('3', '部门领导', '2017-05-02 09:18:38', '2017-05-02 09:18:39');
INSERT INTO `role` VALUES ('4', '员工', '2017-05-02 09:18:53', '2017-05-02 09:18:54');

-- ----------------------------
-- Table structure for schedule
-- ----------------------------
DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `reason` varchar(200) NOT NULL,
  `start` datetime NOT NULL,
  `end` datetime NOT NULL,
  `status` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `user_id` int(11) NOT NULL,
  `reject_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `schedule_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schedule
-- ----------------------------
INSERT INTO `schedule` VALUES ('4', '商务谈判', '2019-06-04 08:00:00', '2019-06-29 08:00:00', '1', '1', '2019-06-27 23:45:53', '2019-06-27 23:45:53', '1');
INSERT INTO `schedule` VALUES ('5', '家中有事', '2019-06-26 08:00:00', '2019-06-29 08:00:00', '1', '0', '2019-06-27 23:46:04', '2019-06-27 23:46:04', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role_id` int(11) NOT NULL,
  `department_id` int(11) NOT NULL,
  `update_time` datetime NOT NULL,
  `create_time` datetime NOT NULL,
  `phone` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id_uindex` (`id`),
  UNIQUE KEY `user_email_uindex` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'root', 'root', '63A9F0EA7BB98050796B649E85481845', '1', '2', '2017-05-05 12:37:58', '2017-05-05 12:37:58', '18381085886');
INSERT INTO `user` VALUES ('2', '田宇', '993575552@qq.com', 'E10ADC3949BA59ABBE56E057F20F883E', '2', '1', '2017-05-05 12:38:40', '2017-05-05 12:38:40', '15148745424');
INSERT INTO `user` VALUES ('3', '陈铁男', '5421574845@qq.com', 'E10ADC3949BA59ABBE56E057F20F883E', '3', '2', '2017-05-05 12:40:24', '2017-05-05 12:39:27', '15445875462');
INSERT INTO `user` VALUES ('4', '田呱呱', '123456@qq.com', 'E10ADC3949BA59ABBE56E057F20F883E', '4', '3', '2017-05-05 12:43:30', '2017-05-05 12:43:30', '12344574856');

-- ----------------------------
-- Table structure for work_check
-- ----------------------------
DROP TABLE IF EXISTS `work_check`;
CREATE TABLE `work_check` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `time` date NOT NULL,
  `type` int(11) NOT NULL,
  `start` time NOT NULL,
  `end` time DEFAULT NULL,
  `start_check` time DEFAULT NULL,
  `end_check` time DEFAULT NULL,
  `work_time` decimal(10,0) DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `work_check_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of work_check
-- ----------------------------
INSERT INTO `work_check` VALUES ('1', '2017-05-05', '1', '08:30:00', '17:30:00', '12:46:14', '12:46:14', '0', null, '2017-05-05 12:46:14', '2017-05-05 12:46:14', '6');
INSERT INTO `work_check` VALUES ('12', '2019-06-27', '1', '08:30:00', '17:30:00', '23:45:26', '23:45:31', '0', null, '2019-06-27 23:45:26', '2019-06-27 23:45:26', '1');
