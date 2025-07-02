CREATE TABLE member(
	id VARCHAR(100) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE bank(
	name VARCHAR(100),
    balance INT
);
INSERT INTO bank VALUES('지은', 100000);
INSERT INTO bank VALUES('지연', 0);

drop table bank;

select * from bank;

CREATE TABLE person(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    age INT,
    addr VARCHAR(200)
);

drop table person;

select * from person;

insert into person(name, age, addr) values ("비비빅" , 1 , "GS25");