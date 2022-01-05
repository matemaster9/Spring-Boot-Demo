use student;

create table student
(
    id    bigint auto_increment
        primary key,
    name  varchar(10) null,
    age   int         null,
    email varchar(50) null
);

INSERT INTO student.student (id, name, age, email) VALUES (1, 'sys', 23, 'sys@163.com');
INSERT INTO student.student (id, name, age, email) VALUES (2, 'mate', 23, 'mate@stu.cdut.edu.cn');