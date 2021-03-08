-- Database: ztrack

DROP SCHEMA public CASCADE;
CREATE SCHEMA public;

-- CREATE DATABASE ztrack
--     WITH 
--     OWNER = postgres
--     ENCODING = 'UTF8'
--     LC_COLLATE = 'Bosnian (Latin)_Bosnia and Herzegovina.1252'
--     LC_CTYPE = 'Bosnian (Latin)_Bosnia and Herzegovina.1252'
--     TABLESPACE = pg_default
--     CONNECTION LIMIT = -1;

CREATE TABLE TPC_EMPLOYEES_ROLES(
	id SERIAL PRIMARY KEY,
	code VARCHAR(5),
	name VARCHAR(60),
	create_by VARCHAR(40),
	create_date DATE,
	update_by VARCHAR(40),
	update_date DATE
);

CREATE TABLE TPC_EMPLOYEES(
	id SERIAL PRIMARY KEY,
	first_name VARCHAR(30),
	last_name VARCHAR(40),
	display_name VARCHAR(70),
	dob DATE,
	experience INT,
	employees_role_id INT,
	username VARCHAR(20),
	password VARCHAR(30),
	create_by VARCHAR(40),
	create_date DATE,
	update_by VARCHAR(40),
	update_date DATE,
	role VARCHAR(10),
	FOREIGN KEY (employees_role_id) REFERENCES TPC_EMPLOYEES_ROLES(id)
);

CREATE TABLE TPC_ACCOUNTS (
    	id SERIAL PRIMARY KEY, 
    	code VARCHAR(5),
    	name VARCHAR(60),
	active VARCHAR(1),
	valid_from DATE,
	valid_to DATE,
	responsible INT,
	create_by VARCHAR(40),
	create_date DATE,
	update_by VARCHAR(40),
	update_date DATE,
   	FOREIGN KEY (responsible) REFERENCES TPC_EMPLOYEES(id)
);

CREATE TABLE TPC_EVENTS(
	id SERIAL PRIMARY KEY,
	code VARCHAR(5),
	name VARCHAR(60),
	create_by VARCHAR(40),
	create_date DATE,
	update_by VARCHAR(40),
	update_date DATE
);

CREATE TABLE TPC_PROJECT_ACTIVITIES(
	id SERIAL PRIMARY KEY,
    	code VARCHAR(5),
    	name VARCHAR(60),
	active VARCHAR(1),
	valid_from DATE,
	valid_to DATE,
	responsible INT,
	project_id INT,
	create_by VARCHAR(40),
	create_date DATE,
	update_by VARCHAR(40),
	update_date DATE,
    	FOREIGN KEY (responsible) REFERENCES TPC_EMPLOYEES(id),
    	FOREIGN KEY (project_id) REFERENCES TPC_ACCOUNTS(id)
);

CREATE TABLE TPT_WORKLOG(
	id SERIAL PRIMARY KEY,
	employee_id INT,
	project_id INT,
	project_activity_id INT,
	work_date DATE,
	hours INT,
	minutes INT,
	notes VARCHAR(200),
	create_by VARCHAR(40),
	create_date DATE,
	update_by VARCHAR(40),
	update_date DATE,
	FOREIGN KEY (project_activity_id) REFERENCES TPC_PROJECT_ACTIVITIES(id),
	FOREIGN KEY (employee_id) REFERENCES TPC_EMPLOYEES(id),
	FOREIGN KEY (project_id) REFERENCES TPC_ACCOUNTS(id)
);

CREATE TABLE TPC_PRODUCTS(
	id SERIAL PRIMARY KEY,
    	code VARCHAR(5),
    	name VARCHAR(60),
	create_by VARCHAR(40),
	create_date DATE,
	update_by VARCHAR(40),
	update_date DATE
);

CREATE TABLE TPC_KNOWLEDGE(
	id SERIAL PRIMARY KEY,
    	code VARCHAR(5),
    	name VARCHAR(60),
	create_by VARCHAR(40),
	create_date DATE,
	update_by VARCHAR(40),
	update_date DATE
);

CREATE TABLE TPC_CERTIFICATES(
	id SERIAL PRIMARY KEY,
    	code VARCHAR(5),
    	name VARCHAR(60),
	create_by VARCHAR(40),
	create_date DATE,
	update_by VARCHAR(40),
	update_date DATE
);

CREATE TABLE TPC_HOLIDAYS(
	id SERIAL PRIMARY KEY,
	name VARCHAR(60),
    	holiday_date DATE,
   	recurring VARCHAR(1),
	create_by VARCHAR(40),
	create_date DATE,
	update_by VARCHAR(40),
	update_date DATE
);

