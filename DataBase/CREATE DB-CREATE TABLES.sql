CREATE DATABASE HOTELAPP;

USE HOTELAPP;

CREATE TABLE Room (
	roomNo INT,
    roomType VARCHAR(20),
    roomPrice FLOAT,
    details TEXT,
    occupancy INT
);

CREATE TABLE Booking (
	bookingId INT,
    clientId INT,
    roomNo INT,
    arrivalDate DATE, 
    departureDate DATE,
    numAdult INT,
    numChildren INT,
    invoiceNo INT
);

CREATE TABLE Bill (
	invoiceNo INT,
    bookingId INT,
    clientId INT,
	paymentDate DATE,
    paymentMode VARCHAR(10),
    payedCharges FLOAT,
    creditCardNo INT,
    expireDate VARCHAR(5)  
); 

CREATE TABLE Client (
	clientId INT,
    bookingId INT,
    clientTitle VARCHAR(20),
    clientTitleNo VARCHAR(50),
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    DOB DATE,
    gender CHAR(1),
    phoneNo INT,
    email VARCHAR(50),
    pwd VARCHAR(100),
    adresse VARCHAR(50),
    city VARCHAR(50),
    country VARCHAR(50)
);

CREATE TABLE Admin (
	AdminId INT,
    AdminTitle VARCHAR(20),
    AdminTitleNo VARCHAR(50),
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    DOB DATE,
    gender CHAR(1),
    phoneNo INT,
    email VARCHAR(50),
    pwd VARCHAR(100),
    adresse VARCHAR(50),
    city VARCHAR(50),
    country VARCHAR(50),
    salary FLOAT
);