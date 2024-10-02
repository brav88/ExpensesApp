CREATE DATABASE ExpensesDatabase;
USE ExpensesDatabase;

CREATE TABLE users (
    id int,
    lastName varchar(255),
    firstName varchar(255),
    email varchar(255),
    pwd varchar(255),
    creationDate datetime
);

INSERT INTO users (id, lastName, firstName, email, pwd, creationDate)
VALUES (1, 'Sandi', 'Braulio', 'brav88@hotmail.com', 'Admin$1234', CURDATE());

INSERT INTO users (id, lastName, firstName, email, pwd, creationDate)
VALUES (2, 'Taylor', 'Jason', 'jason.taylor@gmail.com', 'ABC$123', CURDATE());

CREATE TABLE expenses (
	idUser int,		
    description varchar(255),
    amount decimal,    
    creationDate datetime
);

INSERT INTO expenses (idUser, description, amount, creationDate)
VALUES (1, 'Playstation 5', 600, CURDATE());
INSERT INTO expenses (idUser, description, amount, creationDate)
VALUES (1, 'TV LG', 1000, CURDATE());
INSERT INTO expenses (idUser, description, amount, creationDate)
VALUES (2, 'Clothes', 350, CURDATE());