CREATE TABLE TPC_EMPLOYEES_CERTIFICATES(
	id SERIAL PRIMARY KEY,
	employee_id INT,
	certificate_id INT,
	active VARCHAR(1),
	create_by VARCHAR(40),
	create_date DATE,
	update_by VARCHAR(40),
	update_date DATE,
	FOREIGN KEY (employee_id) REFERENCES TPC_EMPLOYEES(id),
	FOREIGN KEY (certificate_id) REFERENCES TPC_CERTIFICATES(id)
);

CREATE TABLE TPC_EMPLOYEES_KNOWLEDGE(
	id SERIAL PRIMARY KEY,
	employee_id INT,
	knowledge_id INT,
	active VARCHAR(1),
	create_by VARCHAR(40),
	create_date DATE,
	update_by VARCHAR(40),
	update_date DATE,
	FOREIGN KEY (employee_id) REFERENCES TPC_EMPLOYEES(id),
	FOREIGN KEY (knowledge_id) REFERENCES TPC_KNOWLEDGE(id)
);

CREATE TABLE TPC_EMPLOYEES_PRODUCTS(
	id SERIAL PRIMARY KEY,
	employee_id INT,
	product_id INT,
	active VARCHAR(1),
	create_by VARCHAR(40),
	create_date DATE,
	update_by VARCHAR(40),
	update_date DATE,
	FOREIGN KEY (employee_id) REFERENCES TPC_EMPLOYEES(id),
	FOREIGN KEY (product_id) REFERENCES TPC_PRODUCTS(id)
);

CREATE TABLE TPT_PLANNING(
	id SERIAL PRIMARY KEY,
	employee_id INT,
	workdate DATE,
	project_activity_id INT,
	create_by VARCHAR(40),
	create_date DATE,
	update_by VARCHAR(40),
	update_date DATE,
	FOREIGN KEY (employee_id) REFERENCES TPC_EMPLOYEES(id),
	FOREIGN KEY (project_activity_id) REFERENCES TPC_PROJECT_ACTIVITIES(id)
);

CREATE TABLE TPT_PLANNING_EVENTS(
	id SERIAL PRIMARY KEY,
	date_from DATE,
	date_to DATE,
	project_activity_id INT,
	event_id INT,
	create_by VARCHAR(40),
	create_date DATE,
	update_by VARCHAR(40),
	update_date DATE,
	FOREIGN KEY (project_activity_id) REFERENCES TPC_PROJECT_ACTIVITIES(id),
	FOREIGN KEY (event_id) REFERENCES TPC_EVENTS(id)
);

CREATE TABLE TPA_ROLES(
	id SERIAL PRIMARY KEY,
	code VARCHAR(5),
    	name VARCHAR(60),
	create_by VARCHAR(40),
	create_date DATE,
	update_by VARCHAR(40),
	update_date DATE
);

CREATE TABLE TPA_SEGMENTS(
	id SERIAL,
	segment_group VARCHAR(5) PRIMARY KEY,
    	name VARCHAR(60),
	create_by VARCHAR(40),
	create_date DATE,
	update_by VARCHAR(40),
	update_date DATE
);

CREATE TABLE TPA_ROLES_SEGMENTS(
	id SERIAL PRIMARY KEY,
	role_id INT,
	segment_group VARCHAR(5),
	create_by VARCHAR(40),
	create_date DATE,
	update_by VARCHAR(40),
	update_date DATE,
	FOREIGN KEY (role_id) REFERENCES TPA_ROLES(id),
    	FOREIGN KEY (segment_group) REFERENCES TPA_SEGMENTS(segment_group)
);

CREATE TABLE TPA_USER_ROLES(
	id SERIAL PRIMARY KEY,
	employee_id INT,
	role_id INT,
	create_by VARCHAR(40),
	create_date DATE,
	update_by VARCHAR(40),
	update_date DATE,
	FOREIGN KEY (role_id) REFERENCES TPA_ROLES(id),
    	FOREIGN KEY (employee_id) REFERENCES TPC_EMPLOYEES(id)
);

CREATE TABLE TPC_TEAMS(
	id SERIAL PRIMARY KEY,
	code VARCHAR(5),
	name VARCHAR(60),
	assigned_project_id INT,
	team_lead_id INT,
	valid_from DATE,
	valid_to DATE,
	create_by VARCHAR(40),
	create_date DATE,
	update_by VARCHAR(40),
	update_date DATE,
	FOREIGN KEY (assigned_project_id) REFERENCES TPC_ACCOUNTS(id),
	FOREIGN KEY (team_lead_id) REFERENCES TPC_EMPLOYEES(id)
);

CREATE TABLE TPC_TEAM_MEMBERS(
    	id SERIAL PRIMARY KEY,
    	team_id INT,
    	team_member_id INT,
    	team_member_role_id INT,
    	FOREIGN KEY (team_id) REFERENCES TPC_TEAMS(id),
    	FOREIGN KEY (team_member_id) REFERENCES TPC_EMPLOYEES(id),
    	FOREIGN KEY (team_member_role_id) REFERENCES TPC_EMPLOYEES_ROLES(id)
);

