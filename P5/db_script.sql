drop database if exists clk;
create database clk; 
use clk; 
create table HoraCentral(
ID int not null primary key auto_increment, 
-- hPrev varchar(20), 
hRef varchar(20) -- Hora del Servidor de Tiempo
); 

create table Equipos(
HoraEquipos_ID int not null primary key auto_increment, 
IP varchar(20), -- IP del equipo 
Nombre varchar (50), -- Nombre de la clase
Latencia varchar(20) -- Latencia
); 

create table HoraEquipos(
ID int not null primary key auto_increment, 
IDhSincr int, 
foreign key (IDhSincr) references HoraCentral(ID) on delete cascade on update cascade, 
IDEquipo int, 
foreign key (IDEquipo) references Equipos(HoraEquipos_ID) on delete cascade on update cascade, 
hEquipo varchar(20), -- Hora del coordinador cuando solicita la hora 
Error varchar(20)
); 


