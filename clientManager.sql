create table clients(
	client_id serial primary key,
	client_name varchar(255) not null,
	address varchar(255) not null,
	email varchar(255) not null,
	tel_num varchar(255) not null,
	active boolean default 'true' 
);

insert into clients (client_name, address, email, tel_num) values ('Mary', 'jamaica down', 'pat2@gmail', '020 40 234 2324');
insert into clients (client_name, address, email, tel_num) values ('Alex', 'taifa', 'rfgth2@gmail', '230 40 234 2324');
insert into clients (client_name, address, email, tel_num) values ('Dawud', 'tantra', 'alex13232@gmail', '020 345 77 2324');
insert into clients (client_name, address, email, tel_num) values ('Erbynn', 'burkina', 'tttt@gmail', '0334 5666 456');
insert into clients (client_name, address, email, tel_num) values ('Drake', 'madina', 'dawudestate@gmail', '0543 40 234 2324');
insert into clients (client_name, address, email, tel_num) values ('Cindy', 'ferary', 'tree@gmail', '0330 40 234');
insert into clients (client_name, address, email, tel_num) values ('Shaggy', 'trigga', 'rof@gmail', '020 40 234 2324');
insert into clients (client_name, address, email, tel_num) values ('Kassy', 'foreign land', 'karabian@gmail', '020 40 234 2324');
insert into clients (client_name, address, email, tel_num) values ('Doreen', 'astra', 'drake3@gmail', '05543 234 2324');
insert into clients (client_name, address, email, tel_num) values ('Funny', 'estate', 'fresd@gmail', '033 7687 56656');







