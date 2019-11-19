/*******************************************************/
/********** DK�������ϵͳ���ݿ��ʼ���ű� V1.0          *********/
/********** DK Educational Manager System v1.0 *********/
/*******************************************************/
-- ����ʹ�����ݿ⣺dkems_db
DROP DATABASE IF EXISTS dkems_db;
CREATE DATABASE dkems_db CHARACTER SET 'utf8mb4';
USE dkems_db;

-- ��ɫ��Ϣ��sys_role
DROP TABLE IF EXISTS sys_role;
CREATE TABLE sys_role(
	role_id INT(10) NOT NULL AUTO_INCREMENT COMMENT '��ɫ����',
	role_name VARCHAR(255) NOT NULL COMMENT '��ɫ����',
	role_code VARCHAR(255) COMMENT '��ɫ����',
	sort_order INT(10) COMMENT '����',
	create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '����ʱ��',
	update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '�޸�ʱ��',
	PRIMARY KEY(role_id)
)ENGINE=INNODB CHARSET='utf8mb4' COMMENT='��ɫ��Ϣ��';
INSERT INTO sys_role(role_name, role_code, sort_order) VALUES('��Ա', 'teacher', 1);
INSERT INTO sys_role(role_name, role_code, sort_order) VALUES('ѧ��', 'student', 2);

-- �༶��Ϣ��sys_stu_class
DROP TABLE IF EXISTS sys_stu_class;
CREATE TABLE sys_stu_class(
	stu_class_id INT(10) NOT NULL AUTO_INCREMENT COMMENT '�༶����',
	stu_class_no VARCHAR(255) NOT NULL COMMENT '�༶���',
	sort_order INT(10) COMMENT '����',
	create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '����ʱ��',
	update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '�޸�ʱ��',
	PRIMARY KEY(stu_class_id)
)ENGINE=INNODB CHARSET='utf8mb4' COMMENT='�༶��Ϣ��';
INSERT INTO sys_stu_class(stu_class_no, sort_order) VALUES('DK0J190101Q', 1);
INSERT INTO sys_stu_class(stu_class_no, sort_order) VALUES('DK0J190201Q', 2);
INSERT INTO sys_stu_class(stu_class_no, sort_order) VALUES('DK0J190301Q', 3);
INSERT INTO sys_stu_class(stu_class_no, sort_order) VALUES('DK0J190401Q', 4);
INSERT INTO sys_stu_class(stu_class_no, sort_order) VALUES('DK0J190501Q', 5);
INSERT INTO sys_stu_class(stu_class_no, sort_order) VALUES('DK0J190601Q', 6);
INSERT INTO sys_stu_class(stu_class_no, sort_order) VALUES('DK0J190701Q', 7);
INSERT INTO sys_stu_class(stu_class_no, sort_order) VALUES('DK0J190801Q', 8);
INSERT INTO sys_stu_class(stu_class_no, sort_order) VALUES('DK0J190901Q', 9);

