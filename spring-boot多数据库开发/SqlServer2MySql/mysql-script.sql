drop table if exists sys_user;
drop table if exists tb_temp;

create table if not exists sys_user
(
    id           bigint              not null auto_increment,
    name         varchar(255)        not null,
    phone        varchar(255)        not null,
    company      varchar(255)        not null,
    sex          tinyint(1) unsigned not null,
    address      varchar(255)        not null,
    create_time  datetime            not null,
    latest_stamp timestamp           not null,
    primary key (id)
);

create table if not exists tb_temp
(
    id           bigint       not null auto_increment,
    tb_name      varchar(255) not null,
    latest_count bigint       not null,
    latest_stamp bigint       not null,
    primary key (id)
);