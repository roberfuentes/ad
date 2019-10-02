create table categoria (
    id serial primary key,
    nombre varchar(50) not null UNIQUE
);

insert into categoria (nombre) values ('categoria 1');
insert into categoria (nombre) values ('categoria 2');
insert into categoria (nombre) values ('categoria 3');



CREATE TABLE `dbprueba`.`articulo` 
( `id` SERIAL primary key, 
 `nombre` VARCHAR(50) NOT NULL UNIQUE ,
 `precio` DECIMAL(10,2), `categoria` BIGINT UNSIGNED,
  foreign key categoria references categoria(id)
 );
