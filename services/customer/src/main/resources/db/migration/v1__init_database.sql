create table if not exists customer(
    id SERIAL PRIMARY KEY ,
    firstname VARCHAR(255) NOT NULL ,
    lastname VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    NIC VARCHAR(11) NOT NULL ,
    password VARCHAR(255) NOT NULL
);