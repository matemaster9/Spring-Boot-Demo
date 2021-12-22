create database db_act;
use db_act;
create table ACT_AUDIT_BACKLOG
(
    id             bigint      not null identity (1,1),
    activity_id    varchar(32) not null,
    dept_id        varchar(6),
    submitter_id   varchar(32) not null,
    submitter_name varchar(50) not null,
    submit_time    datetime    not null,
    status         tinyint     not null,
    delete_flag    bit         not null default 0,
    stamp          timestamp   not null,
    primary key (id)
);