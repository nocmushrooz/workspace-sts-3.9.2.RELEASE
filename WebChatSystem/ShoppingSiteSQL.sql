/* Catalog for CPU */
CREATE TABLE catalog_CPU
(
    idCPU varchar(255),
    modelName varchar(255),
    price varchar(255)
);
INSERT INTO catalog_CPU
VALUES('c1','i7-8700','897');
INSERT INTO catalog_CPU
VALUES('c2','i5_8600K','389');
INSERT INTO catalog_CPU
VALUES('c3','i3_8100','199');
/* Catalog for GPU */
CREATE TABLE catalog_GPU
(
    idGPU varchar(255),
    modelName varchar(255),
    price varchar(255)
);
INSERT INTO catalog_GPU
VALUES('g1','1080TI','1516');
INSERT INTO catalog_GPU
VALUES('g2','1070','728');
INSERT INTO catalog_GPU
VALUES('g3','1060','398');
/* Catalog for RAM */
CREATE TABLE catalog_RAM
(
    idRAM varchar(255),
    modelName varchar(255),
    price varchar(255)
);
INSERT INTO catalog_GPU VALUES('r1','32GB','539');
INSERT INTO catalog_GPU VALUES('r2','16GB','249');
INSERT INTO catalog_GPU VALUES('r3','8GB','139');

drop table chat_user cascade constraints;

CREATE TABLE CHAT_USER(
  USERNAME VARCHAR2(255) PRIMARY KEY,
  USERPASSWORD VARCHAR2(255),
  EMAILADDRESS VARCHAR2(255) UNIQUE,
  USERADDRESS VARCHAR2(255),
  POSTALCODE NUMBER, 
  NAMEOFUSER VARCHAR2(255) UNIQUE,
  CONTACTNUMBER NUMBER UNIQUE,
  USERTYPE VARCHAR2(10)
);

insert into chat_user values ('ken', 'pswd1', 'ken@gmail.com', 'home sweet home', 090024, 'Ken Tan', 91449057, 'User');
insert into chat_user values ('jamie', 'pswd1', 'jamie@gmail.com', 'blk 24, telok blangah crescent, #12-464', 090024, 'Jamie Wee', 81114720, 'User');
insert into chat_user values ('jeremy', 'pswd1', 'jeremy@hotmail.com', 'blk 143, telok blangah rise, #18-147', 090143, 'Jeremy Lee', 91234567, 'User');
insert into chat_user values ('errol', 'pswd1', 'errol@hotmail.com', 'mount faber apartments', 123654, 'Errol Lee', 91441403, 'User');
insert into chat_user values ('dominic', 'pswd1', 'domdomtay@gmail.com', 'city square residences', 845788, 'Dominic Tan', 90020326, 'User');
insert into chat_user values ('weijie', 'pswd1', 'weijie12@gmail.com', 'Chua Chu Kang North, Verge Grove Avenue', 254877, 'Sng Wei Jie', 81475855, 'User');
insert into chat_user values ('vincent', 'pswd1', 'vincent_rocks@hotmail.com', 'Jurong West Street 61, #13-011', 123455, 'Vincent Ong Wei Jie', 99454784, 'Admin');

commit; 

CREATE TABLE MESSAGE_LIST(
  USERNAME VARCHAR2(255),
  CHAT_WITH VARCHAR2(255),
  TABLENAME VARCHAR2(255),
  USER_LEFT_CHAT VARCHAR2(255)
);

insert into item (AVAILABILITY, DESCRIPTION, CATEGORY, PICTURE, PRODUCTNAME, PRICE) values ('yes', '', 'cpu', 'amd1', 'AMD1', '10.30');
insert into item (AVAILABILITY, DESCRIPTION, CATEGORY, PICTURE, PRODUCTNAME, PRICE) values ('yes', 'i7-core processor', 'cpu', 'amd2', 'AMD_Ryzen_7_1800x', '20.30');
insert into item (AVAILABILITY, DESCRIPTION, CATEGORY, PICTURE, PRODUCTNAME, PRICE) values ('yes', 'i7-core processor', 'cpu', 'amd3', 'Intel_i5_8700K', '30.30');
insert into item (AVAILABILITY, DESCRIPTION, CATEGORY, PICTURE, PRODUCTNAME, PRICE) values ('yes', 'i7-core processor', 'cpu', 'amd4', 'Intel_i5_8700K', '40.30');
insert into item (AVAILABILITY, DESCRIPTION, CATEGORY, PICTURE, PRODUCTNAME, PRICE) values ('yes', 'i7-core processor', 'cpu', 'amd5', 'amd5', '50.30');
insert into item (AVAILABILITY, DESCRIPTION, CATEGORY, PICTURE, PRODUCTNAME, PRICE) values ('yes', 'i7-core processor', 'cpu', 'amd6', 'amd6', '60.30');
insert into item (AVAILABILITY, DESCRIPTION, CATEGORY, PICTURE, PRODUCTNAME, PRICE) values ('yes', 'i7-core processor', 'cpu', 'amd7', 'amd7', '70.30');

commit; 
