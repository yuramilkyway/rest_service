-- Users

CREATE TABLE users
(
    id       SERIAL primary key,
    name     VARCHAR(20) unique,
    password VARCHAR(255)
);

INSERT INTO users (name, password)
VALUES ('user', '$2y$05$bQn1GOHgFRLMQqsBXjfT7u5tcQq0YucCNEDPmlPmgLyo9pkappqH6'),
       ('admin', '$2y$05$sXKETC5O1WUS0EZDeaua9uJWFcrezXTjetCdhgFdF/uUobxNfjyd.');