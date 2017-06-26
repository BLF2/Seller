CREATE DATABASE seller DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE seller;

DROP TABLE IF EXISTS UserInfo;
CREATE TABLE UserInfo(userId VARCHAR(100) PRIMARY KEY,userName VARCHAR(50),userPswd VARCHAR(20),userRole
VARCHAR(50) NOT NULL,belongTo VARCHAR(50));

DROP TABLE IF EXISTS WorkShop;
CREATE TABLE WorkShop(workShopNum VARCHAR(100) PRIMARY KEY,workShopName VARCHAR(100),workShopAdmin VARCHAR(100),
workShopDesc VARCHAR(255));

DROP TABLE IF EXISTS ReponsityIo;
CREATE TABLE ReponsityIo(reponsityNum VARCHAR(100) PRIMARY KEY,materialsName VARCHAR(100),materialsOp VARCHAR(20),
measurementUnit VARCHAR(20),pricePerUnit DOUBLE ,totalCost DOUBLE,currentAdminId VARCHAR(100),currentAdminName
VARCHAR(50),ioPersonId VARCHAR(100),ioPersonName VARCHAR(50),operateDateTime VARCHAR(30),measurementNum DOUBLE );

