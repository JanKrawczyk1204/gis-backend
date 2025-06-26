CREATE TABLE "users" (
                         id          SERIAL PRIMARY KEY,
                         uuid        VARCHAR NOT NULL,
                         login       VARCHAR NOT NULL,
                         email       VARCHAR NOT NULL,
                         password    VARCHAR NOT NULL,
                         role        VARCHAR NOT NULL
);

ALTER TABLE users ADD CONSTRAINT unique_uuid UNIQUE (uuid);