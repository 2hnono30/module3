create database customer;
use customer;
create table Customer(
cID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
cName VARCHAR(45), 
cAge INT );
create table Orders(
oID INT NOT NULL PRIMARY KEY,
cID INT NOT NULL,
    FOREIGN KEY (cID) REFERENCES Customer (cID)
    );
create table Product(
pID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
pNAME VARCHAR(45),
pPRICE FLOAT);
CREATE TABLE OrderDetail(
oID INT NOT NULL,
pID INT NOT NULL,
PRIMARY KEY(oID,pID),
odQTY INT,
Foreign KEY(pID) References Product (pID),
Foreign KEY(oID) References Orders (oID)
);
   