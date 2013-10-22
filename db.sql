/******************************************************************************
SQL Database Script for FOSLS - Free Open Source Library System
created for Java DB (Apache Derbi) as embebed database

Version:    0.1
******************************************************************************/

create table sys_user(
id integer not null primary key generated always as identity
    (start with 1, increment by 1),

user varchar(50) not null,
pass varchar(50) not null,
name varchar(300) not null,
description varchar(500)
);

/*
md5('admin')    = 21232f297a57a5a743894a0e4a801fc3
sha1('admin')   = d033e22ae348aeb5660fc2140aec35850c4da997
sha256('admin') = 8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918
*/
insert into sys_user(user,pass,name) values('admin', 
'd033e22ae348aeb5660fc2140aec35850c4da997', 'Administrator');

create table library_user(
id integer not null primary key generated always as identity
    (start with 1, increment by 1),
school_id varchar(50) not null,
name varchar(300) not null,
address varchar(500) not null,
telephone varchar(25),
email varchar(50)
);

create table book_catalogue(
id integer not null primary key generated always as identity
    (start with 1, increment by 1),
name varchar(100) not null,
description varchar(500),
);

create table book(
id integer not null primary key generated always as identity
    (start with 1, increment by 1),
id_book_catalogue integer not null,
name varchar(300) not null,
author1 varchar(300) not null,
author2 varchar(300),
author3 varchar(300),
isbn varchar(50),
state varchar(20),
foreign key(id_book_catalogue) references book_catalogue(id)
on update cascade
on delete restrict
);

create table book_loan(
id integer not null primary key generated always as identity
    (start with 1, increment by 1),
id_library_user integer not null,
id_book integer not null,
start_date date not null,
end_date date not null,
received date,
state varchar(20) not null,
comments varchar(500),

foreign key(id_library_user) references library_user(id)
on update cascade
on delete restrict,

foreign key(id_book) references book(id)
on update cascade
on delete restrict
);
