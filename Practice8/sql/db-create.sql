DROP DATABASE practice8;

CREATE DATABASE practice8;

USE practice8;

CREATE TABLE users (
  id    INT PRIMARY KEY AUTO_INCREMENT,
  login VARCHAR(16) UNIQUE NOT NULL
);

CREATE TABLE groups (
  id   INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(16) UNIQUE NOT NULL
);

CREATE TABLE users_groups (
  user_id  INTEGER REFERENCES users (id),
  group_id INTEGER REFERENCES groups (id) ON DELETE CASCADE,
  PRIMARY KEY (user_id, group_id)
);

INSERT INTO users VALUE
(DEFAULT, "ivanov");

INSERT INTO groups VALUE
(DEFAULT, "teamA");

-- INSERT INTO users_groups VALUE (1, 1);

SELECT u.login, ' in ', g.name
FROM users_groups ug
JOIN users u ON ug.user_id = u.id
JOIN groups g ON ug.group_id = g.id;