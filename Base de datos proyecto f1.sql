create database f1_championship;
use f1_championship;

create table drivers(
id_driver int primary key auto_increment null not null,
driver_name varchar(200),
natinality varchar(150),
driver_image longblob,
driver_number int,
wins int,
drivers_championship int
);

create table teams(
id_team int primary key auto_increment null,
team_name varchar(200),
team_location varchar (200),
team_image longblob,
constructors_championship int,
drivers varchar(200),
id_driver int,
foreign key (id_driver) references drivers(id_driver)
);

create table circuits(
id_circuit int primary key auto_increment not null,
circuit_name varchar(250),
circuit_image longblob,
circuit_info varchar(250),
fastest_lap_record varchar(250)
);


create table race(
id_circuit int not null,
id_teams int not null,
event_date date not null
);

alter table race add foreign key(id_circuit) references circuits(id_circuit);
alter table race add foreign key(id_teams) references teams(id_team);