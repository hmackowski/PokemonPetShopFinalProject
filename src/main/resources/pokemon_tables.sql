DROP TABLE IF EXISTS pokemon_orders;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS trainers;
DROP TABLE IF EXISTS nature;
DROP TABLE IF EXISTS pokemon;


CREATE TABLE pokemon (
    pokemon_id int PRIMARY KEY AUTO_INCREMENT,
    pokedex_number int NOT NULL,
    name TEXT NOT NULL,
    type1 VARCHAR(64) NOT NULL,
    type2 VARCHAR(64),
    evolution_phase INT NOT NULL
);

CREATE TABLE nature (
	nature_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
	nature_name VARCHAR(64) NOT NULL
);

CREATE TABLE trainers (
	trainer_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(64) NOT NULL,
	last_name VARCHAR(64) NOT NULL,
	home_town VARCHAR(64) NOT NULL
);

CREATE TABLE orders (
    order_id int PRIMARY KEY AUTO_INCREMENT,
    trainer_id int NOT NULL,
    nature_id int NOT NULL,
    price decimal(9,2) NOT NULL,
    order_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (nature_id) REFERENCES nature (nature_id) ON DELETE CASCADE,
    FOREIGN KEY (trainer_id) REFERENCES trainers (trainer_id) ON DELETE CASCADE
);


CREATE TABLE pokemon_orders (
	pokemon_orders_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
	order_id int,
	pokemon_id int,
	FOREIGN KEY (order_id) REFERENCES orders (order_id) ON DELETE CASCADE,
	FOREIGN KEY (pokemon_id) REFERENCES pokemon (pokemon_id) ON DELETE CASCADE
);



