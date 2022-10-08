--liquibase formatted sql
--changeset nikita.korovenkov:marvel-2
create table users
(
    id    bigint auto_increment
    primary key,
    email varchar(50) null,
    password varchar(120) null,
    username varchar(20) null
);
--rollback DROP TABLE users;