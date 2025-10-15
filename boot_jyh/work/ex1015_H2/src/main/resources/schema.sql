CREATE TABLE member(
    id int auto_increment primary key,
    name varchar(50) not null,
    email varchar(50) not null unique,
    age int
);

CREATE TABLE article(
    id int auto_increment primary key,
    title varchar(100),
    description varchar(4096),
    created datetime,
    updated datetime,
    memberid int,
    foreign key(memberid) references member(id) on delete cascade
);

INSERT into member (name, email, age) VALUES ('hong', 'red@one.com', 10);
INSERT into member (name, email, age) VALUES ('cheong', 'blue@two.com', 26);
INSERT into member (name, email, age) VALUES ('ja', 'purple@three.com', 37);