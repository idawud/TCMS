create table clients IF NOT EXIST(
    client_id serial primary key
    client_name varchar(200) not null
    address varchar(250) not null
    tel_no varchar(50) not null
    email varchar(200) not mull
);

insert into clients(client_name, address, tel_no, email) values ("Thonny Gaddis", "Mile 7 st, Achimota, Accra", "thonny@gmail.com");
insert into clients(client_name, address, tel_no, email) values ("Thom Gaddis", "Taifa st, Achimota, Accra", "thomson@gmail.com");

