CREATE TABLE country (
                         id BIGSERIAL PRIMARY KEY,
                         name VARCHAR(100) NOT NULL,
                         continent VARCHAR(100) NOT NULL
);

CREATE TABLE host (
                      id BIGSERIAL PRIMARY KEY,
                      created_at TIMESTAMP,
                      updated_at TIMESTAMP,
                      name VARCHAR(100) NOT NULL,
                      surname VARCHAR(100) NOT NULL,
                      country_id BIGINT NOT NULL,
                      CONSTRAINT fk_host_country FOREIGN KEY (country_id) REFERENCES country(id)
);

CREATE TABLE accommodation (
                               id BIGSERIAL PRIMARY KEY,
                               created_at TIMESTAMP,
                               updated_at TIMESTAMP,
                               name VARCHAR(100) NOT NULL,
                               category VARCHAR(50) NOT NULL,
                               host_id BIGINT NOT NULL,
                               num_rooms INT NOT NULL,
                               state VARCHAR(20) NOT NULL,
                               CONSTRAINT fk_accommodation_host FOREIGN KEY (host_id) REFERENCES host(id)
);

INSERT INTO country (name, continent) VALUES
                                          ('Macedonia', 'Europe'),
                                          ('Italy', 'Europe'),
                                          ('Germany', 'Europe');

INSERT INTO host (created_at, updated_at, name, surname, country_id) VALUES
                                                                         (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Ana', 'Petrova', 1),
                                                                         (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Mario', 'Rossi', 2),
                                                                         (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Hans', 'Muller', 3);

INSERT INTO accommodation (created_at, updated_at, name, category, host_id, num_rooms, state) VALUES
                                                                                                  (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Villa Ana', 'HOUSE', 1, 5, 'GOOD'),
                                                                                                  (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Mario Apartment', 'APARTMENT', 2, 3, 'GOOD'),
                                                                                                  (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Hans Motel', 'MOTEL', 3, 10, 'BAD');