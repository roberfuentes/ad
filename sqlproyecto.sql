create table category (
  id serial primary key,
  name varchar(50) not null unique
);

create table item (
  id serial primary key,
  name varchar(50) not null unique,
  price decimal(10,2),
  category_id bigint unsigned,
  foreign key (category_id) references category (id)
);

create table customer (
  id serial primary key,
  name varchar(50) not null
);

create table orders (
  id serial primary key,
  customer_id bigint unsigned not null,
  order_date datetime not null,
  cost numeric(10,2) not null,
  foreign key (customer_id) references customer (id)
);

create table orderline (
  id serial primary key,
  order_id bigint unsigned not null,
  item_id bigint unsigned not null,
  price numeric(10,2) not null,
  quantity numeric(10,2) not null,
  cost numeric(10,2) not null,
  foreign key (order_id) references orders (id) on delete cascade,
  foreign key (item_id) references item (id)
);
