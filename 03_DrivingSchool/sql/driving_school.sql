/*
 Navicat Premium Data Transfer

 Source Server         : course
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : driving_school

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 29/01/2021 23:14:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dict_item
-- ----------------------------
DROP TABLE IF EXISTS `dict_item`;
CREATE TABLE `dict_item`  (
  `id` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称',
  `value` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '值',
  `sn` smallint(5) UNSIGNED NOT NULL DEFAULT 0 COMMENT '排列顺序，默认0。值越大，就排在越前面',
  `disabled` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否禁用。0代表不禁用（启用），1代表禁用',
  `type_id` smallint(5) UNSIGNED NOT NULL DEFAULT 0 COMMENT '所属的类型',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `dict_item_name_type_id_uindex`(`name`, `type_id`) USING BTREE,
  UNIQUE INDEX `dict_item_value_type_id_uindex`(`value`, `type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '数据字典条目' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dict_item
-- ----------------------------
INSERT INTO `dict_item` VALUES (1, '程序员', 'coder', 8, 1, 1);
INSERT INTO `dict_item` VALUES (2, '教师', 'teacher', 0, 0, 1);
INSERT INTO `dict_item` VALUES (3, '司机', 'driver', 6, 1, 1);
INSERT INTO `dict_item` VALUES (5, '学员', 'student', 666, 0, 97);
INSERT INTO `dict_item` VALUES (6, '666', '777', 0, 0, 0);
INSERT INTO `dict_item` VALUES (7, '课程合集', '0', 0, 0, 115);
INSERT INTO `dict_item` VALUES (8, '科目2', '2', 0, 0, 115);
INSERT INTO `dict_item` VALUES (9, '科目3', '3', 0, 0, 115);

-- ----------------------------
-- Table structure for dict_type
-- ----------------------------
DROP TABLE IF EXISTS `dict_type`;
CREATE TABLE `dict_type`  (
  `id` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称',
  `value` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '值',
  `intro` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '简介',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `dict_type_name_uindex`(`name`) USING BTREE,
  UNIQUE INDEX `dict_type_value_uindex`(`value`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 116 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '数据字典类型' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dict_type
-- ----------------------------
INSERT INTO `dict_type` VALUES (1, '职业', 'job', '一份工作');
INSERT INTO `dict_type` VALUES (13, '哈哈12', 'haha12', '12');
INSERT INTO `dict_type` VALUES (14, '哈哈13', 'haha13', '13');
INSERT INTO `dict_type` VALUES (15, '哈哈14', 'haha14', '14');
INSERT INTO `dict_type` VALUES (16, '哈哈15', 'haha15', '15');
INSERT INTO `dict_type` VALUES (17, '哈哈16', 'haha16', '16');
INSERT INTO `dict_type` VALUES (18, '哈哈17', 'haha17', '17');
INSERT INTO `dict_type` VALUES (19, '哈哈18', 'haha18', '18');
INSERT INTO `dict_type` VALUES (20, '哈哈19', 'haha19', '19');
INSERT INTO `dict_type` VALUES (21, '哈哈20', 'haha20', '20');
INSERT INTO `dict_type` VALUES (22, '哈哈21', 'haha21', '21');
INSERT INTO `dict_type` VALUES (23, '哈哈22', 'haha22', '22');
INSERT INTO `dict_type` VALUES (24, '哈哈23', 'haha23', '23');
INSERT INTO `dict_type` VALUES (25, '哈哈24', 'haha24', '24');
INSERT INTO `dict_type` VALUES (26, '哈哈25', 'haha25', '25');
INSERT INTO `dict_type` VALUES (27, '哈哈26', 'haha26', '26');
INSERT INTO `dict_type` VALUES (28, '哈哈27', 'haha27', '27');
INSERT INTO `dict_type` VALUES (29, '哈哈28', 'haha28', '28');
INSERT INTO `dict_type` VALUES (30, '哈哈29', 'haha29', '29');
INSERT INTO `dict_type` VALUES (31, '哈哈30', 'haha30', '30');
INSERT INTO `dict_type` VALUES (32, '哈哈31', 'haha31', '31');
INSERT INTO `dict_type` VALUES (33, '哈哈32', 'haha32', '32');
INSERT INTO `dict_type` VALUES (34, '哈哈33', 'haha33', '33');
INSERT INTO `dict_type` VALUES (35, '哈哈34', 'haha34', '34');
INSERT INTO `dict_type` VALUES (36, '哈哈35', 'haha35', '35');
INSERT INTO `dict_type` VALUES (37, '哈哈36', 'haha36', '36');
INSERT INTO `dict_type` VALUES (38, '哈哈37', 'haha37', '37');
INSERT INTO `dict_type` VALUES (39, '哈哈38', 'haha38', '38');
INSERT INTO `dict_type` VALUES (40, '哈哈39', 'haha39', '39');
INSERT INTO `dict_type` VALUES (41, '哈哈40', 'haha40', '40');
INSERT INTO `dict_type` VALUES (42, '哈哈41', 'haha41', '41');
INSERT INTO `dict_type` VALUES (43, '哈哈42', 'haha42', '42');
INSERT INTO `dict_type` VALUES (44, '哈哈43', 'haha43', '43');
INSERT INTO `dict_type` VALUES (45, '哈哈44', 'haha44', '44');
INSERT INTO `dict_type` VALUES (46, '哈哈45', 'haha45', '45');
INSERT INTO `dict_type` VALUES (47, '哈哈46', 'haha46', '46');
INSERT INTO `dict_type` VALUES (48, '哈哈47', 'haha47', '47');
INSERT INTO `dict_type` VALUES (49, '哈哈48', 'haha48', '48');
INSERT INTO `dict_type` VALUES (50, '哈哈49', 'haha49', '49');
INSERT INTO `dict_type` VALUES (51, '哈哈50', 'haha50', '50');
INSERT INTO `dict_type` VALUES (52, '哈哈51', 'haha51', '51');
INSERT INTO `dict_type` VALUES (53, '哈哈52', 'haha52', '52');
INSERT INTO `dict_type` VALUES (54, '哈哈53', 'haha53', '53');
INSERT INTO `dict_type` VALUES (55, '哈哈54', 'haha54', '54');
INSERT INTO `dict_type` VALUES (56, '哈哈55', 'haha55', '55');
INSERT INTO `dict_type` VALUES (57, '哈哈56', 'haha56', '56');
INSERT INTO `dict_type` VALUES (58, '哈哈57', 'haha57', '57');
INSERT INTO `dict_type` VALUES (59, '哈哈58', 'haha58', '58');
INSERT INTO `dict_type` VALUES (60, '哈哈59', 'haha59', '59');
INSERT INTO `dict_type` VALUES (61, '哈哈60', 'haha60', '60');
INSERT INTO `dict_type` VALUES (62, '哈哈61', 'haha61', '61');
INSERT INTO `dict_type` VALUES (63, '哈哈62', 'haha62', '62');
INSERT INTO `dict_type` VALUES (64, '哈哈63', 'haha63', '63');
INSERT INTO `dict_type` VALUES (65, '哈哈64', 'haha64', '64');
INSERT INTO `dict_type` VALUES (66, '哈哈65', 'haha65', '65');
INSERT INTO `dict_type` VALUES (67, '哈哈66', 'haha66', '66');
INSERT INTO `dict_type` VALUES (68, '哈哈67', 'haha67', '67');
INSERT INTO `dict_type` VALUES (69, '哈哈68', '756567657', '68');
INSERT INTO `dict_type` VALUES (70, '哈哈69', 'haha69', '69');
INSERT INTO `dict_type` VALUES (71, '哈哈70', 'haha70', '70');
INSERT INTO `dict_type` VALUES (72, '哈哈71', 'haha71', '71');
INSERT INTO `dict_type` VALUES (73, '哈哈72', 'haha72', '72');
INSERT INTO `dict_type` VALUES (74, '哈哈73', 'haha73', '73');
INSERT INTO `dict_type` VALUES (75, '哈哈74', 'haha74', '74');
INSERT INTO `dict_type` VALUES (76, '哈哈75', 'haha75', '75');
INSERT INTO `dict_type` VALUES (77, '哈哈76', 'haha76', '76');
INSERT INTO `dict_type` VALUES (78, '哈哈77', 'haha77', '77');
INSERT INTO `dict_type` VALUES (84, '哈哈83', 'haha83', '83');
INSERT INTO `dict_type` VALUES (85, '哈哈84', 'haha84', '84');
INSERT INTO `dict_type` VALUES (86, '哈哈85', 'haha85', '85');
INSERT INTO `dict_type` VALUES (87, '哈哈86', 'haha86', '86');
INSERT INTO `dict_type` VALUES (88, '哈哈87', 'haha87', '87');
INSERT INTO `dict_type` VALUES (89, '哈哈88', 'haha88', '88');
INSERT INTO `dict_type` VALUES (90, '哈哈89', 'haha89', '89');
INSERT INTO `dict_type` VALUES (91, '哈哈90', 'haha90', '90');
INSERT INTO `dict_type` VALUES (92, '哈哈91', 'haha91', '91');
INSERT INTO `dict_type` VALUES (93, '哈哈92', 'haha92', '92');
INSERT INTO `dict_type` VALUES (94, '哈哈93', 'haha93', '93');
INSERT INTO `dict_type` VALUES (95, '哈哈94', 'haha94', '94');
INSERT INTO `dict_type` VALUES (96, '哈哈95', 'haha95', '95');
INSERT INTO `dict_type` VALUES (97, '哈哈96', 'haha96', '96');
INSERT INTO `dict_type` VALUES (98, '哈哈97', 'haha97', '97');
INSERT INTO `dict_type` VALUES (99, '哈哈98', 'haha98', '98');
INSERT INTO `dict_type` VALUES (100, '哈哈99', 'haha99', '99');
INSERT INTO `dict_type` VALUES (101, '654546', '765768768', '789789789');
INSERT INTO `dict_type` VALUES (112, '123', '123', '123');
INSERT INTO `dict_type` VALUES (115, '科2科3课程类型', 'course_type', '科2科3课程类型科2科3课程类型科2科3课程类型科2科3课程类型');

-- ----------------------------
-- Table structure for exam_place
-- ----------------------------
DROP TABLE IF EXISTS `exam_place`;
CREATE TABLE `exam_place`  (
  `id` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称',
  `province_id` smallint(5) UNSIGNED NOT NULL DEFAULT 0 COMMENT '考场是哪个省份的',
  `city_id` smallint(5) UNSIGNED NOT NULL DEFAULT 0 COMMENT '考场是哪个城市的',
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '考场的具体地址',
  `latitude` decimal(10, 7) NOT NULL DEFAULT 0.0000000 COMMENT '纬度',
  `longitude` decimal(10, 7) NOT NULL DEFAULT 0.0000000 COMMENT '经度',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `exam_place_city_id_name_uindex`(`city_id`, `name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '考场' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exam_place
-- ----------------------------
INSERT INTO `exam_place` VALUES (1, '白云考场', 3, 5, '白云区棠下', 0.0000000, 0.0000000);
INSERT INTO `exam_place` VALUES (2, '金牛考场', 6, 9, '金牛区', 0.0000000, 0.0000000);
INSERT INTO `exam_place` VALUES (3, '电瓶车考场', 10, 11, '很多电瓶车的考场', 2.0000000, 1.0000000);
INSERT INTO `exam_place` VALUES (4, '保安考场', 3, 12, '', 0.0000000, 0.0000000);
INSERT INTO `exam_place` VALUES (5, '天河考场', 3, 5, '', 0.0000000, 0.0000000);

-- ----------------------------
-- Table structure for exam_place_course
-- ----------------------------
DROP TABLE IF EXISTS `exam_place_course`;
CREATE TABLE `exam_place_course`  (
  `id` mediumint(8) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称',
  `price` decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '价格',
  `type` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '课程类型：0是课程合集，2是科目2，3是科目3',
  `intro` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `video` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '视频',
  `cover` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '封面',
  `place_id` smallint(5) UNSIGNED NOT NULL DEFAULT 0 COMMENT '考场',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '考场课程' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exam_place_course
-- ----------------------------
INSERT INTO `exam_place_course` VALUES (1, '2021-01-08 21:58:35', '倒车入库', 99.99, 0, '这是一门比较难的课程', '', 'upload/img/51f5048f-dddc-430c-9038-3bff9a5f89a9.jpg', 5);

-- ----------------------------
-- Table structure for plate_region
-- ----------------------------
DROP TABLE IF EXISTS `plate_region`;
CREATE TABLE `plate_region`  (
  `id` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称',
  `plate` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '车牌',
  `pinyin` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '拼音',
  `parent_id` smallint(5) UNSIGNED NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `plate_region_parent_id_name_uindex`(`parent_id`, `name`) USING BTREE,
  INDEX `plate_region_parent_id_plate_index`(`parent_id`, `plate`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '带有车牌的区域' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of plate_region
-- ----------------------------
INSERT INTO `plate_region` VALUES (3, '广东', '粤', 'GUANG_DONG', 0);
INSERT INTO `plate_region` VALUES (4, '福建', '闽', 'FU_JIAN', 0);
INSERT INTO `plate_region` VALUES (5, '广州', 'A', 'guangzhou', 3);
INSERT INTO `plate_region` VALUES (6, '四川', '川', 'SI_CHUAN', 0);
INSERT INTO `plate_region` VALUES (8, '贵州', '贵', 'GUI_ZHOU', 0);
INSERT INTO `plate_region` VALUES (9, '成都', 'A', 'CHENG_DOU', 6);
INSERT INTO `plate_region` VALUES (10, '广西', '桂', 'GUANG_XI', 0);
INSERT INTO `plate_region` VALUES (11, '南宁', 'A', 'NAN_NING', 10);
INSERT INTO `plate_region` VALUES (12, '深圳', 'B', 'SHEN_ZHEN', 3);
INSERT INTO `plate_region` VALUES (13, '珠海', 'C', 'ZHU_HAI', 3);
INSERT INTO `plate_region` VALUES (14, '汕头', 'D', 'SHAN_TOU', 3);
INSERT INTO `plate_region` VALUES (15, '福州', 'A', 'FU_ZHOU', 4);
INSERT INTO `plate_region` VALUES (16, '厦门', 'J', 'SHA_MEN', 4);
INSERT INTO `plate_region` VALUES (17, '莆田', 'B', 'PU_TIAN', 4);
INSERT INTO `plate_region` VALUES (18, '茂名', 'K', 'MAO_MING', 3);

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource`  (
  `id` tinyint(3) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称',
  `uri` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '链接地址',
  `permission` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '权限标识',
  `type` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '资源类型（0是目录，1是菜单，2是目录）',
  `icon` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '图标',
  `sn` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '序号',
  `parent_id` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '父资源id',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `sys_resource_parent_id_name_uindex`(`parent_id`, `name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 57 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '资源' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES (1, '系统', '', '', 0, 'fa fa-lock', 0, 0);
INSERT INTO `sys_resource` VALUES (2, '元数据', '', '', 0, 'fa fa-newspaper-o', 1, 0);
INSERT INTO `sys_resource` VALUES (3, '考试', '', '', 0, 'fa fa-mortar-board', 2, 0);
INSERT INTO `sys_resource` VALUES (4, '客户', '', '', 0, 'fa fa-users', 3, 0);
INSERT INTO `sys_resource` VALUES (5, '用户', 'page/sys/user/list.html', '', 1, 'fa fa-user-circle', 0, 1);
INSERT INTO `sys_resource` VALUES (6, '角色', 'page/sys/role/list.html', '', 1, 'fa fa-user', 1, 1);
INSERT INTO `sys_resource` VALUES (7, '资源', 'page/sys/resource/list.html', '', 1, 'fa fa-key', 2, 1);
INSERT INTO `sys_resource` VALUES (8, '省份', 'page/metadata/province/list.html', '', 1, 'fa fa-map-marker', 0, 2);
INSERT INTO `sys_resource` VALUES (9, '城市', 'page/metadata/city/list.html', '', 1, 'fa fa-location-arrow', 1, 2);
INSERT INTO `sys_resource` VALUES (10, '数据字典类型', 'page/metadata/dictType/list.html', '', 1, 'fa fa-cube', 2, 2);
INSERT INTO `sys_resource` VALUES (11, '数据字典条目', 'page/metadata/dictItem/list.html', '', 1, 'fa fa-cubes', 3, 2);
INSERT INTO `sys_resource` VALUES (12, '考场', 'page/exam/examPlace/list.html', '', 1, 'fa fa-car', 0, 3);
INSERT INTO `sys_resource` VALUES (13, '科1科4', 'page/exam/k1k4/list.html', '', 1, 'fa fa-pencil', 1, 3);
INSERT INTO `sys_resource` VALUES (14, '科2科3', 'page/exam/examPlaceCourse/list.html', '', 1, 'fa fa-video-camera', 2, 3);
INSERT INTO `sys_resource` VALUES (15, '交易', '', '', 0, 'fa fa-money', 4, 0);
INSERT INTO `sys_resource` VALUES (16, '驾校', 'page/customer/school/list.html', '', 1, 'fa fa-university', 0, 4);
INSERT INTO `sys_resource` VALUES (17, '教练', 'page/customer/coach/list.html', '', 1, 'fa fa-male', 1, 4);
INSERT INTO `sys_resource` VALUES (18, '学员', 'page/customer/student/list.html', '', 1, 'fa fa-child', 2, 4);
INSERT INTO `sys_resource` VALUES (19, '提现', 'page/deal/withdraw/list.html', '', 1, 'fa fa-cny', 0, 15);
INSERT INTO `sys_resource` VALUES (20, '订单', 'page/deal/order/list.html', '', 1, 'fa fa-ticket', 1, 15);
INSERT INTO `sys_resource` VALUES (21, '查询', '', 'sysUser:list', 2, '', 0, 5);
INSERT INTO `sys_resource` VALUES (22, '添加', '', 'sysUser:add', 2, '', 0, 5);
INSERT INTO `sys_resource` VALUES (23, '修改', '', 'sysUser:update', 2, '', 0, 5);
INSERT INTO `sys_resource` VALUES (24, '删除', '', 'sysUser:remove', 2, '', 0, 5);
INSERT INTO `sys_resource` VALUES (25, '查询', '', 'sysRole:list', 2, '', 0, 6);
INSERT INTO `sys_resource` VALUES (26, '添加', '', 'sysRole:add', 2, '', 0, 6);
INSERT INTO `sys_resource` VALUES (27, '修改', '', 'sysRole:update', 2, '', 0, 6);
INSERT INTO `sys_resource` VALUES (28, '删除', '', 'sysRole:remove', 2, '', 0, 6);
INSERT INTO `sys_resource` VALUES (29, '查询', '', 'sysResource:list', 2, '', 0, 7);
INSERT INTO `sys_resource` VALUES (30, '添加', '', 'sysResource:add', 2, '', 0, 7);
INSERT INTO `sys_resource` VALUES (31, '修改', '', 'sysResource:update', 2, '', 0, 7);
INSERT INTO `sys_resource` VALUES (32, '删除', '', 'sysResource:remove', 2, '', 0, 7);
INSERT INTO `sys_resource` VALUES (33, '查询', '', 'province:list', 2, '', 0, 8);
INSERT INTO `sys_resource` VALUES (34, '添加', '', 'province:add', 2, '', 0, 8);
INSERT INTO `sys_resource` VALUES (35, '修改', '', 'province:update', 2, '', 0, 8);
INSERT INTO `sys_resource` VALUES (36, '删除', '', 'province:remove', 2, '', 0, 8);
INSERT INTO `sys_resource` VALUES (37, '查询', '', 'city:list', 2, '', 0, 9);
INSERT INTO `sys_resource` VALUES (38, '添加', '', 'city:add', 2, '', 0, 9);
INSERT INTO `sys_resource` VALUES (39, '修改', '', 'city:update', 2, '', 0, 9);
INSERT INTO `sys_resource` VALUES (40, '删除', '', 'city:remove', 2, '', 0, 9);
INSERT INTO `sys_resource` VALUES (41, '查询', '', 'dictType:list', 2, '', 0, 10);
INSERT INTO `sys_resource` VALUES (42, '添加', '', 'dictType:add', 2, '', 0, 10);
INSERT INTO `sys_resource` VALUES (43, '修改', '', 'dictType:update', 2, '', 0, 10);
INSERT INTO `sys_resource` VALUES (44, '删除', '', 'dictType:remove', 2, '', 0, 10);
INSERT INTO `sys_resource` VALUES (45, '查询', '', 'dictItem:list', 2, '', 0, 11);
INSERT INTO `sys_resource` VALUES (46, '添加', '', 'dictItem:add', 2, '', 0, 11);
INSERT INTO `sys_resource` VALUES (47, '修改', '', 'dictItem:update', 2, '', 0, 11);
INSERT INTO `sys_resource` VALUES (48, '删除', '', 'dictItem:remove', 2, '', 0, 11);
INSERT INTO `sys_resource` VALUES (49, '查询', '', 'examPlace:list', 2, '', 0, 12);
INSERT INTO `sys_resource` VALUES (50, '添加', '', 'examPlace:add', 2, '', 0, 12);
INSERT INTO `sys_resource` VALUES (51, '修改', '', 'examPlace:update', 2, '', 0, 12);
INSERT INTO `sys_resource` VALUES (52, '删除', '', 'examPlace:remove', 2, '', 0, 12);
INSERT INTO `sys_resource` VALUES (53, '查询', '', 'examPlaceCourse:list', 2, '', 0, 14);
INSERT INTO `sys_resource` VALUES (54, '添加', '', 'examPlaceCourse:add', 2, '', 0, 14);
INSERT INTO `sys_resource` VALUES (55, '修改', '', 'examPlaceCourse:update', 2, '', 0, 14);
INSERT INTO `sys_resource` VALUES (56, '删除', '', 'examPlaceCourse:remove', 2, '', 0, 14);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` tinyint(3) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '角色名称',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `sys_role_name_uindex`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (4, '客服');
INSERT INTO `sys_role` VALUES (1, '总经理');
INSERT INTO `sys_role` VALUES (2, '销售经理');

-- ----------------------------
-- Table structure for sys_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resource`;
CREATE TABLE `sys_role_resource`  (
  `role_id` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '角色id',
  `resource_id` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '资源id',
  PRIMARY KEY (`resource_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色-资源' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_resource
-- ----------------------------
INSERT INTO `sys_role_resource` VALUES (1, 21);
INSERT INTO `sys_role_resource` VALUES (2, 21);
INSERT INTO `sys_role_resource` VALUES (1, 22);
INSERT INTO `sys_role_resource` VALUES (2, 22);
INSERT INTO `sys_role_resource` VALUES (1, 23);
INSERT INTO `sys_role_resource` VALUES (2, 23);
INSERT INTO `sys_role_resource` VALUES (1, 24);
INSERT INTO `sys_role_resource` VALUES (1, 25);
INSERT INTO `sys_role_resource` VALUES (2, 25);
INSERT INTO `sys_role_resource` VALUES (4, 25);
INSERT INTO `sys_role_resource` VALUES (1, 26);
INSERT INTO `sys_role_resource` VALUES (2, 26);
INSERT INTO `sys_role_resource` VALUES (1, 27);
INSERT INTO `sys_role_resource` VALUES (2, 27);
INSERT INTO `sys_role_resource` VALUES (1, 28);
INSERT INTO `sys_role_resource` VALUES (1, 29);
INSERT INTO `sys_role_resource` VALUES (2, 29);
INSERT INTO `sys_role_resource` VALUES (4, 29);
INSERT INTO `sys_role_resource` VALUES (1, 30);
INSERT INTO `sys_role_resource` VALUES (2, 30);
INSERT INTO `sys_role_resource` VALUES (1, 31);
INSERT INTO `sys_role_resource` VALUES (2, 31);
INSERT INTO `sys_role_resource` VALUES (1, 32);
INSERT INTO `sys_role_resource` VALUES (1, 33);
INSERT INTO `sys_role_resource` VALUES (2, 33);
INSERT INTO `sys_role_resource` VALUES (4, 33);
INSERT INTO `sys_role_resource` VALUES (1, 34);
INSERT INTO `sys_role_resource` VALUES (2, 34);
INSERT INTO `sys_role_resource` VALUES (1, 35);
INSERT INTO `sys_role_resource` VALUES (2, 35);
INSERT INTO `sys_role_resource` VALUES (1, 36);
INSERT INTO `sys_role_resource` VALUES (1, 37);
INSERT INTO `sys_role_resource` VALUES (2, 37);
INSERT INTO `sys_role_resource` VALUES (4, 37);
INSERT INTO `sys_role_resource` VALUES (1, 38);
INSERT INTO `sys_role_resource` VALUES (2, 38);
INSERT INTO `sys_role_resource` VALUES (1, 39);
INSERT INTO `sys_role_resource` VALUES (2, 39);
INSERT INTO `sys_role_resource` VALUES (1, 40);
INSERT INTO `sys_role_resource` VALUES (1, 41);
INSERT INTO `sys_role_resource` VALUES (2, 41);
INSERT INTO `sys_role_resource` VALUES (4, 41);
INSERT INTO `sys_role_resource` VALUES (1, 42);
INSERT INTO `sys_role_resource` VALUES (2, 42);
INSERT INTO `sys_role_resource` VALUES (1, 43);
INSERT INTO `sys_role_resource` VALUES (2, 43);
INSERT INTO `sys_role_resource` VALUES (1, 44);
INSERT INTO `sys_role_resource` VALUES (1, 45);
INSERT INTO `sys_role_resource` VALUES (2, 45);
INSERT INTO `sys_role_resource` VALUES (4, 45);
INSERT INTO `sys_role_resource` VALUES (1, 46);
INSERT INTO `sys_role_resource` VALUES (2, 46);
INSERT INTO `sys_role_resource` VALUES (1, 47);
INSERT INTO `sys_role_resource` VALUES (2, 47);
INSERT INTO `sys_role_resource` VALUES (1, 48);
INSERT INTO `sys_role_resource` VALUES (1, 49);
INSERT INTO `sys_role_resource` VALUES (2, 49);
INSERT INTO `sys_role_resource` VALUES (4, 49);
INSERT INTO `sys_role_resource` VALUES (1, 50);
INSERT INTO `sys_role_resource` VALUES (2, 50);
INSERT INTO `sys_role_resource` VALUES (1, 51);
INSERT INTO `sys_role_resource` VALUES (2, 51);
INSERT INTO `sys_role_resource` VALUES (1, 52);
INSERT INTO `sys_role_resource` VALUES (1, 53);
INSERT INTO `sys_role_resource` VALUES (2, 53);
INSERT INTO `sys_role_resource` VALUES (4, 53);
INSERT INTO `sys_role_resource` VALUES (1, 54);
INSERT INTO `sys_role_resource` VALUES (2, 54);
INSERT INTO `sys_role_resource` VALUES (1, 55);
INSERT INTO `sys_role_resource` VALUES (2, 55);
INSERT INTO `sys_role_resource` VALUES (1, 56);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `nickname` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '昵称',
  `username` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '登录用的用户名',
  `password` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '登录用的密码',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建的时间',
  `login_time` datetime(0) NULL DEFAULT NULL COMMENT '最后一次登录的时间',
  `status` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '账号的状态，0是正常，1是锁定',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `sys_user_username_uindex`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户（可以登录后台系统的）' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'mj666', 'mj666', '10ce015cbc7f405b4f9648d1ee68c3ec', '2021-01-15 20:54:16', '2021-01-22 22:20:59', 0);
INSERT INTO `sys_user` VALUES (2, 'mj111333', 'mj111333', 'mj111222', '2021-01-15 20:57:35', NULL, 0);
INSERT INTO `sys_user` VALUES (3, 'mj777', 'xiaoshoujingli', '4a68ee2565e67e908d66992337497b3c', '2021-01-15 21:14:32', '2021-01-28 21:46:48', 0);
INSERT INTO `sys_user` VALUES (5, '123', 'zongjngli', 'd0c91300e4b8ddf0d6083b1b9e5c6b57', '2021-01-18 20:54:01', '2021-01-29 22:15:11', 0);
INSERT INTO `sys_user` VALUES (6, '666', 'kefu', '0444e11e0501438bda1af664f36974de', '2021-01-18 21:21:32', '2021-01-28 22:23:12', 0);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `role_id` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '角色id',
  `user_id` smallint(5) UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户id',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户-角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (2, 1);
INSERT INTO `sys_user_role` VALUES (1, 2);
INSERT INTO `sys_user_role` VALUES (2, 3);
INSERT INTO `sys_user_role` VALUES (1, 5);
INSERT INTO `sys_user_role` VALUES (4, 6);

SET FOREIGN_KEY_CHECKS = 1;
