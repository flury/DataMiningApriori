/*
 Source Server         : Localhost_MySQL_3306
 Source Server Type    : MySQL
 Source Server Version : 50527
 Source Host           : localhost:3306
 Source Schema         : data_mining

 Target Server Type    : MySQL
 Target Server Version : 50527
 File Encoding         : 65001

 Date: 22/01/2022 22:58:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity_log
-- ----------------------------
DROP TABLE IF EXISTS `activity_log`;
CREATE TABLE `activity_log`  (
  `activity_log_id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `command` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `ip_address` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `log_message` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `log_time` datetime NULL DEFAULT NULL,
  `log_type` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`activity_log_id`) USING BTREE,
  UNIQUE INDEX `activity_log_id`(`activity_log_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of activity_log
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `usertype` int(11) NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `wrong_password` int(11) NULL DEFAULT NULL,
  `is_account_lock` tinyint(1) NULL DEFAULT NULL,
  `status_user` tinyint(1) NULL DEFAULT NULL,
  `full_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `first_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `last_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `email_user` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `gender` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `phone_number` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `change_password` datetime NULL DEFAULT NULL,
  `last_login` datetime NULL DEFAULT NULL,
  `create_date` datetime NULL DEFAULT NULL,
  `create_user` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `update_date` datetime NULL DEFAULT NULL,
  `update_user` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `FK36EBCBAE31DDA3`(`usertype`) USING BTREE,
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`usertype`) REFERENCES `usertype` (`user_type_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = 'Manager User Credential' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('5f4dcc3b5aa765d61d8327deb882cf99', 9, 'sysadm', '$2a$10$3lSCiIGXrbX7Gq6DZF1JKuS0NCYbOM83jQPxkqjAiPNuJfxnqMQpK', 0, 1, 1, 'Administrator System', 'Administrator', 'System', 'username@example1.com', 'Female', '081343552233', '2016-12-27 12:31:09', NULL, '2016-11-14 11:15:19', 'sysadm', '2016-12-27 12:29:57', 'sysadm');

-- ----------------------------
-- Table structure for usercommand
-- ----------------------------
DROP TABLE IF EXISTS `usercommand`;
CREATE TABLE `usercommand`  (
  `command_id` int(11) NOT NULL,
  `command` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`command_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = 'Manager Flow Command Credential' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of usercommand
-- ----------------------------
INSERT INTO `usercommand` VALUES (101, 'ROLE_INDEX', 'Dashboard');

-- ----------------------------
-- Table structure for userpriviledge
-- ----------------------------
DROP TABLE IF EXISTS `userpriviledge`;
CREATE TABLE `userpriviledge`  (
  `user_priviledge_id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `usertype` int(11) NULL DEFAULT NULL,
  `command_id` int(11) NULL DEFAULT NULL,
  `authorized` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`user_priviledge_id`) USING BTREE,
  INDEX `FK538ABEDAC4CB8F2F`(`command_id`) USING BTREE,
  CONSTRAINT `userpriviledge_ibfk_1` FOREIGN KEY (`command_id`) REFERENCES `usercommand` (`command_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = 'Manager User Priviledge Credential' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of userpriviledge
-- ----------------------------
INSERT INTO `userpriviledge` VALUES ('95fe7a8c-b48d-4cb6-8fdc-b7353a36a8ed', 9, 101, 1);

-- ----------------------------
-- Table structure for usertype
-- ----------------------------
DROP TABLE IF EXISTS `usertype`;
CREATE TABLE `usertype`  (
  `user_type_id` int(11) NOT NULL,
  `user_type_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_type_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = 'Manager User Type Credential' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of usertype
-- ----------------------------
INSERT INTO `usertype` VALUES (9, 'IT Support');

SET FOREIGN_KEY_CHECKS = 1;
