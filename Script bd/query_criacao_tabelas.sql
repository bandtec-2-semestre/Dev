create table Client (
idClient int primary key identity(1,1),
name varchar(100),
compName varchar(100),
cnpj varchar(20),
email varchar(50),
phone varchar(50),
pswd varchar(256)
);

create table DeviceType (
idType int primary key identity(1,1),
name varchar(30),
model varchar(50)
);

create table DeviceStatus (
idStatus int primary key identity(1,1),
description varchar(20),
);

create table System (
idSystem int primary key identity(1,1),
name varchar(30),
FK_client int foreign key references Client(idClient)
);


create table Device (
idDevice int primary key identity(1,1),
name varchar(30),
description varchar(40),
fk_type int foreign key references DeviceType(idType),
fk_system int foreign key references System(idSystem),
fk_status int foreign key references DeviceStatus(idStatus)
);

create table DeviceLog (
idDeviceLog int primary key identity(1,1),
description varchar(30),
dateTime datetime,
FK_device int foreign key references Device(idDevice),
N_error varchar(45)
);

create table SystemComponents (
idSystemComponents int primary key identity(1,1),
name varchar(30),
description varchar(30),
size int,
FK_system int foreign key references System(idSystem)
);

create table SystemLog (
idSystemLog int primary key identity(1,1),
value int,
components varchar(30),
date_time datetime,
FK_system int foreign key references System(idSystem),
FK_systemComponents int foreign key references SystemComponents(idSystemComponents)
);