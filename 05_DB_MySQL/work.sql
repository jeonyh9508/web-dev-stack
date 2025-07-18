CREATE TABLE member(
	id VARCHAR(100) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL
);

drop table member;

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
drop table member;
create table member(
	id varchar(100) primary key,
	name varchar(50) not null,
    pwd varchar(200) not null,
    age int
);
    
create table book(
	book_no int primary key auto_increment,
    title varchar(100) not null,
    author varchar(50) not null,
    access_age int default 0
);

create table rent(
	rent_no int primary key auto_increment,
    id varchar(100),
    book_no int,
    rent_date DATETIME DEFAULT (CURRENT_DATE)
);
    
ALTER TABLE rent ADD FOREIGN KEY (id) REFERENCES member(id) on delete cascade;
ALTER TABLE rent ADD FOREIGN KEY (book_no) REFERENCES book(book_no);
    
drop table rent;
drop table member;
drop table book;
    
select * from work.member;
select * from book;
select * from rent;

Delete from member where id='qwer';