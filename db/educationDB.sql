DROP DATABASE IF EXISTS educationSite;
CREATE DATABASE educationSite;

use educationSite;

CREATE TABLE `educationSite`.`users` (
	`id`				INT(11)			AUTO_INCREMENT,
	`email`				TEXT 			NOT NULL,
    `username`			TEXT			NOT NULL,
    `password` 			TEXT 			NOT NULL,
    `courses`           INT(11)         NOT NULL	  	DEFAULT 0,
    `checkpoint`		INT(11)			NOT NULL	  	DEFAULT 0,
    -- make id to primary key.
    PRIMARY KEY (`id`)
);

CREATE TABLE `educationSite`.`courses` (
	`id` 				INT(11)			AUTO_INCREMENT,
    `name_course` 		TEXT			NOT NULL,
    -- 0: hidden, 1: show
    -- If not fill this field. Default value = 1.
    `status`       		INT(1)			NOT NULL		DEFAULT 1,
    -- who create
    -- If not fill this field. Default value = ADMIN.
    `created_by` 	 	NVARCHAR(250)	NOT NULL		DEFAULT 'ADMIN',
    -- when create
    -- Insert: if not fill this field, default value = current time.
	`created_date` 		DATETIME     	NOT NULL		DEFAULT CURRENT_TIMESTAMP,
    -- who update
    -- If not fill this field. Default value = ADMIN.
	`updated_by` 	 	NVARCHAR(250)	NOT NULL 		DEFAULT 'ADMIN',
    -- when update
    -- Insert or Update: if not fill this field, default value = current time.
	`updated_date` 		DATETIME     	NOT NULL		DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    -- make id to primary key.
    PRIMARY KEY (`id`)
);

CREATE TABLE `educationSite`.`modules` (
	`id` 				INT(11)			AUTO_INCREMENT,
    `topic`				TEXT 			NOT NULL,
    -- foreign key ref to courses.id.
    `id_course` 		INT(11) 		NOT NULL,
    -- 0: hidden, 1: show
    -- If not fill this field. Default value = 1.
    `status`       		INT(1)			NOT NULL		DEFAULT 1,
    -- make id to primary key.
    PRIMARY KEY (`id`),
    -- make id_course to foreign key to courses.id.
    CONSTRAINT `fk_courses_modules`
	FOREIGN KEY (`id_course`)
	REFERENCES `educationSite`.`courses` (`id`)
	ON DELETE CASCADE
	ON UPDATE CASCADE
);

CREATE TABLE `educationSite`.`checkpoint` (
	`id` 				INT(11)			AUTO_INCREMENT,
    `requireText`		TEXT			NOT NULL,
    -- foreign key ref to courses.id.
    `id_module` 		INT(11) 		NOT NULL,
    -- make id to primary key.
    PRIMARY KEY (`id`),
    -- make id_course to foreign key to courses.id.
    CONSTRAINT `fk_module_checkpoint`
	FOREIGN KEY (`id_module`)
	REFERENCES `educationSite`.`modules` (`id`)
	ON DELETE CASCADE
	ON UPDATE CASCADE
);

