/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : duck_management_system

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 23/12/2023 15:21:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_info
-- ----------------------------
DROP TABLE IF EXISTS `admin_info`;
CREATE TABLE `admin_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名字',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '密码',
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '性别',
  `age` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '年龄',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '手机号',
  `level` int NULL DEFAULT 1 COMMENT '权限等级',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 42 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_info
-- ----------------------------
INSERT INTO `admin_info` VALUES (1, 'admin', '123', '女', '32', '13680524090', 1);
INSERT INTO `admin_info` VALUES (2, 'tom', '123', '男', '27', '17566889723', 1);
INSERT INTO `admin_info` VALUES (3, 'jerry', '123', '女', '31', '18929010106', 1);
INSERT INTO `admin_info` VALUES (38, 'mancy', '123', '女', '23', '18860200752', 1);
INSERT INTO `admin_info` VALUES (40, 'duckee', '123', '男', '25', '16660208901', 1);

-- ----------------------------
-- Table structure for class_info
-- ----------------------------
DROP TABLE IF EXISTS `class_info`;
CREATE TABLE `class_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '课程名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '结课方式',
  `major` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '开设学院',
  `score` int NULL DEFAULT 0 COMMENT '学分',
  `teacherId` bigint NULL DEFAULT NULL COMMENT '教师ID',
  `classOpen` int NULL DEFAULT NULL COMMENT '人数上限',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '上课时间',
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '上课地点',
  `classChoose` int NULL DEFAULT 0 COMMENT '已选课程人数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class_info
-- ----------------------------
INSERT INTO `class_info` VALUES (1, '高等数学', '考试', '数学学院', 5, 5, 2, '周一1-2', 'if楼305', 2);
INSERT INTO `class_info` VALUES (5, 'Java基础', '考试', '软件工程', 2, 7, 60, '周二7-8', 'B203', 3);
INSERT INTO `class_info` VALUES (6, '线性代数', '考试', '软件工程', 3, 5, 3, '周四3-4', '丰盛堂C307', 1);
INSERT INTO `class_info` VALUES (7, '中国近代史', '考试', '历史学院', 3, 2, 50, '周三5-6', '丰盛堂A105', 0);
INSERT INTO `class_info` VALUES (9, '操作系统', '考试', '计算机学院', 3, 7, 30, '周五3-4', 'C503', 0);
INSERT INTO `class_info` VALUES (13, '学术制图', '考核', '化学学院', 2, 6, 10, '周二-5-6', 'D201', 1);

-- ----------------------------
-- Table structure for course_select_info
-- ----------------------------
DROP TABLE IF EXISTS `course_select_info`;
CREATE TABLE `course_select_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '课程名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '结课方式',
  `major` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '开设学院',
  `score` int NULL DEFAULT 0 COMMENT '学分',
  `teacherId` bigint NULL DEFAULT NULL COMMENT '教师ID',
  `classOpen` int NULL DEFAULT 0 COMMENT '人数上限',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '上课时间',
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '上课地点',
  `classChoose` int NULL DEFAULT 0 COMMENT '课程已选人数',
  `studentId` bigint NULL DEFAULT NULL COMMENT '选课学生ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_select_info
-- ----------------------------
INSERT INTO `course_select_info` VALUES (9, '高等数学', '考试', '数学学院', 5, 1, 1, '周一1-2', 'if楼305', 0, 1);
INSERT INTO `course_select_info` VALUES (10, '线性代数', '考试', '软件工程', 3, 5, 50, '周四3-4', '丰盛堂C307', 0, 1);
INSERT INTO `course_select_info` VALUES (12, '高等数学', '考试', '数学学院', 5, 1, 2, '周一1-2', 'if楼305', 1, 6);
INSERT INTO `course_select_info` VALUES (13, 'Java基础', '考核', '软件工程', 2, 2, 60, '周二7-8', '教学大楼B203', 1, 6);
INSERT INTO `course_select_info` VALUES (14, 'Java基础', '考核', '软件工程', 2, 2, 60, '周二7-8', '教学大楼B203', 2, 1);
INSERT INTO `course_select_info` VALUES (27, '学术制图', '考核', '化学学院', 2, 6, 10, '周二-5-6', 'D201', 0, 1);
INSERT INTO `course_select_info` VALUES (28, 'Java基础', '考试', '软件工程', 2, 7, 60, '周二7-8', 'B203', 2, 1);

-- ----------------------------
-- Table structure for student_info
-- ----------------------------
DROP TABLE IF EXISTS `student_info`;
CREATE TABLE `student_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名字',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '密码',
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '性别',
  `age` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '年龄',
  `uid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '学号',
  `level` int NULL DEFAULT 3 COMMENT '权限等级',
  `major` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '学院',
  `score` int NULL DEFAULT 0 COMMENT '学分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_info
-- ----------------------------
INSERT INTO `student_info` VALUES (1, 'stu', '123', '女', '19', '22331001', 3, '软件工程', 55);
INSERT INTO `student_info` VALUES (3, 'Wattit', '123', '女', '20', '21331080', 3, '人文社科', 10);
INSERT INTO `student_info` VALUES (6, 'Adam', '123', '男', '20', '21131674', 3, '数学系', 70);
INSERT INTO `student_info` VALUES (7, 'Chris', '123', '女', '19', '22261005', 3, 'AI', 53);

-- ----------------------------
-- Table structure for teacher_info
-- ----------------------------
DROP TABLE IF EXISTS `teacher_info`;
CREATE TABLE `teacher_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名字',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '密码',
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '性别',
  `age` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '年龄',
  `level` int NULL DEFAULT 2 COMMENT '权限等级',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '职称',
  `major` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '学院',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher_info
-- ----------------------------
INSERT INTO `teacher_info` VALUES (1, 'tch', '123', '女', '38', 2, '教授', '软件工程');
INSERT INTO `teacher_info` VALUES (2, '王红', '123', '女', '45', 2, '讲师', 'AI');
INSERT INTO `teacher_info` VALUES (5, '张三', '123', '男', '48', 2, '讲师', '微电子');
INSERT INTO `teacher_info` VALUES (6, '王五', '123', '女', '41', 2, '副教授', '历史类');
INSERT INTO `teacher_info` VALUES (7, '赵四', '123', '女', '52', 2, '副教授', '数学系');

SET FOREIGN_KEY_CHECKS = 1;
