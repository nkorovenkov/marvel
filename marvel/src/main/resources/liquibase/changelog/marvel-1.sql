--liquibase formatted sql
--changeset nikita.korovenkov:marvel-1

create table image
(
    id           bigint auto_increment
        primary key,
    name         varchar(255) null,
    location     varchar(255) null
);

create table `character`
(
    id       bigint auto_increment
        primary key,
    name     varchar(255) null,
    image_id bigint null,
    constraint FKtqgdcy9ZMEmW2wILNJWruFNto
        foreign key (image_id) references image (id)
);

create table comics
(
    id    bigint auto_increment
        primary key,
    title varchar(255) null
);

create table character_comics
(
    characters_id bigint not null,
    comics_id     bigint not null,
    constraint FK33dw8yx33tik65gvu8ygusyt
        foreign key (characters_id) references `character` (id),
    constraint FKe7mrbuo8w82fuo5ee11jwyo26
        foreign key (comics_id) references comics (id)
);


--rollback DROP TABLE image;
--rollback DROP TABLE character_comics;
--rollback DROP TABLE comics;
--rollback DROP TABLE `character`;
