/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50637
Source Host           : 127.0.0.1:3306
Source Database       : study_notes

Target Server Type    : MYSQL
Target Server Version : 50637
File Encoding         : 65001

Date: 2018-09-24 22:53:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_files
-- ----------------------------
DROP TABLE IF EXISTS `t_files`;
CREATE TABLE `t_files` (
  `id` varchar(50) NOT NULL,
  `superId` varchar(50) DEFAULT NULL,
  `file_name` varchar(100) DEFAULT NULL,
  `type` varchar(2) DEFAULT NULL,
  `del` varchar(2) DEFAULT NULL,
  `sort` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_files_notes
-- ----------------------------
DROP TABLE IF EXISTS `t_files_notes`;
CREATE TABLE `t_files_notes` (
  `id` varchar(50) NOT NULL,
  `filesId` varchar(50) DEFAULT NULL,
  `notesId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_notes
-- ----------------------------
DROP TABLE IF EXISTS `t_notes`;
CREATE TABLE `t_notes` (
  `id` varchar(50) NOT NULL,
  `superId` varchar(50) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `content` mediumtext,
  `insertDate` datetime DEFAULT NULL,
  `updataDate` datetime DEFAULT NULL,
  `del` varchar(2) DEFAULT NULL,
  `sort` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_sort
-- ----------------------------
DROP TABLE IF EXISTS `t_sort`;
CREATE TABLE `t_sort` (
  `id` varchar(50) NOT NULL,
  `sort_name` varchar(100) DEFAULT NULL,
  `del` varchar(2) DEFAULT NULL,
  `sort` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_sort_files
-- ----------------------------
DROP TABLE IF EXISTS `t_sort_files`;
CREATE TABLE `t_sort_files` (
  `id` varchar(50) NOT NULL,
  `sort_id` varchar(50) DEFAULT NULL,
  `files_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
