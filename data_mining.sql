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
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

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
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = 'Manager User Credential' ROW_FORMAT = Compact;

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
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = 'Manager Flow Command Credential' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of usercommand
-- ----------------------------
INSERT INTO `usercommand` VALUES (52, 'ROLE_BILLING_USER_ACCOUNT_SETTING', 'Menu Account Setting');
INSERT INTO `usercommand` VALUES (54, 'ROLE_BILLING_USER_ROLES', 'Menu Role Management');
INSERT INTO `usercommand` VALUES (101, 'ROLE_PROPERTY_INDEX', 'Dashboard');
INSERT INTO `usercommand` VALUES (102, 'ROLE_MENU_PROPERTY', 'Menu Property');
INSERT INTO `usercommand` VALUES (103, 'ROLE_MENU_MANAGEMENT', 'Menu Management');
INSERT INTO `usercommand` VALUES (104, 'ROLE_MENU_APPS', 'Menu Apps');
INSERT INTO `usercommand` VALUES (110, 'ROLE_VIEW_LISTING_REQUEST', 'Menu Request');
INSERT INTO `usercommand` VALUES (111, 'ROLE_VIEW_LISTING_PENDING_APPROVE', 'Menu Pending Approve');
INSERT INTO `usercommand` VALUES (112, 'ROLE_APPROVE_LISTING', 'Approve Listing');
INSERT INTO `usercommand` VALUES (120, 'ROLE_VIEW_LISTING_PROPERTY_PRIMARY', 'Menu Listing Property Primary');
INSERT INTO `usercommand` VALUES (121, 'ROLE_CREATE_LISTING_PRIMARY', 'Form Register Listing Primary');
INSERT INTO `usercommand` VALUES (122, 'ROLE_CREATE_LISTING_SECONDARY', 'Form Register Listing Secondary');
INSERT INTO `usercommand` VALUES (123, 'ROLE_VIEW_DETAILS_LISTING', 'View Details Listing Property');
INSERT INTO `usercommand` VALUES (130, 'ROLE_EDIT_DETAIL_SECONDARY', 'Form Edit Detail Secondary Property');
INSERT INTO `usercommand` VALUES (131, 'ROLE_EDIT_DETAIL_PRIMARY', 'Form Edit Detail Secondary Property');
INSERT INTO `usercommand` VALUES (140, 'ROLE_VIEW_USER_AGENT', 'Menu User Agent');
INSERT INTO `usercommand` VALUES (141, 'ROLE_ADD_USER_AGENT', 'Form Add User Agent');

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
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = 'Manager User Priviledge Credential' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of userpriviledge
-- ----------------------------
INSERT INTO `userpriviledge` VALUES ('00edb528-7530-4276-8804-c0441f3fa40b', 72, 54, 0);
INSERT INTO `userpriviledge` VALUES ('046086c3-329f-4e62-ac9d-fd32fb2e3ee3', 9, 120, 1);
INSERT INTO `userpriviledge` VALUES ('0831b17a-6ab4-4d42-9b7d-25f36d3dbcd7', 9, 52, 1);
INSERT INTO `userpriviledge` VALUES ('0f2097db-59a8-462a-bdfb-e05369f90293', 61, 102, 1);
INSERT INTO `userpriviledge` VALUES ('12f9b197-a949-4d5a-9dc9-8dd89fd2008d', 60, 101, 1);
INSERT INTO `userpriviledge` VALUES ('1c07e23a-33d1-4825-8d3f-caaa92c45dfd', 60, 141, 0);
INSERT INTO `userpriviledge` VALUES ('1d8fc226-d8bf-452f-a625-aeb42e268457', 72, 110, 1);
INSERT INTO `userpriviledge` VALUES ('1df52a9b-60df-48d5-b6cd-2eada73109aa', 61, 141, 0);
INSERT INTO `userpriviledge` VALUES ('284ac32d-f7f7-404f-9096-e039757f2ab7', 60, 122, 1);
INSERT INTO `userpriviledge` VALUES ('2ad74b55-71d5-4771-a0e0-6ba3a507a3c9', 61, 103, 0);
INSERT INTO `userpriviledge` VALUES ('2bec528d-0f88-4ec2-b380-d4fbd7191ea3', 61, 130, 1);
INSERT INTO `userpriviledge` VALUES ('2d04f58c-1a3f-442c-bbec-d76a93a58004', 20, 122, 1);
INSERT INTO `userpriviledge` VALUES ('2d5ceccc-61eb-4b20-b3a0-09913dd7be8c', 72, 121, 0);
INSERT INTO `userpriviledge` VALUES ('2f3738ab-3323-482c-ab80-e64c59f996e1', 72, 130, 1);
INSERT INTO `userpriviledge` VALUES ('31d65587-2f2c-4e68-ad37-88ec145fb550', 72, 120, 1);
INSERT INTO `userpriviledge` VALUES ('32de27cc-c5c6-4f41-be5f-52d729ea0035', 60, 110, 1);
INSERT INTO `userpriviledge` VALUES ('350c23a1-8ba4-4569-bca5-75d19bd8825d', 9, 104, 1);
INSERT INTO `userpriviledge` VALUES ('350d17ab-748d-4ae4-9830-ece9669f439e', 61, 121, 1);
INSERT INTO `userpriviledge` VALUES ('3c20cd7d-8ef8-4511-b99a-18db2046e16c', 61, 122, 1);
INSERT INTO `userpriviledge` VALUES ('3fbfb85b-1fa6-4fa1-9064-3ae2e358f4fa', 20, 104, 1);
INSERT INTO `userpriviledge` VALUES ('4462d49b-3bbc-4d01-bd30-dc67710df095', 61, 123, 1);
INSERT INTO `userpriviledge` VALUES ('48f0d47d-a78e-441c-8cb5-d992439a4849', 72, 112, 0);
INSERT INTO `userpriviledge` VALUES ('4c7a1b32-9975-477d-97bf-7358df4b6b67', 9, 54, 1);
INSERT INTO `userpriviledge` VALUES ('4e4c30b5-4221-490c-82fe-2e5c76d80c19', 20, 111, 1);
INSERT INTO `userpriviledge` VALUES ('53247ecf-829c-49e8-b7ac-6d854d2d15dc', 9, 122, 1);
INSERT INTO `userpriviledge` VALUES ('5355999d-cba6-42a1-be8a-f584b5c8b52e', 60, 102, 1);
INSERT INTO `userpriviledge` VALUES ('5e92d749-6fe3-4325-930c-a698680866db', 9, 112, 1);
INSERT INTO `userpriviledge` VALUES ('5fe26b5f-8fe0-4bc5-8a6f-6765f8f2efe9', 61, 140, 0);
INSERT INTO `userpriviledge` VALUES ('601838a6-519b-4d56-8cd1-b06a1a6aecbf', 60, 121, 1);
INSERT INTO `userpriviledge` VALUES ('608e28f6-7880-45a5-8e8b-3b903b95f702', 60, 103, 0);
INSERT INTO `userpriviledge` VALUES ('665d35cc-8df5-44bb-b125-18a242bfb024', 9, 103, 1);
INSERT INTO `userpriviledge` VALUES ('676176d8-0c19-48f9-9e65-5bd243fafce2', 72, 111, 1);
INSERT INTO `userpriviledge` VALUES ('6943ca42-3d68-41be-b16d-40b32d170307', 20, 121, 1);
INSERT INTO `userpriviledge` VALUES ('6ad459d1-84d6-4db0-ac3a-0fad4411af53', 61, 52, 0);
INSERT INTO `userpriviledge` VALUES ('6b940dd2-b7c3-4e84-a185-620d7889b4f8', 9, 102, 1);
INSERT INTO `userpriviledge` VALUES ('6c75270f-7651-43b4-aee1-146fcf0a3b80', 72, 123, 1);
INSERT INTO `userpriviledge` VALUES ('6cca49cd-04fe-4ca0-bbcb-72cc0a08ec71', 61, 104, 0);
INSERT INTO `userpriviledge` VALUES ('6f3c8b62-c15e-44f2-b663-12bb70fa4665', 61, 110, 1);
INSERT INTO `userpriviledge` VALUES ('740dd34b-dce1-434a-924a-bc4026651fc2', 61, 101, 1);
INSERT INTO `userpriviledge` VALUES ('748dac3a-7827-4648-9e65-9c26192b504d', 60, 120, 1);
INSERT INTO `userpriviledge` VALUES ('75fac862-f504-4e2c-be54-43a59dea0b51', 9, 121, 1);
INSERT INTO `userpriviledge` VALUES ('774e0d92-e6c2-4492-ba71-cf44ba9932db', 20, 140, 1);
INSERT INTO `userpriviledge` VALUES ('77fb5a47-d4fd-4f88-bd64-92ade801226b', 20, 110, 1);
INSERT INTO `userpriviledge` VALUES ('789ba8ec-8dcb-4504-95d4-5aab4168f4b1', 60, 140, 0);
INSERT INTO `userpriviledge` VALUES ('7bb5b555-a046-4a78-9aa1-c4ab42a646f2', 9, 140, 1);
INSERT INTO `userpriviledge` VALUES ('7c8a9555-0296-42c0-9704-f97c878f1cb2', 60, 123, 1);
INSERT INTO `userpriviledge` VALUES ('7e7d272d-0d87-4c12-aecd-ef856162b7bb', 72, 122, 0);
INSERT INTO `userpriviledge` VALUES ('839bad28-828c-41df-9eb3-5a9e44702155', 61, 112, 0);
INSERT INTO `userpriviledge` VALUES ('8c79ea51-6d89-4aea-b039-c3786ca5c334', 20, 101, 1);
INSERT INTO `userpriviledge` VALUES ('8d882ea5-affa-4e28-b421-6ad302e41a68', 20, 54, 0);
INSERT INTO `userpriviledge` VALUES ('8f4f21e9-b1d8-4e66-93ce-684995f49481', 9, 141, 1);
INSERT INTO `userpriviledge` VALUES ('91abaf6b-153d-40d5-87ff-ef4f89e08f36', 20, 131, 0);
INSERT INTO `userpriviledge` VALUES ('92437a9f-2e6e-4df5-873a-8295789aae72', 61, 120, 1);
INSERT INTO `userpriviledge` VALUES ('92823615-bd0c-4f54-b301-7f6b6b151c9c', 60, 104, 0);
INSERT INTO `userpriviledge` VALUES ('95fe7a8c-b48d-4cb6-8fdc-b7353a36a8ed', 9, 101, 1);
INSERT INTO `userpriviledge` VALUES ('96646c65-2b69-4189-a7d8-20f41e1ec709', 9, 123, 1);
INSERT INTO `userpriviledge` VALUES ('97b4ca6b-55da-4add-9bef-183e1ac4a0d8', 60, 52, 0);
INSERT INTO `userpriviledge` VALUES ('98c42959-ee67-4082-bab9-0f8d9196611c', 60, 112, 1);
INSERT INTO `userpriviledge` VALUES ('99e6703f-3c38-41ab-b9ed-6ab429b972d9', 61, 54, 0);
INSERT INTO `userpriviledge` VALUES ('9c7e8fd2-1662-4451-a3b8-49e5d12e2a36', 20, 112, 1);
INSERT INTO `userpriviledge` VALUES ('a0d715ae-7610-4235-82f7-e3b41c81f3c1', 72, 104, 0);
INSERT INTO `userpriviledge` VALUES ('ae1866bc-f2ea-4ac4-b942-9043ec2dea52', 72, 140, 0);
INSERT INTO `userpriviledge` VALUES ('b0ff44ec-bede-4a9a-b687-7f4400320e39', 61, 131, 1);
INSERT INTO `userpriviledge` VALUES ('b5b4354f-af82-4c5b-9228-fa9cde8d7280', 72, 141, 0);
INSERT INTO `userpriviledge` VALUES ('b6c8fcf6-113c-434c-b72f-98dfd0ce606c', 72, 103, 0);
INSERT INTO `userpriviledge` VALUES ('bc8ebd5c-ba44-4c09-9db2-614bb0e7ebf9', 60, 111, 1);
INSERT INTO `userpriviledge` VALUES ('c54a6855-0c9f-471d-bb01-47a4bc92b945', 60, 130, 0);
INSERT INTO `userpriviledge` VALUES ('c689377b-2c8d-4de8-b81d-d16f284b83a2', 20, 141, 1);
INSERT INTO `userpriviledge` VALUES ('cf013dbf-ce00-419a-be89-8a6c1e553277', 20, 52, 0);
INSERT INTO `userpriviledge` VALUES ('d1732be1-5dd5-49e4-969d-99dc67d3e95b', 61, 111, 1);
INSERT INTO `userpriviledge` VALUES ('db5221cb-ecfc-47fa-82ee-70b142de7a72', 72, 102, 1);
INSERT INTO `userpriviledge` VALUES ('df415b5d-ed96-4fcd-a012-c28fd88d248d', 60, 131, 0);
INSERT INTO `userpriviledge` VALUES ('e60d4c1a-6278-4d02-8b5b-f6d7e5c4cfa2', 20, 102, 1);
INSERT INTO `userpriviledge` VALUES ('e774bdd0-ad49-4209-b606-38379c58ff96', 72, 52, 0);
INSERT INTO `userpriviledge` VALUES ('eee6d34f-3be6-42a3-b678-387dc5fb399b', 20, 103, 0);
INSERT INTO `userpriviledge` VALUES ('ef384482-2055-4f42-992b-d9698c785777', 72, 131, 1);
INSERT INTO `userpriviledge` VALUES ('ef3c9cbd-2649-4c7c-bf25-64b1f038f1a6', 20, 130, 0);
INSERT INTO `userpriviledge` VALUES ('f1cbdc7a-7798-493d-88de-cebc35827d0b', 9, 131, 1);
INSERT INTO `userpriviledge` VALUES ('f371f3bf-18a7-46fa-8b82-217459ee3c2a', 72, 101, 1);
INSERT INTO `userpriviledge` VALUES ('f4dfa407-e033-4d89-943b-85df24a8ce8a', 9, 110, 1);
INSERT INTO `userpriviledge` VALUES ('f59f02c9-75fc-4e55-b7fb-58912fcde71a', 20, 123, 1);
INSERT INTO `userpriviledge` VALUES ('f5ac7e4b-d32d-407e-8386-fe5da2f5e4e9', 60, 54, 0);
INSERT INTO `userpriviledge` VALUES ('f732a4a3-e5d6-422a-aa1e-7d0dd6d2ffb8', 20, 120, 1);
INSERT INTO `userpriviledge` VALUES ('f957d7e3-7b8b-40d3-bb49-23ad3af0faec', 9, 111, 1);
INSERT INTO `userpriviledge` VALUES ('fdf8b693-d5e8-4b93-b408-3b1f374dc66e', 9, 130, 1);

-- ----------------------------
-- Table structure for usertype
-- ----------------------------
DROP TABLE IF EXISTS `usertype`;
CREATE TABLE `usertype`  (
  `user_type_id` int(11) NOT NULL,
  `user_type_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_type_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = 'Manager User Type Credential' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of usertype
-- ----------------------------
INSERT INTO `usertype` VALUES (9, 'IT Support');
INSERT INTO `usertype` VALUES (20, 'Principal');
INSERT INTO `usertype` VALUES (60, 'Agent Koordinator');
INSERT INTO `usertype` VALUES (61, 'Agent Staff');
INSERT INTO `usertype` VALUES (72, 'Operator');

-- ----------------------------
-- Triggers structure for table user
-- ----------------------------
DROP TRIGGER IF EXISTS `TR_DELETE_USER`;
delimiter ;;
CREATE TRIGGER `TR_DELETE_USER` BEFORE DELETE ON `user` FOR EACH ROW BEGIN
	IF OLD.USERNAME = 'sysadm' THEN
		SIGNAL SQLSTATE '77777' SET MESSAGE_TEXT = "You can't delete data";
	END IF;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
