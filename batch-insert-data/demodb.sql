create database demodb;

use demodb;

create table tb_person
(
    id          bigint              not null auto_increment,
    name        varchar(255)        not null,
    phone       varchar(255)        not null,
    salary      decimal(10, 2)      not null,
    company     varchar(255)        not null,
    is_single   tinyint(1) unsigned not null,
    sex         tinyint(1) unsigned not null,
    address     varchar(255)        not null,
    create_time datetime            not null,
    create_user varchar(255)        not null,
    primary key (id)
);