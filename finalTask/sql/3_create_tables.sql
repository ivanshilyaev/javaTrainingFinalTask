USE account_db;

CREATE TABLE user (
	id INTEGER NOT NULL AUTO_INCREMENT,
	login VARCHAR(255) NOT NULL UNIQUE,
	password CHAR(32) NOT NULL,
	/*
	 * 0 - студент (Role.STUDENT)
	 * 1 - староста (Role.LEADER)
	 * 2 - работник деканата (Role.ADMINISTRATOR)
	 * 3 - преподаватель (Role.TUTOR)
	 */
	role TINYINT NOT NULL CHECK (role IN (0, 1, 2, 3)),
	surname VARCHAR(255) NOT NULL,
	name VARCHAR(255) NOT NULL,
	patronymic VARCHAR(255) NOT NULL, -- отчество
	CONSTRAINT pk_user PRIMARY KEY (id)
);

/*
 * таблицы-справочники:
 * - время начала пар, продолжительность пар и перерывов
 * (для вычисления времени начала и конца пары)
 * - диспилины
 * - преподаватели
 * - факультет
 */

 CREATE TABLE  pairtime (
    id INTEGER NOT NULL AUTO_INCREMENT,
    beginning_time CHAR(32) NOT NULL,
    pair_duration CHAR(32) NOT NULL,
    break_duration CHAR(32) NOT NULL,
    CONSTRAINT pk_pairtime PRIMARY KEY (id)
 );

 CREATE TABLE subject (
    id INTEGER NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_subject PRIMARY KEY (id)
 );

CREATE TABLE classroom (
    id INTEGER NOT NULL AUTO_INCREMENT,
    number INTEGER NOT NULL,
    capacity INTEGER NOT NULL,
    /*
	 * 0 - семианрская (Type.SEMINAR)
	 * 1 - лекционная (Type.LECTURE)
	 */
    type TINYINT NOT NULL CHECK (type IN (0, 1)),
    hasProjector BIT NOT NULL,
    CONSTRAINT pk_classroom PRIMARY KEY (id)
);

CREATE TABLE faculty (
    id INTEGER NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    dean VARCHAR(255) NOT NULL,
    CONSTRAINT pk_faculty PRIMARY KEY (id)
);

/*
 * конец таблиц-справочников
 */

 CREATE TABLE timetable (
    course_number INTEGER NOT NULL,
	group_number INTEGER NOT NULL,
    /*
	 * 0 - пн (Day.MONDAY)
	 * 1 - вт (Day.TUESDAY)
	 * 2 - ср (Day.WEDNESDAY)
	 * 3 - чт (Day.THURSDAY)
	 * 4 - пт (Day.FRIDAY)
	 * 5 - сб (Day.SATURDAY)
	 */
	day TINYINT NOT NULL CHECK (day IN (0, 1, 2, 3, 4, 5)),
	pair_number INTEGER NOT NULL, -- номер пары
	pairtime_id INTEGER NOT NULL,
	subject_id INTEGER NOT NULL,
	/*
	 * 0 - лекция (Type.LECTURE)
	 * 1 - практическое занятие (Type.PRACTICE)
	 * 2 - семинар (Type.SEMINAR)
	 */
	type TINYINT NOT NULL CHECK (type IN (0, 1, 2)),
	classroom_id INTEGER NOT NULL,
	tutor_id INTEGER NOT NULL,
	CONSTRAINT pk_timetable
	    PRIMARY KEY (course_number, group_number, day, pair_number),
	CONSTRAINT fk_timetable_pairtime FOREIGN KEY (pairtime_id) REFERENCES pairtime (id),
	CONSTRAINT fk_timetable_subject FOREIGN KEY (subject_id) REFERENCES subject (id),
	CONSTRAINT fk_timetable_classroom FOREIGN KEY (classroom_id) REFERENCES classroom (id)
);

CREATE TABLE student (
	id INTEGER NOT NULL, -- номер студенческого билета
	faculty_id INTEGER NOT NULL,
	student_course INTEGER NOT NULL,
	student_group INTEGER NOT NULL,
	student_subgroup BIT,
	user_id INTEGER NOT NULL,
	CONSTRAINT pk_student PRIMARY KEY (id),
	CONSTRAINT fk_student_faculty FOREIGN KEY (faculty_id) REFERENCES faculty (id),
	CONSTRAINT fk_student_timetable FOREIGN KEY (student_course, student_group)
	    REFERENCES timetable (course_number, group_number),
	CONSTRAINT fk_student_user FOREIGN KEY (user_id) REFERENCES user (id)
);

CREATE TABLE administrator (
	id INTEGER NOT NULL AUTO_INCREMENT,
	position VARCHAR(255) NOT NULL,
	user_id INTEGER NOT NULL,
	CONSTRAINT pk_administrator PRIMARY KEY (id),
	CONSTRAINT fk_administrator_user FOREIGN KEY (user_id) REFERENCES user (id)
);

CREATE TABLE tutor (
    id INTEGER NOT NULL AUTO_INCREMENT,
    position VARCHAR(255) NOT NULL,
    degree VARCHAR(255) NOT NULL,
    user_id INTEGER NOT NULL,
    CONSTRAINT pk_tutor PRIMARY KEY (id),
	CONSTRAINT fk_tutor_user FOREIGN KEY (user_id) REFERENCES user (id)
);

CREATE TABLE leader (
    id INTEGER NOT NULL AUTO_INCREMENT,
    student_id INTEGER NOT NULL,
    CONSTRAINT pk_leader PRIMARY KEY (id),
    CONSTRAINT fk_leader_student FOREIGN KEY (student_id) REFERENCES student (id)
);