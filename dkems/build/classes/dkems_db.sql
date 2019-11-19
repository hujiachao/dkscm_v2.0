/*******************************************************/
/********** DK教务管理系统数据库初始化脚本 V1.0          *********/
/********** DK Educational Manager System v1.0 *********/
/*******************************************************/
-- 创建使用数据库：dkems_db
DROP DATABASE IF EXISTS dkems_db;
CREATE DATABASE dkems_db CHARACTER SET 'utf8mb4';
USE dkems_db;

-- 角色信息表：sys_role
DROP TABLE IF EXISTS sys_role;
CREATE TABLE sys_role(
	role_id INT(10) NOT NULL AUTO_INCREMENT COMMENT '角色主键',
	role_name VARCHAR(255) NOT NULL COMMENT '角色名称',
	role_code VARCHAR(255) COMMENT '角色编码',
	sort_order INT(10) COMMENT '排序',
	create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
	PRIMARY KEY(role_id)
)ENGINE=INNODB CHARSET='utf8mb4' COMMENT='角色信息表';
INSERT INTO sys_role(role_name, role_code, sort_order) VALUES('教员', 'teacher', 1);
INSERT INTO sys_role(role_name, role_code, sort_order) VALUES('学生', 'student', 2);

-- 班级信息表：sys_stu_class
DROP TABLE IF EXISTS sys_stu_class;
CREATE TABLE sys_stu_class(
	stu_class_id INT(10) NOT NULL AUTO_INCREMENT COMMENT '班级主键',
	stu_class_no VARCHAR(255) NOT NULL COMMENT '班级编号',
	sort_order INT(10) COMMENT '排序',
	create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
	PRIMARY KEY(stu_class_id)
)ENGINE=INNODB CHARSET='utf8mb4' COMMENT='班级信息表';
INSERT INTO sys_stu_class(stu_class_no, sort_order) VALUES('DK0J190101Q', 1);
INSERT INTO sys_stu_class(stu_class_no, sort_order) VALUES('DK0J190201Q', 2);
INSERT INTO sys_stu_class(stu_class_no, sort_order) VALUES('DK0J190301Q', 3);
INSERT INTO sys_stu_class(stu_class_no, sort_order) VALUES('DK0J190401Q', 4);
INSERT INTO sys_stu_class(stu_class_no, sort_order) VALUES('DK0J190501Q', 5);
INSERT INTO sys_stu_class(stu_class_no, sort_order) VALUES('DK0J190601Q', 6);
INSERT INTO sys_stu_class(stu_class_no, sort_order) VALUES('DK0J190701Q', 7);
INSERT INTO sys_stu_class(stu_class_no, sort_order) VALUES('DK0J190801Q', 8);
INSERT INTO sys_stu_class(stu_class_no, sort_order) VALUES('DK0J190901Q', 9);

