create table article(
    id INTEGER auto_increment primary key,
    title varchar(256),
    description varchar(4096),
    created datetime,
    updated datetime,
    member_id INTEGER
);