/*
Navicat MySQL Data Transfer

Source Server         : 120.79.214.246
Source Server Version : 50633
Source Host           : 120.79.214.246:3306
Source Database       : capstone

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2018-02-26 18:01:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `repair_id` int(11) NOT NULL COMMENT '单号',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `message` varchar(225) DEFAULT NULL COMMENT '内容',
  `time` date DEFAULT NULL COMMENT '时间',
  `status` int(11) DEFAULT NULL COMMENT '是否使用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  PRIMARY KEY (`id`),
  KEY `FK_repair` (`user`),
  CONSTRAINT `FK_repair` FOREIGN KEY (`user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of repair
-- ----------------------------
INSERT INTO `repair` VALUES ('1', '2', '123456789', '计算机', '2017-12-08', '1', '2019-12-02', '装系统配环境');
INSERT INTO `repair` VALUES ('3', '3', '123456789', '计算机', '2017-12-08', '1', '1970-01-02', '装系统、配环境');
INSERT INTO `repair` VALUES ('4', '4', '123456789', '计算机', '2018-02-27', '1', '1970-01-02', '装系统、配环境');

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
  `staff` varchar(255) DEFAULT NULL COMMENT '维修人',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `status` int(255) DEFAULT '1' COMMENT '是否有效',
  PRIMARY KEY (`id`),
  KEY `FK_report` (`user`),
  CONSTRAINT `FK_report` FOREIGN KEY (`user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of report
-- ----------------------------
INSERT INTO `report` VALUES ('1', '2', '计算机', '海南省', '吴多智', '湖南大学', '信科院', '13098921645', '海南省海口市', '张三', '装系统配环境', '1');
INSERT INTO `report` VALUES ('2', '3', '计算机', '湖南省', '吴多智', '湖南大学', '信息科学与工程学院', '13098921645', '海南省海口市', '张三', '装系统配环境', null);
INSERT INTO `report` VALUES ('3', '4', '笔记本', '海南省', '小智', '小鱼科技', '技术部', '1234876509', '馃子街后巷天桥附近', '李国', '不能联网', '0');
INSERT INTO `report` VALUES ('4', '2', '笔记本', '海南省', '小智', '小鱼科技', '技术部', '1234876509', '馃子街后巷', '李国', '不能联网', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', '维尼熊', 'wuduozhi', '1', '12345678901', '1');
INSERT INTO `user` VALUES ('3', '吴多智e', 'wuduozhi', '3', '13098921645', '1');
INSERT INTO `user` VALUES ('4', '维尼熊', 'wuduozhi', '1', '12345678901', '1');
INSERT INTO `user` VALUES ('5', '吴多智e', 'wuduozhi', '3', '13098921645', null);
INSERT INTO `user` VALUES ('6', '小智e', 'asdfghjkl', '1', '13098765432', null);
INSERT INTO `user` VALUES ('7', '小智e', 'asdfghjkl', '1', '13098765432', null);
INSERT INTO `user` VALUES ('8', '小智e', 'asdfghjkl', '1', '13098765432', '1');