-- 用户信息表：sys_user
DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user(
	user_id INT(10) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
	username VARCHAR(255) NOT NULL COMMENT '用户姓名',
	cellphone VARCHAR(100) NOT NULL COMMENT '手机号码',
	PASSWORD VARCHAR(500) NOT NULL COMMENT '登录密码',
	role_id INT(10) NOT NULL COMMENT '用户角色',
	stu_class_id INT(10) COMMENT '所在班级',
	email VARCHAR(500) COMMENT '电子邮件',
	id_card VARCHAR(100) COMMENT '身份证号码',
	photo VARCHAR(500) COMMENT '头像',
	STATUS VARCHAR(10) NOT NULL DEFAULT 'Y' COMMENT '状态：正常-启用，离线-禁用',
	sort_order INT(10) COMMENT '排序',
	create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
	PRIMARY KEY(user_id)
)ENGINE=INNODB CHARSET='utf8mb4' COMMENT='人员信息表';
INSERT INTO sys_user(username, cellphone, PASSWORD, role_id, stu_class_id) VALUES('王老师', '17629039600', '21232f297a57a5a743894a0e4a801fc3', 1, 7);
INSERT INTO sys_user(username, cellphone, PASSWORD, role_id, stu_class_id) VALUES('成博', '15771712836', '1f5f72f9d38b9cff1e5a663782ad26ac', 2, 7);
INSERT INTO sys_user(username, cellphone, PASSWORD, role_id, stu_class_id) VALUES('崔涛', '12345678901', 'a5c7c87378c0ff7089ebd528640eb3a7', 2, 7);
INSERT INTO sys_user(username, cellphone, PASSWORD, role_id, stu_class_id) VALUES('杜治磊', '18309297750', '8b4cff833678ae05ef275e145f1bf7af', 2, 7);
INSERT INTO sys_user(username, cellphone, PASSWORD, role_id, stu_class_id) VALUES('韩育', '18792647022', '0f64e80696b572976c80d4ab811e4819', 2, 7);
INSERT INTO sys_user(username, cellphone, PASSWORD, role_id, stu_class_id) VALUES('胡嘉超', '15891449276', '287daeaf04c1efe4322d61ac28dcd40c', 2, 7);
INSERT INTO sys_user(username, cellphone, PASSWORD, role_id, stu_class_id) VALUES('康虎', '13572314348', 'b8b61970d8772a59001f133fe2322f63', 2, 7);
INSERT INTO sys_user(username, cellphone, PASSWORD, role_id, stu_class_id) VALUES('李林善', '15129239895', '7a9bcdfa83238bdbf98cfb1c700c0287', 2, 7);
INSERT INTO sys_user(username, cellphone, PASSWORD, role_id, stu_class_id) VALUES('李子龙', '18700618102', '4feede0ce64ccb2056c3870df19aa168', 2, 7);
INSERT INTO sys_user(username, cellphone, PASSWORD, role_id, stu_class_id) VALUES('芦熙', '15229218705', 'a25b90d485278d8fd97a038ffdf97e08', 2, 7);
INSERT INTO sys_user(username, cellphone, PASSWORD, role_id, stu_class_id) VALUES('乔佳', '18700055530', '05d83bc39ea956957e514b6d37ac53c4', 2, 7);
INSERT INTO sys_user(username, cellphone, PASSWORD, role_id, stu_class_id) VALUES('王梦杰', '15029091279', '7d47552c984be8257d1d73d4872aa088', 2, 7);
INSERT INTO sys_user(username, cellphone, PASSWORD, role_id, stu_class_id) VALUES('王子悦', '17718101275', '052a73ac8c5671bd2aab6b8f18903e12', 2, 7);
INSERT INTO sys_user(username, cellphone, PASSWORD, role_id, stu_class_id) VALUES('薛权多', '18064322568', '723526cc83cd720060a55f7dd752d0e9', 2, 7);
INSERT INTO sys_user(username, cellphone, PASSWORD, role_id, stu_class_id) VALUES('杨芳芳', '18391626339', '709f466138d4b2616c6a14497c4e9086', 2, 7);
INSERT INTO sys_user(username, cellphone, PASSWORD, role_id, stu_class_id) VALUES('易孝涛', '18691598057', 'a8c922ce25a46698afbb952aae62c85d', 2, 7);
INSERT INTO sys_user(username, cellphone, PASSWORD, role_id, stu_class_id) VALUES('于泽', '15667078961', '14bc8c48df12f7499d89c6e4a72457d6', 2, 7);
INSERT INTO sys_user(username, cellphone, PASSWORD, role_id, stu_class_id) VALUES('赵文强', '18149335896', 'ec2986eab15fbd349bb89d952952f14d', 2, 7);

-- 课程信息表：sys_course
DROP TABLE IF EXISTS sys_course;
CREATE TABLE sys_course(
	course_id INT(10) NOT NULL AUTO_INCREMENT COMMENT '课程主键',
	course_name VARCHAR(255) NOT NULL COMMENT '课程名称',
	course_code VARCHAR(100) COMMENT '课程编号',
	sort_order INT(10) COMMENT '排序',
	create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
	PRIMARY KEY(course_id)
)ENGINE=INNODB CHARSET='utf8mb4' COMMENT='课程信息表';
INSERT INTO sys_course(course_name) VALUES('Java基础');
INSERT INTO sys_course(course_name) VALUES('Java面向对象');
INSERT INTO sys_course(course_name) VALUES('Java高级应用');
INSERT INTO sys_course(course_name) VALUES('MySQL数据库实用技术');
INSERT INTO sys_course(course_name) VALUES('Web前端开发');
INSERT INTO sys_course(course_name) VALUES('JavaScript开发与实战');
INSERT INTO sys_course(course_name) VALUES('jQuery实用技术');
INSERT INTO sys_course(course_name) VALUES('Java Web开发');

-- 学生选课信息表：sys_user_course
DROP TABLE IF EXISTS sys_user_course;
CREATE TABLE sys_user_course(
	user_id INT(10) COMMENT '用户主键',
	course_id INT(255) COMMENT '课程主键'
)ENGINE=INNODB CHARSET='utf8mb4' COMMENT='学生选课信息表';