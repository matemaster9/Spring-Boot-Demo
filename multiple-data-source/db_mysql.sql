create database db_act;
use db_act;
create table act_audit_backlog
(
    id             bigint              not null auto_increment comment '记录ID',
    activity_id    varchar(32)         not null comment '活动ID',
    dept_id        varchar(6) comment '部门ID',
    submitter_id   varchar(32)         not null comment '提交人ID',
    submitter_name varchar(50)         not null comment '提交人名称',
    submit_time    datetime            not null comment '提交时间',
    status         tinyint             not null comment '状态,1:未处理、2:已处理',
    delete_flag    tinyint(1) unsigned not null default 0 comment '删除标志',
    stamp          timestamp           not null,
    primary key (id)
);