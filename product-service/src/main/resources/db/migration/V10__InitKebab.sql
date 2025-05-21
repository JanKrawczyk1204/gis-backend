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