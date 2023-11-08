DROP DATABASE IF EXISTS resume;
CREATE DATABASE resume CHARACTER SET utf8mb4;
USE resume;

DROP TABLE IF EXISTS award;
DROP TABLE IF EXISTS education;
DROP TABLE IF EXISTS skill;
DROP TABLE IF EXISTS website;
DROP TABLE IF EXISTS experience;
DROP TABLE IF EXISTS project;
DROP TABLE IF EXISTS company;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS contact;

# user
CREATE TABLE user ( 
	id INT AUTO_INCREMENT, 
	created_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, 
	password VARCHAR(32) NOT NULL,
	email VARCHAR(50) NOT NULL UNIQUE,
	birthday DATE,
	photo VARCHAR(100),
	intro VARCHAR(1000),
	name VARCHAR(20),
	address VARCHAR(100),
	phone VARCHAR(20),
	job VARCHAR(20),
	trait VARCHAR(100),
	interests VARCHAR(100),
	PRIMARY KEY (id)
);

# skill
CREATE TABLE skill ( 
	id INT AUTO_INCREMENT, 
	created_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, 
	name VARCHAR(20) NOT NULL,
	level INT NOT NULL,
	PRIMARY KEY (id)
);

# website
CREATE TABLE website ( 
	id INT AUTO_INCREMENT, 
	created_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, 
	footer VARCHAR(1000),
	PRIMARY KEY (id)
);

# company
CREATE TABLE company ( 
	id INT AUTO_INCREMENT, 
	created_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, 
	name VARCHAR(20) NOT NULL UNIQUE,
	logo VARCHAR(100),
	website VARCHAR(50),
	intro VARCHAR(1000),
	PRIMARY KEY (id)
);

# award
CREATE TABLE award ( 
	id INT AUTO_INCREMENT, 
	created_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, 
	name VARCHAR(20) NOT NULL,
	image VARCHAR(100),
	intro VARCHAR(1000),
	PRIMARY KEY (id)
);

# contact
CREATE TABLE contact ( 
	id INT AUTO_INCREMENT, 
	created_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, 
	name VARCHAR(20) NOT NULL,
	email VARCHAR(50) NOT NULL,
	comment VARCHAR(1000) NOT NULL,
	subject VARCHAR(20),
	already_read INT NOT NULL DEFAULT 0,
	PRIMARY KEY (id)
);

# education
CREATE TABLE education ( 
	id INT AUTO_INCREMENT, 
	created_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, 
	name VARCHAR(20) UNIQUE NOT NULL,
	type INT NOT NULL,
	intro VARCHAR(1000),
	begin_day DATE NOT NULL, 
	end_day DATE, 
	PRIMARY KEY (id)
);

# experience
CREATE TABLE experience ( 
	id INT AUTO_INCREMENT, 
	created_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, 
	job VARCHAR(20) NOT NULL,
	intro VARCHAR(1000),
	begin_day DATE NOT NULL, 
	end_day DATE, 
	company_id INT NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (company_id) REFERENCES company(id)
);

# project
CREATE TABLE project ( 
	id INT AUTO_INCREMENT, 
	created_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, 
	name VARCHAR(20) NOT NULL,
	intro VARCHAR(1000),
	website VARCHAR(50),
	image VARCHAR(100),
	begin_day DATE NOT NULL, 
	end_day DATE, 
	company_id INT NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (company_id) REFERENCES company(id)
);

# 初始化
INSERT INTO user(email, name, password, 
	job, phone, birthday, 
	address, trait, interests, 
	intro) VALUES(
	'359297567@qq.com', '一叶知秋', 'e10adc3949ba59abbe56e057f20f883e',
	'程序员', '9527', '1990-05-19', 
	'天朝深圳', '活泼,可爱', '足球,台球,电玩',
	'本人学识渊博、经验丰富，代码风骚、效率恐怖，C/C++ C#、Java、PHP、Android、iOS、Python、JavaScript，无不精通玩转，熟练掌握各种框架，并自写语言，创操作系统，写CPU处理器构架，做指令集成。深山苦练20余年，一天只睡3小时，千里之外定位问题，瞬息之间修复上线。身体强壮、健步如飞，可连续工作100小时不休息，讨论技术方案9小时不喝水，上至研发CPU芯片、带项目、出方案、弄计划，下至盗账号、黑网站、Shell提权挂马、攻击同行、拍片摄影、泡妞把妹纸、开挖掘机、威胁PM，啥都能干。'
);

INSERT INTO website(footer) VALUES(
	'<a href="https://github.com/yiyezhiqiu1024" target="_blank">一叶知秋</a> © All Rights Reserved 2021'
);