CREATE TABLE User (
  id int(10) unsigned NOT NULL AUTO_INCREMENT,
  login varchar(50) DEFAULT NULL,
  password varchar(100) DEFAULT NULL,
  email varchar(100) DEFAULT NULL,
  PRIMARY KEY (id)
);


