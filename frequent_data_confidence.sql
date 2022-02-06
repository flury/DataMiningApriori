/*
 Navicat Premium Data Transfer

 Source Server         : Localhost_MySQL_3306
 Source Server Type    : MySQL
 Source Server Version : 50527
 Source Host           : localhost:3306
 Source Schema         : data_mining

 Target Server Type    : MySQL
 Target Server Version : 50527
 File Encoding         : 65001

 Date: 06/02/2022 22:10:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for frequent_data_confidence
-- ----------------------------
DROP TABLE IF EXISTS `frequent_data_confidence`;
CREATE TABLE `frequent_data_confidence`  (
  `id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `frequent_data_id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `candidate_a` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `support_a` double NULL DEFAULT NULL,
  `candidate_b` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `support_b` double NULL DEFAULT NULL,
  `confidence` double NULL DEFAULT NULL,
  `execute_user` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `execute_date` datetime NULL DEFAULT NULL,
  `param_min_confidence` double NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