CREATE TABLE `educationSite`.`questions` (
	`id` 				INT(11)			AUTO_INCREMENT,
    `question`			TEXT 			NOT NULL,
    -- 0: all, 1: easy, 2: normal, 3: hard
    -- If not fill this field. Default value = 1.
    `levels`       		INT(1)			NOT NULL		DEFAULT 1,
    -- foreign key ref to courses.id.
    `id_course` 		INT(11) 		NOT NULL,
    -- 0: hidden, 1: show
    -- If not fill this field. Default value = 1.
    `status`       		INT(1)			NOT NULL		DEFAULT 1,
    -- who create
    -- If not fill this field. Default value = ADMIN.
    `created_by` 	 	NVARCHAR(250)	NOT NULL		DEFAULT 'ADMIN',
    -- when create
    -- Insert: if not fill this field, default value = current time.
	`created_date` 		DATETIME     	NOT NULL		DEFAULT CURRENT_TIMESTAMP,
    -- who update
    -- If not fill this field. Default value = ADMIN.
	`updated_by` 	 	NVARCHAR(250)	NOT NULL 		DEFAULT 'ADMIN',
    -- when update
    -- Insert or Update: if not fill this field, default value = current time.
	`updated_date` 		DATETIME     	NOT NULL		DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	-- make id to primary key.
    PRIMARY KEY (`id`),
    -- make id_course to foreign key to courses.id.
    CONSTRAINT `fk_courses_questions`
	FOREIGN KEY (`id_course`)
	REFERENCES `educationSite`.`courses` (`id`)
	ON DELETE CASCADE
	ON UPDATE CASCADE
);

CREATE TABLE `educationSite`.`answers` (
	`id` 				INT(11)			AUTO_INCREMENT,
    `answer` 			TEXT 			NOT NULL,
    -- 0: fail, 1: true.
    -- 1 question: 1 or more correct answers.
    `correct`       	INT(1)			NOT NULL		DEFAULT 0,
    -- foreign key ref to questions.id.
    `id_question` 		INT(11) 		NOT NULL,
    -- 0: hidden, 1: show
    -- If not fill this field. Default value = 1.
    `status`       		INT(1)			NOT NULL		DEFAULT 1,
    -- who create
    -- If not fill this field. Default value = ADMIN.
    `created_by` 	 	NVARCHAR(250)	NOT NULL		DEFAULT 'ADMIN',
    -- when create
    -- Insert: if not fill this field, default value = current time.
	`created_date` 		DATETIME     	NOT NULL		DEFAULT CURRENT_TIMESTAMP,
    -- who update
    -- If not fill this field. Default value = ADMIN.
	`updated_by` 	 	NVARCHAR(250)	NOT NULL 		DEFAULT 'ADMIN',
    -- when update
    -- Insert or Update: if not fill this field, default value = current time.
	`updated_date` 		DATETIME     	NOT NULL		DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	-- make id to primary key.
    PRIMARY KEY (`id`),
    -- make id_course to foreign key to courses.id.
    CONSTRAINT `fk_questions_answers`
	FOREIGN KEY (`id_question`)
	REFERENCES `educationSite`.`questions` (`id`)
	ON DELETE CASCADE
	ON UPDATE CASCADE
);

INSERT INTO courses (name_course)
VALUES ('Python'), ('C++');

INSERT INTO modules (topic, id_course)
VALUES ('Variable', 1),
('List', 1),
('Variable', 2),
('Pointer', 2);

INSERT INTO checkpoint (requireText, id_module) 
VALUES ('List all variable', 1),
('Print list', 2),
('Print out all variable', 3),
('List all pointer index', 4);

INSERT INTO questions (question, id_course, levels)
VALUES ('A 1998 study suggests that which of the following explorers reached the North Pole?', 1,2),
('History students are taught about the "the fall of Constantinople" in 1453. to who did it fall?', 1,2),
('The average of first 50 natural numbers is', 2,2),
('A fraction which bears the same ratio to 1/27 as 3/11 bear to 5/9 is equal to', 2,2);

INSERT INTO answers (answer, correct, id_question) 
VALUES ('Roald Amundsen', 0, 1),
('Robert E. Peary', 1, 1),
('William Barents', 0, 1),
('Adam Sound', 0, 1),
('Christian crusaders', 0, 2),
('Mongol hordes', 0, 2),
('Ottoman Turks', 1, 2),
('Romans', 0, 2),
('25.30', 0, 3),
('25.5', 1, 3),
('25.00', 0, 3),
('12.25', 0, 3),
('1/55', 1, 4),
('55', 0, 4),
('3/11', 0, 4),
('1/11', 0, 4);