-- populate tables
-- TPC_EMPLOYEES_ROLES

INSERT INTO TPC_EMPLOYEES_ROLES(code, name,	create_by, create_date,	update_by, update_date)
VALUES
	('SYS_A', 'System Analyst', 'Džejla Šuman', '2020-06-19', 'Džejla Šuman', '2020-06-19'), 
	('J_DEV', 'Junior Developer', 'Džejla Šuman', '2020-06-19', 'Džejla Šuman', '2020-06-19'), 
	('S_DEV', 'Senior Developer', 'Džejla Šuman', '2020-06-19', 'Džejla Šuman', '2020-06-19'),
	('PR_MN', 'Project Manager', 'Džejla Šuman', '2020-06-19', 'Džejla Šuman', '2020-06-19'),
	('G_DES', 'Graphic Designer', 'Džejla Šuman', '2020-06-19', 'Džejla Šuman', '2020-06-19'),
	('ADM', 'Administrator', 'Džejla Šuman', '2020-06-19', 'Džejla Šuman', '2020-06-19');


-- TPC_EMPLOYEES

INSERT INTO TPC_EMPLOYEES(first_name, last_name, display_name, dob, experience, employees_role_id, username, 
						 password, create_by, create_date,	update_by, update_date, role)
VALUES
	('Emina', 'Fejzic', 'Emina Fejzic', '1987-07-03','10', 1, 'femina', '7654qbw876dj!', 'Džejla Šuman', '2020-06-19', 'Džejla Šuman', '2020-06-19', 'user'),
	('Ajdin', 'Hasanefendic', 'Ajdin Hasanefendic', '1997-07-20','2', 3, 'vuzeo', 'asfrktgj_23', 'Ajdin Hasanefendic', '2020-06-05', 'Ajdin Hasanefendic', '2020-06-05', 'user'),
	('Ema', 'Arnautovic', 'Ema Arnautovic', '1998-05-01','1', 1, 'hellanimal', 'aujq3wtij_234', 'Ajdin Hasanefendic', '2020-06-05', 'Ajdin Hasanefendic', '2020-06-05', 'user'),
	('Lejla', 'Kavac', 'Lejla Kavac', '1984-12-05','3', 4, 'leka', '123abd23', 'Ajdin Hasanefendic', '2020-06-05', 'Ajdin Hasanefendic', '2020-06-05', 'user'),
	('Hasan', 'Hasanbegovic', 'Hasan Hasanbegovic', '1991-09-13','8', 2, 'h_hen', '3248ksdnfgv!', 'Ajdin Hasanefendic', '2020-06-05', 'Ajdin Hasanefendic', '2020-06-05', 'user'),
	('Danijel', 'Catic', 'Danijel Catic', '1981-05-31','2', 3, 'ezdb', 'asdawtwez', 'Ajdin Hasanefendic', '2020-06-05', 'Ajdin Hasanefendic', '2020-06-05', 'user'),
	('Anka', 'Vulotovic', 'Anka Vulotovic', '1979-03-11','6', 5, 'ank_V1', '8i57zztdfghz!', 'Ajdin Hasanefendic', '2020-06-05', 'Ajdin Hasanefendic', '2020-06-05', 'user'),
	('Anela', 'Durakovic', 'Anela Durakovic', '1987-07-03','9', 6, 'anelka', 'tz8i7856u', 'Ajdin Hasanefendic', '2020-06-05', 'Ajdin Hasanefendic', '2020-06-05', 'user'),
	('Faris', 'Zgonic', 'Faris Zgonic', '1987-07-03','14', 4, 'zgona', 'woietjlkd', 'Ajdin Hasanefendic', '2020-06-05', 'Ajdin Hasanefendic', '2020-06-05', 'user'),
	('Nadja', 'Fejzic', 'Nadja Fejzic', '1999-06-20','2', 2, 'nfejzic', 'fZtjkV42', 'Džejla Šuman', '2020-07-15', 'Džejla Šuman', '2020-07-15', 'user'),
	('Džejla', 'Šuman', 'Džejla Šuman', '1999-10-14','3', 2, 'dzsuman', 'Qwrxnp971!8', 'Džejla Šuman', '2020-07-15', 'Džejla Šuman', '2020-07-15', 'admin');

-- TPC_ACCOUNTS

INSERT INTO TPC_ACCOUNTS(code, name, active, valid_from, valid_to, responsible, 
						 create_by, create_date, update_by, update_date)
