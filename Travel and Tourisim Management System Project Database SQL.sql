show databases;
use travelmanagementsystem;

CREATE TABLE account (
    username VARCHAR(30),
    name VARCHAR(40),
    password VARCHAR(30),
    security VARCHAR(100),
    answer VARCHAR(50)
);

CREATE TABLE customer (
    username VARCHAR(30),
    id VARCHAR(30),
    number VARCHAR(30),
    name VARCHAR(40),
    gender VARCHAR(20),
    country VARCHAR(30),
    address VARCHAR(100),
    phone VARCHAR(20),
    email VARCHAR(50),
    FOREIGN KEY (username) REFERENCES account(username)
);

show tables;

DESCRIBE account;
DESCRIBE customer;

CREATE TABLE bookpackage (
    username VARCHAR(30),
    package VARCHAR(40),
    persons VARCHAR(20),
    id VARCHAR(30),
    number VARCHAR(30),
    phone VARCHAR(20),
    price VARCHAR(20)
);


select * from bookpackage;

CREATE TABLE hotel (
    name VARCHAR(50),
    costperperson VARCHAR(20),
    acroom VARCHAR(20),
    foodcharged VARCHAR(20)
);

INSERT INTO hotel (name, costperperson, acroom, foodcharged) VALUES 
('JW Marriott Hotel', '3400', '1000', '1600'),
('Mandarin Oriental Hotel', '2500', '700', '1000'),
('Four Seasons Hotel', '4800', '1600', '2000'),
('Radisson Blue Hotel', '3900', '1200', '1800'),
('Classio Hotel', '2200', '500', '700'),
('The Bay Club Hotel', '3000', '900', '1200'),
('Breeze Haven Hotel', '2400', '600', '800'),
('The Taj Hotel', '5000', '2000', '2500'),
('Happy Morning Motel', '1500', '400', '500'),
('River View Hotel', '2800', '800', '1100');

select * from hotel;

CREATE TABLE bookhotel (
    username VARCHAR(30),
    name VARCHAR(50),
    persons VARCHAR(20),
    days VARCHAR(20),
    ac VARCHAR(20),
    food VARCHAR(20),
    id VARCHAR(30),
    number VARCHAR(30),
    phone VARCHAR(20),
    price VARCHAR(20)
);

select * from bookhotel;