-- �û���Ϣ��sys_user
DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user(
	user_id INT(10) NOT NULL AUTO_INCREMENT COMMENT '�û�����',
	username VARCHAR(255) NOT NULL COMMENT '�û�����',
	cellphone VARCHAR(100) NOT NULL COMMENT '�ֻ�����',
	PASSWORD VARCHAR(500) NOT NULL COMMENT '��¼����',
	role_id INT(10) NOT NULL COMMENT '�û���ɫ',
	stu_class_id INT(10) COMMENT '���ڰ༶',
	email VARCHAR(500) COMMENT '�����ʼ�',
	id_card VARCHAR(100) COMMENT '���֤����',
	photo VARCHAR(500) COMMENT 'ͷ��',
	STATUS VARCHAR(10) NOT NULL DEFAULT 'Y' COMMENT '״̬������-���ã�����-����',
	sort_order INT(10) COMMENT '����',
	create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '����ʱ��',
	update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '�޸�ʱ��',
	PRIMARY KEY(user_id)
)ENGINE=INNODB CHARSET='utf8mb4' COMMENT='��Ա��Ϣ��';
INSERT INTO sys_user(username, cellphone, PASSWORD, role_id, stu_class_id) VALUES('����ʦ', '17629039600', '21232f297a57a5a743894a0e4a801fc3', 1, 7);
INSERT INTO sys_user(username, cellphone, PASSWORD, role_id, stu_class_id) VALUES('�ɲ�', '15771712836', '1f5f72f9d38b9cff1e5a663782ad26ac', 2, 7);
INSERT INTO sys_user(username, cellphone, PASSWORD, role_id, stu_class_id) VALUES('����', '12345678901', 'a5c7c87378c0ff7089ebd528640eb3a7', 2, 7);
INSERT INTO sys_user(username, cellphone, PASSWORD, role_id, stu_class_id) VALUES('������', '18309297750', '8b4cff833678ae05ef275e145f1bf7af', 2, 7);
INSERT INTO sys_user(username, cellphone, PASSWORD, role_id, stu_class_id) VALUES('����', '18792647022', '0f64e80696b572976c80d4ab811e4819', 2, 7);
INSERT INTO sys_user(username, cellphone, PASSWORD, role_id, stu_class_id) VALUES('���γ�', '15891449276', '287daeaf04c1efe4322d61ac28dcd40c', 2, 7);
INSERT INTO sys_user(username, cellphone, PASSWORD, role_id, stu_class_id) VALUES('����', '13572314348', 'b8b61970d8772a59001f133fe2322f63', 2, 7);
INSERT INTO sys_user(username, cellphone, PASSWORD, role_id, stu_class_id) VALUES('������', '15129239895', '7a9bcdfa83238bdbf98cfb1c700c0287', 2, 7);
INSERT INTO sys_user(username, cellphone, PASSWORD, role_id, stu_class_id) VALUES('������', '18700618102', '4feede0ce64ccb2056c3870df19aa168', 2, 7);
INSERT INTO sys_user(username, cellphone, PASSWORD, role_id, stu_class_id) VALUES('«��', '15229218705', 'a25b90d485278d8fd97a038ffdf97e08', 2, 7);
INSERT INTO sys_user(username, cellphone, PASSWORD, role_id, stu_class_id) VALUES('�Ǽ�', '18700055530', '05d83bc39ea956957e514b6d37ac53c4', 2, 7);
INSERT INTO sys_user(username, cellphone, PASSWORD, role_id, stu_class_id) VALUES('���ν�', '15029091279', '7d47552c984be8257d1d73d4872aa088', 2, 7);
INSERT INTO sys_user(username, cellphone, PASSWORD, role_id, stu_class_id) VALUES('������', '17718101275', '052a73ac8c5671bd2aab6b8f18903e12', 2, 7);
INSERT INTO sys_user(username, cellphone, PASSWORD, role_id, stu_class_id) VALUES('ѦȨ��', '18064322568', '723526cc83cd720060a55f7dd752d0e9', 2, 7);
INSERT INTO sys_user(username, cellphone, PASSWORD, role_id, stu_class_id) VALUES('���', '18391626339', '709f466138d4b2616c6a14497c4e9086', 2, 7);
INSERT INTO sys_user(username, cellphone, PASSWORD, role_id, stu_class_id) VALUES('��Т��', '18691598057', 'a8c922ce25a46698afbb952aae62c85d', 2, 7);
INSERT INTO sys_user(username, cellphone, PASSWORD, role_id, stu_class_id) VALUES('����', '15667078961', '14bc8c48df12f7499d89c6e4a72457d6', 2, 7);
INSERT INTO sys_user(username, cellphone, PASSWORD, role_id, stu_class_id) VALUES('����ǿ', '18149335896', 'ec2986eab15fbd349bb89d952952f14d', 2, 7);

-- �γ���Ϣ��sys_course
DROP TABLE IF EXISTS sys_course;
CREATE TABLE sys_course(
	course_id INT(10) NOT NULL AUTO_INCREMENT COMMENT '�γ�����',
	course_name VARCHAR(255) NOT NULL COMMENT '�γ�����',
	course_code VARCHAR(100) COMMENT '�γ̱��',
	sort_order INT(10) COMMENT '����',
	create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '����ʱ��',
	update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '�޸�ʱ��',
	PRIMARY KEY(course_id)
)ENGINE=INNODB CHARSET='utf8mb4' COMMENT='�γ���Ϣ��';
INSERT INTO sys_course(course_name) VALUES('Java����');
INSERT INTO sys_course(course_name) VALUES('Java�������');
INSERT INTO sys_course(course_name) VALUES('Java�߼�Ӧ��');
INSERT INTO sys_course(course_name) VALUES('MySQL���ݿ�ʵ�ü���');
INSERT INTO sys_course(course_name) VALUES('Webǰ�˿���');
INSERT INTO sys_course(course_name) VALUES('JavaScript������ʵս');
INSERT INTO sys_course(course_name) VALUES('jQueryʵ�ü���');
INSERT INTO sys_course(course_name) VALUES('Java Web����');

-- ѧ��ѡ����Ϣ��sys_user_course
DROP TABLE IF EXISTS sys_user_course;
CREATE TABLE sys_user_course(
	user_id INT(10) COMMENT '�û�����',
	course_id INT(255) COMMENT '�γ�����'
)ENGINE=INNODB CHARSET='utf8mb4' COMMENT='ѧ��ѡ����Ϣ��';