VALUES
	('NJK', 'Njuskalo', 'Y','2014-02-10', '2024-02-10', '1', 'Džejla Šuman', '2020-06-19', 'Džejla Šuman', '2020-06-19'),
	('STC-I', 'STC ICB', 'Y', '2015-06-04', '2015-04-06', '1', 'Ajdin Hasanefendic', '2015-06-04', 'Ajdin Hasanefendic', '2020-06-05'),
	('STC-A', 'STC ADT', 'Y', '2017-07-16', '2027-07-16', '1', 'Ajdin Hasanefendic', '2017-07-16', 'Ajdin Hasanefendic', '2020-06-05'),
	('HRT', 'HRT', 'Y', '2019-03-12', '2019-03-12', '1', 'Ajdin Hasanefendic', '2019-03-12', 'Ajdin Hasanefendic', '2020-06-05'),
	('BHT', 'BHT', 'Y', '2013-09-18', '2023-09-18', '1', 'Ajdin Hasanefendic', '2013-09-18', 'Ajdin Hasanefendic', '2020-06-05');

-- TPC_EVENTS

INSERT INTO TPC_EVENTS(code, name, create_by, create_date, update_by, update_date)
VALUES
	('ITEST', 'Internal Testing', 'Džejla Šuman', '2020-06-19', 'Džejla Šuman', '2020-06-19'),
	('UAT', 'UAT', 'Ajdin Hasanefendic', '2020-06-05', 'Ajdin Hasanefendic', '2020-06-05'),
	('FT', 'Functional Testing', 'Ajdin Hasanefendic', '2020-06-05', 'Ajdin Hasanefendic', '2020-06-05'),
	('DES', 'Design', 'Ajdin Hasanefendic', '2020-06-05', 'Ajdin Hasanefendic', '2020-06-05'),
	('DEV', 'Development', 'Ajdin Hasanefendic', '2020-06-05', 'Ajdin Hasanefendic', '2020-06-05');

-- TPC_PROJECT_ACTIVITIES

INSERT INTO TPC_PROJECT_ACTIVITIES(code, name,  active, valid_from, valid_to, responsible, 
								   project_id, create_by, create_date, update_by, update_date)
VALUES
	('CR', 'Change Request', 'N','2014-02-10', '2024-02-10', '1', 1, 'Džejla Šuman', '2020-06-19', 'Džejla Šuman', '2020-06-19'),
	('IMPL','Implementation', 'Y', '2020-06-08', '2020-06-05', '1', 2, 'Ajdin Hasanefendic', '2020-06-08', 'Ajdin Hasanefendic', '2020-06-05'),
	('PLA', 'Planning', 'Y', '2020-06-29', '2025-06-09', '3', 3, 'Ajdin Hasanefendic', '2020-06-09', 'Ajdin Hasanefendic', '2020-06-29'),
	('ANA', 'Analysis', 'N', '2020-06-29', '2025-06-09', '6', 4, 'Ajdin Hasanefendic', '2020-06-09', 'Ajdin Hasanefendic', '2020-06-29'),
	('DES', 'Design', 'Y', '2020-06-29', '2025-06-09', '2', 5, 'Ajdin Hasanefendic', '2020-06-09', 'Ajdin Hasanefendic', '2020-06-29'),
	('DEV', 'Development', 'Y', '2020-06-29', '2025-06-09', '4', 4, 'Ajdin Hasanefendic', '2020-06-09', 'Ajdin Hasanefendic', '2020-06-29'),
	('TEST', 'Testing', 'N', '2020-06-29', '2025-06-09', '1', 1, 'Ajdin Hasanefendic', '2020-06-09', 'Ajdin Hasanefendic', '2020-06-29'),
	('MAINT', 'Maintenance', 'Y', '2020-06-29', '2025-06-09', '5', 2, 'Ajdin Hasanefendic', '2020-06-09', 'Ajdin Hasanefendic', '2020-06-29');

-- TPT_WORKLOG

INSERT INTO TPT_WORKLOG(employee_id, project_id, project_activity_id, work_date, hours, minutes, notes,
						create_by, create_date, update_by, update_date)
