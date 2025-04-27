/*
 Navicat Premium Data Transfer

 Source Server         : 24B103120326李阳
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : tlias

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 27/04/2025 19:26:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for clazz
-- ----------------------------
DROP TABLE IF EXISTS `clazz`;
CREATE TABLE `clazz`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID,主键',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '班级名称',
  `room` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '班级教室',
  `begin_date` date NOT NULL COMMENT '开课时间',
  `end_date` date NOT NULL COMMENT '结课时间',
  `master_id` int(0) UNSIGNED NULL DEFAULT NULL COMMENT '班主任ID, 关联员工表ID',
  `subject` tinyint(0) UNSIGNED NOT NULL COMMENT '学科, 1:java, 2:前端, 3:大数据, 4:Python, 5:Go, 6: 嵌入式',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '班级表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of clazz
-- ----------------------------
INSERT INTO `clazz` VALUES (1, 'JavaEE就业163期', '212', '2023-04-30', '2023-06-29', 10, 1, '2023-06-01 17:08:23', '2023-06-01 17:39:58');
INSERT INTO `clazz` VALUES (4, '前端就业90期', '210', '2023-07-10', '2024-01-20', 3, 2, '2023-06-01 17:45:12', '2023-06-01 17:45:12');
INSERT INTO `clazz` VALUES (5, 'JavaEE就业165期', '108', '2023-06-15', '2023-12-25', 6, 1, '2023-06-01 17:45:40', '2023-06-01 17:45:40');
INSERT INTO `clazz` VALUES (6, 'JavaEE就业166期', '105', '2023-07-20', '2024-02-20', 20, 1, '2023-06-01 17:46:10', '2023-06-01 17:46:10');
INSERT INTO `clazz` VALUES (7, '大数据就业58期', '209', '2023-08-01', '2024-02-15', 7, 3, '2023-06-01 17:51:21', '2023-06-01 17:51:21');
INSERT INTO `clazz` VALUES (8, 'JavaEE就业167期', '325', '2023-11-20', '2024-05-10', 36, 1, '2023-11-15 11:35:46', '2023-12-13 14:31:24');

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID, 主键',
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '部门名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (1, '学工部', '2025-02-04 18:23:53', '2025-04-03 18:23:59');
INSERT INTO `dept` VALUES (2, '教研部', '2024-09-25 09:47:40', '2024-09-09 15:17:04');
INSERT INTO `dept` VALUES (3, '咨询部', '2024-09-25 09:47:40', '2024-09-30 21:26:24');
INSERT INTO `dept` VALUES (4, '就业部', '2024-09-25 09:47:40', '2024-09-25 09:47:40');
INSERT INTO `dept` VALUES (5, '人事部', '2024-09-25 09:47:40', '2024-09-25 09:47:40');
INSERT INTO `dept` VALUES (6, '行政部', '2025-03-27 19:38:42', '2025-03-27 19:38:42');
INSERT INTO `dept` VALUES (7, '会计部', '2025-03-27 19:39:57', '2025-03-27 20:59:31');

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID,主键',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '123456' COMMENT '密码',
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '姓名',
  `gender` tinyint(0) UNSIGNED NOT NULL COMMENT '性别, 1:男, 2:女',
  `phone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '手机号',
  `job` tinyint(0) UNSIGNED NULL DEFAULT NULL COMMENT '职位, 1 班主任, 2 讲师 , 3 学工主管, 4 教研主管, 5 咨询师',
  `salary` int(0) UNSIGNED NULL DEFAULT NULL COMMENT '薪资',
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像',
  `entry_date` date NULL DEFAULT NULL COMMENT '入职日期',
  `dept_id` int(0) UNSIGNED NULL DEFAULT NULL COMMENT '部门ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE,
  UNIQUE INDEX `phone`(`phone`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 59 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '员工表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES (1, 'shinaian', '123456', '施耐庵', 1, '13309090001', 4, 15000, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2000-01-01', 2, '2023-10-20 16:35:33', '2023-11-16 16:11:26');
INSERT INTO `emp` VALUES (2, 'songjiang', '123456', '宋江', 1, '13309090002', 2, 8600, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2015-01-01', 2, '2023-10-20 16:35:33', '2023-10-20 16:35:37');
INSERT INTO `emp` VALUES (3, 'lujunyi', '123456', '卢俊义', 1, '13309090003', 2, 8900, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2008-05-01', 2, '2023-10-20 16:35:33', '2023-10-20 16:35:39');
INSERT INTO `emp` VALUES (4, 'wuyong', '123456', '吴用', 1, '13309090004', 2, 9200, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2007-01-01', 2, '2023-10-20 16:35:33', '2023-10-20 16:35:41');
INSERT INTO `emp` VALUES (5, 'gongsunsheng', '123456', '公孙胜', 1, '13309090005', 2, 9500, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2012-12-05', 2, '2023-10-20 16:35:33', '2023-10-20 16:35:43');
INSERT INTO `emp` VALUES (6, 'huosanniang', '123456', '扈三娘', 2, '13309090006', 3, 6500, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2013-09-05', 1, '2023-10-20 16:35:33', '2023-10-20 16:35:45');
INSERT INTO `emp` VALUES (7, 'chaijin', '123456', '柴进', 1, '13309090007', 1, 4700, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2005-08-01', 1, '2023-10-20 16:35:33', '2023-10-20 16:35:47');
INSERT INTO `emp` VALUES (8, 'likui', '123456', '李逵', 1, '13309090008', 1, 4800, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2014-11-09', 1, '2023-10-20 16:35:33', '2023-10-20 16:35:49');
INSERT INTO `emp` VALUES (9, 'wusong', '123456', '武松', 1, '13309090009', 1, 4900, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2011-03-11', 1, '2023-10-20 16:35:33', '2023-10-20 16:35:51');
INSERT INTO `emp` VALUES (10, 'linchong', '123456', '林冲', 1, '13309090010', 1, 5000, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2013-09-05', 1, '2023-10-20 16:35:33', '2023-10-20 16:35:53');
INSERT INTO `emp` VALUES (11, 'huyanzhuo', '123456', '呼延灼', 1, '13309090011', 2, 9700, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2007-02-01', 2, '2023-10-20 16:35:33', '2023-10-20 16:35:55');
INSERT INTO `emp` VALUES (12, 'xiaoliguang', '123456', '小李广', 1, '13309090012', 2, 10000, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2008-08-18', 2, '2023-10-20 16:35:33', '2023-10-20 16:35:57');
INSERT INTO `emp` VALUES (13, 'yangzhi', '123456', '杨志', 1, '13309090013', 1, 5300, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2012-11-01', 1, '2023-10-20 16:35:33', '2023-10-20 16:35:59');
INSERT INTO `emp` VALUES (14, 'shijin', '123456', '史进', 1, '13309090014', 2, 10600, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2002-08-01', 2, '2023-10-20 16:35:33', '2023-10-20 16:36:01');
INSERT INTO `emp` VALUES (15, 'sunerniang', '123456', '孙二娘', 2, '13309090015', 2, 10900, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2011-05-01', 2, '2023-10-20 16:35:33', '2023-10-20 16:36:03');
INSERT INTO `emp` VALUES (16, 'luzhishen', '123456', '鲁智深', 1, '13309090016', 2, 9600, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2010-01-01', 2, '2023-10-20 16:35:33', '2023-10-20 16:36:05');
INSERT INTO `emp` VALUES (17, 'liying', '12345678', '李应', 1, '13309090017', 1, 5800, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2015-03-21', 1, '2023-10-20 16:35:33', '2023-10-20 16:36:07');
INSERT INTO `emp` VALUES (18, 'shiqian', '123456', '时迁', 1, '13309090018', 2, 10200, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2015-01-01', 2, '2023-10-20 16:35:33', '2023-10-20 16:36:09');
INSERT INTO `emp` VALUES (19, 'gudasao', '123456', '顾大嫂', 2, '13309090019', 2, 10500, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2008-01-01', 2, '2023-10-20 16:35:33', '2023-10-20 16:36:11');
INSERT INTO `emp` VALUES (20, 'ruanxiaoer', '123456', '阮小二', 1, '13309090020', 2, 10800, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2018-01-01', 2, '2023-10-20 16:35:33', '2023-10-20 16:36:13');
INSERT INTO `emp` VALUES (21, 'ruanxiaowu', '123456', '阮小五', 1, '13309090021', 5, 5200, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2015-01-01', 3, '2023-10-20 16:35:33', '2023-10-20 16:36:15');
INSERT INTO `emp` VALUES (22, 'ruanxiaoqi', '123456', '阮小七', 1, '13309090022', 5, 5500, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2016-01-01', 3, '2023-10-20 16:35:33', '2023-10-20 16:36:17');
INSERT INTO `emp` VALUES (23, 'ruanji', '123456', '阮籍', 1, '13309090023', 5, 5800, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2012-01-01', 3, '2023-10-20 16:35:33', '2023-10-20 16:36:19');
INSERT INTO `emp` VALUES (24, 'tongwei', '123456', '童威', 1, '13309090024', 5, 5000, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2006-01-03', 3, '2023-10-20 16:35:33', '2025-04-24 16:21:17');
INSERT INTO `emp` VALUES (25, 'tongmeng', '123456', '童猛', 1, '13309090025', 5, 4800, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2002-01-03', 3, '2023-10-20 16:35:33', '2025-04-24 16:21:09');
INSERT INTO `emp` VALUES (26, 'yanshun', '123456', '燕顺', 1, '13309090026', 5, 54001, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2011-01-01', 3, '2023-10-20 16:35:33', '2025-04-24 16:20:54');
INSERT INTO `emp` VALUES (27, 'lijun', '123456', '李俊', 1, '13309090027', 2, 6601, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2004-01-01', 2, '2023-10-20 16:35:33', '2025-04-24 16:49:28');
INSERT INTO `emp` VALUES (28, 'lizhong', '123456', '李忠', 1, '13309090028', 5, 5000, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2007-01-03', 3, '2023-10-20 16:35:33', '2025-04-24 16:20:37');
INSERT INTO `emp` VALUES (30, 'liyun', '123456', '李云', 1, '13309090030', NULL, NULL, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2020-03-02', NULL, '2023-10-20 16:35:33', '2025-04-24 16:20:31');
INSERT INTO `emp` VALUES (36, 'linghuchong', '123456', '令狐冲', 1, '18043954121', 2, 6800, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2023-10-19', 2, '2023-10-20 20:44:54', '2025-04-24 16:50:05');

-- ----------------------------
-- Table structure for emp_expr
-- ----------------------------
DROP TABLE IF EXISTS `emp_expr`;
CREATE TABLE `emp_expr`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID, 主键',
  `emp_id` int(0) UNSIGNED NULL DEFAULT NULL COMMENT '员工ID',
  `begin` date NULL DEFAULT NULL COMMENT '开始时间',
  `end` date NULL DEFAULT NULL COMMENT '结束时间',
  `company` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '公司名称',
  `job` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '职位',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '工作经历' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emp_expr
-- ----------------------------
INSERT INTO `emp_expr` VALUES (13, 27, '2025-01-07', '2025-02-08', '美团', '外卖员');
INSERT INTO `emp_expr` VALUES (14, 36, '2025-04-16', '2025-05-12', '美团', '外卖员');

-- ----------------------------
-- Table structure for emp_log
-- ----------------------------
DROP TABLE IF EXISTS `emp_log`;
CREATE TABLE `emp_log`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID, 主键',
  `operate_time` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  `info` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '日志信息',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '员工日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emp_log
-- ----------------------------
INSERT INTO `emp_log` VALUES (1, '2025-03-31 19:21:22', '新增员工:Emp(id=55, username=aaaa, password=null, name=啊啊啊, gender=1, phone=15645358768, job=1, salary=8780, image=, entryDate=2025-03-04, deptId=2, createTime=2025-03-31T19:21:22.332744900, updateTime=2025-03-31T19:21:22.332744900, deptName=null, exprList=[EmpExpr(id=null, empId=55, begin=2025-03-27, end=2025-04-30, company=sadasd, job=dasdas)])');
INSERT INTO `emp_log` VALUES (2, '2025-04-01 14:29:37', '新增员工:Emp(id=56, username=anyuan, password=null, name=范安圆, gender=2, phone=17866789876, job=1, salary=19000, image=https://sky-take-out039.oss-cn-hangzhou.aliyuncs.com/2025/04/4ca7542a-8627-4d64-8d82-aba3fb3f68ee.JPG, entryDate=2025-04-07, deptId=1, createTime=2025-04-01T14:29:36.535317400, updateTime=2025-04-01T14:29:36.535317400, deptName=null, exprList=[EmpExpr(id=null, empId=56, begin=2025-04-17, end=2025-05-29, company=美团, job=学生)])');
INSERT INTO `emp_log` VALUES (3, '2025-04-06 16:23:06', '新增员工:Emp(id=57, username=ed, password=null, name=de, gender=1, phone=17865787644, job=null, salary=null, image=, entryDate=null, deptId=null, createTime=2025-04-06T16:23:06.341826300, updateTime=2025-04-06T16:23:06.341826300, deptName=null, exprList=[])');
INSERT INTO `emp_log` VALUES (4, '2025-04-06 16:50:02', '新增员工:Emp(id=58, username=liyang, password=null, name=李阳, gender=1, phone=18043954121, job=1, salary=15000, image=https://sky-take-out039.oss-cn-hangzhou.aliyuncs.com/2025/04/e5b99973-c817-4be9-b6fa-fe7d2855a44f.JPG, entryDate=2025-04-01, deptId=1, createTime=2025-04-06T16:50:01.804155400, updateTime=2025-04-06T16:50:01.804155400, deptName=null, exprList=[EmpExpr(id=null, empId=58, begin=2025-04-08, end=2025-05-20, company=美团, job=总经理)])');

-- ----------------------------
-- Table structure for operate_log
-- ----------------------------
DROP TABLE IF EXISTS `operate_log`;
CREATE TABLE `operate_log`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `operate_emp_id` int(0) UNSIGNED NULL DEFAULT NULL COMMENT '操作人ID',
  `operate_time` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  `class_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '操作的类名',
  `method_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '操作的方法名',
  `method_params` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '方法参数',
  `return_value` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '返回值',
  `cost_time` bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '方法执行耗时, 单位:ms',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '操作日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of operate_log
-- ----------------------------
INSERT INTO `operate_log` VALUES (1, 1, '2025-04-10 21:24:42', 'com.itheima.controller.DeptController', 'add', '[Dept(id=null, name=5666, createTime=2025-04-10T21:24:42.359723600, updateTime=2025-04-10T21:24:42.359723600)]', 'Result(code=1, msg=success, data=null)', 19);
INSERT INTO `operate_log` VALUES (2, 1, '2025-04-10 21:24:46', 'com.itheima.controller.DeptController', 'getInfo', '[9]', 'Result(code=1, msg=success, data=Dept(id=9, name=5666, createTime=2025-04-10T21:24:42, updateTime=2025-04-10T21:24:42))', 4);
INSERT INTO `operate_log` VALUES (3, 1, '2025-04-10 21:24:49', 'com.itheima.controller.DeptController', 'update', '[Dept(id=9, name=566656, createTime=2025-04-10T21:24:42, updateTime=2025-04-10T21:24:49.221197300)]', 'Result(code=1, msg=success, data=null)', 11);
INSERT INTO `operate_log` VALUES (4, 1, '2025-04-10 21:24:52', 'com.itheima.controller.DeptController', 'delete', '[9]', 'Result(code=1, msg=success, data=null)', 10);
INSERT INTO `operate_log` VALUES (5, 2, '2025-04-10 22:24:24', 'com.itheima.controller.DeptController', 'add', '[Dept(id=null, name=dwad, createTime=2025-04-10T22:24:23.776115900, updateTime=2025-04-10T22:24:23.776115900)]', 'Result(code=1, msg=success, data=null)', 21);
INSERT INTO `operate_log` VALUES (6, 2, '2025-04-10 22:24:25', 'com.itheima.controller.DeptController', 'getInfo', '[10]', 'Result(code=1, msg=success, data=Dept(id=10, name=dwad, createTime=2025-04-10T22:24:24, updateTime=2025-04-10T22:24:24))', 5);
INSERT INTO `operate_log` VALUES (7, 2, '2025-04-10 22:24:28', 'com.itheima.controller.DeptController', 'update', '[Dept(id=10, name=dwaddwad, createTime=2025-04-10T22:24:24, updateTime=2025-04-10T22:24:28.177952700)]', 'Result(code=1, msg=success, data=null)', 12);
INSERT INTO `operate_log` VALUES (8, 2, '2025-04-10 22:24:30', 'com.itheima.controller.DeptController', 'delete', '[10]', 'Result(code=1, msg=success, data=null)', 11);
INSERT INTO `operate_log` VALUES (9, 58, '2025-04-10 22:26:50', 'com.itheima.controller.DeptController', 'add', '[Dept(id=null, name=ewqe, createTime=2025-04-10T22:26:49.858679, updateTime=2025-04-10T22:26:49.858679)]', 'Result(code=1, msg=success, data=null)', 13);
INSERT INTO `operate_log` VALUES (10, 58, '2025-04-10 22:26:51', 'com.itheima.controller.DeptController', 'getInfo', '[11]', 'Result(code=1, msg=success, data=Dept(id=11, name=ewqe, createTime=2025-04-10T22:26:50, updateTime=2025-04-10T22:26:50))', 3);
INSERT INTO `operate_log` VALUES (11, 58, '2025-04-10 22:26:54', 'com.itheima.controller.DeptController', 'update', '[Dept(id=11, name=ewqewe, createTime=2025-04-10T22:26:50, updateTime=2025-04-10T22:26:53.507823600)]', 'Result(code=1, msg=success, data=null)', 9);
INSERT INTO `operate_log` VALUES (12, 58, '2025-04-10 22:26:56', 'com.itheima.controller.DeptController', 'delete', '[11]', 'Result(code=1, msg=success, data=null)', 7);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID,主键',
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '姓名',
  `no` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学号',
  `gender` tinyint(0) UNSIGNED NOT NULL COMMENT '性别, 1: 男, 2: 女',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '手机号',
  `id_card` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '身份证号',
  `is_college` tinyint(0) UNSIGNED NOT NULL COMMENT '是否来自于院校, 1:是, 0:否',
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系地址',
  `degree` tinyint(0) UNSIGNED NULL DEFAULT NULL COMMENT '最高学历, 1:初中, 2:高中, 3:大专, 4:本科, 5:硕士, 6:博士',
  `graduation_date` date NULL DEFAULT NULL COMMENT '毕业时间',
  `clazz_id` int(0) UNSIGNED NULL DEFAULT NULL COMMENT '班级ID, 关联班级表ID',
  `violation_count` tinyint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '违纪次数',
  `violation_score` tinyint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '违纪扣分',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `no`(`no`) USING BTREE,
  UNIQUE INDEX `phone`(`phone`) USING BTREE,
  UNIQUE INDEX `id_card`(`id_card`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '段誉', '2022000001', 1, '18800000001', '110120000300200001', 1, '北京市昌平区建材城西路1号', 1, '2021-07-01', 2, 0, 0, '2023-11-14 21:22:19', '2023-11-15 16:20:59');
INSERT INTO `student` VALUES (2, '萧峰', '2022000002', 1, '18800210003', '110120000300200002', 1, '北京市昌平区建材城西路2号', 2, '2022-07-01', 1, 0, 0, '2023-11-14 21:22:19', '2023-11-14 21:22:19');
INSERT INTO `student` VALUES (3, '虚竹', '2022000003', 1, '18800013001', '110120000300200003', 1, '北京市昌平区建材城西路3号', 2, '2023-07-01', 1, 0, 0, '2023-11-14 21:22:19', '2023-11-14 21:22:19');
INSERT INTO `student` VALUES (4, '萧远山', '2022000004', 1, '18800003211', '110120000300200004', 1, '北京市昌平区建材城西路4号', 3, '2024-07-01', 1, 0, 0, '2023-11-14 21:22:19', '2023-11-14 21:22:19');
INSERT INTO `student` VALUES (5, '阿朱', '2022000005', 2, '18800160002', '110120000300200005', 1, '北京市昌平区建材城西路5号', 4, '2020-07-01', 1, 0, 0, '2023-11-14 21:22:19', '2023-11-14 21:22:19');
INSERT INTO `student` VALUES (6, '阿紫', '2022000006', 2, '18800000034', '110120000300200006', 1, '北京市昌平区建材城西路6号', 4, '2021-07-01', 2, 0, 0, '2023-11-14 21:22:19', '2023-11-14 21:22:19');
INSERT INTO `student` VALUES (7, '游坦之', '2022000007', 1, '18800000067', '110120000300200007', 1, '北京市昌平区建材城西路7号', 4, '2022-07-01', 2, 0, 0, '2023-11-14 21:22:19', '2023-11-14 21:22:19');
INSERT INTO `student` VALUES (8, '康敏', '2022000008', 2, '18800000077', '110120000300200008', 1, '北京市昌平区建材城西路8号', 5, '2023-07-01', 2, 0, 0, '2023-11-14 21:22:19', '2023-11-14 21:22:19');
INSERT INTO `student` VALUES (9, '徐长老', '2022000009', 1, '18800000341', '110120000300200009', 1, '北京市昌平区建材城西路9号', 3, '2024-07-01', 2, 0, 0, '2023-11-14 21:22:19', '2023-11-14 21:22:19');
INSERT INTO `student` VALUES (10, '云中鹤', '2022000010', 1, '18800006571', '110120000300200010', 1, '北京市昌平区建材城西路10号', 2, '2020-07-01', 2, 0, 0, '2023-11-14 21:22:19', '2023-11-14 21:22:19');
INSERT INTO `student` VALUES (11, '钟万仇', '2022000011', 1, '18800000391', '110120000300200011', 1, '北京市昌平区建材城西路11号', 4, '2021-07-01', 1, 0, 0, '2023-11-14 21:22:19', '2023-11-15 16:21:24');
INSERT INTO `student` VALUES (12, '崔百泉', '2022000012', 1, '18800000781', '110120000300200018', 1, '北京市昌平区建材城西路12号', 4, '2022-07-05', 8, 6, 17, '2023-11-14 21:22:19', '2023-12-13 14:33:58');
INSERT INTO `student` VALUES (13, '耶律洪基', '2022000013', 1, '18800008901', '110120000300200013', 1, '北京市昌平区建材城西路13号', 4, '2023-07-01', 2, 0, 0, '2023-11-14 21:22:19', '2023-11-15 16:21:21');
INSERT INTO `student` VALUES (14, '天山童姥', '2022000014', 2, '18800009201', '110120000300200014', 1, '北京市昌平区建材城西路14号', 4, '2024-07-01', 1, 0, 0, '2023-11-14 21:22:19', '2023-11-15 16:21:17');
INSERT INTO `student` VALUES (15, '刘竹庄', '2022000015', 1, '18800009401', '110120000300200015', 1, '北京市昌平区建材城西路15号', 3, '2020-07-01', 4, 0, 0, '2023-11-14 21:22:19', '2023-11-14 21:22:19');
INSERT INTO `student` VALUES (16, '李春来', '2022000016', 1, '18800008501', '110120000300200016', 1, '北京市昌平区建材城西路16号', 4, '2021-07-01', 4, 0, 0, '2023-11-14 21:22:19', '2023-11-14 21:22:19');
INSERT INTO `student` VALUES (17, '王语嫣', '2022000017', 2, '18800007601', '110120000300200017', 1, '北京市昌平区建材城西路17号', 2, '2022-07-01', 4, 0, 0, '2023-11-14 21:22:19', '2023-11-14 21:22:19');
INSERT INTO `student` VALUES (18, '郑成功', '2023001101', 1, '13309092345', '110110110110110110', 0, '北京市昌平区回龙观街道88号', 5, '2021-07-01', 8, 2, 7, '2023-11-15 16:26:18', '2023-11-15 16:40:10');

SET FOREIGN_KEY_CHECKS = 1;
