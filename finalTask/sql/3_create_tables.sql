USE `account_db`;

CREATE TABLE user (
	id INTEGER NOT NULL AUTO_INCREMENT,
	login VARCHAR(255) NOT NULL UNIQUE,
	password CHAR(32) NOT NULL,
	/*
	 * 0 - студент (Role.STUDENT)
	 * 1 - староста (Role.LEADER)
	 * 2 - работник деканата (Role.ADMINISTRATOR)
	 */
	role TINYINT NOT NULL CHECK (role IN (0, 1, 2)),
	PRIMARY KEY (id)
)

CREATE TABLE student (
	id INTEGER NOT NULL AUTO_INCREMENT, -- номер студенческого билета
	surname VARCHAR(255) NOT NULL,
	name VARCHAR(255) NOT NULL,
	patronymic VARCHAR(255) NOT NULL, -- отчество
	faculty VARCHAR(255) NOT NULL,
	course_number INTEGER NOT NULL,
	group_number INTEGER NOT NULL,
	isLeader BIT DEFAULT 0,
	PRIMARY KEY (id)
)

CREATE TABLE administrator (
	id INTEGER NOT NULL AUTO_INCREMENT,
	surname VARCHAR(255) NOT NULL,
	name VARCHAR(255) NOT NULL,
	patronymic VARCHAR(255) NOT NULL,
	position VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
)

CREATE TABLE timetable (
	id INTEGER NOT NULL AUTO_INCREMENT, -- номер пары
	/*
	 * 0 - пн (Day.MONDAY)
	 * 1 - вт (Day.TUESDAY)
	 * 2 - ср (Day.WEDNESDAY)
	 * 3 - чт (Day.THURSDAY)
	 * 4 - пт (Day.FRIDAY)
	 * 5 - сб (Day.SATURDAY)
	 */
	day TINYINT NOT NULL CHECK (role IN (0, 1, 2, 3, 4, 5)),
	beginning_time CHAR(32) NOT NULL,
	end_time CHAR(32) NOT NULL,
	subject VARCHAR(255) NOT NULL,
	/*
	 * 0 - лекция (Role.LECTURE)
	 * 1 - практическое занятие (Role.PRACTICE)
	 * 2 - семинар (Role.SEMINAR)
	 */
	type TINYINT NOT NULL CHECK (role IN (0, 1, 2)),
	lecturer VARCHAR(255) NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (`author_identity`)
	REFERENCES `authors` (`identity`)
	ON UPDATE CASCADE
	ON DELETE RESTRICT
)

/*
 * таблицы-справочники:
 * - диспилины
 * - преподаватели
 */