VALUES
	(1, 2, 1, '2019-05-27', 0, 30, 'No additional notes.', 'Džejla Šuman', '2020-06-19', 'Džejla Šuman', '2020-06-19'),
	(1, 2, 1, '2019-05-27', 3, 57, 'No additional notes.', 'Džejla Šuman', '2020-06-19', 'Džejla Šuman', '2020-06-19'),
	(11, 5, 5, '2020-07-16', 0, 55, 'No additional notes.', 'Džejla Šuman', '2020-07-16', 'Džejla Šuman', '2020-07-16'),
	(4, 3, 4, '2020-07-19', 0, 55, 'No additional notes.', 'Ajdin Hasanefendic', '2020-07-22', 'Ajdin Hasanefendic', '2020-07-22'),
	(7, 2, 3, '2020-07-23', 2, 43, 'No additional notes.', 'Ajdin Hasanefendic', '2020-07-27', 'Ajdin Hasanefendic', '2020-07-27'),
	(7, 2, 3, '2020-07-23', 1, 20, 'No additional notes.', 'Ajdin Hasanefendic', '2020-07-27', 'Ajdin Hasanefendic', '2020-07-27'),
	(3, 5, 1, '2020-07-24', 3, 35, 'No additional notes.', 'Ajdin Hasanefendic', '2020-07-27', 'Ajdin Hasanefendic', '2020-07-29'),
	(7, 2, 3, '2020-07-25', 0, 50, 'No additional notes.', 'Ajdin Hasanefendic', '2020-07-27', 'Ajdin Hasanefendic', '2020-07-27'),
	(2, 5, 5, '2020-07-26', 2, 14, 'Implemented new feature.', 'Ajdin Hasanefendic', '2020-07-26', 'Ajdin Hasanefendic', '2020-07-26'),
	(2, 5, 5, '2020-07-26', 3, 46, 'Planned new feature.', 'Ajdin Hasanefendic', '2020-07-26', 'Ajdin Hasanefendic', '2020-07-26'),
	(2, 2, 2, '2020-07-26', 3, 37, 'Implemented new feature.', 'Ajdin Hasanefendic', '2020-07-26', 'Ajdin Hasanefendic', '2020-07-26'),
	(2, 3, 3, '2020-07-27', 2, 12, 'Analysed how API works.', 'Ajdin Hasanefendic', '2020-07-27', 'Ajdin Hasanefendic', '2020-07-27'),
	(2, 4, 4, '2020-07-27', 1, 34, 'Urgent!!!', 'Ajdin Hasanefendic', '2020-07-27', 'Ajdin Hasanefendic', '2020-07-27'),
	(2, 1, 7, '2020-07-28', 2, 12, 'Implemented new feature.', 'Ajdin Hasanefendic', '2020-07-28', 'Ajdin Hasanefendic', '2020-07-28'),
	(2, 2, 2, '2020-07-28', 1, 19, 'No additional notes.', 'Ajdin Hasanefendic', '2020-07-28', 'Ajdin Hasanefendic', '2020-07-28'),
	(2, 2, 8, '2020-07-28', 3, 15, 'No additional notes.', 'Ajdin Hasanefendic', '2020-07-28', 'Ajdin Hasanefendic', '2020-07-28'),
	(2, 3, 3, '2020-07-29', 2, 35, 'Urgent!!!', 'Ajdin Hasanefendic', '2020-07-29', 'Ajdin Hasanefendic', '2020-07-29'),
	(2, 1, 7, '2020-07-29', 2, 20, 'Implemented new feature.', 'Ajdin Hasanefendic', '2020-07-29', 'Ajdin Hasanefendic', '2020-07-29'),
	(11, 3, 3, '2020-07-29', 1, 12, 'No additional notes.', 'Džejla Šuman', '2020-07-30', 'Džejla Šuman', '2020-07-30'),
	(2, 2, 2, '2020-07-30', 4, 18, 'Planned new feature on landing page.', 'Ajdin Hasanefendic', '2020-07-30', 'Ajdin Hasanefendic', '2020-07-30'),
	(11, 5, 5, '2020-07-30', 2, 26, 'No additional notes.', 'Džejla Šuman', '2020-07-30', 'Džejla Šuman', '2020-07-30'),
	(2, 4, 6, '2020-07-30', 5, 21, 'Planned new feature on backend.', 'Ajdin Hasanefendic', '2020-07-30', 'Ajdin Hasanefendic', '2020-07-30'),
	(11, 3, 3, '2020-07-31', 1, 54, 'No additional notes.', 'Džejla Šuman', '2020-07-31', 'Džejla Šuman', '2020-07-31'),
	(2, 3, 3, '2020-07-31', 2, 42, 'No additional notes.', 'Ajdin Hasanefendic', '2020-07-31', 'Ajdin Hasanefendic', '2020-07-31'),
	(11, 1, 7, '2020-07-31', 5, 23, 'No additional notes.', 'Džejla Šuman', '2020-07-31', 'Džejla Šuman', '2020-07-31'),
	(11, 2, 8, '2020-08-01', 3, 35, 'No additional notes.', 'Džejla Šuman', '2020-08-01', 'Džejla Šuman', '2020-08-01'),
	(2, 2, 2, '2020-08-01', 3, 35, 'Final touch-ups.', 'Ajdin Hasanefendic', '2020-08-01', 'Ajdin Hasanefendic', '2020-08-01'),
	(11, 2, 2, '2020-08-02', 3, 35, 'Check up done.', 'Džejla Šuman', '2020-08-02', 'Džejla Šuman', '2020-08-02'),
	(2, 2, 8, '2020-08-02', 3, 35, 'No additional notes.', 'Ajdin Hasanefendic', '2020-08-02', 'Ajdin Hasanefendic', '2020-08-02'),
	(11, 2, 8, '2020-08-02', 3, 35, 'No additional notes.', 'Džejla Šuman', '2020-08-02', 'Džejla Šuman', '2020-08-02'),
	(11, 2, 8, '2020-08-03', 3, 35, 'Check up done.', 'Džejla Šuman', '2020-08-03', 'Džejla Šuman', '2020-08-03'),
	(2, 2, 2, '2020-08-04', 3, 35, 'No additional notes.', 'Ajdin Hasanefendic', '2020-08-04', 'Ajdin Hasanefendic', '2020-08-04'),
	(11, 2, 8, '2020-08-05', 3, 35, 'Final touch-ups.', 'Džejla Šuman', '2020-08-10', 'Džejla Šuman', '2020-08-10'),
	(2, 2, 2, '2020-08-06', 3, 35, 'No additional notes.', 'Ajdin Hasanefendic', '2020-08-06', 'Ajdin Hasanefendic', '2020-08-06'),
	(11, 2, 2, '2020-08-06', 3, 35, 'No additional notes.', 'Džejla Šuman', '2020-08-06', 'Džejla Šuman', '2020-08-06'),
	(11, 2, 2, '2020-08-07', 3, 35, 'Check up done.', 'Džejla Šuman', '2020-08-07', 'Džejla Šuman', '2020-08-07'),
	(11, 2, 8, '2020-08-08', 0, 30, 'No additional notes.', 'Džejla Šuman', '2020-08-08', 'Džejla Šuman', '2020-08-08'),
	(11, 4, 4, '2020-08-10', 0, 15, 'No additional notes.', 'Džejla Šuman', '2020-08-10', 'Džejla Šuman', '2020-08-10'),
	(11, 4, 4, '2020-08-11', 0, 30, 'No additional notes.', 'Džejla Šuman', '2020-08-11', 'Džejla Šuman', '2020-08-11'),
	(11, 5, 5, '2020-08-11', 3, 57, 'Check up done.', 'Džejla Šuman', '2020-08-11', 'Džejla Šuman', '2020-08-11'),
	(11, 3, 3, '2020-08-12', 3, 57, 'No additional notes.', 'Džejla Šuman', '2020-08-12', 'Džejla Šuman', '2020-08-12'),
	(11, 1, 7, '2020-08-12', 1, 35, 'Check up done.', 'Džejla Šuman', '2020-08-12', 'Džejla Šuman', '2020-08-12'),
	(2, 1, 7, '2020-08-13', 1, 15, 'No additional notes.', 'Ajdin Hasanefendic', '2020-08-13', 'Ajdin Hasanefendic', '2020-08-13'),
	(11, 5, 5, '2020-08-14', 1, 45, 'Final touch-ups.', 'Džejla Šuman', '2020-08-14', 'Džejla Šuman', '2020-08-14'),
	(11, 4, 4, '2020-08-14', 0, 45, 'Monthly check-in complete.', 'Džejla Šuman', '2020-08-14', 'Džejla Šuman', '2020-08-14'),
	(11, 3, 3, '2020-08-14', 2, 0, 'No additional notes.', 'Džejla Šuman', '2020-08-14', 'Džejla Šuman', '2020-08-14'),
	(11, 4, 6, '2020-08-14', 2, 30, 'No additional notes.', 'Džejla Šuman', '2020-08-14', 'Džejla Šuman', '2020-08-14');

