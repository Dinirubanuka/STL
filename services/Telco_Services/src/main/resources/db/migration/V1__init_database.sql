create table if not exists Package(
                                      id SERIAL PRIMARY KEY,
                                      dataValue DECIMAL(10,2) NOT NULL
    );

create table if not exists Duration(
                                       id SERIAL PRIMARY KEY ,
                                       durationDays INT NOT NULL,
                                       description VARCHAR(15) NOT NULL
    );

CREATE TABLE IF NOT EXISTS Rate(
                                   id SERIAL PRIMARY KEY,
                                   data_id BIGINT NOT NULL,
                                   duration_id BIGINT NOT NULL,
                                   rate DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (data_id) REFERENCES Package(id),
    FOREIGN KEY (duration_id) REFERENCES Duration(id)
    );