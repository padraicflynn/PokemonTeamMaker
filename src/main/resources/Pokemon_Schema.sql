DROP DATABASE IF EXISTS pokemon;
CREATE DATABASE IF NOT EXISTS pokemon;
USE pokemon;

DROP TABLE IF EXISTS pokemon_in_teams;
DROP TABLE IF EXISTS user_made_teams;
DROP TABLE IF EXISTS trainer_table;
DROP TABLE IF EXISTS pokedex_entry;

CREATE TABLE pokedex_entry (
	pokemon_pk int unsigned NOT NULL AUTO_INCREMENT,
	pokemon_name varchar(100) NOT NULL,
	pokemon_type varchar(100) NOT NULL,
	PRIMARY KEY (pokemon_pk)
);
	
CREATE TABLE trainer_table (
	trainer_id_pk int unsigned NOT NULL AUTO_INCREMENT,
	trainer_name varchar(200) NOT NULL,
	PRIMARY KEY (trainer_id_pk)
);
	
CREATE TABLE user_made_teams (
	team_name_pk int unsigned NOT NULL AUTO_INCREMENT,
	team_name varchar(200),
	trainer_id_fk int unsigned NOT NULL,
	description varchar(300),
	PRIMARY KEY (team_name_pk),
	FOREIGN KEY (trainer_id_fk) REFERENCES trainer_table (trainer_id_pk) ON DELETE CASCADE
);
	
CREATE TABLE pokemon_in_teams (
	pokemon_in_teams_pk int unsigned NOT NULL AUTO_INCREMENT,
	team_name_fk int unsigned NOT NULL,
	pokemon_pk_fk int unsigned NOT NULL,
	PRIMARY KEY (pokemon_in_teams_pk),
	FOREIGN KEY (team_name_fk) REFERENCES user_made_teams (team_name_pk) ON DELETE CASCADE,
	FOREIGN KEY (pokemon_pk_fk) REFERENCES pokedex_entry (pokemon_pk) ON DELETE cascade
	);
