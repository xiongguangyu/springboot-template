/*
Navicat MariaDB Data Transfer

Source Server         : order
Source Server Version : 100324
Source Host           : localhost:3306
Source Database       : order

Target Server Type    : MariaDB
Target Server Version : 100324
File Encoding         : 65001

Date: 2020-09-29 10:14:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for g_sys_company
-- ----------------------------
DROP TABLE IF EXISTS `g_sys_company`;
CREATE TABLE `g_sys_company` (
  `COMPANY_ID` bigint(5) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(20) DEFAULT '' COMMENT '负责人名称',
  `USER_TEL` varchar(50) DEFAULT '' COMMENT '负责人手机号',
  `COMPANY_NAME` varchar(50) DEFAULT '' COMMENT '单位名称',
  `ADDRESS` varchar(255) DEFAULT '' COMMENT '单位地址',
  `INDUSTRY` varchar(50) DEFAULT '' COMMENT '所属行业',
  `CREATTIME` datetime DEFAULT NULL COMMENT '创建时间',
  `IS_VALID` char(2) DEFAULT '' COMMENT '状态(0不可用，1可用)',
  `IS_DEL` char(2) DEFAULT '' COMMENT '是否删除(0删除，1可用)',
  PRIMARY KEY (`COMPANY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of g_sys_company
-- ----------------------------
INSERT INTO `g_sys_company` VALUES ('29', '石永杰', '11111111111', '单位1', '河南', '软件开发工程师', '2020-09-24 14:14:21', '1', '1');
INSERT INTO `g_sys_company` VALUES ('30', '常文龙', '22222222222', '单位2', '河南', '软件开发工程师', '2020-09-24 14:15:28', '1', '1');
INSERT INTO `g_sys_company` VALUES ('31', '熊光宇', '33333333333', '单位3', '河南', '软件开发工程师', '2020-09-24 14:16:12', '1', '1');
INSERT INTO `g_sys_company` VALUES ('32', '邹宇辉', '44444444444', '单位4', '河南', '软件开发工程师', '2020-09-24 14:38:21', '1', '1');
INSERT INTO `g_sys_company` VALUES ('33', '常希彬', '55555555555', '单位5', '河南', '软件开发工程师', '2020-09-24 14:44:02', '1', '1');
INSERT INTO `g_sys_company` VALUES ('34', '印度阿三', '66666666666', '单位6', '河南', '歌唱家', '2020-09-24 14:46:40', '1', '1');
INSERT INTO `g_sys_company` VALUES ('35', 'admin', 'admin', '超级管理员', '河南', '超级管理员', '2020-09-24 14:46:40', '1', '1');

-- ----------------------------
-- Table structure for g_sys_evaluate
-- ----------------------------
DROP TABLE IF EXISTS `g_sys_evaluate`;
CREATE TABLE `g_sys_evaluate` (
  `EVALUATE_ID` bigint(5) NOT NULL AUTO_INCREMENT COMMENT '评价订单id',
  `ORDER_ID` bigint(5) NOT NULL COMMENT '维修订单id',
  `ATTITUDE` varchar(2) NOT NULL DEFAULT '1' COMMENT '服务态度评分',
  `EFFICIENCY` varchar(2) NOT NULL DEFAULT '1' COMMENT '工作效率评分',
  `METER` varchar(2) NOT NULL DEFAULT '1' COMMENT '仪表整洁评分',
  `EVALUATION` varchar(255) DEFAULT '' COMMENT '评价描述',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '评分时间',
  PRIMARY KEY (`EVALUATE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of g_sys_evaluate
-- ----------------------------
INSERT INTO `g_sys_evaluate` VALUES ('27', '8', '10', '10', '10', '好评哈哈哈', '2020-09-25 11:10:36');

-- ----------------------------
-- Table structure for g_sys_manage
-- ----------------------------
DROP TABLE IF EXISTS `g_sys_manage`;
CREATE TABLE `g_sys_manage` (
  `OBJ_ID` bigint(5) NOT NULL AUTO_INCREMENT,
  `USER_ID` bigint(5) DEFAULT NULL COMMENT '发布人id',
  `TITLE` longtext DEFAULT NULL COMMENT '标题',
  `TYPE` char(2) DEFAULT '' COMMENT '0:轮播图，1:公告,2：新闻',
  `CONTENT` longtext DEFAULT NULL COMMENT '内容',
  `URL` varchar(255) DEFAULT '' COMMENT '图片路径',
  `CREATTIME` datetime DEFAULT NULL COMMENT '创建时间',
  `RELEASETIME` datetime DEFAULT NULL COMMENT '发布时间',
  `READNUM` bigint(10) DEFAULT NULL COMMENT '阅读量',
  `SORT` bigint(5) DEFAULT NULL COMMENT '排序',
  `RELEASE_STATUS` char(4) DEFAULT '' COMMENT '发布状态（01待审核，02已审核，03.待发布，04已发布）',
  `IS_VALID` char(2) DEFAULT '' COMMENT '状态(0失效，1有效)',
  `IS_DEL` char(2) DEFAULT NULL COMMENT '是否删除（0：已删除1：未删除）',
  `EXAMINE_STATUS` char(4) DEFAULT NULL COMMENT '审核（0：通过1：拒绝）',
  `REMARK` varchar(255) DEFAULT NULL COMMENT '发布（0：通过1：拒绝）',
  `SELECT_ID` varchar(10) DEFAULT '' COMMENT '新闻分类（非新闻此字段默认为空）',
  PRIMARY KEY (`OBJ_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of g_sys_manage
-- ----------------------------
INSERT INTO `g_sys_manage` VALUES ('29', '1', '这是轮播图标题1', '0', '<p>测试富文本<img src=\"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2601367228,506583105&fm=26&gp=0.jpg\" style=\"max-width: 100%;\"></p>', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2601367228,506583105&fm=26&gp=0.jpg', '2020-09-22 09:47:41', '2020-09-22 13:59:04', '40', '1', '1', '1', '1', '1', null, '');
INSERT INTO `g_sys_manage` VALUES ('30', '1', '这是轮播图标题2', '0', '这是轮播图2里面的内容哈哈，首先,需要知道input的类型有多少种,即input的type属性可以赋哪些值,...', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2637882791,4145230125&fm=26&gp=0.jpg', '2020-09-22 09:49:18', '2020-09-22 13:59:08', '4', '2', '1', '1', '1', '1', '\n                              ', '');
INSERT INTO `g_sys_manage` VALUES ('31', '1', '这是轮播图标题3', '0', '这是轮播图3里面的内容哈哈，首先,需要知道input的类型有多少种,即input的type属性可以赋哪些值,...', 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2192107533,2288830240&fm=26&gp=0.jpg', '2020-09-22 09:56:30', '2020-09-22 13:59:12', '4', '3', '1', '1', '1', '1', '\n                              ', '');
INSERT INTO `g_sys_manage` VALUES ('32', '1', '标题1', '2', '首先', '', '2020-09-22 10:35:47', null, '2', '11', '0', '1', '0', '0', '\n                              ', '');
INSERT INTO `g_sys_manage` VALUES ('33', '1', '标题2标题2标题2标题2标题2标题2标题2标题2标题2标题2标题2标题2标题2标题2标题2标题2标题2标题2', '2', '首先', '', '2020-09-22 10:36:16', null, '2', '22', '1', '1', '1', '1', '\n                              ', '');
INSERT INTO `g_sys_manage` VALUES ('35', '1', '标题3', '2', '首先,需要知道input的类型有多少种,即input的type属性可以赋哪些值,...首先,需要知道input的类型有多少种,即input的type属性可以赋哪些值,...首先,需要知道input的类型有多少种,即input的type属性可以赋哪些值,...首先,需要知道input的类型有多少种,即input的type属性可以赋哪些值,...', '', '2020-09-22 10:37:08', null, '1', '33', '1', '1', '0', '1', '\n                              ', '');
INSERT INTO `g_sys_manage` VALUES ('36', '1', '标题4', '2', '首先,需要知道input的类型有多少种,即input的type属性可以赋哪些值,...首先,需要知道input的类型有多少种,即input的type属性可以赋哪些值,...首先,需要知道input的类型有多少种,即input的type属性可以赋哪些值,...首先,需要知道input的类型有多少种,即input的type属性可以赋哪些值,...', '', '2020-09-22 10:37:25', null, '1', '44', '1', '1', '1', '1', '\n                              ', '');
INSERT INTO `g_sys_manage` VALUES ('37', '1', '标题6', '2', '首先,需要知道input的类型有多少种,即input的type属性可以赋哪些值,...首先,需要知道input的类型有多少种,即input的type属性可以赋哪些值,...首先,需要知道input的类型有多少种,即input的type属性可以赋哪些值,...首先,需要知道input的类型有多少种,即input的type属性可以赋哪些值,...', '', '2020-09-22 10:41:23', null, '1', '66', '0', '1', '1', '1', '\n                              阿萨德', '');
INSERT INTO `g_sys_manage` VALUES ('40', '1', '这是公告标题1', '1', '这是公告1里面的内容哈哈，首先,需要知道input的类型有多少种,即input的type属性可以赋哪些值,...', '', '2020-09-22 09:56:30', '2020-09-22 10:42:47', '3', '1', '1', '1', '1', '1', '\n                              ', '');
INSERT INTO `g_sys_manage` VALUES ('41', '1', '这是公告标题2', '1', '这是公告2里面的内容哈哈，首先,需要知道input的类型有多少种,即input的type属性可以赋哪些值,...', '', '2020-09-22 09:56:30', '2020-09-22 10:42:47', '3', '2', '1', '1', '1', '1', '\n                              ', '');
INSERT INTO `g_sys_manage` VALUES ('42', '1', '这是公告标题3', '1', '这是公告3里面的内容哈哈，首先,需要知道input的类型有多少种,即input的type属性可以赋哪些值,...', '', '2020-09-22 09:56:30', '2020-09-22 10:42:47', '1', '3', '1', '1', '1', '1', '\n                              ', '');
INSERT INTO `g_sys_manage` VALUES ('43', '1', '这是新闻标题1', '2', '这是新闻1里面的内容哈哈，首先,需要知道input的类型有多少种,即input的type属性可以赋哪些值,...', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2601367228,506583105&fm=26&gp=0.jpg', '2020-09-22 09:56:30', '2020-09-22 10:42:47', '10', '1', '1', '1', '1', '1', '\n                              ', '1');
INSERT INTO `g_sys_manage` VALUES ('44', '1', '这是新闻标题2', '2', '这是新闻2里面的内容哈哈，首先,需要知道input的类型有多少种,即input的type属性可以赋哪些值,...', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2637882791,4145230125&fm=26&gp=0.jpg', '2020-09-22 09:56:30', '2020-09-22 10:42:47', '3', '2', '1', '1', '1', '1', '\n                              ', '1');
INSERT INTO `g_sys_manage` VALUES ('45', '1', '这是新闻标题3', '2', '这是新闻3里面的内容哈哈，首先,需要知道input的类型有多少种,即input的type属性可以赋哪些值,...', 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2192107533,2288830240&fm=26&gp=0.jpg', '2020-09-22 09:56:30', '2020-09-22 10:42:47', '2', '3', '1', '1', '1', '1', '\n                              ', '1');
INSERT INTO `g_sys_manage` VALUES ('46', '1', '这是新闻标题4', '2', '这是新闻4里面的内容哈哈，首先,需要知道input的类型有多少种,即input的type属性可以赋哪些值,...', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2601367228,506583105&fm=26&gp=0.jpg', '2020-09-22 09:56:30', '2020-09-22 10:42:47', '3', '3', '1', '1', '1', '1', '\n                              ', '2');
INSERT INTO `g_sys_manage` VALUES ('47', '1', '', '2', '', '', '2020-09-22 20:34:43', null, '1', null, '0', '0', '0', '1', '\n                              ', '');
INSERT INTO `g_sys_manage` VALUES ('48', '1', '', '2', '', '', '2020-09-22 20:38:30', null, '1', null, '0', '0', '0', '0', null, '');
INSERT INTO `g_sys_manage` VALUES ('49', '1', '', '2', '', '', '2020-09-22 20:39:23', null, '1', null, '0', '0', '0', '0', null, '');
INSERT INTO `g_sys_manage` VALUES ('50', '1', '这是新闻标题5', '2', '这是新闻5里面的内容哈哈，首先,需要知道input的类型有多少种,即input的type属性可以赋哪些值,...', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2601367228,506583105&fm=26&gp=0.jpg', '2020-09-22 09:56:30', '2020-09-22 10:42:47', '3', '3', '1', '1', '1', '1', '\n                              ', '2');
INSERT INTO `g_sys_manage` VALUES ('51', '1', '这是新闻标题6', '2', '这是新闻6里面的内容哈哈，首先,需要知道input的类型有多少种,即input的type属性可以赋哪些值,...', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2601367228,506583105&fm=26&gp=0.jpg', '2020-09-22 09:56:30', '2020-09-22 10:42:47', '3', '3', '1', '1', '1', '1', '\n                              ', '2');
INSERT INTO `g_sys_manage` VALUES ('52', '1', '这是新闻标题7', '2', '这是新闻7里面的内容哈哈，首先,需要知道input的类型有多少种,即input的type属性可以赋哪些值,...', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2601367228,506583105&fm=26&gp=0.jpg', '2020-09-22 09:56:30', '2020-09-22 10:42:47', '3', '3', '1', '1', '1', '1', '\n                              ', '3');
INSERT INTO `g_sys_manage` VALUES ('53', '1', '这是新闻标题8', '2', '这是新闻8里面的内容哈哈，首先,需要知道input的类型有多少种,即input的type属性可以赋哪些值,...', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2601367228,506583105&fm=26&gp=0.jpg', '2020-09-22 09:56:30', '2020-09-22 10:42:47', '3', '3', '1', '1', '1', '1', '\n                              ', '3');
INSERT INTO `g_sys_manage` VALUES ('54', '1', '这是新闻标题9', '2', '这是新闻9里面的内容哈哈，首先,需要知道input的类型有多少种,即input的type属性可以赋哪些值,...', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2601367228,506583105&fm=26&gp=0.jpg', '2020-09-22 09:56:30', '2020-09-22 10:42:47', '3', '3', '1', '1', '1', '1', '\n                              ', '3');
INSERT INTO `g_sys_manage` VALUES ('55', '1', '这是后台轮播图', '0', '这是新闻9里面的内容哈哈，首先,需要知道input的类型有多少种,即input的type属性可以赋哪些值,...这是新闻9里面的内容哈哈，首先,需要知道input的类型有多少种,即input的type属性可以赋哪些值,...', '', '2020-09-22 09:56:30', null, '1', '22', '0', '1', '1', '1', ' ', '');
INSERT INTO `g_sys_manage` VALUES ('56', '1', '标题标题标题标题标题标题标题标题', '2', '', '', '2020-09-23 19:14:57', null, '1', '99', '0', '1', '1', '0', null, '');
INSERT INTO `g_sys_manage` VALUES ('57', '1', '第二次测试富文本', '2', '<p>第二次测试富文本<img src=\"http://localhost:8081/2020-09-23/1600860348790_810.jpg\" style=\"max-width: 100%;\"></p>', '', '2020-09-23 19:25:51', '2020-09-23 19:27:32', '1', '100', '1', '1', '1', '1', '\n                              ', '');
INSERT INTO `g_sys_manage` VALUES ('58', '1', '阿达', '2', '<p>阿萨德</p>', '', '2020-09-23 19:48:25', null, '1', '22', '0', '1', '1', '0', null, '');
INSERT INTO `g_sys_manage` VALUES ('59', '1', '阿萨德', '2', '<p>阿萨德</p>', '', '2020-09-24 15:26:37', null, '1', '44', '0', '1', '1', '0', null, '');
INSERT INTO `g_sys_manage` VALUES ('60', '1', '阿萨德', '1', '<p>阿萨德</p>', '', '2020-09-24 15:27:05', null, '1', '33', '0', '1', '1', '1', '\n                              ', '');
INSERT INTO `g_sys_manage` VALUES ('61', '1', '阿萨德', '1', '<p>阿萨德</p>', '', '2020-09-24 15:27:23', null, '1', '44', '0', '1', '1', '1', '\n                              ', '');
INSERT INTO `g_sys_manage` VALUES ('62', '1', '阿萨德', '2', '<p>阿萨德</p>', '', '2020-09-27 14:43:04', null, '1', '11', '0', '1', '0', '0', null, '');
INSERT INTO `g_sys_manage` VALUES ('63', '1', 'asdasdasd', '2', '<p><br></p>', '', '2020-09-27 15:08:02', null, '1', null, '0', '1', '1', '0', null, '');
INSERT INTO `g_sys_manage` VALUES ('64', '1', '阿萨德', '2', '<p>阿萨德</p>', '', '2020-09-27 15:24:12', null, '1', '22', '0', '1', '1', '0', null, '');
INSERT INTO `g_sys_manage` VALUES ('65', '1', 'sa ', '2', '<p>asd&nbsp;</p>', '', '2020-09-28 14:06:11', null, '1', '66', '0', '1', '1', '0', null, '');
INSERT INTO `g_sys_manage` VALUES ('66', '1', 'asd 阿斯顿', '2', '<p><br></p>', 'https://dss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1906469856,4113625838&fm=26&gp=0.jpg', '2020-09-28 14:08:42', null, '1', '77', '0', '1', '1', '0', null, '');
INSERT INTO `g_sys_manage` VALUES ('67', '1', '阿斯顿', '2', '<p>阿斯顿</p>', '[object Object]', '2020-09-28 14:46:10', null, '1', '55', '0', '1', '1', '0', null, '');
INSERT INTO `g_sys_manage` VALUES ('68', '1', '阿斯顿', '2', '<p>阿斯顿</p>', 'http://localhost:8081/2020-09-28/1601275626967_171.jpeg', '2020-09-28 14:47:09', null, '1', '22', '0', '1', '1', '0', null, '');

-- ----------------------------
-- Table structure for g_sys_manager
-- ----------------------------
DROP TABLE IF EXISTS `g_sys_manager`;
CREATE TABLE `g_sys_manager` (
  `MANAGER_ID` bigint(5) NOT NULL AUTO_INCREMENT,
  `MANAGER_NAME` varchar(16) DEFAULT '' COMMENT '客户经理姓名',
  `GENDER` varchar(2) DEFAULT '' COMMENT '性别',
  `PHONE` varchar(16) DEFAULT '' COMMENT '手机号',
  `PASSWORD` varchar(64) DEFAULT NULL COMMENT '小程序登录密码',
  `COMPANY_ID` varchar(50) DEFAULT '' COMMENT '所属单位id',
  `IS_DEL` varchar(2) DEFAULT '' COMMENT '逻辑删除字段',
  `IS_VALID` varchar(2) DEFAULT NULL COMMENT '是否可用',
  PRIMARY KEY (`MANAGER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of g_sys_manager
-- ----------------------------
INSERT INTO `g_sys_manager` VALUES ('1', '常文龙423', '1', '12345678910', 'e10adc3949ba59abbe56e057f20f883e', '29', '1', null);
INSERT INTO `g_sys_manager` VALUES ('2', 'sss', '1', '12345678910', 'e10adc3949ba59abbe56e057f20f883e', '29', '0', null);
INSERT INTO `g_sys_manager` VALUES ('15', 'yongjie Shi2', '1', '18838278373', 'e10adc3949ba59abbe56e057f20f883e', '29', '1', null);
INSERT INTO `g_sys_manager` VALUES ('16', 'yongjie Shi1', '1', '12378945674', 'e10adc3949ba59abbe56e057f20f883e', '29', '1', null);
INSERT INTO `g_sys_manager` VALUES ('17', '测试人员', '1', '15555555555', 'e10adc3949ba59abbe56e057f20f883e', '28', '1', '1');
INSERT INTO `g_sys_manager` VALUES ('19', '测试客户经理1', '1', '12222222222', '6ebe76c9fb411be97b3b0d48b791a7c9', '29', '1', null);

-- ----------------------------
-- Table structure for g_sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `g_sys_menu`;
CREATE TABLE `g_sys_menu` (
  `MENU_ID` bigint(5) NOT NULL COMMENT '菜单id',
  `MENU_NAME` varchar(12) NOT NULL DEFAULT '' COMMENT '菜单名称',
  `REMARK` varchar(24) NOT NULL COMMENT '英文描述',
  `PARENT_ID` int(2) NOT NULL COMMENT '所属父级菜单',
  `IS_VALID` char(1) NOT NULL DEFAULT '1' COMMENT '菜单是否可用',
  `SORT` bigint(5) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of g_sys_menu
-- ----------------------------
INSERT INTO `g_sys_menu` VALUES ('1', '内容管理', 'content', '0', '1', '2');
INSERT INTO `g_sys_menu` VALUES ('2', '新增内容', 'addnews', '1', '1', '2');
INSERT INTO `g_sys_menu` VALUES ('3', '审核内容', 'reviewbulletin', '1', '1', '3');
INSERT INTO `g_sys_menu` VALUES ('4', '单位管理', 'unit', '0', '1', '4');
INSERT INTO `g_sys_menu` VALUES ('5', '单位管理', 'unitmanage', '4', '1', '5');
INSERT INTO `g_sys_menu` VALUES ('6', '客户经理管理', 'clientmanage', '4', '1', '6');
INSERT INTO `g_sys_menu` VALUES ('7', '业主管理', 'ownermanage', '4', '1', '7');
INSERT INTO `g_sys_menu` VALUES ('8', '维修工人管理', 'worker', '0', '1', '8');
INSERT INTO `g_sys_menu` VALUES ('9', '一级维修工人管理', 'firstlevelwoker', '8', '1', '9');
INSERT INTO `g_sys_menu` VALUES ('10', '二级维修工人管理', 'secondlevelwoker', '8', '1', '10');
INSERT INTO `g_sys_menu` VALUES ('11', '三级维修工人管理', 'thirdlevelwoker', '8', '1', '11');
INSERT INTO `g_sys_menu` VALUES ('12', '工单管理', 'order', '0', '1', '12');
INSERT INTO `g_sys_menu` VALUES ('13', '工单管理', 'ordermanager', '12', '1', '13');
INSERT INTO `g_sys_menu` VALUES ('14', '统计报表', 'statistics', '12', '1', '14');
INSERT INTO `g_sys_menu` VALUES ('15', '系统管理', 'system', '0', '1', '15');
INSERT INTO `g_sys_menu` VALUES ('16', '系统设置', 'systemsite', '15', '1', '16');
INSERT INTO `g_sys_menu` VALUES ('17', '权限设置', 'authority', '15', '1', '17');
INSERT INTO `g_sys_menu` VALUES ('18', '公告管理', 'announcement', '0', '1', '18');
INSERT INTO `g_sys_menu` VALUES ('19', '新增公告', 'addannouncement', '18', '1', '19');
INSERT INTO `g_sys_menu` VALUES ('20', '审核公告', 'reviewannouncement', '18', '1', '20');
INSERT INTO `g_sys_menu` VALUES ('21', '审核轮播图', 'reviewrotationchart', '18', '1', '20');

-- ----------------------------
-- Table structure for g_sys_order
-- ----------------------------
DROP TABLE IF EXISTS `g_sys_order`;
CREATE TABLE `g_sys_order` (
  `ORDER_ID` bigint(5) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `OPEN_ID` varchar(50) DEFAULT '' COMMENT 'OPENID',
  `CONSUMER_ID` bigint(5) DEFAULT NULL COMMENT '维修工id',
  `FAULT_TYPE` varchar(50) DEFAULT '' COMMENT '故障类型id',
  `PROBLEM` varchar(255) DEFAULT '' COMMENT '遇到的问题',
  `FEEDBACKSRC` varchar(1000) DEFAULT '' COMMENT '反馈图片',
  `TELEPHONE` varchar(50) DEFAULT '' COMMENT '联系电话',
  `COMPANY_ID` bigint(5) DEFAULT NULL COMMENT '业主单位ID',
  `ADDRESS` varchar(50) DEFAULT '' COMMENT '联系地址',
  `CONTACT_ADDR` varchar(255) DEFAULT '' COMMENT '详细地址',
  `ORDER_STATUS` char(2) NOT NULL DEFAULT '' COMMENT '订单状态(01:已确认  02:待维修  03:已维修  04:已完成)',
  `CREATE_TIME` datetime NOT NULL COMMENT '上报时间',
  `SEND_SMS` char(2) DEFAULT NULL COMMENT '是否成功发送短信（0否，1是）',
  `TRANSFER_DESC` varchar(255) DEFAULT NULL COMMENT '订单转派描述',
  PRIMARY KEY (`ORDER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of g_sys_order
-- ----------------------------
INSERT INTO `g_sys_order` VALUES ('1', 'oHNWb5Z32g-rEn3NoyGBH6N5S75I', '1', '4', '突然就停电了，怎么办呀怎么办', '[\"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2637882791,4145230125&fm=26&gp=0.jpg\",\"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2637882791,4145230125&fm=26&gp=0.jpg\"]', '15555556666', '1', '顺河回族区', '回族区0101', '01', '2020-09-24 09:44:31', null, null);
INSERT INTO `g_sys_order` VALUES ('2', 'oHNWb5Z32g-rEn3NoyGBH6N5S75I', '1', '4', '网线断了，怎么办呀怎么办', '[\"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2637882791,4145230125&fm=26&gp=0.jpg\",\"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2637882791,4145230125&fm=26&gp=0.jpg\"]', '15565657878', '1', '禹王台区', '道王府服001', '02', '2020-09-24 09:44:34', null, null);
INSERT INTO `g_sys_order` VALUES ('3', 'oHNWb5Z32g-rEn3NoyGBH6N5S75I', '1', '5', '不知道为什么  突然就没有网了 怎么办呀怎么办', '[\"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2637882791,4145230125&fm=26&gp=0.jpg\",\"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2637882791,4145230125&fm=26&gp=0.jpg\"]', '15656788765', '8', '祥符区', '分时那001', '01', '2020-09-24 09:44:39', null, null);
INSERT INTO `g_sys_order` VALUES ('4', 'oHNWb5Z32g-rEn3NoyGBH6N5S75I', '8', '6', '停电了呀停电了 啊哈哈哈', '[\"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2637882791,4145230125&fm=26&gp=0.jpg\",\"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2637882791,4145230125&fm=26&gp=0.jpg\"]', '18787876767', '8', '鼓楼区', '东风股份001', '03', '2020-09-24 09:44:43', null, null);
INSERT INTO `g_sys_order` VALUES ('5', 'oHNWb5Z32g-rEn3NoyGBH6N5S75I', '8', '7', '法无法无法法忘2123', '[\"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2637882791,4145230125&fm=26&gp=0.jpg\",\"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2637882791,4145230125&fm=26&gp=0.jpg\"]', '15656567878', '8', '顺河回族区', '分的粉色发我', '02', '2020-09-24 09:44:46', null, null);
INSERT INTO `g_sys_order` VALUES ('6', 'oHNWb5Z32g-rEn3NoyGBH6N5S75I', '8', '5', '停电了怎么办呀怎么办', '[\"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2637882791,4145230125&fm=26&gp=0.jpg\",\"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2637882791,4145230125&fm=26&gp=0.jpg\"]', '15565566565', '8', '顺河回族区', '给你送蛋糕0101', '02', '2020-09-25 10:46:39', null, null);
INSERT INTO `g_sys_order` VALUES ('7', 'oHNWb5Z32g-rEn3NoyGBH6N5S75I', '8', '5', '不知道遇到了什么问题', '[\"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2637882791,4145230125&fm=26&gp=0.jpg\",\"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2637882791,4145230125&fm=26&gp=0.jpg\"]', '15567677676', '8', '顺河回族区', '分手吧故事01', '02', '2020-09-25 10:51:33', null, null);
INSERT INTO `g_sys_order` VALUES ('8', 'oHNWb5Z32g-rEn3NoyGBH6N5S75I', '8', '5', '不知道什么问题啊哈哈哈', '[\"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2637882791,4145230125&fm=26&gp=0.jpg\",\"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2637882791,4145230125&fm=26&gp=0.jpg\",\"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2637882791,4145230125&fm=26&gp=0.jpg\",\"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2601367228,506583105&fm=26&gp=0.jpg\"]', '15656567676', '8', '顺河回族区', '发过001', '04', '2020-09-25 11:07:01', null, null);
INSERT INTO `g_sys_order` VALUES ('9', 'oHNWb5Z32g-rEn3NoyGBH6N5S75I', '8', '6', '网线出问题了哈哈哈哈', '[\"http://localhost:8081/2020-09-25/1601029804908_378.jpg\",\"http://localhost:8081/2020-09-25/1601029804908_378.jpg\"]', '15555556666', '8', '顺河回族区', '带娃法儿u', '03', '2020-09-25 18:30:21', null, '');

-- ----------------------------
-- Table structure for g_sys_order_progress
-- ----------------------------
DROP TABLE IF EXISTS `g_sys_order_progress`;
CREATE TABLE `g_sys_order_progress` (
  `PROGRESS_ID` bigint(5) NOT NULL AUTO_INCREMENT,
  `ORDER_ID` bigint(5) DEFAULT NULL COMMENT '订单ID',
  `CREAT_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `STATUS` char(2) DEFAULT NULL COMMENT '订单进度状态',
  PRIMARY KEY (`PROGRESS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of g_sys_order_progress
-- ----------------------------
INSERT INTO `g_sys_order_progress` VALUES ('3', '8', '2020-09-21 11:07:01', '01');
INSERT INTO `g_sys_order_progress` VALUES ('4', '8', '2020-09-25 11:10:36', '04');
INSERT INTO `g_sys_order_progress` VALUES ('5', '8', '2020-09-22 11:11:52', '02');
INSERT INTO `g_sys_order_progress` VALUES ('6', '8', '2020-09-23 11:12:06', '03');
INSERT INTO `g_sys_order_progress` VALUES ('7', '8', '2020-09-24 14:25:18', '02');
INSERT INTO `g_sys_order_progress` VALUES ('8', '9', '2020-09-25 18:30:21', '01');
INSERT INTO `g_sys_order_progress` VALUES ('10', '9', '2020-09-29 10:05:20', '03');

-- ----------------------------
-- Table structure for g_sys_owner
-- ----------------------------
DROP TABLE IF EXISTS `g_sys_owner`;
CREATE TABLE `g_sys_owner` (
  `OWNER_ID` bigint(5) NOT NULL AUTO_INCREMENT,
  `OWNER_NAME` varchar(16) DEFAULT '' COMMENT '业主名称',
  `PHONE` varchar(16) DEFAULT '' COMMENT '联系方式',
  `ADDRESS` varchar(50) DEFAULT '' COMMENT '所在地址',
  `MANAGER_ID` varchar(50) DEFAULT '' COMMENT '所属客户经理id',
  `IS_DEL` varchar(2) DEFAULT '',
  PRIMARY KEY (`OWNER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of g_sys_owner
-- ----------------------------
INSERT INTO `g_sys_owner` VALUES ('1', '测试业主2', '123456781', '河南省郑州市某某某街1', '1', '1');
INSERT INTO `g_sys_owner` VALUES ('2', '测试业主3', '18838432134', '金士达产业园区', '2', '1');
INSERT INTO `g_sys_owner` VALUES ('7', '测试业主4', '18838278373', '金士达产业园区', '1', '1');
INSERT INTO `g_sys_owner` VALUES ('8', '测试业主1', '15555556666', '金士达产业园区', '17', '1');

-- ----------------------------
-- Table structure for g_sys_para
-- ----------------------------
DROP TABLE IF EXISTS `g_sys_para`;
CREATE TABLE `g_sys_para` (
  `PARA_ID` bigint(20) NOT NULL COMMENT '主键id',
  `KEYSS` varchar(20) DEFAULT '',
  `VALUE` varchar(20) DEFAULT '',
  `REMARK` varchar(20) DEFAULT '' COMMENT '备注',
  `ISVALID` char(1) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL COMMENT '超级管理员id',
  PRIMARY KEY (`PARA_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of g_sys_para
-- ----------------------------
INSERT INTO `g_sys_para` VALUES ('1', 'aaa', '1', '下单自动短信发送开关', '0', '1');
INSERT INTO `g_sys_para` VALUES ('2', 'bbb', '0', '结束工单自动发短信开关', '0', '1');
INSERT INTO `g_sys_para` VALUES ('3', 'ccc', '短信', '下单短信内容', '0', '1');
INSERT INTO `g_sys_para` VALUES ('4', 'ddd', '短信内容', '结束工单短信内容', '0', '1');

-- ----------------------------
-- Table structure for g_sys_select
-- ----------------------------
DROP TABLE IF EXISTS `g_sys_select`;
CREATE TABLE `g_sys_select` (
  `SELECT_ID` bigint(5) NOT NULL AUTO_INCREMENT,
  `SELECT_CODE` varchar(20) DEFAULT NULL,
  `SELECT_VALUE` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`SELECT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of g_sys_select
-- ----------------------------
INSERT INTO `g_sys_select` VALUES ('1', 'news', '新闻专区');
INSERT INTO `g_sys_select` VALUES ('2', 'news', '精选专区');
INSERT INTO `g_sys_select` VALUES ('3', 'news', '订阅专区');
INSERT INTO `g_sys_select` VALUES ('4', 'failType', '路由器坏了');
INSERT INTO `g_sys_select` VALUES ('5', 'failType', '停电了');
INSERT INTO `g_sys_select` VALUES ('6', 'failType', '网线问题');
INSERT INTO `g_sys_select` VALUES ('7', 'failType', '断网');

-- ----------------------------
-- Table structure for g_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `g_sys_user`;
CREATE TABLE `g_sys_user` (
  `USER_ID` bigint(5) NOT NULL AUTO_INCREMENT COMMENT '用户标识',
  `LOGIN_NAME` varchar(16) NOT NULL DEFAULT '' COMMENT '登陆名',
  `PASSWORD` varchar(64) NOT NULL DEFAULT '' COMMENT '登陆密码',
  `STATUS` char(1) NOT NULL DEFAULT '1' COMMENT '用户状态',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `PWD_UPT_TIME` datetime DEFAULT NULL COMMENT '密码修改时间',
  `LAST_LOGIN_TIME` datetime DEFAULT NULL COMMENT '最近登陆时间',
  `USER_NAME` varchar(64) NOT NULL COMMENT '用户名',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of g_sys_user
-- ----------------------------
INSERT INTO `g_sys_user` VALUES ('1', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '1', '2020-08-26 16:49:28', null, '2020-09-22 14:24:25', '超级管理员');
INSERT INTO `g_sys_user` VALUES ('5', '15333976597', 'e10adc3949ba59abbe56e057f20f883e', '1', '2020-08-26 05:32:00', null, '2020-08-31 11:47:50', '单位管理员');
INSERT INTO `g_sys_user` VALUES ('14', '11111111111', 'e10adc3949ba59abbe56e057f20f883e', '1', '2020-09-24 14:14:23', null, null, '石永杰');
INSERT INTO `g_sys_user` VALUES ('15', '22222222222', 'e10adc3949ba59abbe56e057f20f883e', '1', '2020-09-24 14:15:29', null, null, '常文龙');
INSERT INTO `g_sys_user` VALUES ('16', '33333333333', 'e10adc3949ba59abbe56e057f20f883e', '1', '2020-09-24 14:16:14', null, null, '熊光宇');
INSERT INTO `g_sys_user` VALUES ('17', '44444444444', 'e10adc3949ba59abbe56e057f20f883e', '1', '2020-09-24 14:38:23', null, null, '邹宇辉');
INSERT INTO `g_sys_user` VALUES ('18', '55555555555', 'e10adc3949ba59abbe56e057f20f883e', '1', '2020-09-24 14:44:04', null, null, '常希彬');
INSERT INTO `g_sys_user` VALUES ('19', '66666666666', 'e10adc3949ba59abbe56e057f20f883e', '1', '2020-09-24 14:46:43', null, null, '印度阿三');

-- ----------------------------
-- Table structure for g_sys_user_menu
-- ----------------------------
DROP TABLE IF EXISTS `g_sys_user_menu`;
CREATE TABLE `g_sys_user_menu` (
  `USER_ID` bigint(5) NOT NULL COMMENT '用户ID',
  `MENU_ID` bigint(5) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`USER_ID`,`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of g_sys_user_menu
-- ----------------------------
INSERT INTO `g_sys_user_menu` VALUES ('1', '1');
INSERT INTO `g_sys_user_menu` VALUES ('1', '2');
INSERT INTO `g_sys_user_menu` VALUES ('1', '3');
INSERT INTO `g_sys_user_menu` VALUES ('1', '4');
INSERT INTO `g_sys_user_menu` VALUES ('1', '5');
INSERT INTO `g_sys_user_menu` VALUES ('1', '6');
INSERT INTO `g_sys_user_menu` VALUES ('1', '7');
INSERT INTO `g_sys_user_menu` VALUES ('1', '8');
INSERT INTO `g_sys_user_menu` VALUES ('1', '9');
INSERT INTO `g_sys_user_menu` VALUES ('1', '10');
INSERT INTO `g_sys_user_menu` VALUES ('1', '11');
INSERT INTO `g_sys_user_menu` VALUES ('1', '12');
INSERT INTO `g_sys_user_menu` VALUES ('1', '13');
INSERT INTO `g_sys_user_menu` VALUES ('1', '14');
INSERT INTO `g_sys_user_menu` VALUES ('1', '15');
INSERT INTO `g_sys_user_menu` VALUES ('1', '16');
INSERT INTO `g_sys_user_menu` VALUES ('1', '17');
INSERT INTO `g_sys_user_menu` VALUES ('1', '18');
INSERT INTO `g_sys_user_menu` VALUES ('1', '19');
INSERT INTO `g_sys_user_menu` VALUES ('1', '20');
INSERT INTO `g_sys_user_menu` VALUES ('5', '1');
INSERT INTO `g_sys_user_menu` VALUES ('5', '2');
INSERT INTO `g_sys_user_menu` VALUES ('5', '3');
INSERT INTO `g_sys_user_menu` VALUES ('5', '4');
INSERT INTO `g_sys_user_menu` VALUES ('5', '5');
INSERT INTO `g_sys_user_menu` VALUES ('5', '6');
INSERT INTO `g_sys_user_menu` VALUES ('5', '7');
INSERT INTO `g_sys_user_menu` VALUES ('14', '4');
INSERT INTO `g_sys_user_menu` VALUES ('14', '6');
INSERT INTO `g_sys_user_menu` VALUES ('14', '8');
INSERT INTO `g_sys_user_menu` VALUES ('14', '9');
INSERT INTO `g_sys_user_menu` VALUES ('14', '10');
INSERT INTO `g_sys_user_menu` VALUES ('14', '11');
INSERT INTO `g_sys_user_menu` VALUES ('14', '12');
INSERT INTO `g_sys_user_menu` VALUES ('14', '13');
INSERT INTO `g_sys_user_menu` VALUES ('15', '4');
INSERT INTO `g_sys_user_menu` VALUES ('15', '6');
INSERT INTO `g_sys_user_menu` VALUES ('15', '8');
INSERT INTO `g_sys_user_menu` VALUES ('15', '9');
INSERT INTO `g_sys_user_menu` VALUES ('15', '10');
INSERT INTO `g_sys_user_menu` VALUES ('15', '11');
INSERT INTO `g_sys_user_menu` VALUES ('15', '12');
INSERT INTO `g_sys_user_menu` VALUES ('15', '13');
INSERT INTO `g_sys_user_menu` VALUES ('16', '4');
INSERT INTO `g_sys_user_menu` VALUES ('16', '6');
INSERT INTO `g_sys_user_menu` VALUES ('16', '8');
INSERT INTO `g_sys_user_menu` VALUES ('16', '9');
INSERT INTO `g_sys_user_menu` VALUES ('16', '10');
INSERT INTO `g_sys_user_menu` VALUES ('16', '11');
INSERT INTO `g_sys_user_menu` VALUES ('16', '12');
INSERT INTO `g_sys_user_menu` VALUES ('16', '13');
INSERT INTO `g_sys_user_menu` VALUES ('17', '4');
INSERT INTO `g_sys_user_menu` VALUES ('17', '6');
INSERT INTO `g_sys_user_menu` VALUES ('17', '8');
INSERT INTO `g_sys_user_menu` VALUES ('17', '9');
INSERT INTO `g_sys_user_menu` VALUES ('17', '10');
INSERT INTO `g_sys_user_menu` VALUES ('17', '11');
INSERT INTO `g_sys_user_menu` VALUES ('17', '12');
INSERT INTO `g_sys_user_menu` VALUES ('17', '13');
INSERT INTO `g_sys_user_menu` VALUES ('18', '4');
INSERT INTO `g_sys_user_menu` VALUES ('18', '6');
INSERT INTO `g_sys_user_menu` VALUES ('18', '8');
INSERT INTO `g_sys_user_menu` VALUES ('18', '9');
INSERT INTO `g_sys_user_menu` VALUES ('18', '10');
INSERT INTO `g_sys_user_menu` VALUES ('18', '11');
INSERT INTO `g_sys_user_menu` VALUES ('18', '12');
INSERT INTO `g_sys_user_menu` VALUES ('18', '13');
INSERT INTO `g_sys_user_menu` VALUES ('19', '4');
INSERT INTO `g_sys_user_menu` VALUES ('19', '6');
INSERT INTO `g_sys_user_menu` VALUES ('19', '8');
INSERT INTO `g_sys_user_menu` VALUES ('19', '9');
INSERT INTO `g_sys_user_menu` VALUES ('19', '10');
INSERT INTO `g_sys_user_menu` VALUES ('19', '11');
INSERT INTO `g_sys_user_menu` VALUES ('19', '12');
INSERT INTO `g_sys_user_menu` VALUES ('19', '13');

-- ----------------------------
-- Table structure for g_sys_worker
-- ----------------------------
DROP TABLE IF EXISTS `g_sys_worker`;
CREATE TABLE `g_sys_worker` (
  `WORKER_ID` bigint(5) NOT NULL AUTO_INCREMENT,
  `WORKER_NAME` varchar(16) DEFAULT '' COMMENT '维修工姓名',
  `GENDER` varchar(2) DEFAULT '' COMMENT '性别',
  `PHONE` varchar(16) DEFAULT '' COMMENT '手机号',
  `PASSWORD` varchar(64) DEFAULT '' COMMENT '密码',
  `IS_VALID` varchar(2) DEFAULT '' COMMENT '状态1是可用0是不可用',
  `GRADE` varchar(2) DEFAULT '' COMMENT '等级0是一级维修工1是二级维修工2是三级维修工',
  `IS_DEL` varchar(2) DEFAULT '',
  PRIMARY KEY (`WORKER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of g_sys_worker
-- ----------------------------
INSERT INTO `g_sys_worker` VALUES ('1', '常文龙123', '1', '1104321321', '15478784515', '1', '1', '1');
INSERT INTO `g_sys_worker` VALUES ('8', '测试一级维修工', '1', '15555555555', '6ebe76c9fb411be97b3b0d48b791a7c9', '1', '0', '0');
INSERT INTO `g_sys_worker` VALUES ('9', '测试二级维修工', '1', '15655555555', 'e10adc3949ba59abbe56e057f20f883e', '1', '1', '1');
INSERT INTO `g_sys_worker` VALUES ('10', '测试三级维修工', '1', '15755555555', 'e10adc3949ba59abbe56e057f20f883e', '1', '2', '1');
INSERT INTO `g_sys_worker` VALUES ('11', '测试一级维修工2', '0', '18838278373', '6c44e5cd17f0019c64b042e4a745412a', '1', '0', '1');
