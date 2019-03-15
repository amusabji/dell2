create table appointments (
	id integer PRIMARY KEY AUTOINCREMENT,
	client_id integer,
	pet_id integer,
	appt_time varchar(255),
	appt_date varchar(255),
	appt_type varchar(255),
	FOREIGN KEY (client_id) REFERENCES clients(id),
	FOREIGN KEY (pet_id) REFERENCES pets(id)
);
