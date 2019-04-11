create table IF NOT EXISTS clients (
	id integer PRIMARY KEY AUTOINCREMENT,
	name varchar(255),
	phone_number varchar(255),
	address varchar(255),
	UNIQUE(name, address, phone_number)
);

create table IF NOT EXISTS pets (
	id integer PRIMARY KEY AUTOINCREMENT,
	name varchar(255),
	gender varchar(255),
	altered boolean,
	client_id integer,
	FOREIGN KEY (client_id) REFERENCES clients(id),
	UNIQUE(name, client_id)
);

create table IF NOT EXISTS users (
	id integer PRIMARY KEY AUTOINCREMENT,
	username varchar(255) UNIQUE,
	encoded_password varchar(255),
	role varchar(255)
);

create table IF NOT EXISTS appointments (
	id integer PRIMARY KEY AUTOINCREMENT,
	client_id integer,
	pet_id integer,
	appt_time varchar(255),
	appt_date varchar(255),
	appt_type varchar(255),
	FOREIGN KEY (client_id) REFERENCES clients(id),
	FOREIGN KEY (pet_id) REFERENCES pets(id),
	UNIQUE(client_id, pet_id, appt_time, appt_date)
);