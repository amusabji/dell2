DROP TABLE IF EXISTS appointments;
DROP TABLE IF EXISTS pets;
DROP TABLE IF EXISTS clients;
DROP TABLE IF EXISTS appointments;
DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS clients(
    id integer PRIMARY KEY AUTOINCREMENT,
    name TEXT,
    phone_number TEXT,
    address TEXT
);

CREATE TABLE IF NOT EXISTS pets(
    id integer PRIMARY KEY AUTOINCREMENT,
    name TEXT,
    gender TEXT,
    altered boolean,
    client_id integer REFERENCES clients(id) ON DELETE CASCADE
);

CREATE INDEX IF NOT EXISTS pets_name_index ON pets(name);

CREATE TABLE appointments(
    id integer PRIMARY KEY AUTOINCREMENT,
    pet_id integer REFERENCES pets(id),
    appt_type text,
    appt_date TEXT,
    appt_time integer,
    created TEXT DEFAULT CURRENT_DATE
);

CREATE INDEX IF NOT EXISTS appt_pet_id_index ON appointments(pet_id);

CREATE TABLE IF NOT EXISTS users(
    id integer PRIMARY KEY AUTOINCREMENT,
    username TEXT NOT NULL UNIQUE,
    encoded_password TEXT NOT NULL,
    role TEXT DEFAULT 'USER'
);

insert into users values (null, 'admin', 'password', 'SUPER_ADMIN');