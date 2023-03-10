CREATE TABLE persons
(
    id      bigserial       NOT NULL,
    name    varchar(255)    NULL,
    surname varchar(255)    NULL,
    CONSTRAINT persons_pkey PRIMARY KEY (id)
);
