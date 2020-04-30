/*
Navicat MySQL Data Transfer

Source Server         : 新连接
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : stuscoremanager

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2020-04-30 15:56:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `account` varchar(30) NOT NULL,
  `name` varchar(20) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '2016300001', 'admin', '123');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courseid` varchar(255) NOT NULL,
  `coursename` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '1', '高数');
INSERT INTO `course` VALUES ('2', '2', '大学英语听说');
INSERT INTO `course` VALUES ('3', '3', 'Python');
INSERT INTO `course` VALUES ('4', '4', '创新创业基础导论');
INSERT INTO `course` VALUES ('5', '5', '线性代数');
INSERT INTO `course` VALUES ('6', '6', '离散数学');
INSERT INTO `course` VALUES ('7', '7', '大学英语读写');
INSERT INTO `course` VALUES ('8', '8', 'C#');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stuno` varchar(30) NOT NULL,
  `courseid` varchar(30) NOT NULL,
  `score` float(30,1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('2', '2016100001', '2', '97.0');
INSERT INTO `score` VALUES ('3', '2016100001', '3', '66.5');
INSERT INTO `score` VALUES ('4', '2016100001', '4', '95.0');
INSERT INTO `score` VALUES ('5', '2016100001', '5', '61.0');
INSERT INTO `score` VALUES ('6', '2016100001', '6', '77.0');
INSERT INTO `score` VALUES ('8', '2016100001', '8', '89.0');
INSERT INTO `score` VALUES ('9', '2016100002', '1', '66.0');
INSERT INTO `score` VALUES ('10', '2016100002', '2', '87.0');
INSERT INTO `score` VALUES ('11', '2016100002', '3', '65.5');
INSERT INTO `score` VALUES ('12', '2016100002', '4', '78.5');
INSERT INTO `score` VALUES ('13', '2016100002', '5', '79.0');
INSERT INTO `score` VALUES ('14', '2016100002', '6', '88.0');
INSERT INTO `score` VALUES ('15', '2016100002', '7', '68.5');
INSERT INTO `score` VALUES ('16', '2016100002', '8', '99.0');
INSERT INTO `score` VALUES ('17', '2016100003', '1', '61.0');
INSERT INTO `score` VALUES ('19', '2016100003', '3', '98.0');
INSERT INTO `score` VALUES ('20', '2016100003', '4', '91.0');
INSERT INTO `score` VALUES ('21', '2016100003', '5', '68.5');
INSERT INTO `score` VALUES ('22', '2016100003', '6', '87.0');
INSERT INTO `score` VALUES ('23', '2016100003', '7', '96.0');
INSERT INTO `score` VALUES ('24', '2016100003', '8', '69.5');
INSERT INTO `score` VALUES ('26', '2016100003', '2', '55.0');
INSERT INTO `score` VALUES ('28', '2016100001', '1', '66.0');
INSERT INTO `score` VALUES ('29', '2016100001', '7', '98.0');
INSERT INTO `score` VALUES ('30', '2016100004', '1', '99.0');
INSERT INTO `score` VALUES ('31', '2016100004', '3', '45.0');
INSERT INTO `score` VALUES ('32', '2016100004', '4', '65.0');
INSERT INTO `score` VALUES ('33', '2016100004', '5', '68.5');
INSERT INTO `score` VALUES ('34', '2016100004', '6', '87.0');
INSERT INTO `score` VALUES ('35', '2016100004', '7', '96.0');
INSERT INTO `score` VALUES ('36', '2016100004', '8', '69.5');
INSERT INTO `score` VALUES ('37', '2016100004', '2', '55.0');
INSERT INTO `score` VALUES ('38', '2016100005', '1', '66.0');
INSERT INTO `score` VALUES ('39', '2016100005', '3', '86.0');
INSERT INTO `score` VALUES ('40', '2016100005', '4', '98.5');
INSERT INTO `score` VALUES ('41', '2016100005', '5', '65.0');
INSERT INTO `score` VALUES ('42', '2016100005', '6', '77.0');
INSERT INTO `score` VALUES ('43', '2016100005', '7', '88.0');
INSERT INTO `score` VALUES ('44', '2016100005', '8', '32.0');
INSERT INTO `score` VALUES ('45', '2016100005', '2', '57.0');

-- ----------------------------
-- Table structure for student_info
-- ----------------------------
DROP TABLE IF EXISTS `student_info`;
CREATE TABLE `student_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stuno` varchar(40) NOT NULL,
  `stuname` varchar(40) NOT NULL,
  `graclass` varchar(255) NOT NULL,
  `psd` varchar(255) NOT NULL,
  `sex` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_info
-- ----------------------------
INSERT INTO `student_info` VALUES ('1', '2016100001', '陈小龙', '计算机科学与技术本科2班', '123', '男');
INSERT INTO `student_info` VALUES ('2', '2016100002', '张雪', '物联网本科4班', '123', '女');
INSERT INTO `student_info` VALUES ('3', '2016100003', '吴刚', '土木工程专科2班', '123', '男');
INSERT INTO `student_info` VALUES ('4', '2016100004', '张晓敏', '计算机科学与技术本科2班', '123', '女');
INSERT INTO `student_info` VALUES ('5', '2016100005', '吴晓龙', '计算机科学与技术本科2班', '123', '男');

-- ----------------------------
-- Table structure for teacher_info
-- ----------------------------
DROP TABLE IF EXISTS `teacher_info`;
CREATE TABLE `teacher_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teachno` varchar(30) NOT NULL,
  `teachname` varchar(40) NOT NULL,
  `course` int(3) NOT NULL,
  `psd` varchar(255) NOT NULL,
  `sex` varchar(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher_info
-- ----------------------------
INSERT INTO `teacher_info` VALUES ('1', '2016200001', '张狂', '1', '123', '男');
