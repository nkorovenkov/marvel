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

create table roles
(
    id    bigint auto_increment
        primary key,
    name varchar(20) null
);
create table users_roles
(
    user_id bigint not null,
    role_id     bigint not null,
    constraint FKdfstzCKCn65x308Hctnp1X5KX
        foreign key (user_id) references users (id),
    constraint FKkYxVrapVcfG5NCwB7mbdkThPe
        foreign key (role_id) references roles (id)
);
--rollback DROP TABLE users_roles;
--rollback DROP TABLE roles;
--rollback DROP TABLE users;