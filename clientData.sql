drop table if exists clients
create table if not exists clients( client_id int primary key auto_increment, client_name varchar(200) not null, address varchar(250) not null, tel_num varchar(50) not null, email varchar(200) not null, active boolean default 'true')
insert into clients (client_name, address, email, tel_num) values ('Mary', 'jamaica down', 'pat2@gmail', '020 40 234 2324')
insert into clients (client_name, address, email, tel_num) values ('Alex', 'taifa', 'rfgth2@gmail', '230 40 234 2324')
