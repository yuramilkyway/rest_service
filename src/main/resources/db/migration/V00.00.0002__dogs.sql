-- Dogs

CREATE TABLE dogs
(
    id         SERIAL primary key,
    name       VARCHAR(10),
    color      VARCHAR(10),
    breed      VARCHAR(10)
);

INSERT into dogs (name, color, breed)
VALUES ('Dobbi', 'Black', 'doberman'),
       ('Spani', 'Black', 'Spaniel'),
       ('Tipster', 'Black', 'yard breed'),
       ('Merciless', 'Apricot', 'Poodle');