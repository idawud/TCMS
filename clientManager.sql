create table clients(
	client_id serial primary key,
	client_name varchar(255) not null,
	address varchar(255) not null,
	email varchar(255) not null,
	tel_num varchar(255) not null,
	active boolean default 'true' 
);







