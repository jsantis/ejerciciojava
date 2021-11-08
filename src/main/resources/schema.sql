DROP TABLE IF EXISTS user;

CREATE TABLE user (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL,
  password VARCHAR(250) DEFAULT NULL,
  created DATE DEFAULT now(),
  modified DATE DEFAULT now(),
  last_login DATE DEFAULT now(),
  token uuid default random_uuid(),
  isactive boolean default false
);