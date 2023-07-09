create table city
(
    id         bigint      not null auto_increment,
    name_city  varchar(60) not null,
    name_state varchar(60) not null,

    primary key (id)
) engine = InnoDB
  default charset = UTF8MB4;