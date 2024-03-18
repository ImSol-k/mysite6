grant all privileges on web_db.* to 'web'@'%' ;

drop table users;
create table users(
no int auto_increment primary key,
id varchar(20) unique not null,
pass varchar(20) not null,
name varchar(20) not null,
gender varchar(20)
);

drop table board;
create table board(
no int auto_increment primary key,
title varchar(500) not null,
content varchar(4000),
hit int,
reg_date date not null,
user_no int not null,
CONSTRAINT board_fk FOREIGN KEY (user_no)
REFERENCES users(no)
);

drop table rboard;
create table rboard(
no int auto_increment primary key,
user_no int not null,
title varchar(500),
content text,
hit int,
reg_date date,
group_no int,
order_no int,
depth int,
CONSTRAINT rboard_fk FOREIGN KEY (user_no)
REFERENCES users(no)
);

drop table guestbook;
create table guestbook(
book_id int auto_increment primary key,
name varchar(80) not null,
pw varchar(20) not null,
content varchar(2000) not null,
date date not null);

drop table gallery;
create table gallery(
no int auto_increment primary key,
user_no int,
content varchar(1000),
org_name varchar(500),
save_name varchar(500),
file_path varchar(500),
file_size int,
CONSTRAINT gallery_fk FOREIGN KEY (user_no)
REFERENCES users(no)
);