-- TPC_PRODUCTS

INSERT INTO TPC_PRODUCTS (code, name, create_by, create_date, update_by, update_date)
VALUES 
	('PC', 'PC', 'nf', '2020-06-19','nf', '2020-06-19'),
	('TRM', 'TRM', 'nf', '2020-06-19','nf', '2020-06-19'),
	('WCRM', 'WCRM', 'nf', '2020-06-05','nf', '2020-06-05');

-- TPC_KNOWLEDGE 

INSERT INTO TPC_KNOWLEDGE (code, name, create_by, create_date, update_by, update_date)
VALUES 
	('P', 'Python', 'nf', '2020-06-19','nf', '2020-06-19'),
	('J', 'Java', 'nf', '2020-06-19','nf', '2020-06-19'),
	('CPP', 'CPP', 'nf', '2020-06-05','nf', '2020-06-05'),
	('C', 'C', 'nf', '2020-06-05','nf', '2020-06-05'),
	('JS', 'JavaScript', 'nf', '2020-06-05','nf', '2020-06-05'),
	('SQL', 'SQL', 'nf', '2020-06-05','nf', '2020-06-05'),
	('Ang', 'Angular', 'nf', '2020-06-05','nf', '2020-06-05'),
	('DataB', 'Database', 'nf', '2020-06-05','nf', '2020-06-05'),
	('Net', 'Networks', 'nf', '2020-06-05','nf', '2020-06-05'),
	('HTML', 'HTML', 'nf', '2020-06-05','nf', '2020-06-05');

-- TPC_CERTIFICATES

INSERT INTO TPC_CERTIFICATES (code, name, create_by, create_date, update_by, update_date)
VALUES 
	('M', 'Microsoft', 'nf', '2020-06-19','nf', '2020-06-19'),
	('G', 'Google', 'nf', '2020-06-19','nf', '2020-06-19');

