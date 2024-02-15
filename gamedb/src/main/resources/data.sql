CREATE TABLE accounts (
    id SERIAL NOT NULL UNIQUE,
    name VARCHAR(22) NOT NULL,
    mail VARCHAR(22) NOT NULL UNIQUE,
    password VARCHAR(22) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE settings (
    id SERIAL NOT NULL UNIQUE,
    steamUser VARCHAR(22),
    gogUser VARCHAR(22),
    FOREIGN KEY (id) REFERENCES accounts(id)
    PRIMARY KEY (id)
);

INSERT INTO accounts (id, name, mail, password) VALUES (1, "Wompus", "dick.balls@urmum.com", "1234");
INSERT INTO settings (id, steamUser, gogUser) VALUES (1, null ,null);