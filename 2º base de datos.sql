
/*base de datos chatgpt*/
create database f1_championship;
use f1_championship;

CREATE TABLE teams (
    id_team INT PRIMARY KEY AUTO_INCREMENT,
    team_name VARCHAR(200),
    team_location VARCHAR(200),
    team_image LONGBLOB,
    constructors_championship INT
);

CREATE TABLE drivers (
    id_driver INT PRIMARY KEY AUTO_INCREMENT,
    driver_name VARCHAR(200),
    nationality VARCHAR(150),
    driver_image LONGBLOB,
    driver_number INT,
    wins INT,
    drivers_championship INT,
    id_team INT,
    FOREIGN KEY (id_team) REFERENCES teams (id_team)
);

CREATE TABLE circuits (
    id_circuit INT PRIMARY KEY AUTO_INCREMENT,
    circuit_name VARCHAR(250),
    circuit_image LONGBLOB,
    circuit_info VARCHAR(250),
    fastest_lap_record VARCHAR(250),
    winner_id_driver INT,
    FOREIGN KEY (winner_id_driver) REFERENCES drivers (id_driver)
);


CREATE TABLE races (
    id_race INT PRIMARY KEY AUTO_INCREMENT,
    id_circuit INT,
    event_date DATE,
    FOREIGN KEY (id_circuit) REFERENCES circuits (id_circuit)
);