create database if not exists coordinador;
USE coordinador;
CREATE TABLE if not exists PLAYER(
IP varchar(30),
HORA VARCHAR(20),
SUMA INT
);
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'root';
