/*
Navicat MySQL Data Transfer

Source Server         : TestJDBC
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : population

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2019-03-22 20:56:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_dept
-- ----------------------------
DROP TABLE IF EXISTS `t_dept`;
CREATE TABLE `t_dept` (
  `dept_id` int(10) NOT NULL DEFAULT '0' COMMENT '部门id',
  `dept_name` varchar(255) NOT NULL DEFAULT '' COMMENT '部门名',
  `dept_leader` varchar(255) NOT NULL DEFAULT '' COMMENT '部门领导'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_emp
-- ----------------------------
DROP TABLE IF EXISTS `t_emp`;
CREATE TABLE `t_emp` (
  `emp_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '雇员id',
  `emp_name` varchar(20) NOT NULL DEFAULT '' COMMENT '雇员姓名',
  `emp_email` varchar(256) NOT NULL DEFAULT '' COMMENT '邮件地址',
  `gender` char(2) NOT NULL DEFAULT '' COMMENT '性别',
  `department_id` int(11) NOT NULL DEFAULT '0' COMMENT '部门id',
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
