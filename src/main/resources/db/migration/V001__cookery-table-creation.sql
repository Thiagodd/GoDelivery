create table cookery
(
    id   bigint      not null auto_increment,
    name varchar(60) not null,

    primary key (id)
) engine = InnoDB
  default charset = UTF8MB4;