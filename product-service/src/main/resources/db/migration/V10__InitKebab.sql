CREATE TABLE kebab
(
    id                  serial primary key,
    uid                 varchar   not null,
    kebab_name          varchar   not null,
    location_x          decimal(12,2)      not null,
    location_y          decimal(12,2)      not null,
    hours               TEXT,
    rating              decimal(12,2)     not null,
    address             TEXT      not null
);

CREATE TABLE review (
    id                 SERIAL PRIMARY KEY,
    uuid               VARCHAR NOT NULL UNIQUE,
    kebab_name         VARCHAR NOT NULL,
    user_login         VARCHAR NOT NULL,
    content            TEXT NOT NULL,
    rating             DECIMAL(3,2) NOT NULL
);
