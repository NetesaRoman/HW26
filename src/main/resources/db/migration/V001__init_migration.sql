-- Создание схемы
CREATE SCHEMA IF NOT EXISTS my_school;

-- Создание последовательности;
CREATE SEQUENCE IF NOT EXISTS my_school.my_school_id_seq;

-- Создание таблицы;
CREATE TABLE IF NOT EXISTS my_school.student
(
    id integer NOT NULL DEFAULT nextval('my_school.my_school_id_seq') PRIMARY KEY,
    name                text NOT NULL,
    email               text NOT NULL
);


CREATE TABLE IF NOT EXISTS my_school.mark
(
    id serial           NOT NULL PRIMARY KEY ,
    fk_student_id       integer constraint data_source_fk_connection_id_fkey references my_school.student,
    discipline text     NOT NULL,
    value               integer
);


