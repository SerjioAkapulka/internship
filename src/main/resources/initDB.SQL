DROP TABLE IF EXISTS mobile;
DROP TABLE IF EXISTS internet;
DROP TABLE IF EXISTS penalties;
DROP TABLE IF EXISTS contracts;
DROP TABLE IF EXISTS clients;


CREATE TABLE clients
(
    id               UUID                    PRIMARY KEY,
    first_name       VARCHAR                 NOT NULL,
    last_name        VARCHAR                 NOT NULL,
    balance          INTEGER                 NOT NULL,
);

CREATE TABLE contracts
(
    contract_id      UUID                    PRIMARY KEY,
    client_id       UUID                    NOT NULL,
    status           VARCHAR                 NOT NULL,
    FOREIGN KEY (client_id) REFERENCES clients (id) ON DELETE CASCADE
);

CREATE TABLE internet
(
    client_id       UUID                             NOT NULL,
    internet_title            VARCHAR                 NOT NULL,
    internet_cost             INTEGER                 NOT NULL,
    FOREIGN KEY (client_id) REFERENCES clients (id) ON DELETE CASCADE
);
CREATE TABLE mobile
(
    client_id       UUID                        NOT NULL,
        title            VARCHAR                 NOT NULL,
        cost             INTEGER                 NOT NULL,
        FOREIGN KEY (client_id) REFERENCES clients (id) ON DELETE CASCADE
);
CREATE TABLE penalties
(
    client_id       UUID                        NOT NULL,
        title            VARCHAR                 NOT NULL,
        cost             INTEGER                 NOT NULL,
        FOREIGN KEY (client_id) REFERENCES clients (id) ON DELETE CASCADE
);

INSERT INTO clients (name, email)
VALUES ('1ae53c7b-0002-483e-897d-3e21f8ca16eb','Vasya', 'Petin','100'),
('2ae53c7b-0002-483e-897d-3e21f8ca16eb','Katya', 'Petina','200'),
('3ae53c7b-0002-483e-897d-3e21f8ca16eb','Vitya', 'Ukk','10000');

INSERT INTO contracts (client_id, contract_id,status)
VALUES ('1ae53c7b-0002-483e-897d-3e21f8ca16eb', '1re53c7b-0002-483e-897d-3e21f8ca16ea', 'Active'),
       ('2ae53c7b-0002-483e-897d-3e21f8ca16eb', '2re53c7b-0002-483e-897d-3e21f8ca16ea', 'Active'),
       ('3ae53c7b-0002-483e-897d-3e21f8ca16eb', '3re53c7b-0002-483e-897d-3e21f8ca16ea', 'Frozen'),