-- TPC_HOLIDAYS

INSERT INTO TPC_HOLIDAYS (name, holiday_date, recurring, create_by, create_date, update_by, update_date)
VALUES 
	('New Year', '2020-12-31', 'Y', 'nf', '2020-06-19','nf', '2020-06-19'),
	('Christmas', '2020-12-25', 'Y', 'nf', '2020-06-19','nf', '2020-06-19'),
	('FMay', '2020-05-01', 'Y', 'nf', '2020-06-05','nf', '2020-06-05'),
	('StatehoodDay', '2020-11-25', 'Y', 'nf', '2020-06-05','nf', '2020-06-05'),
	('IndepDay', '2020-03-01', 'Y', 'nf', '2020-06-05','nf', '2020-06-05');

-- TPC_EMPLOYEES_CERTIFICATES

INSERT INTO TPC_EMPLOYEES_CERTIFICATES (employee_id, certificate_id, active, create_by, create_date, update_by, update_date)
VALUES 
	(1, 1, 'Y', 'nf','2020-06-19','nf', '2020-06-19'),
	(2, 1, 'Y', 'nf','2020-06-05','nf', '2020-06-05'),
	(3, 2, 'Y', 'nf','2020-06-05','nf', '2020-06-05'),
	(4, 2, 'Y', 'nf','2020-06-05','nf', '2020-06-05'),
	(5, 1, 'Y', 'nf','2020-06-05','nf', '2020-06-05'),
	(6, 2, 'Y', 'nf','2020-06-05','nf', '2020-06-05'),
	(7, 1, 'Y', 'nf','2020-06-05','nf', '2020-06-05'),
	(8, 2, 'Y', 'nf','2020-06-05','nf', '2020-06-05'),
	(9, 2, 'Y', 'nf','2020-06-05','nf', '2020-06-05');

-- TPC_EMPLOYEES_KNOWLEDGE

INSERT INTO TPC_EMPLOYEES_KNOWLEDGE (employee_id, knowledge_id, active, create_by, create_date, update_by, update_date)
VALUES 
	(1, 1, 'Y', 'nf','2020-06-19','nf', '2020-06-19'),
	(2, 2, 'Y', 'nf','2020-06-05','nf', '2020-06-05'),
	(3, 4, 'Y', 'nf','2020-06-05','nf', '2020-06-05'),
	(4, 8, 'Y', 'nf','2020-06-05','nf', '2020-06-05'),
	(5, 3, 'Y', 'nf','2020-06-05','nf', '2020-06-05'),
	(6, 5, 'Y', 'nf','2020-06-05','nf', '2020-06-05'),
	(7, 9, 'Y', 'nf','2020-06-05','nf', '2020-06-05'),
	(8, 10, 'Y', 'nf','2020-06-05','nf', '2020-06-05'),
	(9, 7, 'Y', 'nf','2020-06-05','nf', '2020-06-05');

-- TPC_EMPLOYEES_PRODUCTS

INSERT INTO TPC_EMPLOYEES_PRODUCTS (employee_id, product_id, active, create_by, create_date, update_by, update_date)
VALUES 
	(1, 1, 'Y', 'Ajdin Hasanefendic', '2020-05-06', 'Ajdin Hasanefendic', '2020-06-19'),
	(7, 2, 'Y', 'Džejla Šuman', '2020-06-24', 'Džejla Šuman', '2020-06-24'),
	(9, 1, 'N', 'Džejla Šuman', '2020-06-24', 'Džejla Šuman', '2020-06-24');

-- TPT_PLANNING

INSERT INTO TPT_PLANNING (employee_id, workdate, project_activity_id, create_by, create_date, update_by, update_date)
VALUES 
	(1, '12-06-2020', 1, 'Ajdin Hasanefendic', '2020-06-11', 'Ajdin Hasanefendic', '2020-06-19'),
	(3, '2020-04-07', 1, 'Džejla Šuman', '2020-06-24', 'Džejla Šuman', '2020-06-24'),
	(5, '2020-04-07', 1, 'Džejla Šuman', '2020-06-24', 'Džejla Šuman', '2020-06-24'),
	(4, '2019-07-02', 1, 'Džejla Šuman', '2020-06-24', 'Džejla Šuman', '2020-06-24'),
	(8, '2020-04-07', 1, 'Džejla Šuman', '2020-06-24', 'Džejla Šuman', '2020-06-24');

-- TPT_PLANNING_EVENTS

