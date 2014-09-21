create database alipapa;

use alipapa;

create table user (
id int primary key auto_increment,
username varchar(40),
password varchar(20),
phone varchar(20),
addr varchar(255),
rdate datetime
);

create table category (
id int primary key auto_increment,
name varchar(40),
descr varchar(255),
pid int,
isleaf int,
grade int
);

create table product (
id int primary key auto_increment,
name varchar(255),
descr varchar(255),
normalprice double,
memberprice double,
pdate datetime,
categoryid int references category(id)
);

create table salesorder (
id int primary key auto_increment,
userid int,
addr varchar(255),
odate datetime,
status int
);

create table salesitem (
id int primary key auto_increment,
productid int,
unitprice double,
pCount int,
orderid int
);
