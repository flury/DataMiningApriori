/*
 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 100406
 Source Host           : localhost:3306
 Source Schema         : data_mining

 Target Server Type    : MySQL
 Target Server Version : 100406
 File Encoding         : 65001

 Date: 06/03/2022 11:57:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for master_itemset
-- ----------------------------
DROP TABLE IF EXISTS `master_itemset`;
CREATE TABLE `master_itemset`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of master_itemset
-- ----------------------------
INSERT INTO `master_itemset` VALUES (1, 'Angkatan 13', NULL);
INSERT INTO `master_itemset` VALUES (2, 'Angkatan 14', NULL);
INSERT INTO `master_itemset` VALUES (3, 'Angkatan 15', NULL);
INSERT INTO `master_itemset` VALUES (4, 'Angkatan 16', NULL);
INSERT INTO `master_itemset` VALUES (5, 'Pria', NULL);
INSERT INTO `master_itemset` VALUES (6, 'Wanita', NULL);
INSERT INTO `master_itemset` VALUES (7, 'Beasiswa', NULL);
INSERT INTO `master_itemset` VALUES (8, 'Nilai Rapor Kurang Dari 7.00', NULL);
INSERT INTO `master_itemset` VALUES (9, 'Nilai Rapor >= 7.00', NULL);
INSERT INTO `master_itemset` VALUES (10, 'SMA', NULL);
INSERT INTO `master_itemset` VALUES (11, 'SMK', NULL);
INSERT INTO `master_itemset` VALUES (12, 'Jakarta', NULL);
INSERT INTO `master_itemset` VALUES (13, 'Tangerang', NULL);
INSERT INTO `master_itemset` VALUES (14, 'Luar Kota', NULL);
INSERT INTO `master_itemset` VALUES (15, 'Teknik Informatika', NULL);
INSERT INTO `master_itemset` VALUES (16, 'Non Teknik Informatika', NULL);
INSERT INTO `master_itemset` VALUES (17, 'Cumlaude (Lebih dari 3.5)', NULL);
INSERT INTO `master_itemset` VALUES (18, 'Memuaskan (Kurang dari 3.5)', NULL);
INSERT INTO `master_itemset` VALUES (19, 'Cepat (Kurang dari = 4)', NULL);
INSERT INTO `master_itemset` VALUES (20, 'Standar (Lebih dari 4)', NULL);
INSERT INTO `master_itemset` VALUES (21, 'TI', NULL);
INSERT INTO `master_itemset` VALUES (22, 'SI', NULL);

SET FOREIGN_KEY_CHECKS = 1;