INSERT INTO TPT_PLANNING_EVENTS (date_from, date_to, project_activity_id, event_id, create_by, create_date, update_by, update_date)
VALUES 
	('2020-06-12', '2020-08-10', 1, 1, 'Ajdin Hasanefendic', '2020-05-13', 'Ajdin Hasanefendic', '2020-06-19'),
	('2015-01-29', '2018-07-29', 1, 1, 'Džejla Šuman', '2020-06-24', 'Džejla Šuman', '2020-06-24'),
	('2013-05-05', '2014-05-05', 1, 1, 'Džejla Šuman', '2020-06-24', 'Džejla Šuman', '2020-06-24'),
	('2010-07-10', '2015-12-30', 1, 1, 'Džejla Šuman', '2020-06-24', 'Džejla Šuman', '2020-06-24');

-- TPA_ROLES

INSERT INTO  TPA_ROLES (code, name, create_by, create_date, update_by, update_date)
VALUES 
	('HR', 'Human Resources', 'Ajdin Hasanefendic', '2019-10-15', 'Ajdin Hasanefendic', '2020-06-19'),
	('M', 'Management', 'Ajdin Hasanefendic', '2019-10-15', 'Ajdin Hasanefendic', '2020-06-19'),
	('TL', 'Team Leader', 'Ajdin Hasanefendic', '2019-10-15', 'Ajdin Hasanefendic', '2020-06-19'),
	('FIN', 'Finance', 'Džejla Šuman', '2020-06-24', 'Džejla Šuman', '2020-06-24');

-- TPA_SEGMENTS

INSERT INTO  TPA_SEGMENTS (segment_group, name, create_by, create_date, update_by, update_date)
VALUES 
	('P_RED', 'Read', 'Ajdin Hasanefendic', '2020-04-14', 'Ajdin Hasanefendic', '2020-06-19'),
	('P_ALL', 'Project Planing', 'Ajdin Hasanefendic', '2020-04-14', 'Ajdin Hasanefendic', '2020-06-19'),
	('C_RED', 'Code review', 'Ajdin Hasanefendic', '2020-04-14', 'Ajdin Hasanefendic', '2020-06-19'),
	('A_ALL', 'Administration', 'Ajdin Hasanefendic', '2020-04-14', 'Ajdin Hasanefendic', '2020-06-19');

-- TPA_USER_ROLES

INSERT INTO TPA_USER_ROLES (employee_id, role_id, create_by, create_date, update_by, update_date)
VALUES 
	(1, 1, 'Ajdin Hasanefendic', '2019-05-15', 'Ajdin Hasanefendic', '2020-06-19'),
	(4, 2, 'Džejla Šuman', '2020-06-24', 'Džejla Šuman', '2020-06-24'),
	(7, 4, 'Džejla Šuman', '2020-06-24', 'Džejla Šuman', '2020-06-24'),
	(8, 3, 'Džejla Šuman', '2020-06-24', 'Džejla Šuman', '2020-06-24'),
	(9, 1, 'Džejla Šuman', '2020-06-24', 'Džejla Šuman', '2020-06-24');
	
-- TPA_ROLES_SEGMENTS

INSERT INTO TPA_ROLES_SEGMENTS (role_id, segment_group, create_by, create_date, update_by, update_date)
VALUES 
	(1, 'A_ALL', 'Ajdin Hasanefendic', '2020-05-17', 'Ajdin Hasanefendic', '2020-06-19'),
	(2, 'C_RED', 'Ajdin Hasanefendic', '2020-05-17', 'Ajdin Hasanefendic', '2020-06-19'),
	(3, 'P_ALL', 'Ajdin Hasanefendic', '2020-05-17', 'Ajdin Hasanefendic', '2020-06-19'),
	(1, 'P_RED', 'Ajdin Hasanefendic', '2020-05-17', 'Ajdin Hasanefendic', '2020-06-19'),
	(2, 'P_ALL', 'Ajdin Hasanefendic', '2020-05-17', 'Ajdin Hasanefendic', '2020-06-19'),
	(3, 'C_RED', 'Ajdin Hasanefendic', '2020-05-17', 'Ajdin Hasanefendic', '2020-06-19');



-- TPC_TEAMS

INSERT INTO TPC_TEAMS (code, name, assigned_project_id, team_lead_id, valid_from, valid_to, 
				create_by, create_date, update_by, update_date)
VALUES 
	('TEAM1', 'Team 1', 2, 2, '2020-07-23', '2020-12-23', 'Džejla Šuman', '2020-07-23', 'Džejla Šuman', '2020-07-23'),
	('TEAM2', 'Team 2', 4, 1, '2020-07-23', '2020-11-23', 'Džejla Šuman', '2020-07-23', 'Džejla Šuman', '2020-07-23');


-- TPC_TEAM_MEMBERS

INSERT INTO TPC_TEAM_MEMBERS(team_id, team_member_id, team_member_role_id)
VALUES
	(1, 6, 3),
	(2, 1, 1),
	(1, 5, 2),
	(2, 4, 4),
	(1, 8, 6),
	(2, 7, 5),
	(1, 2, 3),
	(2, 11, 2),
	(2, 3, 1);