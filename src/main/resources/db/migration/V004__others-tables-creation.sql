create table `group`
(
    id   bigint       not null auto_increment,
    name varchar(60) not null,

    primary key (id)
) engine = InnoDB charset=UTF8MB4;
create table permission
(
    id          bigint       not null auto_increment,
    description varchar(120) not null,
    name        varchar(60) not null,

    primary key (id)
) engine = InnoDB charset=UTF8MB4;
create table group_permission
(
    compilation_id bigint not null,
    permission_id  bigint not null
) engine = InnoDB charset=UTF8MB4;
create table product
(
    id            bigint         not null auto_increment,
    active        bit            not null,
    description   varchar(120)   not null,
    name          varchar(60)   not null,
    price         decimal(38, 2) not null,
    restaurant_id bigint,

    primary key (id)
) engine = InnoDB charset=UTF8MB4;
create table payment_method
(
    id          bigint       not null auto_increment,
    description varchar(120) not null,
    primary key (id)
) engine = InnoDB charset=UTF8MB4;
create table restaurant_payment_method
(
    restaurant_id      bigint not null,
    payment_method_id bigint not null
) engine = InnoDB charset=UTF8MB4;
create table user
(
    id                 bigint       not null auto_increment,
    name               varchar(60) not null,
    email              varchar(60) not null,
    password           varchar(60) not null,
    creation_timestamp datetime     not null,
    update_timestamp   datetime     not null,

    primary key (id)
) engine = InnoDB;
create table restaurant
(
    id                 bigint         not null auto_increment,
    name               varchar(60)   not null,
    delivery_fee       decimal(38, 2) not null,
    address_cep        varchar(10),
    address_district   varchar(40),
    address_number     varchar(10),
    address_street     varchar(40),
    creation_timestamp datetime       not null,
    update_timestamp   datetime       not null,
    address_city_id    bigint,
    cookery_id         bigint         not null,

    primary key (id)
) engine = InnoDB charset=UTF8MB4;
create table user_group
(
    user_id        bigint not null,
    group_id bigint not null
) engine = InnoDB charset=UTF8MB4;

alter table group_permission add constraint FK_compilation_permission foreign key (permission_id) references permission (id);
alter table group_permission add constraint FK_permission_compilation foreign key (compilation_id) references `group` (id);
alter table product add constraint FK_product_restaurant foreign key (restaurant_id) references restaurant (id);
alter table restaurant add constraint FK_restaurant_city foreign key (address_city_id) references city (id);
alter table restaurant add constraint FK_restaurant_cookery foreign key (cookery_id) references cookery (id);
alter table restaurant_payment_method add constraint FK_restaurants_payment_methods foreign key (payment_method_id) references payment_method (id);
alter table restaurant_payment_method add constraint FK_payment_methods_restaurants foreign key (restaurant_id) references restaurant (id);
alter table user_group add constraint FK_user_group foreign key (group_id) references `group` (id);
alter table user_group add constraint FK_group_user foreign key (user_id) references user (id);