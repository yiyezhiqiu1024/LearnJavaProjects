DROP DATABASE IF EXISTS mybatis;
CREATE DATABASE mybatis;
USE mybatis;

DROP TABLE IF EXISTS skill;
DROP TABLE IF EXISTS experience;
DROP TABLE IF EXISTS company;

# skill
CREATE TABLE skill ( 
	id INT AUTO_INCREMENT, 
	created_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, 
	name VARCHAR(20) NOT NULL,
	level INT NOT NULL,
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