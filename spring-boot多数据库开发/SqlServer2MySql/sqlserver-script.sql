create database SQLSERVERDB;

use SQLSERVERDB;

create table SYS_USER
(
    id           bigint       not null identity (1,1),
    name         varchar(255) not null,
    phone        varchar(255) not null,
    company      varchar(255) not null,
    sex          bit          not null,
    address      varchar(255) not null,
    create_time  datetime     not null,
    latest_stamp timestamp    not null,
    primary key (id)
);