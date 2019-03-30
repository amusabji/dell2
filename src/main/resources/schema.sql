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

--additional tables

DROP TABLE IF EXISTS user_client;
DROP TABLE IF EXISTS veterinarians;
DROP TABLE IF EXISTS vet_appointments;
DROP TABLE IF EXISTS visits;

CREATE TABLE IF NOT EXISTS user_client(
    client_id integer REFERENCES clients(id),
    user_id integer REFERENCES users(id) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS veterinarians(
    id integer PRIMARY KEY AUTOINCREMENT,
    name text
);

CREATE INDEX IF NOT EXISTS vet_index ON veterinarians(name);

CREATE TABLE IF NOT EXISTS vet_appointments(
    vet_id integer REFERENCES veterinarians(id),
    appt_id integer REFERENCES appointments(id)
);

CREATE TABLE IF NOT EXISTS visits(
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    pet_id INTEGER NOT NULL REFERENCES pets(id),
    visit_date TEXT,
    created TEXT DEFAULT CURRENT_DATE,
    description TEXT
);

CREATE INDEX IF NOT EXISTS visits_pet_id_index ON visits(pet_id);