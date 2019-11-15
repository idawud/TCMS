--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;



SET default_tablespace = '';

SET default_with_oids = false;


---
--- drop tables
---


DROP TABLE IF EXISTS clients;

create table clients IF NOT EXIST(
    client_id serial primary key
    client_name varchar(200) not null
    address varchar(250) not null
    tel_no varchar(50) not null
    email varchar(200) not mull
);

insert into clients(client_name, address, tel_no, email) values ('Thonny Gaddis', 'Mile 7 st, Achimota, Accra', 'thonny@gmail.com');
insert into clients(client_name, address, tel_no, email) values ('Thom Gaddis', 'Taifa st, Achimota, Accra', 'thomson@gmail.com');

