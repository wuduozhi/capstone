/*
Navicat MySQL Data Transfer

Source Server         : 120.79.214.246
Source Server Version : 50633
Source Host           : 120.79.214.246:3306
Source Database       : capstone

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2018-03-14 20:45:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for list
-- ----------------------------
DROP TABLE IF EXISTS `list`;
CREATE TABLE `list` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `repair_id` int(11) unsigned NOT NULL COMMENT '报修id',
  `report_id` int(11) unsigned NOT NULL COMMENT '维修id',
  PRIMARY KEY (`id`),
  KEY `FK_repair_id` (`repair_id`),
  KEY `FK_report_id` (`report_id`),
  CONSTRAINT `FK_repair_id` FOREIGN KEY (`repair_id`) REFERENCES `repair` (`id`),
  CONSTRAINT `FK_report_id` FOREIGN KEY (`report_id`) REFERENCES `report` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of list
-- ----------------------------

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `repair_id` int(11) DEFAULT NULL COMMENT '单号',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `message` varchar(225) DEFAULT NULL COMMENT '内容',
  `time` date DEFAULT NULL COMMENT '时间',
  `status` int(11) DEFAULT NULL COMMENT '是否使用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------

-- ----------------------------
-- Table structure for repair
-- ----------------------------
DROP TABLE IF EXISTS `repair`;
CREATE TABLE `repair` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user` int(11) unsigned NOT NULL COMMENT '用户id',
  `number` varchar(255) NOT NULL COMMENT '单号',
  `good` varchar(255) DEFAULT NULL COMMENT '物品',
  `time` date DEFAULT NULL COMMENT '报修时间',
  `status` int(6) DEFAULT NULL COMMENT '维修状态',
  `do_time` date DEFAULT NULL COMMENT '维修时间',
  `operation` varchar(255) DEFAULT NULL COMMENT '操作',
  `remark` varchar(255) DEFAULT NULL COMMENT '评价',
  PRIMARY KEY (`id`),
  KEY `FK_repair` (`user`),
  CONSTRAINT `FK_repair` FOREIGN KEY (`user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of repair
-- ----------------------------

-- ----------------------------
-- Table structure for report
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user` int(11) unsigned NOT NULL COMMENT '用户id',
  `kind` varchar(255) NOT NULL COMMENT '种类',
  `area` varchar(255) DEFAULT NULL COMMENT '报修人地区',
  `name` varchar(255) DEFAULT NULL COMMENT '报修人姓名',
  `company` varchar(255) DEFAULT NULL COMMENT '报修人单元',
  `department` varchar(255) DEFAULT NULL COMMENT '报修人部门',
  `phone` varchar(255) DEFAULT NULL COMMENT '报修人电话',
  `address` varchar(255) DEFAULT NULL COMMENT '报修人地址',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `judge` varchar(255) DEFAULT '' COMMENT '留言',
  `status` int(255) DEFAULT '1' COMMENT '是否有效',
  `staff` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_report` (`user`),
  KEY `FK_staff` (`staff`),
  CONSTRAINT `FK_report` FOREIGN KEY (`user`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_staff` FOREIGN KEY (`staff`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of report
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(11) NOT NULL COMMENT '用户姓名',
  `password` varchar(225) NOT NULL COMMENT '密码',
  `level` int(11) NOT NULL COMMENT '用户权限 超管|维修人员|普通人员',
  `phone` varchar(225) DEFAULT NULL COMMENT '电话',
  `status` int(255) DEFAULT '1' COMMENT '是否可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=167 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
