
CREATE TABLE IF NOT EXISTS Rate(
                                   id SERIAL PRIMARY KEY,
                                   data_value VARCHAR(20) NOT NULL,
                                   duration VARCHAR(20) NOT NULL,
                                   rate DECIMAL(10, 2) NOT NULL );