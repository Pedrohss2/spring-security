CREATE TABLE users
(
    id       Long UNIQUE PRIMARY KEY NOT NULL,
    login    TEXT UNIQUE,
    password TEXT                    NOT NULL,
    role     TEXT                    NOT NULL
);